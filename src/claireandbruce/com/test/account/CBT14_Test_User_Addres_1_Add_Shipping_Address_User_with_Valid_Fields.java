package claireandbruce.com.test.account;

import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;
import org.testng.Assert;

import basics.ClaireandbruceTestCase;

/**
 * Especificaci�n de prueba para la verificaci�n  y validaci�n de una direcci�n de env�o 
 * de pedido para ser a�adida a las direcciones con datos validos.
 * El �xito de la prueba ser� el ingreso al sistema de la nueva direcci�n 
 * @author Mar�a Fernanda Rodr�guez Vargas
 *
 */
public class CBT14_Test_User_Addres_1_Add_Shipping_Address_User_with_Valid_Fields extends ClaireandbruceTestCase {
		
	@Test
	public void CBT14() throws Exception{
		selenium.open("");
		selenium.waitForPageToLoad("30000");
		
		//El usuario no debe tener su sesi�n iniciada
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			Claireandbruce.login(selenium, username, password);
		}
		
		
		Helper.log("Ambiente de prueba: "+selenium.getLocation());
		//Ingresar a traves del bot�n 'TUS DIRECCIONES' �rea privada'
		if(selenium.isElementPresent("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p")){
			selenium.click("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p");
		} else {//Ingresar a trav�s del link 'Modificar o a�adir direcci�n'
			selenium.click("xpath=html/body/div/div[2]/div[2]/div[1]/div[2]/ul/div[3]/li/a/span");
		}
		
		selenium.waitForPageToLoad("15000");
		selenium.click("xpath=.//*[@id='spanNewAddress']");
		
		selenium.type("xpath=.//*[@id='firstname']","Sandra Milena"); //Nombre
		selenium.type("xpath=.//*[@id='lastname']","Torres Valencia"); //Apellidos
		selenium.type("xpath=.//*[@id='street_1']","Avenida 8 No. 15 - 20 Santa Lucia");	//Direcci�n
		selenium.type("xpath=.//*[@id='city']","Barcelona"); //Poblaci�n
		selenium.type("xpath=.//*[@id='zip']","08080"); //C�digo postal
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[2]/div[3]/div/div[1]/div/div[1]"); //Men� desplegable Provincia
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[2]/div[3]/div/div[2]/div/div/div[11]"); //Se selecciona Barcelona como Provincia
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[3]/div[1]/div/div[1]"); //Menu de seleccion Pa�s
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[3]/div[1]/div/div[2]/div/div/div"); //Se selecciona Pa�s = ESPA�A
		selenium.type("xpath=.//*[@id='telephone']","010540345"); //Tel�fono M�vil
		selenium.click("xpath=.//*[@id='primary_shipping']"); //Marcar por defecto
		
		selenium.click("xpath=.//*[@id='form-validate-']/div[2]/button[2]"); //Click en bot�n Guardar
		selenium.waitForPageToLoad("15000");
		
		if(!selenium.isTextPresent("Se guard� la direcci�n.")){
			Assert.fail("The address was not added");
		} else {
			Helper.log("Address was added Ok");
		}
	}

}
