package claireandbruce.com.test.basicsFlows;

import lib.Helper;

import com.thoughtworks.selenium.Selenium;
import basics.ClaireandbruceTestCase;

/**
 * 
 * @author NEWSHORE
 *
 */
public class LibWithPurchaseAndOtherAddress extends ClaireandbruceTestCase {
	
	public static void with_Purchase_and_Other_Address (Selenium selenium){
		
		//Para efectos de prueba unitaria
		/*if(!("Compra ahora").equals(selenium.getTitle())) {		
			if(selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
				selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
				selenium.waitForPageToLoad("20000");
			} else {
				selenium.click("xpath=//div/div/div/a");
				selenium.waitForPageToLoad("20000");
			}
		}*/
		Helper.log(" ");
		Helper.log("Se inicia proceso para seleccion de factura con direcci�n diferente a la de env�o");
		//Se verifica que se encuentre seleccionado "Necesito una factura" 
		if(selenium.getValue("id=showFakeBilling").equals("off")){
			Helper.log("Se selecciona la opci�n 'Necesito una factura'");
			selenium.click("id=showFakeBilling");
		}
		
		//Se verifica que se encuentre desactivado la selecci�n de la direcci�n de factura es diferente a la de env�o
		if(selenium.getValue("id=showFakeBillingExtended").equals("on")){
			Helper.log("Se muestra activo sin seleccionarlo el usuario la opci�n 'La direcci�n de factura es diferente a la de env�o'");
			selenium.click("id=showFakeBillingExtended");		 //Se desactiva para que al seleccionarlo de nuevo muestre los campos necesarios	
		}
		//Se selecciona la opci�n 'La direcci�n de factura es diferente a la de env�o'
		Helper.log("Se selecciona la opci�n 'La direcci�n de factura es diferente a la de env�o'");
		selenium.click("id=showFakeBillingExtended");
		Helper.log("Se ingresan datos de facturaci�n");
		//Se verifican que los campos 'Nombre' y 'Apellidos' se encuentren diligenciados
		if(selenium.getValue("id=billing:firstname").equals("")){
			Helper.log("El campo Nombre no se encuentra diligenciado con la informaci�n del usuario");
			selenium.type("id=billing:firstname","Claire");
		}
		if(!selenium.getValue("id=billing:lastname").equals("")){
			Helper.log("El campo Apellidos no se encuentra diligenciado con la informaci�n del usuario");
			selenium.type("id=billing:firstname","QA");
		}
		int i = (int)Math.random()*20;
		//Se ingresan los datos (Direcci�n1. Poblaci�n, C�digo Postal, Tel�fono)
		selenium.type("id=billing:street1", "AV "+i+" 34 6");
		selenium.type("id=billing:city", "Barcelona");
		selenium.click("xpath=//li[5]/div[2]/div/div[2]/div/div/div[23]");
		selenium.type("id=billing:postcode", "50080");
		selenium.type("id=billing:telephone", "920512354");
		
		Helper.log("Se finaliza ingreso de informaci�n sobre facturaci�n con direcci�n diferente a la de env�o");
		
	}
}
