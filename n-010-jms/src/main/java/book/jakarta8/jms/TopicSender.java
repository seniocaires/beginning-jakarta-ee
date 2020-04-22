package book.jakarta8.jms;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

@Singleton
@Startup
public class TopicSender {

	@Resource(lookup = "jms/TestTopic")
	private Topic topic;
	
	@Inject
	private JMSContext jmsContext;
	
	@Resource
	private SessionContext context; // needed for the timer

	@PostConstruct
	public void go() {
		// schedule the timer with a 5 secs delay
		context.getTimerService().createSingleActionTimer(5000, new TimerConfig());
	}

	@Timeout // called when the timer fires
	public void programmaticTimeout(Timer timer) {
		String msg = "My JMS Message";
		jmsContext.createProducer().send(topic, msg);
	}
}
