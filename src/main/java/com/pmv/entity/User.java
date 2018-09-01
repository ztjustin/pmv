package com.pmv.entity;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="image",nullable=false)
	private byte[] image;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="role_id", nullable=false)
	private Role role;

	public User(String userName, boolean enable, String password) {
		super();
		this.userName = userName;
		this.enable = enable;
		this.password = password;
	}
	
	public User(String userName, String name, String lastName, int age, boolean enable, String password, byte[] image,
			Role role) {
		super();
		this.userName = userName;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.enable = enable;
		this.password = password;
		this.image = image;
		this.role = role;
	}


	public User() {
		super();
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
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	//return the string code
    public String getImageEncoded() {
    	byte[] encodeImage = Base64.getEncoder().encode(this.image);
        return new String(encodeImage);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (enable ? 1231 : 1237);
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (enable != other.enable)
			return false;
		if (!Arrays.equals(image, other.image))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
    
}
