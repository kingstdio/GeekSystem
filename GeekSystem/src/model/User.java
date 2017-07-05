package model;

import java.util.List;

/**
 * 
 * @author shand
 * 用户模型
 */
public class User {
	private int id;
	private String userName;
	private String password;
	private String role;
	private String email;
	


	private List<Address> addresslist;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 *获取用户名
	 * @return 用户名
	 */
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
