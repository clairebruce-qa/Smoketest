package basics;
import org.junit.Assert;
import org.junit.Test;

import lib.Claireandbruce;


public class TestGuestLlistManagement extends ClaireandbruceTestCase {

	//Clase adaptada a R2
	
	@Test
	public void TB1214() throws Exception{		
		//TB-1214:Guest_List: create a wrong email User	
		Claireandbruce.login(selenium, username, password);		
		Assert.assertEquals("Email address requiered.",Claireandbruce.addGuest(selenium, "name", "lastName", "email"));		
		Claireandbruce.logout(selenium);		
	}
		
	/*
	@Test
	public void TB1216() throws Exception{
		
		//TB-1216:Guest_List: create a wrong name User
	
		Tb.login(selenium, username, password);
		
		String longName = "martino123martino123martino123martino123martino1231";
		
		Assert.assertEquals("The first name exceeds the maximum length of 50 characters.",Tb.addGuest(selenium, longName, "lastName", "email2@it.it"));
		
		Tb.logout(selenium);
		
	}
	*/
	
	/*
	 * IPV: Test Obsotelto, ya no se testea 
	 
	@Test
	public void TB1322() throws Exception{
		
		//TB-1322:Create User
	
		Tb.login(selenium, username, password);
			
		Tb.deleteAllGuest(selenium);
		
		Assert.assertEquals("addGuestOk",Tb.addGuest(selenium, "AutomationName", "Automation lastName", "email@pippo.it"));
		
		Tb.deleteGuest(selenium, "email@pippo.it");
		Tb.logout(selenium);
		
	}*/
	
	/*
	 * IPV:  Test borrado TestCloud, ya no se testea
	 *
	@Test
	public void TB1113() throws Exception{
		
		//TB-1133:Guest_List "editar" option in action bar
	
		Tb.login(selenium, username, password);
			
		Tb.deleteAllGuest(selenium);
		
		Assert.assertEquals("addGuestOk",Tb.addGuest(selenium, "AutomationName", "Automation lastName", "email@pippo.it"));
		
		Tb.editGuest(selenium, "email@pippo.it");
		
		Tb.deleteGuest(selenium, "email@pippo.it");
		Tb.logout(selenium);
		
	}*/
}
