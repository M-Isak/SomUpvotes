package com.somupvotes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.somupvotes.domain.User;
import com.somupvotes.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
@GetMapping("/login")
public String login(){
	return "login";
}

@GetMapping("/register")
public String register(ModelMap model){
	model.put("user", new User());
	
	return "register";
}

@PostMapping("/register")
public String registerAccount(@ModelAttribute User user) {
	  
	User savedUser =  userService.save(user);
//	System.out.println(savedUser);
//	System.out.println(user);
	
	return "redirect:/login";
}
}
