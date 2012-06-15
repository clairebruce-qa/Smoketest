package claireandbruce.com.test.basicsFlows;

import junit.framework.Assert;
import lib.Helper;

import com.thoughtworks.selenium.Selenium;

/**
 * Libreria para verificar el env�o de un pedido con factura y direcci�n
 * de env�o igual a la direcci�n por defecto
 * @author NEWSHORE
 *
 */


public class LibWithPurchase  {
		
	public static void shippingWithPurchase(Selenium selenium){
		
		int i =(int)(Math.random()*(4-3)+3);
		
		//-----****** Verif�ca que la pagina de Tu Compra esta desplegada de lo contrario la carga *****----\\
		Helper.log(" ");
		Helper.log("Se inicia proceso de verificaci�n de una direcci�n de env�o por defecto se�alada");
		if(!("Compra ahora").equals(selenium.getTitle())) {	
			Helper.log("Se busca m�todo de ingreso a la interfaz 'Compra ahora'");
			if(selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el bot�n 'C�MPRALO AHORA' del header");
				selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
				Helper.log("Se hace clic en el bot�n 'C�MPRALO AHROA' del header");
				selenium.waitForPageToLoad("30000");
			} else {
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el bot�n 'COMPRA AHORA' ubicado en la parte superior de la interfaz");
				selenium.click("xpath=//div/div/div/a");
				Helper.log("Se hace clic en el bot�n 'COMPRA AHORA' ubicado en la parte superior de la p�gina");
				selenium.waitForPageToLoad("30000");
			}
			Helper.log("Se presiona el bot�n 'CONTINUA' de la interfaz 'Shopping Cart'");
			selenium.click("xpath=(//button[@type='button'])[3]");
			selenium.waitForPageToLoad("20000");
		}
		//------*****  Verifica que el pedido ser� con factura *****-------\\
		Helper.log("Se verifica que el pedido ser� con factura");		
		if(!("on").equals(selenium.getValue("xpath=.//*[@id='showFakeBilling']"))) {
			
			//----- El Formulario para los datos de facturaci�n -----\\
			Helper.log("Se selecciona 'Necesito una factura'");
			selenium.click("id=showFakeBilling");// Selecciona el env�o de factura
			
			if(!selenium.isElementPresent("xpath=.//*[@id='fakeCompany']")|| selenium.isElementPresent("xpath.//*[@id='fakebilling:taxvat']")){
				Assert.fail("Error: Elementos no encontrados");
			}
			Helper.log("Se ingresan los datos de facturaci�n");
			selenium.type("xpath=.//*[@id='fakeCompany']","Privalia"+i); //Nombre Compa��a 
			selenium.type("xpath=.//*[@id='fakebilling:taxvat']","A55425275"+i); // Nif/Cif 
						
			//----- Direcci�n diferente a la direcci�n por defecto ------\\
			if(!("off").equals(selenium.getValue("id=showFakeBillingExtended"))) {
				Assert.fail("Error:  Se esta solicitando la factura con direcci�n diferente por defecto");
			}
		}else
		{
			Assert.fail("Error:  Se est� solicitando la factura sin que el usuario as� lo solicite");
		}		
	}
}