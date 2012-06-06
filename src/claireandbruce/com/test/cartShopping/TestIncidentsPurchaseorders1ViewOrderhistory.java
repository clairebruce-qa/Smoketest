package claireandbruce.com.test.cartShopping;

import junit.framework.Assert;
import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;

import basics.ClaireandbruceTestCase;
/**
 * 
 * @author NEWSHORE
 *
 */
public class TestIncidentsPurchaseorders1ViewOrderhistory extends ClaireandbruceTestCase{

	
	private String message;

	@Test
	public void TestHistorialPedidosAbiertoUserLogin() throws Exception{
		message="";
	
		selenium.open(ClaireandbruceUrl);

		//El usuario no debe tener su sesión iniciada
		if(!selenium.isElementPresent("xpath=//a[contains(text(), 'Salir')]")){
			
			LibCorrectLogonValidUserAccout.CBT55(selenium);
			
		}
		Helper.log(selenium.getLocation());
		if(!selenium.isElementPresent("xpath=//a[contains(text(), 'Mi cuenta')]")){			
			selenium.click("css=a.header-user-logged");
			selenium.waitForPageToLoad("30000");			
		}
			
		selenium.click("//a[contains(text(),'Mi cuenta')]");
			
		selenium.waitForPageToLoad("30000");
		
	
		if(!selenium.isElementPresent("//a[contains(text(),'VER HISTORIAL DE PEDIDOS')]")){
			Assert.fail("Link Historial de pedidos no se encuentra");
		}
		
		selenium.click("//a[contains(text(),'VER HISTORIAL DE PEDIDOS')]");
		selenium.waitForPageToLoad("30000");
		
		if(!selenium.isElementPresent("//span[2]/a"))
		{
			Assert.fail("No se encuentran los pedidos");
		}
		
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
