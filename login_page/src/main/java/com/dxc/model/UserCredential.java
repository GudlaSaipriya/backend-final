package com.dxc.model;

public class UserCredential {

	private String useremail;
	private String userpassword;
	
	public UserCredential() {
		super();
	}

	public UserCredential(String useremail, String userpassword) {
		super();
		this.useremail = useremail;
		this.userpassword = userpassword;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	@Override
	public String toString() {
		return "UserCredential [useremail=" + useremail + ", userpassword=" + userpassword + "]";
	}
	
	
	
}
