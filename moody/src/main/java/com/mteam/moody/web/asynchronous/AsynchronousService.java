package com.mteam.moody.web.asynchronous;

import java.util.concurrent.CountDownLatch;

import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.AtmosphereResourceEventListenerAdapter;
import org.springframework.stereotype.Service;

@Service
public class AsynchronousService {
	
	public void suspend(final AtmosphereResource resource) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        resource.addEventListener(new AtmosphereResourceEventListenerAdapter() {
        	@Override
        	public void onBroadcast(AtmosphereResourceEvent event) {
        		// TODO Auto-generated method stub
        		super.onBroadcast(event);
        	}
        	@Override
        	public void onDisconnect(AtmosphereResourceEvent event) {
        		// TODO Auto-generated method stub
        		super.onDisconnect(event);
        	}
        	@Override
        	public void onThrowable(AtmosphereResourceEvent event) {
        		// TODO Auto-generated method stub
        		super.onThrowable(event);
        	}
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

}
