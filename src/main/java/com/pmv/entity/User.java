package com.pmv.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="username",nullable=false,unique=true,length=45)
	private String userName;
	
	@Column(name="name",nullable=false,length=50)
	private String name;
	
	@Column(name="lastname",nullable=false,length=50)
	private String lastName;
	
	@Column(name="age",nullable=false)
	private int age;
	
	@Column(name="enable",nullable=false)
	private boolean enable;
	
	@Column(name="password",nullable=false)
	private String password;
	
	/*@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="image",nullable=false)
	private byte[] image;*/
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="role_id", nullable=false)
	private Role role;


	public User() {
		super();
	}
	
	public User(String userName, String name, String lastName, int age, boolean enable, String password, Role role) {
		super();
		this.userName = userName;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.enable = enable;
		this.password = password;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	/*//return the string code
    public String getImageEncoded() {
    	byte[] encodeImage = Base64.getEncoder().encode(this.image);
        return new String(encodeImage);
    }*/


    
}
