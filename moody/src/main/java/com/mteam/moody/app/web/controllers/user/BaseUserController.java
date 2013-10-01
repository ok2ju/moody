package com.mteam.moody.app.web.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mteam.moody.app.model.follow.Follower;
import com.mteam.moody.app.model.follow.Following;
import com.mteam.moody.app.model.status.Status;
import com.mteam.moody.app.model.user.User;
import com.mteam.moody.app.service.user.UserService;

@Controller
@SessionAttributes("userDetails")
public class BaseUserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String home(@PathVariable String userId) {
		User user = userService.findUserByUserId(userId);
		Follower follower = userService.findFollower(userId);
		Following following = userService.findFollowing(userId);
		List<Status> statuses = userService.findStatusesByUserId(userId);
		
		return "home";
	}
	
	/*@RequestMapping(value = "/addstatus", method = RequestMethod.POST)
	public String addStatus(@ModelAttribute("status")Status status) {
		UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findUserByUsername(userDetails.getUsername());
		userService.addStatus(user, status);
		return "/home";
	}
	
	@RequestMapping(value = "/addstatusdev", method = RequestMethod.GET)
	public String addStatusDev() {
		User user = userService.findUserByUsername("oleg");
		
		Status status = new Status("oleg", new Date(), "Test status", SmileTypes.GOOD);
		
		userService.addStatus(user, status);
		return "login";
	}*/
	
}
