package com.mteam.moody.web.asynchronous;

import java.util.concurrent.CountDownLatch;

import org.atmosphere.cpr.ApplicationConfig;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.AtmosphereResourceEventListenerAdapter;
import org.atmosphere.cpr.AtmosphereResourceFactory;
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
	
	public void suspend(final AtmosphereResource resource) {
			
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        resource.addEventListener(new AtmosphereResourceEventListenerAdapter() {
            @Override
            public void onSuspend(AtmosphereResourceEvent event) {
                countDownLatch.countDown();
                resource.removeEventListener(this);
            }
        });
        resource.suspend();
        
        String uuid = (String)resource.getRequest().getAttribute(ApplicationConfig.SUSPENDED_ATMOSPHERE_RESOURCE_UUID);
        AtmosphereResource newResource = AtmosphereResourceFactory.getDefault().find(uuid);

        if(chatBroadcaster.getAtmosphereResources().contains(newResource)) {
        	chatBroadcaster.addAtmosphereResource(resource);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	public void sendMessages(String message) {
		chatBroadcaster.broadcast(message);
	}
	
	public Broadcaster getChatBroadcaster() {
		return chatBroadcaster;
	}

}
