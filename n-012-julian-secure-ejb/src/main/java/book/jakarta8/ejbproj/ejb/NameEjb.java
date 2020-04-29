package book.jakarta8.ejbproj.ejb;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import book.jakarta8.ejbproj.ejb.interfaces.NameEjbLocal;
import book.jakarta8.ejbproj.ejb.interfaces.NameEjbRemote;

@Singleton
@Local(NameEjbLocal.class)
@Remote(NameEjbRemote.class)
@DeclareRoles({ "admin" })
public class NameEjb implements NameEjbLocal, NameEjbRemote {

	@RolesAllowed({ "admin" })
	public String hello(String name) {
		return "Hello " + name + " (admin)";
	}

//	@Resource
//	private SessionContext ctx;
//
//	public void someMethod() {
//        if(ctx.isCallerInRole("SomeRole")) {
//            ...
//        } else {
//            throw new SecurityException(...);
//        }
//    }

//	@EJB
//	private SomeOtherEjb ejb2;
//	
//	@RunAs("member")
//    public void someMethod() {
//        ejb2.doSomething();
//    }
}
