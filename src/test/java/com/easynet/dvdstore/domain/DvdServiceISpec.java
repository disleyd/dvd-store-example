package com.easynet.dvdstore.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DvdServiceISpec {
	
	private static String INVALID_DVD_REFERENCE = "INVALID-TEXT";
	private static String DVD_NOT_FOUND_REFERENCE = "DVD-999";
	
	public static class TestRetrieveDvd {
	
		private DvdService dvdService;
		
		@Before
		public void setUp() {
			dvdService = new DvdServiceImpl(new DvdRepositoryMock());
		}

		@Test
		public void shouldRetrieveADvd() throws DvdNotFoundException, DvdInvalidReference {
			Dvd result = dvdService.retrieveDvd(DvdRepositoryMock.DVD_TOPGUN_REFERENCE);
			assertEquals(DvdRepositoryMock.TOPGUN, result);
		}
		
		@Test(expected=DvdNotFoundException.class)
		public void shouldThrowNotFoundWhenDvdNotFound() throws DvdNotFoundException, DvdInvalidReference {
			dvdService.retrieveDvd(DVD_NOT_FOUND_REFERENCE);
		}
		
		@Test(expected=DvdInvalidReference.class)
		public void shouldThrowInvalidReferenceWhenDvdReferenceIsInvalid() throws DvdNotFoundException, DvdInvalidReference {
			dvdService.retrieveDvd(INVALID_DVD_REFERENCE);
		}
		
		@Test(expected=DvdInvalidReference.class)
		public void shouldThrowInvalidReferenceWhenDvdReferenceIsNull() throws DvdNotFoundException, DvdInvalidReference {
			dvdService.retrieveDvd(null);
		}
	}
	
	public static class TestGetDvdSummary {
		
		private DvdService dvdService;
		
		@Before
		public void setUp() {
			dvdService = new DvdServiceImpl(new DvdRepositoryMock());
		}
		
		@Test
		public void shouldReturnADvdSummary() throws DvdNotFoundException, DvdInvalidReference {
			String dvdSummary1 = dvdService.getDvdSummary(DvdRepositoryMock.DVD_TOPGUN_REFERENCE);
			assertEquals("[DVD-TG423] Topgun - All action film", dvdSummary1);
			
			String dvdSummary2 = dvdService.getDvdSummary(DvdRepositoryMock.DVD_SHREK_REFERENCE);
			assertEquals("[DVD-S765] Shrek - Green monsters seem to be all the rage these days...", dvdSummary2);
		}
	
		@Test(expected=DvdInvalidReference.class)
		public void shouldThrowInvalidReferenceWhenDvdReferenceIsInvalid() throws DvdNotFoundException, DvdInvalidReference {
			dvdService.getDvdSummary(INVALID_DVD_REFERENCE);
		}
		
		@Test(expected=DvdInvalidReference.class)
		public void shouldThrowInvalidReferenceWhenDvdReferenceIsNull() throws DvdNotFoundException, DvdInvalidReference {
			dvdService.getDvdSummary(null);
		} 
		
		@Test(expected=DvdNotFoundException.class)
		public void shouldThrowNotFoundWhenDvdNotFound() throws DvdNotFoundException, DvdInvalidReference {
			dvdService.retrieveDvd(DVD_NOT_FOUND_REFERENCE);
		}
	}
}
