package com.dp.persistence.mq;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.dp.persistence.domain.DmonValue;
import com.dp.persistence.service.DmonValueService;
import com.dp.persistence.util.XMLUtils;

public class ConsumerMessageListener implements MessageListener {

	private static ApplicationContext applicationContext;
	
	static {
		applicationContext = new FileSystemXmlApplicationContext("classpath:persistence-context.xml");
	}
	
	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				String source = ((TextMessage)message).getText();
				System.out.println(source);
				List<DmonValue> dmonValues = XMLUtils.parseDmonValueList(source);
				
				DmonValueService dmonValueService = applicationContext.getBean(DmonValueService.class);
				dmonValueService.batchSaveDmonValue(dmonValues);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException("Message must be of type TextMessage");
		}
	}

}
