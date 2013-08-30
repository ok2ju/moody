package com.mteam.moody.web.controllers;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Broadcaster;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mteam.moody.model.user.User;
import com.mteam.moody.service.PersonService;
import com.mteam.moody.web.asynchronous.AsynchronousService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MoodyDevController {
	
	private static final Logger logger = LoggerFactory.getLogger(MoodyDevController.class);
	
	private final ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private AsynchronousService asyncService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		personService.clean();
		personService.addPerson(new User("Oleg"));
		
		model.addAttribute("person", personService.listPerson().get(0));
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/async", method = RequestMethod.GET)
	@ResponseBody
	public void async(AtmosphereResource atmosphereResource) {
		logger.info("MoodyDevController: Async called");
		
		asyncService.suspend(atmosphereResource);
		
		logger.info("Atmo Resource Size: " + asyncService.getChatBroadcaster().getAtmosphereResources().size());
		final Random r = new Random();

		asyncService.getChatBroadcaster().scheduleFixedBroadcast(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return mapper.writeValueAsString(r.nextInt(500));
            }
        }, 10, TimeUnit.SECONDS);
	}
}