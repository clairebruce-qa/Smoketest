package basics;
import junit.framework.Assert;

import org.junit.Test;

import lib.ElementNotFoundException;
import lib.Helper;
import lib.Claireandbruce;


public class TestRecycleBin extends ClaireandbruceTestCase {
	
	// Ya ha sido adaptada a R2

	@Test
	public void TB1361() throws Exception {		
		//Adaptado a R2		
		//TB-1361:Recycle Bin option in Spaces section		
		//Login
		Claireandbruce.login(selenium, username, password);
		
		//go to recycle bin page
		Claireandbruce.gotoRecycleBin(selenium);
		
		//logout
		Claireandbruce.logout(selenium);
	}
	
	@Test
	public void TB1384() throws Exception {
		
		//Adaptado a R2		
		//TB-1384:Walk thru Recycle bin section different language		
		//Login
		Claireandbruce.login(selenium, username, password);
		
		//Putting in english
		Claireandbruce.setLanguageEN(selenium);
		
		//go to recycle bin page
		Claireandbruce.gotoRecycleBin(selenium);
		
		//logout
		Claireandbruce.logout(selenium);
	}	
	
	@Test
	public void TB1362() throws Exception {		
		//Adaptado a R2		
		//TB-1362:Delete Files/Folders dialog box		
		//Login
		Claireandbruce.login(selenium, username, password);
		
		//Clean the online files
		Claireandbruce.deleteAllOnlineFiles(selenium);
		
		//Upload a file
		Claireandbruce.uploadFile(selenium, "contact_terabox.docx");
		
		//Select and delete the file
		Claireandbruce.deleteOnlineFile(selenium, "contact_terabox.docx");
				
		//logout
		Claireandbruce.logout(selenium);
	}
	
	@Test
	public void TB1364() throws Exception {		
		//Adaptado a R2		
		//TB-1364:Delete Files/Folders in "File Manager" or "Backups" section		
		//login
		Claireandbruce.login(selenium, username, password);
		
		//Clear online files
		Claireandbruce.deleteAllOnlineFiles(selenium);
		
		Claireandbruce.deleteAllRecycleBin(selenium);
		//Upload a file
		Claireandbruce.uploadFile(selenium, "dns.txt");
		
		//Delete the file
		Claireandbruce.deleteOnlineFile(selenium, "dns.txt");
		
		//Verify the deleted file is in the recycle bin
		Assert.assertTrue(Claireandbruce.isFileInRecycleBin(selenium, "dns.txt"));
		
		//Log out
		Claireandbruce.logout(selenium);		
	}

	@Test
	public void TB1366() throws Exception {		
		//Adaptado a R2		
		//TB-1366:Task bar funtionality		
		Claireandbruce.login(selenium, username, password);
		
		//clear all
		Claireandbruce.deleteAllOnlineFiles(selenium);
		Claireandbruce.deleteAllRecycleBin(selenium);
		
		Claireandbruce.gotoHomePage(selenium);
		
		//Upload a file
		Claireandbruce.uploadFile(selenium, "dns.txt");
		
		//Delete the upload file
		Claireandbruce.deleteAllOnlineFiles(selenium);
		
		//Goto recycle bin
		Claireandbruce.gotoRecycleBin(selenium);
		
		//Assert task bar links are not active
		Assert.assertFalse(Claireandbruce.isDivVisible(selenium, "button_item button-blue btn-recover left", "Click here to restore selected files to its origin folder."));
		Assert.assertFalse(Claireandbruce.isDivVisible(selenium, "button_item button-grey btn-delete left", "Click here to permanently delete selected files."));

		//select file
		Claireandbruce.selectFile(selenium, "dns.txt");
		
		Claireandbruce.logout(selenium);		
	}


	@Test
	public void TB1386() throws Exception{		
		//Adaptado a R2		
		//TB-1386:Files deleted not appear in search results		
		Claireandbruce.login(selenium, username, password);
		
		Claireandbruce.deleteAllOnlineFiles(selenium);
		
		Claireandbruce.uploadFile(selenium, "dns.txt");
		
		Assert.assertEquals("searchOk",Claireandbruce.search(selenium, "dns"));
		
		Claireandbruce.deleteAllOnlineFiles(selenium);
		
		Assert.assertNotSame("searchOk",Claireandbruce.search(selenium, "dns"));
		
		Claireandbruce.logout(selenium);		
	}

	@Test
	public void TB1378() throws Exception{		
		//Adaptado a R2		
		// TB-1378:Delete Albums not sent to Recycle Bin		
		Claireandbruce.login(selenium, username, password);
		
		String albumName = "TB1378";
		
		try{
			Claireandbruce.deleteAlbum(selenium, albumName);
		}catch(ElementNotFoundException e){}
				
		Claireandbruce.createAlbum(selenium, albumName);
		
		Claireandbruce.deleteAlbum(selenium, albumName);
		
		Claireandbruce.gotoRecycleBin(selenium);
		
		Assert.assertFalse(selenium.isTextPresent(albumName));
		
		Claireandbruce.logout(selenium);
	}

	/*
	 * IPV: test obsoleto, ya no se testea
	 *
	@Test
	public void TB1372() throws Exception{
		//TB-1372:Dialog box to permanently delete Files/Folders
		
		Tb.login(selenium, username, password);
		
		//clean the environment
		Tb.deleteAllOnlineFiles(selenium);
		Tb.deleteAllRecycleBin(selenium);
		
		String fileName = "dns.txt";
		
		Tb.uploadFile(selenium, fileName);
		
		Tb.deleteOnlineFile(selenium, fileName);
		
		
		Tb.gotoRecycleBin(selenium);
		
		//select the file
		Tb.selectFile(selenium, fileName);
		
		//Click to delete a file
	    selenium.click("//a[@class='Delete']");
		
		//Wait for window Delete
	    Helper.waitForElement(selenium,"//*[@id='FirstInnerTabMiddle']", "The Window Delete dont appear");
	    
	    //Assert dialog text
	    Assert.assertEquals("You are about to permanently delete the item(s) below. You will not be able to recover these items in the future.", selenium.getText("//span[@id[contains(. ,'_DeleteContentControl_DeleteNotice')]]"));
	    
		//Assert delete button
	    Assert.assertTrue(selenium.isElementPresent("//span[@class='icon16 ok16']"));
		
		//Assert cancel button
	    Assert.assertTrue(selenium.isElementPresent("//span[@class='icon16 cancel16']"));
		
		//logout
		Tb.logout(selenium);
		
		
	}*/
	
	@Test
	public void TB1373() throws Exception{		
		//Adaptado a R2		
		//TB-1373:Delete permanently a File/Folder		
		Claireandbruce.login(selenium, username, password);
		
		//clean the environment
		Claireandbruce.deleteAllOnlineFiles(selenium);
		Claireandbruce.deleteAllRecycleBin(selenium);
		
		String fileName = "dns.txt";
		
		Claireandbruce.uploadFile(selenium, fileName);
		
		Claireandbruce.deleteOnlineFile(selenium, fileName);
		
		Claireandbruce.gotoRecycleBin(selenium);
		
		Claireandbruce.deleteRecycleBinFile(selenium, fileName);
		
		Assert.assertFalse(Claireandbruce.isFileInRecycleBin(selenium, fileName));
	
		//logout
		Claireandbruce.logout(selenium);		
	}

	@Test
	public void TB1375() throws Exception{		
		//Adaptado a R2		
		//TB-1375:Delete permanently all Files/Folders existing		
		Claireandbruce.login(selenium, username, password);
		
		//clean the environment
		Claireandbruce.deleteAllOnlineFiles(selenium);
		Claireandbruce.deleteAllRecycleBin(selenium);
		
		String fileName = "dns.txt";
		String folderName = "TB1375";
		
		Claireandbruce.uploadFile(selenium, fileName);
		Claireandbruce.deleteOnlineFile(selenium, fileName);
		
		Claireandbruce.createFolder(selenium, folderName);
		Claireandbruce.deleteFolder(selenium, folderName);
		
		Claireandbruce.gotoRecycleBin(selenium);
		Claireandbruce.deleteAllRecycleBin(selenium);
		
		Assert.assertFalse(Claireandbruce.isFileInRecycleBin(selenium, fileName));
	
		Assert.assertFalse(Claireandbruce.isFileInRecycleBin(selenium, folderName));

		//logout
		Claireandbruce.logout(selenium);		
	}

	@Test
	public void TB1369() throws Exception{		
		//Adaptado a R2		
		// TB-1369:Restoring Files/Folders		
		Claireandbruce.login(selenium, username, password);
		
		//clean the environment
		//Tb.deleteAllOnlineFiles(selenium);
		//Tb.deleteAllRecycleBin(selenium);
		
		String fileName = "dns.txt";
		String folderName = "TB1375";
		
		//Tb.uploadFile(selenium, fileName);
		//Tb.deleteOnlineFile(selenium, fileName);
		
		//Tb.createFolder(selenium, folderName);
		//Tb.deleteFolder(selenium, folderName);
		
		Claireandbruce.gotoRecycleBin(selenium);
		Claireandbruce.restoreRecycleBinFile(selenium,fileName);
		Claireandbruce.restoreRecycleBinFile(selenium,folderName);		
		
		Assert.assertTrue(Claireandbruce.isFileInOnlineFiles(selenium, fileName));
		Assert.assertTrue(Claireandbruce.isFileInOnlineFiles(selenium, folderName));

		//logout
		Claireandbruce.logout(selenium);			
	}
	
	@Test
	public void TB1382() throws Exception{		
		//Adaptado a R2		
		//Verify if when the current version of the file is deleted, only the current version shall appear in the Recycle Bin.	
		Claireandbruce.login(selenium, username, password);
		
		//clear the environment
		Claireandbruce.deleteAllOnlineFiles(selenium);
		Claireandbruce.deleteAllRecycleBin(selenium);
		
		String fileName = "dns.txt";
		
		Claireandbruce.uploadFile(selenium, fileName);
		Claireandbruce.uploadFile(selenium, fileName);
		Claireandbruce.uploadFile(selenium, fileName);
		
		//assert that there is a versioned file
		Assert.assertTrue("Versioning icon is not present, maybe the versioning is not working!!",selenium.isElementPresent("//tr[@id[contains(.,'file_')]]/td[1]/span[3]"));
		
		Claireandbruce.deleteOnlineFile(selenium, fileName);
		
		Claireandbruce.gotoRecycleBin(selenium);
		
		Assert.assertTrue(selenium.isElementPresent("//*[@class='left sprite_icon ico_file_off file-type']"));
		
		Claireandbruce.logout(selenium);		
	}
	
	@Test
	public void TB1388() throws Exception{		
		//Adaptado a R2		
		//Verify that when a file is restored, the prior versions of the file will be restored too	
		Claireandbruce.login(selenium, username, password);
		
		//clear the environment
		Claireandbruce.deleteAllOnlineFiles(selenium);
		Claireandbruce.deleteAllRecycleBin(selenium);
		
		String fileName = "dns.txt";
		
		Claireandbruce.uploadFile(selenium, fileName);
		Claireandbruce.uploadFile(selenium, fileName);
		Claireandbruce.uploadFile(selenium, fileName);
		
		//assert that there is a versioned file
		Assert.assertTrue("Versioning icon is not present, maybe the versioning is not working!!",selenium.isElementPresent("//tr[@id[contains(.,'file_')]]/td[1]/span[3]"));
		
		Claireandbruce.deleteOnlineFile(selenium, fileName);
		
		Claireandbruce.gotoRecycleBin(selenium);
		
		Assert.assertTrue(selenium.isElementPresent("//*[@class='left sprite_icon ico_file_off file-type']"));

		Claireandbruce.selectFile(selenium, fileName);
		
		Claireandbruce.restoreRecycleBinFile(selenium,fileName);
		
		Claireandbruce.gotoHomePage(selenium);
		
		Assert.assertTrue("Versioning icon is not present, maybe the versioning is not working!!",selenium.isElementPresent("//tr[@id[contains(.,'file_')]]/td[1]/span[3]"));

		Claireandbruce.logout(selenium);		
	}
	
	@Test
	public void TB1365() throws Exception{		
		//Adaptado a R2		
		//Verify if the user cannot open a Folders displayed on Recycle Bin		
		Claireandbruce.login(selenium, username, password);
		
		//clear the environment
		Claireandbruce.deleteAllOnlineFiles(selenium);
		Claireandbruce.deleteAllRecycleBin(selenium);
		
		Claireandbruce.gotoHomePage(selenium);
		
		String folderName = "automationTB1365";
		
		Claireandbruce.createFolder(selenium, folderName);
		
		Claireandbruce.deleteFolder(selenium, folderName);
		
		Claireandbruce.gotoRecycleBin(selenium);
		
		selenium.click("//a[@title='"+folderName+"']");
			
		Thread.sleep(5000);
		
		Assert.assertEquals("Recycle bin", selenium.getText("//a[@title='Recycle bin']"));

		Claireandbruce.logout(selenium);		
	}
}
