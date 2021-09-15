package com.todo.myapp.responses;

public class TodoResponse {
	
	private long id;
	private String contactName;
	private String contactNumero;
	
	public TodoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TodoResponse(long id, String contactName, String contactNumero) {
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
