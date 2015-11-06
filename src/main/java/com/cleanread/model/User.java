package com.cleanread.model;

public class User {
	private String email;
	private String username;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean equals(User user){
		if(this.email.equals(user.getEmail()))
			return true;
		else 
			return false;
	}
	
	public String toString(){
		return this.email + " " + this.username + " " + this.password;
	}
}
