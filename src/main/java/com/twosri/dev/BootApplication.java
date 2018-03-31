package com.twosri.dev;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.ServletContextListener;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.twosri.dev.config.BootServletContextListener;

@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BootApplication.class, args);
		/*
		 * new SpringApplicationBuilder(BootApplication.class).listeners(new
		 * ApplicationListener<ContextClosedEvent>() {
		 * 
		 * @Override public void onApplicationEvent(ContextClosedEvent arg0) {
		 * System.out.println("application close event!!!"); try { ((Client)
		 * arg0.getApplicationContext().getBean(Client.class)).close(); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * System.out.println("application closed!!!");
		 * 
		 * }
		 * 
		 * }).run(args);
		 */
	}

	@Bean
	public Client client() {
		try {
			TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
					.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
			return client;
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Unused

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> listenerRegistrationBean() {
		ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean<>();
		bean.setListener(new BootServletContextListener());
		return bean;

	}
}