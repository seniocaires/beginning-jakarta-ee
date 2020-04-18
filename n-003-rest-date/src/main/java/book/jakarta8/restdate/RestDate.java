package book.jakarta8.restdate;

import java.time.ZonedDateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 */
@Path("/d")
public class RestDate {

	/*
	 * Para testar o endpoint
	 * 
	 * curl -X GET http://localhost:8080/n-003-rest-date/webapi/d
	 */
	@GET
	@Produces("text/plain")
	public String stdDate() {
		return ZonedDateTime.now().toString();
	}
}
