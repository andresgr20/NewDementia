package com.example.andres.newdementia.model;

public class User {
	private long _id;
	private String username;
	private String name;
	private String password;
	private String role;

	public User(long _id, String name, String username, String password, String role) {
		this.set_id(_id);
		this.setUsername(username);
		this.setPassword(password);
		this.setRole(role);
		this.setName(name);
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override public String toString() {
		return "User{" +
				"_id=" + _id +
				", username='" + username + '\'' +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", role='" + role + '\'' +
				'}';
	}
}
