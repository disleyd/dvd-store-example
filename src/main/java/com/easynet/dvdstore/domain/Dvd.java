package com.easynet.dvdstore.domain;

public interface Dvd {

	String DVD_REFERENCE_PREFIX = "DVD-";

	/**
	 * @return Returns the description.
	 */
	public abstract String getReview();

	/**
	 * @return Returns the reference.
	 */
	public abstract String getReference();

	/**
	 * @return Returns the title.
	 */
	public abstract String getTitle();

}