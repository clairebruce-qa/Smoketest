package basics;
import junit.framework.Assert;

import org.junit.Test;

import com.thoughtworks.selenium.SeleneseTestCase;

import lib.ElementNotFoundException;
import lib.Helper;
import lib.Claireandbruce;


public class TestRegresionTest extends ClaireandbruceTestCase {	
	// Ya ha sido adaptada a R2	
	/*
	 *  IPV: Desde Release 1.5.A.3 se pueden crear de hasta 55 char despues peta la applicacion (intesteable automaticamente pq aplicacion inestable)
	 * 
	*/
	
	@Test
	public void TB1337() throws Exception{	
		// Ya ha sido adaptado a R2
		SeleneseTestCase stclocal = new SeleneseTestCase();
		
		//Verify if Terabox work correctly with 100 users created
		Claireandbruce.login(selenium, username, password);
		Claireandbruce.deleteAllGuest(selenium);
		
		int i;
		i = 0;
		
		for(i =1;i<=100;i++){			
			String name		="name"+i;
			String lastName	="lastName"+i;
			String email	="email"+i+"@automation.com";
			Claireandbruce.addGuest(selenium, name, lastName, email);
		}
		
		//wait and click Shared link in top toolbar	
		selenium.click("//div[@id='main-subheader']/div[1]/div[1]/ul/li[5]/a/cufon/canvas");
		selenium.waitForPageToLoad("60000");
		
		//wait and click Guest list link
		selenium.click("//div[@id='main-wrapper']/div[1]/div/div[1]/div/ul/li[2]/a/cufon[2]/canvas");
		
		//IPV: añadir espera
		Thread.sleep(6000);		
		
		stclocal.verifyTrue(selenium.isTextPresent(i +" contacts in total"));
		Claireandbruce.logout(selenium);		
	}


	@Test
	public void TB1341() throws Exception{		
		// Ya ha sido adaptado a R2
		//TB-1341:Calendar in "Compartir Elementos" screen
		
		Claireandbruce.login(selenium, username, password);
		
		String fileName = "dns.txt";
		
		//clear
		Claireandbruce.deleteAllOnlineFiles(selenium);
		
		Claireandbruce.uploadFile(selenium, fileName);
		
		Assert.assertEquals("onlineFilesShareOk",Claireandbruce.onlineFilesShare(selenium, fileName, "test@test.com"));
		
		Claireandbruce.logout(selenium);
	}	

	@Test
	public void TB1355() throws Exception{		
		// Ya ha sido adaptado a R2
		Helper.log("TB-1355:Lightbox section in Albumes link");
		
		Claireandbruce.login(selenium, username, password);
		
		String albumName = "TB1355";
		
		try{
			Claireandbruce.deleteAlbum(selenium, albumName);
			}catch(ElementNotFoundException e){Helper.log("Album "+albumName+" not deleted becouse do no exist");}
			
		Claireandbruce.createAlbum(selenium, albumName);
		
		Claireandbruce.openAlbum(selenium, albumName);
		
		// assert that the tool tips aer present for the different tabs	
		selenium.click("class=jNiceSelectText");
		
		Helper.waitForElement(selenium, "link=only videos", "The 'only videos' toot tip is not shown in Album manager");
		Helper.waitForElement(selenium, "link=only audio", "The 'only audio' toot tip is not shown in Album manager");
		Helper.waitForElement(selenium, "link=only audio", "The 'only images' toot tip is not shown in Album manager");		
		
		Claireandbruce.logout(selenium);		
	}	

	
	@Test
	public void TB1363() throws Exception{		
		// Ya ha sido adaptado a R2
		SeleneseTestCase stclocal = new SeleneseTestCase();
		
		Helper.log(" TB-1363:492_R.1.5_Album_Upload your media file with long names");
		//Tb.login(selenium, "usuario_tb_3", password);
		//IPV: los usuarios han cambiado
		Claireandbruce.login(selenium, username, password);
	
		//clear
		Claireandbruce.deleteAllOnlineFiles(selenium);
		
		String fileName = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111112222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222333333333333333333333333333333333333333333.jpg";
		Claireandbruce.uploadFile(selenium, fileName);

		Claireandbruce.selectFile(selenium, fileName);
		
		//selecciono el combo box que me permitira agergar a un albúm que crearé al mismo tiempo
		selenium.click("class=jNiceSelectText");
		
		selenium.click("link=add to album");

		Helper.waitForElement(selenium, "//div[@id='dialog-popup']", "Add to albúm windows not shown");
		
		// click on "Create new collection" radio button
		selenium.click("//input[@id='lightbox-add-new-col']");
		
		selenium.type("//input[@id='add-newLightBoxName']", "automationTest001");	

		//Click on accept button
		selenium.click("//form[@id='form-lightbox-add']/div/div/div[5]/div/div");
	
		//IPV: añadir espera
		Thread.sleep(6000);
		
		stclocal.verifyTrue(selenium.isElementPresent("//span[@class='left sprite_icon ico_add_col']"));

		Claireandbruce.deleteAlbum(selenium, "automationTest001");
		
		Claireandbruce.logout(selenium);		
	}
}
