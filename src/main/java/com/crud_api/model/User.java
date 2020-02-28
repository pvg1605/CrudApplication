package com.crud_api.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity

@Table(name = "Users")
 
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private Integer id;
	
	@Getter @Setter @NotEmpty(message = "first name is required")
	private String firstname;
	
	@Getter @Setter @NotEmpty(message = "last name is required")
	private String lastname;
	
	@Getter @Setter @NotEmpty(message = "email is required")
	private String email;
	
	@Getter @Setter 
	private Long phone;
		
	public User() {
		
	}
	public User(Integer id, String firstname, String lastname, String email, Long phone) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}
}