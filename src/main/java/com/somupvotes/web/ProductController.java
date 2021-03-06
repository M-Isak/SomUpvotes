package com.somupvotes.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.somupvotes.domain.Product;
import com.somupvotes.domain.User;
import com.somupvotes.repository.ProductRepo;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("deprecation")
@Controller
public class ProductController {
	
	private Logger log = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductRepo productRepo;

	
	@GetMapping("/products/{productId}")
	public String getProduct(@PathVariable Long productId, ModelMap model, HttpServletResponse response) throws IOException {
		
	 Optional<Product> productOpt = productRepo.findByIdWithUser(productId);
	 
	 if (productOpt.isPresent()) {
		 Product product = productOpt.get();
		 model.put("product", product);
	 } else {
		 
		 response.sendError(HttpStatus.NOT_FOUND.value(), "Product with id" + productId +"Not found");
		
		 return "product";
	 }
		return "product";
	}
	
	@GetMapping("/p/{productName}")
	public String productUserView(@PathVariable String productName, ModelMap model) {
		
		if (productName != null) {
			
		try {
		String decodedProductName	= URLDecoder.decode(productName, StandardCharsets.UTF_8.name());
		Optional<Product>   productOpt = productRepo.findByName(decodedProductName);
		
		if (productOpt.isPresent()) {
			
			model.put("product", productOpt.get());
		}
		
		} catch (UnsupportedEncodingException e) {
		log.error("There is an error decoding the product url", e);
		}
		
		}
		
		return "productUserView";
	}
	
	
	@PostMapping("/products/{productId}")
	public String saveProduct(@PathVariable Long productId, Product product ) {
		
		System.out.println(product);
		
		product = productRepo.save(product);
		return "redirect:/products/"+product.getId();
	}
	
	
	
	@PostMapping("/products")
	public String createProduct(@AuthenticationPrincipal User user) {
		
		Product product = new Product();
		product.setPublished(false);
		product.setUser(user);
		
		product =productRepo.save(product);
		
		return ("redirect:/products/"+product.getId());	}

}
