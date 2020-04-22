package book.jakarta8.jms;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(//
		activationConfig = { //
				@ActivationConfigProperty(//
						propertyName = "destinationType", //
						propertyValue = "javax.jms.Queue") //
		}, //
		mappedName = "jms/TestQueue")
public class TestQueueReceiverEJB implements MessageListener {

	@Resource
	private MessageDrivenContext mdc;

	@Override
	public void onMessage(Message message) {
		try {
			System.err.println("!#!#!#! QUEUE " + ((TextMessage) message).getText());
		} catch (JMSException e) {
			e.printStackTrace(System.err);
		}
	}
}
