package com.example.project.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	@GetMapping(value="")
	public String getIndexPage(Model model, HttpServletRequest req, HttpServletResponse res) {
		Enumeration<String> requsetHeaderKeys = req.getHeaderNames();
		Map<String, String> reqMap = new HashMap<>();
		
		while (requsetHeaderKeys.hasMoreElements()) {
		     String key = requsetHeaderKeys.nextElement();
		     reqMap.put(key, req.getHeader(key));
		}
		
		model.addAttribute("reqHeader", reqMap);
		
		return "header";
	}

}
