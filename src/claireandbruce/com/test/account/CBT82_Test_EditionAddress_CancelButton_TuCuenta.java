package claireandbruce.com.test.account;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

/** 2.51
 * Este Caso de Prueba verificar� el correcto funcionamiento del proceso encargado de 
 * cancelar las modificaciones realizadas a las direcciones previamente ingresadas a la 
 * cuenta de un usuario. El �xito del proceso se evaluar� al NO mostrar el mensaje "Se 
 * guard� la direcci�n." 
 * @author Mar�a Fernanda Rodr�guez Vargas
 *
 */
public class CBT82_Test_EditionAddress_CancelButton_TuCuenta extends ClaireandbruceTestCase {
		
	@Test
	public void test_EditionAddress_CancelButton_TuCuenta() throws Exception{
		Claireandbruce.login(selenium, username, password);
		Helper.log("Ambiente de prueba "+selenium.getLocation());
		
		//Ingresar a traves del bot�n 'TUS DIRECCIONES' �rea privada'
		if(selenium.isElementPresent("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p")){
			selenium.click("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p");
		} else {//Ingresar a trav�s del link 'Modificar o a�adir direcci�n'
			selenium.click("xpath=html/body/div/div[2]/div[2]/div[1]/div[2]/ul/div[3]/li/a/span");
		}
		
		selenium.waitForPageToLoad("15000");
		
		if(selenium.isTextPresent("No tienes ninguna direcci�n de env�o por defecto en tu libreta de direcciones.")){
			CBT13_Test_User_Addres_1_Add_Shipping_Address_User_with_Valid_Fields tb = new CBT13_Test_User_Addres_1_Add_Shipping_Address_User_with_Valid_Fields();
			tb.test_User_Addres_1_Add_Shipping_Address_User_with_Valid_Fields();
			Helper.log("Address was added");
		}
		
		selenium.click("class=edit");
		Helper.log("Editing Address");
		String nombreCompleto = selenium.getText("xpath=html/body/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]");
		selenium.type("xpath=.//*[@id='firstname']", "Sandra M");
		Helper.log("Editing name: Sandra M");
		selenium.type("xpath=.//*[@id='lastname']", "Torres C");
		Helper.log("Editing lastname: Torres C");
		selenium.type("xpath=.//*[@id='city']", "Rojas");
		Helper.log("Editing Poblaci�n: Rojas");
		
		selenium.click("xpath=(//button[@type='submit'])[2]");
		assertTrue(selenium.getText("xpath=html/body/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]").equals(nombreCompleto));
		
	}

}
