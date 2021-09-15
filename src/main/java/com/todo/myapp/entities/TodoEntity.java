package com.todo.myapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todos")
public class TodoEntity {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String contactName;
	
	@Column(nullable = false)
	private String contactNumero;
	
	public TodoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TodoEntity(long id, String contactName, String contactNumero) {
		super();
		this.id = id;
		this.contactName = contactName;
		this.contactNumero = contactNumero;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumero() {
		return contactNumero;
	}

	public void setContactNumero(String contactNumero) {
		this.contactNumero = contactNumero;
	}
	
}
