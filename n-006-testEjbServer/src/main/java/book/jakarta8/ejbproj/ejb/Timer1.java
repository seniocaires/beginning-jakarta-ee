package book.jakarta8.ejbproj.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;

@Singleton
@Startup
public class Timer1 {

	@Resource
	private SessionContext context;

	@PostConstruct
	public void go() {
		context.getTimerService().createSingleActionTimer(5000, new TimerConfig());
	}

	@Timeout
	public void timeout(Timer timer) {
		System.err.println("Hello from " + getClass());
	}
}
