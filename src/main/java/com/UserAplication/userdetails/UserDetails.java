package com.UserAplication.userdetails;

import javax.persistence.*;

@Entity
@Table(name = "usertable")
public class UserDetails {

	public UserDetails() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String age;
	private String email;
	private String address;
	private String contact;

	public UserDetails(Long id, String name, String age, String email, String address, String contact) {
		super();

		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.address = address;
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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
		return "UserDetails{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age='" + age + '\'' +
				", email='" + email + '\'' +
				", address='" + address + '\'' +
				", contact='" + contact + '\'' +
				'}';
	}
}
