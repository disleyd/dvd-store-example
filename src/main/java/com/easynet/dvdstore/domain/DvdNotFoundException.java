/*
 * Copyright Easynet 2006
 */
package com.easynet.dvdstore.domain;

/**
 * @author Jonathan Rogers
 */
public class DvdNotFoundException extends Exception {

	private static final long serialVersionUID = -61622029736767221L;

	public DvdNotFoundException(String message) {
		super(message);
	}
}
