package in.cts.budgetanalysis.profiles.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_holders")
public class AccountHolder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ahId;
	private String firstName;
	private String lastName;
	private String mailId;
	private String mobile;

	public AccountHolder() {
		super();
	}
	
	public AccountHolder(Long ahId, String firstName, String lastName, String mailId, String mobile) {
		super();
		this.ahId = ahId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailId = mailId;
		this.mobile = mobile;
	}

	public Long getAhId() {
		return ahId;
	}

	public void setAhId(Long ahId) {
		this.ahId = ahId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
