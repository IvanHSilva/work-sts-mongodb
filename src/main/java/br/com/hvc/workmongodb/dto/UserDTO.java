package br.com.hvc.workmongodb.dto;

import java.io.Serializable;

import br.com.hvc.workmongodb.domain.User;

public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public UserDTO() {
	}

	public UserDTO(User u) {
		id = u.getId();
		name = u.getName();
		email = u.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}