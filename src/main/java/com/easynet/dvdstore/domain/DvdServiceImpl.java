package com.easynet.dvdstore.domain;

public class DvdServiceImpl implements DvdService {

	static final String APPEND_TO_SUMMARY = "...";
	static final int NUMBER_OF_WORDS_IN_SUMMARY = 10;
	
	private DvdRepository dvdRepository;
	
	public DvdServiceImpl(DvdRepository dvdRepository) {
		this.dvdRepository = dvdRepository;
	}

	@Override
	public String getDvdSummary(String dvdReference) throws DvdNotFoundException, DvdInvalidReference {
		Dvd dvd = retrieveDvd(dvdReference);
		
		StringBuilder dvdSummary = new StringBuilder()
				.append("[")
				.append(dvd.getReference())
				.append("]")
				.append(" ")
				.append(dvd.getTitle())
				.append(" - ")
				.append(abbreviate(dvd.getReview(), NUMBER_OF_WORDS_IN_SUMMARY, APPEND_TO_SUMMARY));
		
		return dvdSummary.toString();
	}

	@Override
	public Dvd retrieveDvd(String dvdReference) throws DvdNotFoundException, DvdInvalidReference {		
		validateDvdReference(dvdReference);
		
		Dvd dvd = dvdRepository.retrieveDvd(dvdReference);
		
		if (dvd == null) throw new DvdNotFoundException("Not found: " + dvdReference);
		
		return dvd;
	}

	private void validateDvdReference(String dvdReference) throws DvdInvalidReference {
		if (dvdReference == null) 
				throw new DvdInvalidReference("Invalid reference: <NULL>.  Reference must start with: " + Dvd.DVD_REFERENCE_PREFIX);
		
		if (!dvdReference.startsWith(Dvd.DVD_REFERENCE_PREFIX)) 
				throw new DvdInvalidReference("Invalid reference: <" + dvdReference + ">.  Reference must start with: " + Dvd.DVD_REFERENCE_PREFIX);
	}
	
	private String abbreviate(String source, int numberOfWords, String append) {
		if ((source == null) || (source.equals("")) || (source.trim().equals(""))) return source; 
		
		String[] words = source.split("[ ,]");	
		if (words.length <= numberOfWords) return source;
		
		StringBuilder resultBuilder = new StringBuilder();
		
		for (int index = 0; index < numberOfWords; index++)  
			resultBuilder.append(words[index]).append(" "); 
		
		String result = resultBuilder.toString();

		return result.trim() + append;
	}
}
