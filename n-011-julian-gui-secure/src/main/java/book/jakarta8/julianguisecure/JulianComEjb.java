package book.jakarta8.julianguisecure;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import book.jakarta8.ejbproj.ejb.interfaces.NameEjbLocal;

@Named
@SessionScoped
public class JulianComEjb implements Serializable {

	private static final long serialVersionUID = -8014050373790922248L;

	@EJB
	private NameEjbLocal nameEjb;

	public String getGreetingTxt() {
		return nameEjb.hello("User");
	}
}