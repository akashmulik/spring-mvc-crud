package com.crud.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import com.crud.validators.NoDuplicateEmail;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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

	@Column(name="email", unique=true, nullable=false)
	@NoDuplicateEmail
	@Email
	private String email;
	
	@Column(name="password", nullable=false)
	@Length(min=5, max=8)
	private String pswd;
	
	@Column(name = "mobile_no")
	@Length(min=10, max=12)
	private String mobile;
	
	@Column(name="city")
	@NotNull
	private String city;
	
	@Column(name="status")
	@Transient
	private boolean activeFlag;
	
	@Transient
	@OneToMany(fetch=FetchType.EAGER, mappedBy="user")
	private Set<UserRole> userProfiles;
	
	public Set<UserRole> getUserProfiles() {
		return userProfiles;
	}
	public void setUserProfiles(Set<UserRole> userProfiles) {
		this.userProfiles = userProfiles;
	}
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
	public boolean getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

}
