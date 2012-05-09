package claireandbruce.com.test.shopping;

import lib.Claireandbruce;
import lib.Helper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class TestShoppingCartWithProduct extends ClaireandbruceTestCase{
	
	TestEmptyShoppingCart tb = new TestEmptyShoppingCart();
	
	@Before
	public void setLogin() throws Exception{
	
		
		//Para Abrir otra ventana
		selenium.deleteAllVisibleCookies();  
		  selenium.open("");

		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		   System.out.print("Si entra");
		  }	
		  	
		  
		  Claireandbruce.login(selenium, username, password);
		  
		  Helper.waitForElement(selenium, "//a[contains(text(),'Salir')]", "Log-out link not found in the page");
	
		  Helper.clickAndVerify(selenium, "class=button-shopping-now", "Compra Ahora","//ol[@id='mini-cart']/li/span/span");
	}
	
	@Test
	public void TestSCWP() throws Exception{
		
		Helper.clickAndVerify(selenium, "class=button-shopping-now", "Sigue comprando","css=div.continue-shopping > span");
		
		//Helper.clickAndVerify(selenium, "css=div.continue-shopping > span", "","css=canvas..firepath-matching-node");
		
		
		if((selenium.isSomethingSelected("css=div.continue-shopping > span")))
		{
			 Helper.waitForElement(selenium, "css=div.add-to-box > div.add-to-cart > button.button", "OK");
			 
		
			  
		}else{
			
		}
		
	}
	
	@After
	public void closed() throws Exception{
		Claireandbruce.logout(selenium);
	}

	
}
