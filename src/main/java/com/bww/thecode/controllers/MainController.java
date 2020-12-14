package com.bww.thecode.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	private Object message;
	private String error;
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		Object sessionCode = session.getAttribute("code");
		if(sessionCode == null) {
			session.setAttribute("code", "");
		}
		session.setAttribute("code", (String) session.getAttribute("code"));
		model.addAttribute("code", session.getAttribute("code"));
		return "form.jsp";
	}
	@RequestMapping("/clear")
	public String clear(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(path="/secretCode", method=RequestMethod.POST)
	public String secretCode(@RequestParam String code, HttpSession session) {
		System.out.println(code);
		session.setAttribute("code", code);
		session.getAttribute("code");
		if(code == "bushido") {
			return "/code";
		} else {
			Object message = session.getAttribute("message");
			System.out.println("You must train harder!");
			error = "You need to train harder";
			session.setAttribute("message", error);
			session.setAttribute("code", code);
			return "redirect:/";
		}
	}
	@RequestMapping("/code")
	public String code() {
		return "results.jsp";
	}
	
}
