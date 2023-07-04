package com.dxc.model;
import javax.persistence.*;

/*create table REGD_USERS(
userid int primary key auto_increment,
username varchar(50) not null,
useremail varchar(50) not null,
userpassword varchar(10) not null,
role varchar(10) not null
);*/

@Entity
@Table(name="REGD_USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int userid;
	public String username;
	private String useremail;
	private String userpassword;
	private String role;//BUYER OR SELLER
	
	public User() {
		super();
	}

	public User(int userid, String username, String useremail, String userpassword, String role) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.userpassword = userpassword;
		this.role = role;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", useremail=" + useremail + ", userpassword="
				+ userpassword + ", role=" + role + "]";
	}

	

	
}
