package com.crud.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.stereotype.Component;

@Component
public class SessionListener implements HttpSessionListener{

	public void sessionDestroyed(HttpSessionEvent se) {
		
		
	}
}
