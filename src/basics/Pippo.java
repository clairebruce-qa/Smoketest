package basics;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import lib.ElementNotFoundException;
import lib.Helper;
import lib.Claireandbruce;

import com.thoughtworks.selenium.SeleneseTestCase;
import org.junit.Assert;
import org.junit.Test;

public class Pippo extends ClaireandbruceTestCase {
	
	@Test
	public void TB1365() throws Exception{
		//Verify if the user cannot open a Folders displayed on Recycle Bin
		
		Claireandbruce.login(selenium, username, password);
		
		//clear the environment
		/*
		Tb.deleteAllOnlineFiles(selenium);
		Tb.deleteAllRecycleBin(selenium);
		
		Tb.gotoHomePage(selenium);
		
		String folderName = "automationTB1365";
		
		Tb.createFolder(selenium, folderName);
		
		Tb.deleteFolder(selenium, folderName);
		
		Tb.gotoRecycleBin(selenium);
		
		selenium.click("//a[@title='"+folderName+"']");
			
		Thread.sleep(5000);
		
		Assert.assertEquals("Recycle bin", selenium.getText("//a[@title='Recycle bin']"));
*/
		Claireandbruce.logout(selenium);
		
	}
	
}
