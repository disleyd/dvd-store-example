package com.easynet.dvdstore.domain;

public class DvdInvalidReference extends Exception {
	
	private static final long serialVersionUID = 5450757393884171019L;
	
	public DvdInvalidReference(String message) {
		super(message);
	}
}
