package com.file.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String goHome(Model model) {
		model.addAttribute("msg","Hello~");
		return "index"; //servlet_context url
	}

}
