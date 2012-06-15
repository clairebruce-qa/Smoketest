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
		Helper.log("Se inicia proceso de prueba: Agregar una direcci�n de env�o con datos v�lidos");
		Helper.log("Se eliminan cookies del navegador");
		selenium.deleteAllVisibleCookies();
		Helper.log("Se carga la p�gina "+ClaireandbruceUrl);
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		int i =(int)(Math.random()*100);
		//El usuario debe tener su sesi�n iniciada
		if(selenium.isElementPresent("link=Salir")) {
			Helper.log("Se ha encontrado una sesi�n de usuario iniciada al cargar la p�gina de C+B");
			selenium.click("link=Salir");
			Helper.log("Se procede a cerrar la sesi�n");
			selenium.waitForPageToLoad("15000");
			
			if(selenium.isElementPresent("id=email")){
				Helper.log("La sesi�n de usuario encontrada se presenta por cookies almacenadas");
				Helper.log("Se ingresan los datos para iniciar sesi�n");
				selenium.type("id=email", username);
				selenium.type("id=pass", password);
				Helper.log("Se hace clic en el bot�n 'ENTRAR'");
				selenium.click("id=send2");
				Helper.log("Se espera carga del �rea privada");
				selenium.waitForPageToLoad("15000");
			} else {
				
				LibCorrectLogonValidUserAccout.CBT55(selenium);
			}
		}
			
	
		//Ingresar a traves del bot�n 'TUS DIRECCIONES' �rea privada'
		Helper.log("Se ingresa a trav�s del bot�n 'TUS DIRECCIONES' del �rea privada");
		selenium.click("xpath=//div[3]/li/a/span");
		Helper.log("Se espera carga de la interfaz");
		selenium.waitForPageToLoad("60000");
		
		if(selenium.isElementPresent("id=spanNewAddress"))
		{
			Helper.log("Se da clic en el link para agregar una direcci�n de env�o nueva");
		selenium.click("id=spanNewAddress");
		Helper.log("Se ingresan los datos de la direcci�n de env�o");
		selenium.type("xpath=.//*[@id='firstname']","Sandra Milena"); //Nombre
		selenium.type("xpath=.//*[@id='lastname']","Torres Valencia"); //Apellidos
		selenium.type("xpath=.//*[@id='street_1']","Avenida 8"+i+" No. 15 - 20 Santa Lucia");	//Direcci�n
		selenium.type("xpath=.//*[@id='city']","Barcelona"); //Poblaci�n
		selenium.type("xpath=.//*[@id='zip']","08080"); //C�digo postal
		Helper.log("Se selecciona la provincia");
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[2]/div[3]/div/div[1]/div/div[1]"); //Men� desplegable Provincia
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[2]/div[3]/div/div[2]/div/div/div[11]"); //Se selecciona Barcelona como Provincia
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[3]/div[1]/div/div[1]"); //Menu de seleccion Pa�s
		Helper.log("Se selecciona el pa�s");
		selenium.click("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[3]/div[1]/div/div[2]/div/div/div"); //Se selecciona Pa�s = ESPA�A
		selenium.type("xpath=.//*[@id='telephone']","010540345"); //Tel�fono M�vil
		Helper.log("Se selecciona 'Marcar por defecto'");
		selenium.click("xpath=.//*[@id='primary_shipping']"); //Marcar por defecto
		Helper.log("Se hace clic en el bot�n 'Guardar'");
		selenium.click("xpath=.//*[@id='form-validate-']/div[2]/button[2]"); //Click en bot�n Guardar
		selenium.waitForPageToLoad("30000");
		
			if(!selenium.isTextPresent("Se guard� la direcci�n."))
			{
				Assert.fail("The address was not added");
			} else {
				Helper.log("La direcci�n se ha guardado �xitosamente");
			}
		}
		else
		{
			Assert.fail("Element not found");
		}
	
		if(selenium.isElementPresent("xpath=//div[3]/div/div[5]/span")){
		
		
		//Se elimina la direcci�n creada
		Helper.log("Se inicia proceso para eliminar la direcci�n creada");
		selenium.click("xpath=//div[3]/div/div[5]/span");
				
		selenium.click("xpath=//div[2]/div/form/div/ul[2]/li[3]/div[3]/input");
		selenium.click("xpath=//div[2]/div/form/div[2]/button[2]");
		Helper.log("Se espera carga de la interfaz");
		selenium.waitForPageToLoad("50000");
		Helper.log("Se espera mensaje 'Se guard� la direcci�n");
		assertTrue(selenium.isTextPresent("Se guard� la direcci�n"));	
		if(selenium.isElementPresent("class=delete")){
			while(selenium.isElementPresent("class=delete")){
				Helper.log("Se elimina la direcc�n");
				selenium.click("class=delete");
				Helper.log("Se confirma el eliminar la direcci�n");
				assertTrue(selenium.getConfirmation().matches("�Est�s seguro de querer borrar esta direcci�n[\\s\\S]$"));
				selenium.waitForPageToLoad("30000");
				Helper.log("Se espera mensaje 'Se elimin� la direcci�n");
				assertTrue(selenium.isTextPresent("Se elimin� la direcci�n"));
				Helper.log("Se elimin� la direcci�n �xitosamente");
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
