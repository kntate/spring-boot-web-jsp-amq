package com.fis;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer{// implements CommandLineRunner {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

/*	@Override
	public void run(String... args) throws Exception {
		//send(args[0]);
		send("My Sample message, Hi All !!");
		System.out.println("Message sent to the Queue is- "+args[0]);
	}*/

	public void send(String msg) {
		System.out.println("Producer sent message to the Queue is- "+ msg);
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
	}

}