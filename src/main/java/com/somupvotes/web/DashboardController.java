package com.somupvotes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

 @GetMapping("/index")
    public String rootView(){
        return "index";
    }
}
