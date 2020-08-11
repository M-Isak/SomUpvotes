package com.somupvotes.web;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	
//	@Autowired
//	private PasswordEncoder passwordEcoder;

 @GetMapping("/")
    public String rootView(){
        return "index";
    }
 
 @GetMapping("/dashboard")
 public String dashboard(){
	 
	 return "dashboard";
 }
 
}
