/*
 * Copyright Easynet 2006
 */
package com.easynet.dvdstore.domain;

/**
 * @author Jonathan Rogers
 */
public class DvdReferenceImpl implements Dvd {
	
	private String reference;
	private String title;
	private String review;
	
	/**
	 * Default Ctor
	 * 
	 * @param reference
	 * @param title
	 * @param description
	 */
	public DvdReferenceImpl(String reference, String title, String description) {
		this.reference = reference;
		this.title = title;
		this.review = description;
	}
	
	/* (non-Javadoc)
	 * @see com.easynet.dvdstore.Dvd#getDescription()
	 */
	public String getReview() {
		return review;
	}
	/* (non-Javadoc)
	 * @see com.easynet.dvdstore.Dvd#getReference()
	 */
	public String getReference() {
		return reference;
	}
	/* (non-Javadoc)
	 * @see com.easynet.dvdstore.Dvd#getTitle()
	 */
	public String getTitle() {
		return title;
	}
}
