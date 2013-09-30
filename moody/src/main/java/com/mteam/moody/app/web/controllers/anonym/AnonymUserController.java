package com.mteam.moody.app.web.controllers.anonym;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mteam.moody.app.model.user.User;
import com.mteam.moody.app.model.user.security.MoodyGrantedAuthority;
import com.mteam.moody.app.service.anonym.AnonymService;

@Controller
public class AnonymUserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AnonymUserController.class);
	
	@Autowired
	private AnonymService anonymService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		LOGGER.info("Welcome home! The client locale is {}.", locale);
		
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		MoodyGrantedAuthority userRole = new MoodyGrantedAuthority("USER");
		auth.add(userRole);
		
		User oleg = new User("oleg", "oleg", auth);
		anonymService.registerUser(oleg);
		
		return "home";
	}
}
