package book.jakarta8.calypsojpa.jpa;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "MEMBER")
@SequenceGenerator(name = "MEMBER_SEQ", initialValue = 1, allocationSize = 50)
public class Member implements Comparable<Member> {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ")
	@Column(name = "ID")
	private int id;
	@NotNull
	@Column(name = "LAST_NAME")
	private String lastName;
	@NotNull
	@Column(name = "FIRST_NAME")
	private String firstName;
	@NotNull
	@Column(name = "BIRTHDAY", length = 10)
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Birthday format: yyyy-MM-dd.")
	private String birthday;
	
	@JoinColumn(name = "MEMBER_ID")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<Status> status;

	@Override
	public int compareTo(Member o) {
		if (o.birthday.compareTo(birthday) != 0)
			return o.birthday.compareTo(birthday);
		if (o.lastName.compareTo(lastName) != 0)
			return -o.lastName.compareTo(lastName);
		return -o.firstName.compareTo(firstName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Set<Status> getStatus() {
		return status;
	}

	public void setStatus(Set<Status> status) {
		this.status = status;
	}
}
