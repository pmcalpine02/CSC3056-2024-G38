package model;

public class Account {

	private String account_number;
	private String user_name;
	private String account_type;
	private String account_open_date;
	
	public Account(String account_number, String user_name, String account_type, String account_open_date) {
		super();
		this.account_number = account_number;
		this.user_name = user_name;
		this.account_type = account_type;
		this.account_open_date = account_open_date;
	}
	
	public String getAccount_number() {
		return account_number;
	}
	
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	
	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getAccount_type() {
		return account_type;
	}
	
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	
	public String getAccount_open_date() {
		return account_open_date;
	}
	
	public void setAccount_open_date(String account_open_date) {
		this.account_open_date = account_open_date;
	}
	
	
}
