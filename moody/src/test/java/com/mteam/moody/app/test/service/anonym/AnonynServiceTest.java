package com.mteam.moody.app.test.service.anonym;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.mteam.moody.app.DAO.UserDAO;
import com.mteam.moody.app.model.user.User;
import com.mteam.moody.app.model.user.security.MoodyGrantedAuthority;
import com.mteam.moody.app.service.anonym.RegisterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {TestConfig.class})
public class AnonynServiceTest {
	
	@Autowired
	private RegisterService anonymService;
	
	@Autowired
	private UserDAO userDAO;
	
	@Before
	public void register() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		MoodyGrantedAuthority userRole = new MoodyGrantedAuthority("USER");
		auth.add(userRole);
		
		User oleg = new User("oleg", "oleg", auth);
		anonymService.registerUser(oleg);
	}
	
	@Test
	public void testRegisterUser() {
		User retriveUser = userDAO.findUserByUsername("oleg");
		Assert.assertNotNull(retriveUser);
		Assert.assertEquals("Username1 == Username2", "oleg", retriveUser.getUsername());
	}
	
	@After
	public void after() {
		userDAO.removeUser("oleg");
	}
	
}
