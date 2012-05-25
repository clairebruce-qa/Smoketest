package claireandbruce.com.test.basicsFlows;

import junit.framework.Assert;

import com.thoughtworks.selenium.Selenium;




/**
 * 
 * Libreria para verificar el envío de un pedido con factura y dirección
 * de envío igual a la dirección por defecto
 * 
 * @author YULIANA MARIA SAAVEDRA RUSSI
 *
 */


public class Lib_Test_With_Purchase  {
	
	
	
	public static void shippingWithPurchase(Selenium selenium){
		
		
		int i =(int)(Math.random()*(4-3)+3);
		
		//-----****** Verifíca que la pagina de Tu Compra esta desplegada de lo contrario la carga *****----\\
		
		if(!("Compra ahora").equals(selenium.getTitle()))
		{
			selenium.click("//a[contains(text(),'Compra ahora')]");
			
			selenium.waitForPageToLoad("30000");
			selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[6]/ul[1]/li[1]/button");
			selenium.waitForPageToLoad("30000");		
		}
		//------*****  Verifica que el pedido será con factura *****-------\\
				
		if(!("on").equals(selenium.getValue("xpath=.//*[@id='showFakeBilling']"))) {
			
			//----- El Formulario para los datos de facturación -----\\
			
			selenium.click("id=showFakeBilling");// Selecciona el envío de factura
			
			if(!selenium.isElementPresent("xpath=.//*[@id='fakeCompany']")|| selenium.isElementPresent("xpath.//*[@id='fakebilling:taxvat']")){
				Assert.fail("Error: Elementos no encontrados");
			}
			
			
			selenium.type("xpath=.//*[@id='fakeCompany']","Privalia"+i); //Nombre Compañía 
			selenium.type("xpath=.//*[@id='fakebilling:taxvat']","A55425275"+i); // Nif/Cif 
			
			
			
			
			//----- Dirección diferente a la dirección por defecto ------\\
			if(!("off").equals(selenium.getValue("id=showFakeBillingExtended"))) {
				Assert.fail("Error:  Se esta solicitando la factura con dirección diferente");
			}
		}else
		{
			Assert.fail("Error:  No se esta solicitando la factura");
		}
		
		
		
		
		
	}
	
	

}
