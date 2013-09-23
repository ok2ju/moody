package com.mteam.moody.app.web.asynchronous;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.AtmosphereResourceEventListenerAdapter;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;
import org.springframework.stereotype.Service;

@Service
public class AsynchronousService {

	private Broadcaster chatBroadcaster;

	public AsynchronousService() {
		chatBroadcaster = BroadcasterFactory.getDefault().get();
		chatBroadcaster.setID("chatBroadcast");
	}

	public void suspend(final AtmosphereResource newResource) {

		AtmosphereResource oldResource = findResource(newResource);

		if (oldResource != null) {
			chatBroadcaster.removeAtmosphereResource(oldResource);
		}
		
		newResource.addEventListener(new AtmosphereResourceEventListenerAdapter() {
			@Override
			public void onSuspend(AtmosphereResourceEvent event) {
				newResource.removeEventListener(this);
			}
		});
		
		newResource.suspend();
		chatBroadcaster.addAtmosphereResource(newResource);
	}

	public void sendMessages(String message) {
		chatBroadcaster.broadcast(message);
	}

	public Broadcaster getChatBroadcaster() {
		return chatBroadcaster;
	}

	private AtmosphereResource findResource(AtmosphereResource resource) {
		HttpSession session = resource.getRequest().getSession();
		Collection<AtmosphereResource> resources = chatBroadcaster.getAtmosphereResources();
		
		for (AtmosphereResource thisResource : resources) {
			if (thisResource.getRequest().getSession().equals(session)) {
				return thisResource;
			}
		}
		return null;
	}
}
