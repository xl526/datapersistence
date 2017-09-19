package com.dp.persistence.mq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class AQHandler {
	
	private static Connection conn;
	
	private static Session ses;
	
	static {
		init();
	}
	
	private static void init() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("failover:(tcp://127.0.0.1:61616)");
		try {
			conn = factory.createConnection();
			ses = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			e.printStackTrace();
			throw new RuntimeException("an exception happened..");
		}
		
	}
	
	public static void receiveByListener() throws Exception {
		Destination destination = ses.createQueue("IN.IP.EQUIPMENT");
		MessageConsumer messageConsumer = ses.createConsumer(destination);
		messageConsumer.setMessageListener(new ConsumerMessageListener());
		conn.start();
	}
	
	public static void main(String[] args) {
		try {
			receiveByListener();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
