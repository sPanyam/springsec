package com.example.VinIdentify.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumeRestEndPoint{

	
	public String consumeRest()
	{
		RestTemplate template = new RestTemplate();
		String uri = "http://localhost:8082/getTicket/over100";
		String val = template.getForObject(uri, String.class);
		System.out.println(val);
		return val;
	}
}
