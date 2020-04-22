package book.jakarta8.wsdate;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class WsDate {

	/*
	 * Acesse: http://localhost:4848
	 * Applications >> n-008-wsdate >> View Endpoint
	 * 
	 * Ou
	 * 
	 * [server]	http://localhost:8080/n-008-wsdate/WsDateService?wsdl
	 * [server]	https://localhost:8181/n-008-wsdate/WsDateService?xsd=1
	 */
	@WebMethod
	public String date(String dateFormat) {
		ZonedDateTime zdt = ZonedDateTime.now();
		String outStr = "";
		String errMsg = "";
		try {
			outStr = ("".equals(dateFormat) ? zdt.toString() : zdt.format(DateTimeFormatter.ofPattern(dateFormat)));
			errMsg = "";
		} catch (Exception e) {
			errMsg = e.getMessage();
		}
		// errMsg currently ignored
		return outStr;
	}
}
