package com.cita.wallet.app.models;

/**
 * @author Enrique Ramirez
 * 
 *         Class based on the response from the LDAP Authentication Web service
 */
public class LdapResponse {
	private int code;
	private String message;

	public LdapResponse() {

	}

	public LdapResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
