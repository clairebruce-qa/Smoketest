package claireandbruce.com.test.account;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;
import org.junit.Test;
import org.testng.Assert;

import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;

import basics.ClaireandbruceTestCase;

/**
 * Especificaci�n de prueba para la verificaci�n  y validaci�n de una direcci�n de env�o 
 * de pedido para ser a�adida a las direcciones con datos validos.
 * El �xito de la prueba ser� el ingreso al sistema de la nueva direcci�n 
 * CBT13
 * @author NEWSHORE
 *
 */
public class TestUserAddress1AddShippingAddressUserWithValidFields extends ClaireandbruceTestCase {
		
	@Test
	public void CBT13() throws Exception{
		
		selenium.deleteAllVisibleCookies();
		
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		int i =(int)(Math.random()*100);
		//El usuario debe tener su sesi�n iniciada
		if(selenium.isElementPresent("link=Salir")) {
			selenium.click("link=Salir");
			selenium.waitForPageToLoad("15000");
			
			if(selenium.isElementPresent("id=email")){
				selenium.type("id=email", username);
				selenium.type("id=pass", password);
				selenium.click("id=send2");
				selenium.waitForPageToLoad("15000");
			} else {
				LibCorrectLogonValidUserAccout.CBT55(selenium);
			}
		} else {
			LibCorrectLogonValidUserAccout.CBT55(selenium);
		}
			
	
		Helper.log("Ambiente de prueba: "+selenium.getLocation());
		//Ingresar a traves del bot�n 'TUS DIRECCIONES' �rea privada'
		selenium.click("xpath=//div[3]/li/a/span");
		selenium.waitForPageToLoad("60000");
		
		if(selenium.isElementPresent("id=spanNewAddress"))
		{
		selenium.click("id=spanNewAddress");
		
		selenium.type("xpath=.//*[@id='firstname']","Sandra Milena"); //Nombre
		selenium.type("xpath=.//*[@id='lastname']","Torres Valencia"); //Apellidos
		selenium.type("xpath=.//*[@id='street_1']","Avenida 8"+i+" No. 15 - 20 Santa Lucia");	//Direcci�n
		selenium.type("xpath=.//*[@id='city']","Barcelona"); //Poblaci�n
		selenium.type("xpath=.//*[@id='zip']","08080"); //C�digo postal
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[2]/div[3]/div/div[1]/div/div[1]"); //Men� desplegable Provincia
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[2]/div[3]/div/div[2]/div/div/div[11]"); //Se selecciona Barcelona como Provincia
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[3]/div[1]/div/div[1]"); //Menu de seleccion Pa�s
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[3]/div[1]/div/div[2]/div/div/div"); //Se selecciona Pa�s = ESPA�A
		selenium.type("xpath=.//*[@id='telephone']","010540345"); //Tel�fono M�vil
		selenium.click("xpath=.//*[@id='primary_shipping']"); //Marcar por defecto
		
		selenium.click("xpath=.//*[@id='form-validate-']/div[2]/button[2]"); //Click en bot�n Guardar
		selenium.waitForPageToLoad("30000");
		
			if(!selenium.isTextPresent("Se guard� la direcci�n."))
			{
				Assert.fail("The address was not added");
			} else {
				Helper.log("Address was added Ok");
			}
		}
		else
		{
			Assert.fail("Element not found");
		}
	
		if(selenium.isElementPresent("xpath=//div[3]/div/div[5]/span")){
		
		
		//Se elimina la direcci�n creada
		
		selenium.click("xpath=//div[3]/div/div[5]/span");
		
		
		selenium.click("xpath=//div[2]/div/form/div/ul[2]/li[3]/div[3]/input");
		selenium.click("xpath=//div[2]/div/form/div[2]/button[2]");
		selenium.waitForPageToLoad("50000");
		assertTrue(selenium.isTextPresent("Se guard� la direcci�n"));	
		if(selenium.isElementPresent("class=delete")){
			while(selenium.isElementPresent("class=delete")){
				selenium.click("class=delete");
				assertTrue(selenium.getConfirmation().matches("�Est�s seguro de querer borrar esta direcci�n[\\s\\S]$"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Se elimin� la direcci�n"));
				Helper.log("Se elimin� la direcci�n");
			}
		
		}
	
	
		else{
			Helper.log("Error: No existen direcciones para borrar");
			
		}
		
		Claireandbruce.logout(selenium);
		selenium.stop();
	}
	}
}
