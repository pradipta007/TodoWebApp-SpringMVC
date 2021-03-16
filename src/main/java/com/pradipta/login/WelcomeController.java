package com.pradipta.login;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/",method = RequestMethod.GET)//default controller 	 
	public String showLoginPage(ModelMap model)
	{
		model.put("name", "Pradipta");
		return "welcome"; 
	}
	
	// We are Musing spring security we dont need this logic
//	@RequestMapping(value = "/login",method = RequestMethod.POST)//when user submits the form in login page
//	public String handleLoginRequest(@RequestParam String name, String password, ModelMap model)
//	{
//		if(service.userValidation(name, password))
//		{
//			model.put("name", name); 
//			return "welcome";
//			
//		}
//		else {
//			model.put("errorMsg","Wrong Credentials");
//			return "login";
//		}
//	}
}
