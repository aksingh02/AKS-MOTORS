package com.aks.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aks.model.UserDtls;
import com.aks.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/home")
	public String vehicle() {
		return "vehicle";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDtls user, HttpSession session) {
		System.out.println(user);
		boolean f = userService.checkEmail(user.getEmail());

		if (f) {
			session.setAttribute("msg", "Email Id alreday exists");
		}

		else {
			UserDtls userDtls = userService.createUser(user);
			if (userDtls != null) {
				session.setAttribute("msg", "Register Sucessfully");
			} else {
				session.setAttribute("msg", "Something wrong on server");
			}
		}
		return "redirect:/register";
		
	}
	
	@PostMapping("/userLogin")
	public String userLogin(@ModelAttribute UserDtls user, HttpSession session) {
		boolean e = userService.checkEmail(user.getEmail());
		boolean p = userService.checkEmail(user.getPassword());
//		UserDtls userDtls = userService.createUser(user);
		
		if (!e && !p) {
			session.setAttribute("msg", "Invalid User");
			return "redirect:/login";
		}
		else {
			return "redirect:/home";
		}
		
	}
	
	@PostMapping("/vehicleDtls")
	public String vehicleDtls(@ModelAttribute UserDtls user, HttpSession session) {
		session.setAttribute("msg", "Added Sucessfully");
		return "redirect:/home";
	}
	
	@PostMapping("/userMessage")
	public String userMessage(@ModelAttribute UserDtls user, HttpSession session) {
		session.setAttribute("msg", "Submitted Sucessfully");
		return "redirect:/contact";
	}
}
