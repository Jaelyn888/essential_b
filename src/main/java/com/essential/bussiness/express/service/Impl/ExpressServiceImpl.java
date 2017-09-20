package com.essential.bussiness.express.service.Impl;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.essential.bussiness.express.demo.HttpRequest;
import com.essential.bussiness.express.demo.JacksonHelper;
import com.essential.bussiness.express.demo.MD5;
import com.essential.bussiness.express.model.ParamObject;
import com.essential.bussiness.express.model.vo.Express;
import com.essential.bussiness.express.pojo.TaskRequest;
import com.essential.bussiness.express.pojo.TaskResponse;
import com.essential.bussiness.express.service.IExpressService;
import com.essential.utils.CommonResponseUtils;

@Service
public class ExpressServiceImpl implements IExpressService {
	private static Logger logger = LoggerFactory
			.getLogger(ExpressServiceImpl.class);

	@Override
	public Map<String, Object> queryExpress(Express express) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			// 快递单号
			String nu = express.getNu();
			// 物流公司11
			String com = express.getCom();
			URL url = new URL(
					"http://api.kuaidi100.com/api?id=c5e85f627f3a83b7&com="
							+ com + "&nu=" + nu + "&show=0&muti=1&order=desc");
			// 打开url
			URLConnection con = url.openConnection();
			con.setAllowUserInteraction(false);
			// 打开流
			InputStream urlStream = url.openStream();
			String type = con.guessContentTypeFromStream(urlStream);
			String charSet = null;
			if (type == null)
				type = con.getContentType();

			if (type == null || type.trim().length() == 0
					|| type.trim().indexOf("text/html") < 0)
				/* return ; */
				return null;

			if (type.indexOf("charset=") > 0)
				charSet = type.substring(type.indexOf("charset=") + 8);

			byte b[] = new byte[10000];
			int numRead = urlStream.read(b);
			String content = new String(b, 0, numRead);
			// 一直往下循环，把读到的流放到content里面
			while (numRead != -1) {
				numRead = urlStream.read(b);
				if (numRead != -1) {
					// String newContent = new String(b, 0, numRead);
					String newContent = new String(b, 0, numRead, charSet);
					content += newContent;
				}
			}
			System.out.println("content:" + content);
			urlStream.close();
			return CommonResponseUtils.successResponse(JSONObject
					.fromObject(content));

		} catch (Exception e) {
			logger.info("查询物流失败");
			throw new RuntimeException(e);

		}

	}

	@Override
	public Map<String, Object> subscribeExpress() {
		TaskRequest req = new TaskRequest();
		req.setCompany("zhongtong");
		req.setFrom("上海浦东新区");
		req.setTo("广东深圳南山区");
		req.setNumber("408844669731");
		req.getParameters().put("callbackurl",
				"http://www.yourdmain.com/kuaidi");
		req.setKey("utDcFTep1863");

		HashMap<String, String> p = new HashMap<String, String>();
		p.put("schema", "json");
		p.put("param", JacksonHelper.toJSON(req));
		try {
			String ret = HttpRequest.postData("http://www.kuaidi100.com/poll",
					p, "UTF-8");
			TaskResponse resp = JacksonHelper.fromJSON(ret, TaskResponse.class);
			if (resp.getResult() == true) {
				System.out.println("订阅成功");
			} else {
				System.out.println("订阅失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> queryExpressEnterprise(Express express) {
		ParamObject paramObject = new ParamObject();
		String com = express.getCom();
		String num = express.getNu();
		String param = "{\"com\":\"" + com + "\",\"num\":\"" + num + "\"}";
		String customer = "2CD05897F63C73FFD55138E6341A99BA";
		String key = "utDcFTep1863";
		String sign = MD5.encode(param + key + customer);
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("param", param);
		params.put("sign", sign);
		params.put("customer", customer);
		String resp;
		try {
			resp = new HttpRequest().postData(
					"http://poll.kuaidi100.com/poll/query.do", params, "utf-8")
					.toString();
			System.out.println(resp);
			return CommonResponseUtils.successResponse(JSONObject
					.fromObject(resp));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}