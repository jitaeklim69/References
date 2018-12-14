package org.study.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public String common(Exception e, Model model) {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("exception", e);
//		modelAndView.setViewName("error_common");
		logger.info(e.toString());
		model.addAttribute("exception",e);
		return "common/error_common";
	}
}
