package claireandbruce.com.test.account;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

/**
 * Este Caso de Prueba verificará el correcto funcionamiento del proceso encargado de 
 * cancelar las modificaciones realizadas a las direcciones previamente ingresadas a la 
 * cuenta de un usuario. El éxito del proceso se evaluará al NO mostrar el mensaje "Se 
 * guardó la dirección." 
 * Testlink: Local CBT82  - Privalia CBT63
 * @author NEWSHORE
 *
 */
public class TestEditionAddressCancelButtonAccount extends ClaireandbruceTestCase {
		
	@Test
	public void cbt63() throws Exception{
		Claireandbruce.login(selenium, username, password);
		Helper.log("Ambiente de prueba "+selenium.getLocation());
		
		//Ingresar a traves del botón 'TUS DIRECCIONES' Área privada'
		if(selenium.isElementPresent("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p")){
			selenium.click("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p");
		} else {//Ingresar a través del link 'Modificar o añadir dirección'
			selenium.click("xpath=html/body/div/div[2]/div[2]/div[1]/div[2]/ul/div[3]/li/a/span");
		}
		
		selenium.waitForPageToLoad("15000");
		
		if(selenium.isTextPresent("No tienes ninguna dirección de envío por defecto en tu libreta de direcciones.")){
			TestUserAddress1AddShippingAddressUserWithValidFields tb = new TestUserAddress1AddShippingAddressUserWithValidFields();
			tb.cbt6();
			Helper.log("Durección editada");
		}
		
		selenium.click("class=edit");
		Helper.log("Editando dirección");
		String nombreCompleto = selenium.getText("xpath=html/body/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]");
		selenium.type("xpath=.//*[@id='firstname']", "Sandra M");
		Helper.log("Editando Nombre: Sandra M");
		selenium.type("xpath=.//*[@id='lastname']", "Torres C");
		Helper.log("Editando Apellidos: Torres C");
		selenium.type("xpath=.//*[@id='city']", "Rojas");
		Helper.log("Editando Población: Rojas");
		
		selenium.click("xpath=(//button[@type='submit'])[2]");
		assertTrue(selenium.getText("xpath=html/body/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]").equals(nombreCompleto));		
	}
}