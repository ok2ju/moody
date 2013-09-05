package com.mteam.moody.app.web.controllers;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.atmosphere.cpr.AtmosphereResource;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mteam.moody.app.model.user.User;
import com.mteam.moody.app.model.user.security.MoodyGrantedAuthority;
import com.mteam.moody.app.service.UserService;
import com.mteam.moody.app.web.asynchronous.AsynchronousService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MoodyDevController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MoodyDevController.class);
	
	private final ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private UserService personService;
	
	@Autowired
	private AsynchronousService asyncService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		LOGGER.info("Welcome home! The client locale is {}.", locale);		
		return "home";
	}
	
	@RequestMapping(value = "/createTestUser", method = RequestMethod.GET)
	public String createTestUser() {
		personService.cleanCollection();
		User testUser = new User();
		testUser.getUserDetails().setUsername("olegatsman");
		testUser.getUserDetails().setPassword("1234");
		testUser.getUserDetails().setEnabled(true);
		testUser.getUserDetails().setCredentialsNonExpired(true);
		testUser.getUserDetails().setAccountNonLocked(true);
		testUser.getUserDetails().setAccountNonExpired(true);
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		
		MoodyGrantedAuthority m = new MoodyGrantedAuthority("USER");
		
		auth.add(m);
		
		testUser.getUserDetails().setAuthorities(auth);
		personService.addUser(testUser);
		return "home";
	}
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String moodyHomePage(Model model) {
		LOGGER.info("MoodyDevColtroller - moodyHome");
		User user = personService.findByUsername("olegatsman");
		model.addAttribute("person", user);
		return "moodyHomePage";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/async", method = RequestMethod.GET)
	@ResponseBody
	public void async(AtmosphereResource atmosphereResource) {		
		LOGGER.info("MoodyDevController - async user: " + atmosphereResource.getRequest().getUserPrincipal().getName());
		
		asyncService.suspend(atmosphereResource);
		
		LOGGER.info("Atmo Resource Size: " + asyncService.getChatBroadcaster().getAtmosphereResources().size());
		final Random r = new Random();

		asyncService.getChatBroadcaster().scheduleFixedBroadcast(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return mapper.writeValueAsString(r.nextInt(500));
            }
        }, 3, TimeUnit.SECONDS);
	}
}