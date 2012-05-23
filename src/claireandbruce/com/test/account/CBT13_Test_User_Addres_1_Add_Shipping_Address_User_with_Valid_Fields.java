package claireandbruce.com.test.account;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;
import org.testng.Assert;

import basics.ClaireandbruceTestCase;

/**
 * Especificación de prueba para la verificación  y validación de una dirección de envío 
 * de pedido para ser añadida a las direcciones con datos validos.
 * El éxito de la prueba será el ingreso al sistema de la nueva dirección 
 * @author María Fernanda Rodríguez Vargas
 *
 */
public class CBT13_Test_User_Addres_1_Add_Shipping_Address_User_with_Valid_Fields extends ClaireandbruceTestCase {
		
	@Test
	public void CBT13() throws Exception{
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		int i =(int)(Math.random()*100);
		//El usuario no debe tener su sesión iniciada
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			Claireandbruce.login(selenium, username, password);
		}
		
		
		Helper.log("Ambiente de prueba: "+selenium.getLocation());
		//Ingresar a traves del botón 'TUS DIRECCIONES' Área privada'
		if(selenium.isElementPresent("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p")){
			selenium.click("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p");
		} else {//Ingresar a través del link 'Modificar o añadir dirección'
			//selenium.click("xpath=html/body/div/div[2]/div[2]/div[1]/div[2]/ul/div[3]/li/a/span");
		}
		
		selenium.waitForPageToLoad("60000");
		
		selenium.click("xpath=.//*[@id='spanNewAddress']");
		
		selenium.type("xpath=.//*[@id='firstname']","Sandra Milena"); //Nombre
		selenium.type("xpath=.//*[@id='lastname']","Torres Valencia"); //Apellidos
		selenium.type("xpath=.//*[@id='street_1']","Avenida 8"+i+" No. 15 - 20 Santa Lucia");	//Dirección
		selenium.type("xpath=.//*[@id='city']","Barcelona"); //Población
		selenium.type("xpath=.//*[@id='zip']","08080"); //Código postal
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[2]/div[3]/div/div[1]/div/div[1]"); //Menú desplegable Provincia
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[2]/div[3]/div/div[2]/div/div/div[11]"); //Se selecciona Barcelona como Provincia
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[3]/div[1]/div/div[1]"); //Menu de seleccion País
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[3]/div[1]/div/div[2]/div/div/div"); //Se selecciona País = ESPAÑA
		selenium.type("xpath=.//*[@id='telephone']","010540345"); //Teléfono Móvil
		selenium.click("xpath=.//*[@id='primary_shipping']"); //Marcar por defecto
		
		selenium.click("xpath=.//*[@id='form-validate-']/div[2]/button[2]"); //Click en botón Guardar
		selenium.waitForPageToLoad("30000");
		
		if(!selenium.isTextPresent("Se guardó la dirección.")){
			Assert.fail("The address was not added");
			
			
		} else {
			Helper.log("Address was added Ok");
			
		}
		
	
		if(selenium.isElementPresent("xpath=//div[3]/div/div[5]/span")){
		
		
		//Se elimina la dirección creada
		
		selenium.click("xpath=//div[3]/div/div[5]/span");
		
		
		selenium.click("xpath=//div[2]/div/form/div/ul[2]/li[3]/div[3]/input");
		selenium.click("xpath=//div[2]/div/form/div[2]/button[2]");
		selenium.waitForPageToLoad("50000");
		assertTrue(selenium.isTextPresent("Se guardó la dirección"));	
		if(selenium.isElementPresent("class=delete")){
			while(selenium.isElementPresent("class=delete")){
				selenium.click("class=delete");
				assertTrue(selenium.getConfirmation().matches("¿Estás seguro de querer borrar esta dirección[\\s\\S]$"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent("Se eliminó la dirección"));
				Helper.log("Se eliminó la dirección");
		}
		
		}
	
	
		else{
			Helper.log("Error: No existen direcciones para borrar");
			
		}
		
		
	}
	}
}
