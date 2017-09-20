package com.essential.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @ClassName: EditorController
 * @Description: 富文本测试功能controller层
 * @author: panjc
 * @date: 2015年3月13日 下午12:24:46
 *
 */
@Controller
@RequestMapping("/suspension/")
public class SuspensionController {

	/**
	 * 加载悬浮菜单
	 */
	@RequestMapping("loadSuspension")
	public ModelAndView loadSuspension(HttpServletRequest request){
		return new ModelAndView("/publicComponent/suspension");
	}

}
