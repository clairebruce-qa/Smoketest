package basics;
import junit.framework.Assert;

import org.junit.Test;

import lib.Claireandbruce;

public class TestSettingsOption extends ClaireandbruceTestCase {
	
	@Test
	public void TB1215() throws Exception{
		/*
		 * last name fields  with many characters
		 */
		
		Claireandbruce.login(selenium, username, password);
			
		Assert.assertEquals("setUserNameOk",Claireandbruce.setUserName(selenium, "", ""));
	
		///Makes no sense in R2, max lenght is limited programatically, no error message is shown as the user can't exceed 50 characters
		//Assert.assertEquals("The first name exceeds the maximum length of 50 characters.",Tb.setUserName(selenium, "1234512345123451234512345123451234512345123451234445", "last name"));
		//Assert.assertEquals("The last name exceeds the maximum length of 50 characters.",Tb.setUserName(selenium, "Pipo", "$%%%·$·$%·$%·$%·$%·$5353453 25233gv5325gf32523452352"));
	
		Assert.assertEquals("setUserNameOk",Claireandbruce.setUserName(selenium, "Testabil", "Testabil"));
		
		Claireandbruce.logout(selenium);
	}
	
	///Makes no sense in R2, max lenght is limited programatically, no error message is shown as the user can't exceed 50 characters
//	@Test
//	public void TB1332() throws Exception{
//		/*
//		 * name fields  with many characters
//		 */
//		
//	Tb.login(selenium, username, password);
//	
//	Assert.assertEquals("The first name exceeds the maximum length of 50 characters.",Tb.setUserName(selenium, "1234512345123451234512345123451234512345123451234445", "last name"));
//		
//	Tb.logout(selenium);
//
//	}
	
	
	@Test
	public void TB1217() throws Exception{
	
	/*
	 * Check that language can be changed. Language option list values are correctly written.
	 */		
		Claireandbruce.login(selenium, username, password);		
		Claireandbruce.setLanguageEN(selenium);		
		Claireandbruce.setLanguageES(selenium);		
		Claireandbruce.setLanguageEN(selenium);		
		Claireandbruce.logout(selenium);
	}
}
