package com.mteam.moody.app.test.DAO.userDAO;

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
import com.mteam.moody.app.test.service.anonym.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {TestConfig.class})
public class UserDAOTest {
	
	@Autowired
	private UserDAO userDAO;
	
	@Before
	public void before() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		MoodyGrantedAuthority userRole = new MoodyGrantedAuthority("USER");
		auth.add(userRole);
		User testuser1 = new User("testuser1", "testpass1", auth);
		userDAO.saveUser(testuser1);
	}
	
	@Test
	public void testSaveUser() {
		User retriveUser = userDAO.findUserByUsername("testuser1");
		Assert.assertNotNull("retriveUser is null", retriveUser);
	}
	
	@After
	public void after() {
		userDAO.removeUser("testuser1");
	}
}
