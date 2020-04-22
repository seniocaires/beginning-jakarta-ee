package book.jakarta8.ejbproj.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class StartupApp {

	@PostConstruct
	public void postConstruct() {
		System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
}
