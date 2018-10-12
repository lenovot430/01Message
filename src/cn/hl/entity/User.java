package cn.hl.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class User {

	private int userId;
	@NotEmpty
	private String account="";
	@Length(min=6,max=20)
	private String pwd="";
	private int age;
	private boolean gender;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String account, String pwd, int age, boolean gender) {
		super();
		this.userId = userId;
		this.account = account;
		this.pwd = pwd;
		this.age = age;
		this.gender = gender;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", account=" + account + ", pwd=" + pwd + ", age=" + age + ", gender="
				+ gender + "]";
	}
	
}
