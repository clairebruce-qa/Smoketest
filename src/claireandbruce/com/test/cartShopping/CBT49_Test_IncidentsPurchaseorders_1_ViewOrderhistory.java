package claireandbruce.com.test.cartShopping;

import junit.framework.Assert;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT49_Test_IncidentsPurchaseorders_1_ViewOrderhistory extends ClaireandbruceTestCase{

	
	@Test
	public void TestHistorialPedidosAbiertoUserLogin() throws Exception{
		
		selenium.deleteAllVisibleCookies();  
		  selenium.open("");

		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		  }
		
		
		String message = null;
		selenium.open("/es_es/customer/account/");
		Assert.assertTrue(selenium.isElementPresent("css=li.user"));
		Assert.assertTrue(selenium.isElementPresent("css=b"));
		if ((selenium.isElementPresent("css=b"))){
			message = "Ok";
		}else {
			message = selenium.getText("Error");
		}
		Assert.assertTrue(selenium.isElementPresent("link=VER HISTORIAL DE PEDIDOS"));
		selenium.click("link=VER HISTORIAL DE PEDIDOS");
		selenium.waitForPageToLoad("30000");
		Assert.assertTrue(selenium.isElementPresent("link=100000006"));
		
		Assert.assertTrue(selenium.isElementPresent("link=Abierto"));
		if ((selenium.isElementPresent("link=Abierto"))){
			message = "Ok";
		}else {
			message = selenium.getText("Error");
		}
		selenium.click("link=Abierto");
		
		selenium.waitForPageToLoad("30000");
		Assert.assertTrue(selenium.isElementPresent("css=tr.totals > td.right-item > span.price"));
		Assert.assertTrue(selenium.isElementPresent("css=div.open.selected > span"));
		if(message == null){
			Helper.log("Login Error " + selenium.getLocation());
			Assert.fail("Login Error " + selenium.getLocation());
			//SeleneseTestCase.fail("Login Error " + selenium.getLocation());
		}

		Helper.log("Si existen pedidos abiertos " + message);
	}
	
}
