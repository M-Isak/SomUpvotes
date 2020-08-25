package com.somupvotes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.somupvotes.domain.Product;
import com.somupvotes.domain.User;
import com.somupvotes.repository.ProductRepo;

@Controller
public class DashboardController {
	
	@Autowired
	private ProductRepo productRepo;
//	@Autowired
//	private PasswordEncoder passwordEcoder;

 @GetMapping("/")
    public String rootView(){
        return "index";
    }
 
 @GetMapping("/dashboard")
 public String dashboard(@SuppressWarnings("deprecation") @AuthenticationPrincipal User user, ModelMap model){
	 
	 List<Product> products = productRepo.findByUser(user);
     
		model.put("products", products);
	 return "dashboard";
 }
 
}
