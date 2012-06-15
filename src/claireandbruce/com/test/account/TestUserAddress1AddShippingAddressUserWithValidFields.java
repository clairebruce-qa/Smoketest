package claireandbruce.com.test.account;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;
import org.junit.Test;
import org.testng.Assert;

import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;

import basics.ClaireandbruceTestCase;

/**
 * Especificación de prueba para la verificación  y validación de una dirección de envío 
 * de pedido para ser añadida a las direcciones con datos validos.
 * El éxito de la prueba será el ingreso al sistema de la nueva dirección 
 * CBT13
 * @author NEWSHORE
 *
 */
public class TestUserAddress1AddShippingAddressUserWithValidFields extends ClaireandbruceTestCase {
		
	@Test
	public void CBT13() throws Exception{
		Helper.log("Se inicia proceso de prueba: Agregar una dirección de envío con datos válidos");
		Helper.log("Se eliminan cookies del navegador");
		selenium.deleteAllVisibleCookies();
		Helper.log("Se carga la página "+ClaireandbruceUrl);
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		int i =(int)(Math.random()*100);
		//El usuario debe tener su sesión iniciada
		if(selenium.isElementPresent("link=Salir")) {
			Helper.log("Se ha encontrado una sesión de usuario iniciada al cargar la página de C+B");
			selenium.click("link=Salir");
			Helper.log("Se procede a cerrar la sesión");
			selenium.waitForPageToLoad("15000");
			
			if(selenium.isElementPresent("id=email")){
				Helper.log("La sesión de usuario encontrada se presenta por cookies almacenadas");
				Helper.log("Se ingresan los datos para iniciar sesión");
				selenium.type("id=email", username);
				selenium.type("id=pass", password);
				Helper.log("Se hace clic en el botón 'ENTRAR'");
				selenium.click("id=send2");
				Helper.log("Se espera carga del Área privada");
				selenium.waitForPageToLoad("15000");
			} else {
				
				LibCorrectLogonValidUserAccout.CBT55(selenium);
			}
		}
			
	
		//Ingresar a traves del botón 'TUS DIRECCIONES' Área privada'
		Helper.log("Se ingresa a través del botón 'TUS DIRECCIONES' del Área privada");
		selenium.click("xpath=//div[3]/li/a/span");
		Helper.log("Se espera carga de la interfaz");
		selenium.waitForPageToLoad("60000");
		
		if(selenium.isElementPresent("id=spanNewAddress"))
		{
			Helper.log("Se da clic en el link para agregar una dirección de envío nueva");
		selenium.click("id=spanNewAddress");
		Helper.log("Se ingresan los datos de la dirección de envío");
		selenium.type("xpath=.//*[@id='firstname']","Sandra Milena"); //Nombre
		selenium.type("xpath=.//*[@id='lastname']","Torres Valencia"); //Apellidos
		selenium.type("xpath=.//*[@id='street_1']","Avenida 8"+i+" No. 15 - 20 Santa Lucia");	//Dirección
		selenium.type("xpath=.//*[@id='city']","Barcelona"); //Población
		selenium.type("xpath=.//*[@id='zip']","08080"); //Código postal
		Helper.log("Se selecciona la provincia");
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[2]/div[3]/div/div[1]/div/div[1]"); //Menú desplegable Provincia
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[2]/div[3]/div/div[2]/div/div/div[11]"); //Se selecciona Barcelona como Provincia
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[3]/div[1]/div/div[1]"); //Menu de seleccion País
		Helper.log("Se selecciona el país");
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[3]/div[1]/div/div[2]/div/div/div"); //Se selecciona País = ESPAÑA
		selenium.type("xpath=.//*[@id='telephone']","010540345"); //Teléfono Móvil
		Helper.log("Se selecciona 'Marcar por defecto'");
		selenium.click("xpath=.//*[@id='primary_shipping']"); //Marcar por defecto
		Helper.log("Se hace clic en el botón 'Guardar'");
		selenium.click("xpath=.//*[@id='form-validate-']/div[2]/button[2]"); //Click en botón Guardar
		selenium.waitForPageToLoad("30000");
		
			if(!selenium.isTextPresent("Se guardó la dirección."))
			{
				Assert.fail("The address was not added");
			} else {
				Helper.log("La dirección se ha guardado éxitosamente");
			}
		}
		else
		{
			Assert.fail("Element not found");
		}
	
		if(selenium.isElementPresent("xpath=//div[3]/div/div[5]/span")){
		
		
		//Se elimina la dirección creada
		Helper.log("Se inicia proceso para eliminar la dirección creada");
		selenium.click("xpath=//div[3]/div/div[5]/span");
				
		selenium.click("xpath=//div[2]/div/form/div/ul[2]/li[3]/div[3]/input");
		selenium.click("xpath=//div[2]/div/form/div[2]/button[2]");
		Helper.log("Se espera carga de la interfaz");
		selenium.waitForPageToLoad("50000");
		Helper.log("Se espera mensaje 'Se guardó la dirección");
		assertTrue(selenium.isTextPresent("Se guardó la dirección"));	
		if(selenium.isElementPresent("class=delete")){
			while(selenium.isElementPresent("class=delete")){
				Helper.log("Se elimina la direccón");
				selenium.click("class=delete");
				Helper.log("Se confirma el eliminar la dirección");
				assertTrue(selenium.getConfirmation().matches("¿Estás seguro de querer borrar esta dirección[\\s\\S]$"));
				selenium.waitForPageToLoad("30000");
				Helper.log("Se espera mensaje 'Se eliminó la dirección");
				assertTrue(selenium.isTextPresent("Se eliminó la dirección"));
				Helper.log("Se eliminó la dirección éxitosamente");
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
