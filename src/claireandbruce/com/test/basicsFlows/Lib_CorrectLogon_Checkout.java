package claireandbruce.com.test.basicsFlows;

import lib.Helper;

import com.thoughtworks.selenium.Selenium;

import basics.ClaireandbruceTestCase;

public class Lib_CorrectLogon_Checkout extends ClaireandbruceTestCase {

	public static void login_Checkout(Selenium selenium){
		
		Helper.log("\nLOGIN POR CHECKOUT");
				
		//Alerta sobre "La cantidad solicitada no esta disponible en inventario"
		if(selenium.isAlertPresent()){
			selenium.getAlert();
		}
		
		if(!selenium.getTitle().equals("Cesta de la Compra")){
			if(selenium.isElementPresent("link=Compra ahora")){
				selenium.click("link=Compra ahora");
				selenium.waitForPageToLoad("15000");
			} else {
				selenium.click("id=cartHeader");
				selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
				selenium.waitForPageToLoad("15000");			
			}			
		}
		
		//Se presiona el botón "CONTINUA"
		selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[6]/ul[1]/li[1]/button");
		selenium.waitForPageToLoad("20000");
	
		//Se ingresan los datos de usuario
		selenium.type("id=email", username);
		selenium.type("id=pass", password);
		selenium.click("id=send2");
		selenium.waitForPageToLoad("30000");
		
		//Se verifica que se redireccionó al checkout
		if(selenium.isElementPresent("xpath=.//*[@id='checkout-step-shipping-child']/ul/li[1]/div/span")){
			Helper.log("SE DIRECCIONÓ AL CHECKOUT");			
		} else {
			Helper.log("NO SE ENCUENTRA EN EL CHECKOUT");
		}
		
	}
}
