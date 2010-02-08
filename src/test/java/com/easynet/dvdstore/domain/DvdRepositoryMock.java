package com.easynet.dvdstore.domain;

import java.util.HashMap;
import java.util.Map;

public class DvdRepositoryMock implements DvdRepository {
	
	static final String DVD_TOPGUN_REFERENCE = Dvd.DVD_REFERENCE_PREFIX + "TG423";
	static final String DVD_DIRTYDANCING_REFERENCE = Dvd.DVD_REFERENCE_PREFIX + "DD878";
	static final String DVD_SHREK_REFERENCE = Dvd.DVD_REFERENCE_PREFIX + "S765";
	
	static final Dvd TOPGUN = new DvdReferenceImpl(DVD_TOPGUN_REFERENCE, "Topgun", "All action film");
	static final Dvd DIRTYDANCING = new DvdReferenceImpl(DVD_DIRTYDANCING_REFERENCE, "Dirty Dancing", "Nobody leaves baby in the corner");
	static final Dvd SHREK = new DvdReferenceImpl(DVD_SHREK_REFERENCE, "Shrek", "Green monsters seem to be all " +
			"the rage these days, what with Hulk, Yoda, and that big ugly troll " +
			"thingy out of the first Harry Potter movie. But Shrek, the flatulent " +
			"swamp-dwelling ogre with a heart of gold (well, silver at least), " +
			"is more than capable of rivalling any of them.");
			
	private static final Map<String, Dvd> dvds = new HashMap<String, Dvd>();
	
	static {
		dvds.put(DVD_TOPGUN_REFERENCE, TOPGUN);
		dvds.put(DVD_DIRTYDANCING_REFERENCE, DIRTYDANCING); 
		dvds.put(DVD_SHREK_REFERENCE, SHREK); 
	}
	
	@Override
	public Dvd retrieveDvd(String reference) {
		return dvds.get(reference);
	}	
}
