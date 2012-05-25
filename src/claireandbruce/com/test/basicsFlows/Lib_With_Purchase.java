package claireandbruce.com.test.basicsFlows;

import junit.framework.Assert;

import com.thoughtworks.selenium.Selenium;




/**
 * 
 * Libreria para verificar el env�o de un pedido con factura y direcci�n
 * de env�o igual a la direcci�n por defecto
 * 
 * @author YULIANA MARIA SAAVEDRA RUSSI
 *
 */


public class Lib_With_Purchase  {
		
	public static void shippingWithPurchase(Selenium selenium){
		
		int i =(int)(Math.random()*(4-3)+3);
		
		//-----****** Verif�ca que la pagina de Tu Compra esta desplegada de lo contrario la carga *****----\\
		
		if(!("Compra ahora").equals(selenium.getTitle())) {		
			if(selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
				selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
				selenium.waitForPageToLoad("30000");
			} else {
				selenium.click("xpath=//div/div/div/a");
				selenium.waitForPageToLoad("30000");
			}
			selenium.click("xpath=(//button[@type='button'])[3]");
			selenium.waitForPageToLoad("20000");
		}
		//------*****  Verifica que el pedido ser� con factura *****-------\\
				
		if(!("on").equals(selenium.getValue("xpath=.//*[@id='showFakeBilling']"))) {
			
			//----- El Formulario para los datos de facturaci�n -----\\
			
			selenium.click("id=showFakeBilling");// Selecciona el env�o de factura
			
			if(!selenium.isElementPresent("xpath=.//*[@id='fakeCompany']")|| selenium.isElementPresent("xpath.//*[@id='fakebilling:taxvat']")){
				Assert.fail("Error: Elementos no encontrados");
			}
						
			selenium.type("xpath=.//*[@id='fakeCompany']","Privalia"+i); //Nombre Compa��a 
			selenium.type("xpath=.//*[@id='fakebilling:taxvat']","A55425275"+i); // Nif/Cif 
						
			//----- Direcci�n diferente a la direcci�n por defecto ------\\
			if(!("off").equals(selenium.getValue("id=showFakeBillingExtended"))) {
				Assert.fail("Error:  Se esta solicitando la factura con direcci�n diferente");
			}
		}else
		{
			Assert.fail("Error:  No se esta solicitando la factura");
		}		
	}
}