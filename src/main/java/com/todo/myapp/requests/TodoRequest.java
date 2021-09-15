package com.todo.myapp.requests;

public class TodoRequest {
	
	private String contactName;
	private String contactNumero;
		
	public TodoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TodoRequest(String contactName, String contactNumero) {
		super();
		this.contactName = contactName;
		this.contactNumero = contactNumero;
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
