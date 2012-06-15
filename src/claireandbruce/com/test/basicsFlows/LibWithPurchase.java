package claireandbruce.com.test.basicsFlows;

import junit.framework.Assert;
import lib.Helper;

import com.thoughtworks.selenium.Selenium;

/**
 * Libreria para verificar el envío de un pedido con factura y dirección
 * de envío igual a la dirección por defecto
 * @author NEWSHORE
 *
 */


public class LibWithPurchase  {
		
	public static void shippingWithPurchase(Selenium selenium){
		
		int i =(int)(Math.random()*(4-3)+3);
		
		//-----****** Verifíca que la pagina de Tu Compra esta desplegada de lo contrario la carga *****----\\
		Helper.log(" ");
		Helper.log("Se inicia proceso de verificación de una dirección de envío por defecto señalada");
		if(!("Compra ahora").equals(selenium.getTitle())) {	
			Helper.log("Se busca método de ingreso a la interfaz 'Compra ahora'");
			if(selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el botón 'CÓMPRALO AHORA' del header");
				selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
				Helper.log("Se hace clic en el botón 'CÓMPRALO AHROA' del header");
				selenium.waitForPageToLoad("30000");
			} else {
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el botón 'COMPRA AHORA' ubicado en la parte superior de la interfaz");
				selenium.click("xpath=//div/div/div/a");
				Helper.log("Se hace clic en el botón 'COMPRA AHORA' ubicado en la parte superior de la página");
				selenium.waitForPageToLoad("30000");
			}
			Helper.log("Se presiona el botón 'CONTINUA' de la interfaz 'Shopping Cart'");
			selenium.click("xpath=(//button[@type='button'])[3]");
			selenium.waitForPageToLoad("20000");
		}
		//------*****  Verifica que el pedido será con factura *****-------\\
		Helper.log("Se verifica que el pedido será con factura");		
		if(!("on").equals(selenium.getValue("xpath=.//*[@id='showFakeBilling']"))) {
			
			//----- El Formulario para los datos de facturación -----\\
			Helper.log("Se selecciona 'Necesito una factura'");
			selenium.click("id=showFakeBilling");// Selecciona el envío de factura
			
			if(!selenium.isElementPresent("xpath=.//*[@id='fakeCompany']")|| selenium.isElementPresent("xpath.//*[@id='fakebilling:taxvat']")){
				Assert.fail("Error: Elementos no encontrados");
			}
			Helper.log("Se ingresan los datos de facturación");
			selenium.type("xpath=.//*[@id='fakeCompany']","Privalia"+i); //Nombre Compañía 
			selenium.type("xpath=.//*[@id='fakebilling:taxvat']","A55425275"+i); // Nif/Cif 
						
			//----- Dirección diferente a la dirección por defecto ------\\
			if(!("off").equals(selenium.getValue("id=showFakeBillingExtended"))) {
				Assert.fail("Error:  Se esta solicitando la factura con dirección diferente por defecto");
			}
		}else
		{
			Assert.fail("Error:  Se está solicitando la factura sin que el usuario así lo solicite");
		}		
	}
}