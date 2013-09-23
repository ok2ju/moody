package com.mteam.moody.app.web.controllers;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletRequest;

import org.atmosphere.cpr.AtmosphereResource;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
	
	@RequestMapping(value = "/fillDB", method = RequestMethod.GET)
	public String fillBDMethod() {
		fillBD();
		return "home";
	}
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String moodyHomePage(Model model) {
		LOGGER.info("MoodyDevColtroller - moodyHome");
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = personService.findByUsername(userDetails.getUsername());
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
	
	private void fillBD() {
		personService.cleanCollection();
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		MoodyGrantedAuthority userRole = new MoodyGrantedAuthority("USER");
		auth.add(userRole);
		
		User oleg = new User("oleg", "oleg", auth);
		User anton = new User("anton", "anton", auth);
		User lesha2 = new User("lesha2", "lesha2", auth);
		users.add(oleg);
		users.add(anton);
		users.add(lesha2);
		personService.addUsers(users);
	}
	
	
}