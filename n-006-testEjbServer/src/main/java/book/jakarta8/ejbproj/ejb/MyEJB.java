package book.jakarta8.ejbproj.ejb;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import book.jakarta8.ejbproj.ejb.interfaces.MyEJBLocal;

@Stateless
@Local(MyEJBLocal.class)
public class MyEJB implements MyEJBLocal {

	public String hello() {
		return "Hello World!";
	}

	/*
	 * Exemplo de uso
	 * 
	 *   
	 * @EJB
     * private SomeEjb someEjb;
     * ...
     * Future<String> f = someEjb.tellMeLater();
     * try {
     *    // Example only: block until the result
     *    // is available:
     *    String s = f.get();
     *    System.err.println(s);
     * } catch (Exception e) {
     *    e.printStackTrace(System.err);
     * }
	 */
	@Asynchronous
	public Future<String> tellMeLater() {
		// Simulate some long-running calculation
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		return new AsyncResult<String>("Hi from tellMeLater()");
	}

	// @Schedules({
	//    @Schedule(hour="*"),
	//    @Schedule(hour="0", minute="30")
	//  })
	// @Schedule(dayOfMonth="1-10") // <- 00:00:00 each 1st to 10th each month
	// @Schedule(dayOfMonth="1", year="2020") // <- 00:00:00 each 1st each month during 2020
	// @Schedule(month="Feb,Aug") // <- 00:00:00 each February and August (hour defaults to 00)
	// @Schedule(hour="*/10") // <- every 10 hours
	// @Schedule(hour="*", dayOfMonth="1,2,3") // <- every hour at 1st, 2nd, and 3rd each month (minute defaults to 00)
	// @Schedule(minute="25/10", hour="1") // <- 01:25, 01:35, 01:45 and 01:55
	// @Schedule(minute="*/10", hour="*") // <- every 10 minutes, every hour
	// @Schedule(minute="11", hour="15", dayOfWeek="Mon,Tue,Fri") // <- at 15:11:00 on Mondays, Tuesdays and Fridays
	// @Schedule(minute="30", hour="0", dayOfWeek="Tue") // <- at 00:30:00 on Tuesdays (second defaults to 00)
    // @Schedule(second="10", minute="0", hour="0") // <- at 00:00:10 every day
	@Schedule(minute = "*", hour = "20", persistent = false) // every minute during the hour between 00:00 and 01:00
	public void timeout1() {
		System.err.println("Timeout-1 from " + getClass());
	}
}
