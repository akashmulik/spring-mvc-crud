package com.crud.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class LoginBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5283942463036109284L;
	@Id
	private int id;
	private String email;
	
	@Column(name="password")
	private String pswd;
	
	@Column(name = "active_flag")
	private String isActive;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
}
