package book.jakarta8.jms;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Singleton
@Startup
public class QueueSender {

	@Resource(lookup = "jms/TestQueue")
	private Queue queue;

	@Inject
	private JMSContext jmsContext;

	@PostConstruct
	public void go() {
		String msg = "My JMS Message";
		jmsContext.createProducer().send(queue, msg);
	}
}
