package com.essential.base.controller;

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
@RequestMapping("/")
public class EditorController {

	/**
	 * 
	 * @Description: 进入取方法的jsp页面
	 * @author: panjc
	 * @param: @return
	 * @return: ModelAndView
	 * @throws
	 */
	@RequestMapping("testjsp")
	public ModelAndView testjsp(){
		return new ModelAndView("controller");
	}

}
