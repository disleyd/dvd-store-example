/*
 * Copyright Easynet 2006
 */
package com.easynet.dvdstore.domain;

/**
 * @author Jonathan Rogers
 *
 */
public interface DvdService {

	public Dvd retrieveDvd(String dvdReference) throws DvdNotFoundException, DvdInvalidReference;

	public String getDvdSummary(String dvdReference) throws DvdNotFoundException, DvdInvalidReference;
}
