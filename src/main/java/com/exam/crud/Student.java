package com.exam.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
@Column
private String name;
@Column
private String email;
@Column
private String phone;

public Student() {
	super();
}
public Student(long id, String name, String email, String phone) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone = phone;
}

public long getId() {
	return id;
}
public void setId(long id) {
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
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
}


}
