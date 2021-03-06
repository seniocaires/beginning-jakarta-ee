package book.jakarta8.calypso;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 */
@Path("/member")
public class Calypso {

	private static List<Member> members = new ArrayList<>();
	static {
		members.add(new Member("John", "Smith", "2001-03-24", 1));
		members.add(new Member("Linda", "Green", "1997-04-01", 2));
		members.add(new Member("Alice", "Cloud", "1997-04-01", 3));
	}

	@GET
	@Path("/")
	@Produces("application/json")
	public Response list() {
		StringBuilder outStr = new StringBuilder();
		outStr.append("[");
		outStr.append(members.stream().sorted()
				.map(itm -> "{\"firstName\":\"" + itm.firstName + "\"," + "\"lastName\":\"" + itm.lastName + "\","
						+ "\"birthday\":\"" + itm.birthday + "\"," + "\"id\":" + itm.id + "}")
				.collect(Collectors.joining(",")));
		outStr.append("]");
		return Response.ok().entity(outStr.toString()).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response entity(@PathParam("id") int id) {
		Member m = members.stream().filter(itm -> itm.id == id).findFirst().orElse(Member.UNKNOWN);
		return Response.ok().entity("{\"lastName\":\"" + m.lastName + "\", " + "\"firstName\":\"" + m.firstName + "\", "
				+ "\"birthday\":\"" + m.birthday + "\", " + "\"id\":" + m.id + "}").build();
	}

	@POST
	@Path("/")
	@Produces("application/json")
	public Response post(@FormParam("lastName") String lastName, @FormParam("firstName") String firstName,
			@FormParam("birthday") String birthday) {
		int maxId = members.stream().mapToInt(m -> m.id).max().orElse(0);
		int newId = maxId + 1;
		Member m = new Member(firstName, lastName, birthday, newId);
		members.add(m);
		return Response.ok().entity("{\"id\":" + newId + "}").build();
	}

	@PUT
	@Path("/{id}")
	@Produces("application/json")
	public Response put(@FormParam("lastName") String lastName, @FormParam("firstName") String firstName,
			@FormParam("birthday") String birthday, @PathParam("id") int id) {
		Optional<Member> m = members.stream().filter(itm -> itm.id == id).findFirst();
		if (m.isPresent()) {
			members.remove(m.get());
			Member m2 = new Member(firstName, lastName, birthday, id);
			members.add(m2);
		}
		return Response.ok().entity("{}").build();
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public Response del(@PathParam("id") int id) {
		Member m = members.stream().filter(itm -> itm.id == id).findFirst().orElse(Member.UNKNOWN);
		members.remove(m);
		return Response.ok().entity("{}").build();
	}

	private static class Member implements Comparable<Member> {
		public String firstName;
		public String lastName;
		public String birthday;
		public int id;
		public static Member UNKNOWN = new Member("", "", "", 0);

		public Member(String firstName, String lastName, String birthday, int id) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.birthday = birthday;
			this.id = id;
		}

		@Override
		public int compareTo(Member o) {
			if (o.birthday.compareTo(birthday) != 0)
				return o.birthday.compareTo(birthday);
			if (o.lastName.compareTo(lastName) != 0)
				return -o.lastName.compareTo(lastName);
			return -o.firstName.compareTo(firstName);
		}
	}

}
