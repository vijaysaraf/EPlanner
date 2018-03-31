package com.twosri.dev.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;

public class BootServletContextListener implements ServletContextListener {
	@Autowired
	Client client;

	@Override
	public void contextInitialized(ServletContextEvent e) {
		System.out.println("##333333 MyServletContextListener Context Initialized client " + client);
	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		client.close();
		System.out.println("########MyServletContextListener Context Destroyed client " + client);
	}

}
