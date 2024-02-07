package model;

public class Account {

	private String accountNumber;
	private String userName;
	private String accountType;
	private String accountOpenDate;
	
	public Account(String accountNumber, String userName, String accountType, String accountOpenDate) {
		super();
		this.accountNumber = accountNumber;
		this.userName = userName;
		this.accountType = accountType;
		this.accountOpenDate = accountOpenDate;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getAccountOpenDate() {
		return accountOpenDate;
	}
	
	public void setAccountOpenDate(String accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}
}
