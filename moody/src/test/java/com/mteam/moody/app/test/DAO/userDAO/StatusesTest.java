package com.mteam.moody.app.test.DAO.userDAO;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.mteam.moody.app.DAO.StatusesDAO;
import com.mteam.moody.app.model.status.SmileTypes;
import com.mteam.moody.app.model.status.Status;
import com.mteam.moody.app.test.service.anonym.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {TestConfig.class})
public class StatusesTest {
	
	@Autowired
	private StatusesDAO statusesDAO;
	
	@Before
	public void before() {
		Status status = new Status("5249707b91fdf1b1105b22ad", new Date(), "OLOLO", SmileTypes.BAD);
		statusesDAO.saveStatus(status);
	}
	
	@Test
	public void test() {
		List<Status> status = statusesDAO.findStatusesByUserId("5249707b91fdf1b1105b22ad");
		Assert.assertEquals(1, status.size());
	}
	
}
