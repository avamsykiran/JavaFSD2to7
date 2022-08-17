package in.cts.budgetanalysis.statement.models;

public class AccountHolderProfile {
	
	private Long ahId;
	private String firstName;
	private String lastName;
	private String mailId;
	private String mobile;
	private Double currentBalance;

	public AccountHolderProfile() {
		super();
	}
	
	public AccountHolderProfile(Long ahId, String firstName, String lastName, String mailId, String mobile) {
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

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	
}
