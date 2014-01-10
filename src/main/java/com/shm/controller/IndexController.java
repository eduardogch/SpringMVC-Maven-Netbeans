package com.shm.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("index")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public String login(ModelMap model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		model.addAttribute("username", name);
		return "index";

	}

}