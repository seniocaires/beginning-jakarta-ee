package book.jakarta8.calypsojpa;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import book.jakarta8.calypsojpa.ejb.MemberDAO;
import book.jakarta8.calypsojpa.jpa.Member;

/**
* REST Web Service
* http://localhost:8080/n-005-calypso-jpa/static/main.html
*/
/**
 * REST Web Service
 */
@Path("/member")
public class Calypso {

	@EJB
	private MemberDAO members;

	@GET
	@Path("/")
	@Produces("application/json")
	public Response list() {
		List<Member> memberList = members.allMembers();
		StringBuilder outStr = new StringBuilder();
		outStr.append("[");
		outStr.append(memberList.stream().sorted()
				.map((Member itm) -> "{\"firstName\":\"" + itm.getFirstName() + "\"," + "\"lastName\":\""
						+ itm.getLastName() + "\"," + "\"birthday\":\"" + itm.getBirthday() + "\"," + "\"id\":"
						+ itm.getId() + "}")
				.collect(Collectors.joining(",")));
		outStr.append("]");
		return Response.ok().entity(outStr.toString()).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response entity(@PathParam("id") int id) {
		Member m = members.getMember(id);
		return Response.ok()
				.entity("{\"lastName\":\"" + m.getLastName() + "\", " + "\"firstName\":\"" + m.getFirstName() + "\", "
						+ "\"birthday\":\"" + m.getBirthday() + "\", " + "\"id\":" + m.getId() + "}")
				.build();
	}

	@POST
	@Path("/")
	@Produces("application/json")
	public Response post(@FormParam("lastName") String lastName, @FormParam("firstName") String firstName,
			@FormParam("birthday") String birthday) {
		int newId = members.newMember(lastName, firstName, birthday);
		return Response.ok().entity("{\"id\":" + newId + "}").build();
	}

	@PUT
	@Path("/{id}")
	@Produces("application/json")
	public Response put(@FormParam("lastName") String lastName, @FormParam("firstName") String firstName,
			@FormParam("birthday") String birthday, @PathParam("id") int id) {
		members.updateMember(lastName, firstName, birthday, id);
		return Response.ok().entity("{}").build();
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public Response del(@PathParam("id") int id) {
		members.deleteMember(id);
		return Response.ok().entity("{}").build();
	}

}
