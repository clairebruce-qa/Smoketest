package claireandbruce.com.test.basicsFlows;

import lib.Helper;

import com.thoughtworks.selenium.Selenium;

import basics.ClaireandbruceTestCase;
/**
 * 
 * @author NEWSHORE
 *
 */
public class LibCorrectLogonCheckout extends ClaireandbruceTestCase {

	public static void login_Checkout(Selenium selenium){
		Helper.log(" ");
		Helper.log("\nSe inicia proceso de LOGIN POR CHECKOUT");
				
		//Alerta sobre "La cantidad solicitada no esta disponible en inventario"
		if(selenium.isAlertPresent()){
			Helper.log("Se mostró y capturó una alerta sobre producto no disponible en inventario");
			selenium.getAlert();
		}
		
		//Se presiona el botón "CONTINUA"
		Helper.log("Se hace clic en el botón 'CONTINUA' de la interfaz 'Cesta de la Compra'");
		selenium.click("xpath=//li[2]/button");
		Helper.log("Se espera carga de la interfaz de login por checkout");
		selenium.waitForPageToLoad("20000");
	
		Helper.log("Se ingresan datos de usuario para el proceso de login");
		//Se ingresan los datos de usuario
		selenium.type("id=email", username);
		selenium.type("id=pass", password);
		Helper.log("Se hace clic en el botón 'ENTRAR'");
		selenium.click("id=send2");
		Helper.log("Se espera carga de la página con el login OK");
		selenium.waitForPageToLoad("30000");
		
		//Se verifica que se redireccionó al checkout
		if(selenium.isElementPresent("xpath=.//*[@id='checkout-step-shipping-child']/ul/li[1]/div/span")){
			Helper.log("SE DIRECCIONÓ AL CHECKOUT");			
		} else {
			Helper.log("NO SE ENCUENTRA EN EL CHECKOUT");
		}
		
	}
}
