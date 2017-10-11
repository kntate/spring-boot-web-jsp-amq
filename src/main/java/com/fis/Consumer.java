package com.fis;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@JmsListener(destination = "myactivemq.queue")
	public void receiveQueue(String text) {
		System.out.println("Consumer received message=> " + text);
		
	}

}