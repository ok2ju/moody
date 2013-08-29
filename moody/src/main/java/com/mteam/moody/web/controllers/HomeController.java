package com.mteam.moody.web.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.AtmosphereResourceEventListenerAdapter;
import org.atmosphere.cpr.Broadcaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.codehaus.jackson.map.ObjectMapper;

import com.mteam.moody.model.user.User;
import com.mteam.moody.service.PersonService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PersonService personService;
	
	private void suspend(final AtmosphereResource resource) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        resource.addEventListener(new AtmosphereResourceEventListenerAdapter() {
            @Override
            public void onSuspend(AtmosphereResourceEvent event) {
                countDownLatch.countDown();
                resource.removeEventListener(this);
            }
        });
        resource.suspend();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
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
		logger.info("Async done.");
		final ObjectMapper mapper = new ObjectMapper();
		this.suspend(atmosphereResource);
		final Broadcaster bc = atmosphereResource.getBroadcaster();
		logger.info("Atmo Resource Size: " + bc.getAtmosphereResources().size());
		final Random r = new Random();
		
		bc.scheduleFixedBroadcast(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return mapper.writeValueAsString(r.nextInt(500));
            }
        }, 10, TimeUnit.SECONDS);
	}
}