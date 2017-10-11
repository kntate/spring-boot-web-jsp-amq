package com.fis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
	@Autowired
	Producer producer;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		//call activemq to send message to the broker from the client
		try {
			producer.send(this.message);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "welcome";
	}

}