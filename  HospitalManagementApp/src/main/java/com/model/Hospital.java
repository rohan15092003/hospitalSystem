package com.model;

public class Hospital {
private Integer id;
private String name;
private String email;
private String address;
private String contact;
public Hospital(Integer id, String name, String email, String address, String contact) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.address = address;
	this.contact = contact;
}
public Hospital(String name, String email, String address, String contact) {
	super();
	this.name = name;
	this.email = email;
	this.address = address;
	this.contact = contact;
}
public Hospital() {
	super();
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
@Override
public String toString() {
	return "Hospital [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", contact="
			+ contact + "]";
}


	
}
