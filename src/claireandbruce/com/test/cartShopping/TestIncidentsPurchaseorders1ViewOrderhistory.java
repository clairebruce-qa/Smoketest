package claireandbruce.com.test.cartShopping;

import junit.framework.Assert;
import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;

import basics.ClaireandbruceTestCase;
/**
 * El usuario autenticado puede ver el historial de pedidos a trav�s del men�
 * de navegaci�n derecho o a trav�s de la pagina de bienvenida de account.
 * Testlink: Local CBT49  - Privalia CBT13
 * @author NEWSHORE
 *
 */
public class TestIncidentsPurchaseorders1ViewOrderhistory extends ClaireandbruceTestCase{

	
	private String message;

	@Test
	public void cbt13() throws Exception{
		message="";
	
		selenium.open(ClaireandbruceUrl);

		//El usuario no debe tener su sesi�n iniciada
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
			Helper.log("No se encuentran lo pedidos en el historial de pedidos");
		} else {
			Assert.assertTrue(selenium.isElementPresent("link=Abierto"));
		
			if ((selenium.isElementPresent("xpath=//div[2]/a"))){
				message = "Ok";
				selenium.click("xpath=//div[2]/a");
				
				selenium.waitForPageToLoad("30000");
				Assert.assertTrue(selenium.isElementPresent("css=tr.totals > td.right-item > span.price"));
				Assert.assertTrue(selenium.isElementPresent("css=div.open.selected > span"));
				if(message == null){
					Helper.log("Login Error " + selenium.getLocation());
					Assert.fail("Login Error " + selenium.getLocation());
					//SeleneseTestCase.fail("Login Error " + selenium.getLocation());
				}
		
				Helper.log("Si existen pedidos en el historial de pedidos " + message);
			}else {
				message = selenium.getText("Error");
			}			
		}	
	}
}
