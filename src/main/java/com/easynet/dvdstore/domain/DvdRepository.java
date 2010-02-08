/*
 * Copyright Easynet 2006
 */
package com.easynet.dvdstore.domain;

/**
 * @author Jonathan Rogers
 *
 */
public interface DvdRepository {
	
	Dvd retrieveDvd(String reference);
	
}
