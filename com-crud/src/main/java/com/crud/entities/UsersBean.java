package com.crud.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Value;

import com.crud.validators.NoDuplicateEmail;

@Entity
@Table(name = "users")
public class UsersBean implements Serializable{

	/**
	 * To ensure that the class who's obj is serialized is not modified after
	 * serialization - java.io.InvalidClassException
	 */
	private static final long serialVersionUID = 4191084969432733904L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank
	@Column(name="name")
	private String name;

	@Column(name="email")
	@NoDuplicateEmail
	private String email;
	
	@Column(name="password")
	private String pswd;
	
	@Column(name = "mobile_no")
	private String mobile;
	
	@Column(name="city")
	private String city;
	
	@Value("Y")
	@Column(name="active_flag")
	private String activeFlag;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
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
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

}
