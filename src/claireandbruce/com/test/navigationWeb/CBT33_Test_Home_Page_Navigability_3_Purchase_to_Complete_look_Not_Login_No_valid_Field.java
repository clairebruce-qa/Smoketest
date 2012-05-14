package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT33_Test_Home_Page_Navigability_3_Purchase_to_Complete_look_Not_Login_No_valid_Field extends ClaireandbruceTestCase {
	
	@Test
	public void CBT33 () throws Exception{
		//Tener desplegada la interfaz del primer estilo (bohemian-style)
		//selenium.open("bohemian-style.html");
		selenium.open("");
		selenium.waitForPageToLoad("20000");
		Helper.log("AMBIENTE DE PRUEBA: "+selenium.getLocation()+"\n");
		//La prueba se realiza solo si el total look se encuentra
		if(selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[3]/div[1]/a/img")){
			selenium.click("xpath=html/body/div/div[2]/div/div/div[1]/div[3]/div[1]/a/img");
			selenium.waitForPageToLoad("15000");
			
			//Se verifica que se encuentren activos los elementos (Compra el total look, Envio y devolucion, Guia de tallas)
			if(selenium.isElementPresent("xpath=.//*[@id='total-look']")){
				Helper.log("Element Tab 'COMPRA EL TOTAL LOOK' present" );
			} else { 
				Helper.log("Element Tab 'COMPRA EL TOTAL LOOK' is not present" );
			}
			if(selenium.isElementPresent("xpath=.//*[@id='product_addtocart_form']/div[2]/div[3]/div[1]/div[1]")){
				Helper.log("Element Tab 'ENVIO Y DEVOLUCION' present" );
			} else {
				Helper.log("Element Tab 'ENVIO Y DEVOLUCION' is not present");
			}
			if(selenium.isElementPresent("xpath=.//*[@id='product_addtocart_form']/div[2]/div[3]/div[1]/div[2]")){
				Helper.log("Element Tab 'GUIA DE TALLAS present" );
			} else {
				Helper.log("Element Tab 'GUIA DE TALLAS' is not present");
			}
			//Se verifica que se encuentre activo el boton Compra el total look
			if(selenium.isElementPresent("xpath=.//*[@id='bundleSummary']/div/div[2]/div/button")) {
				Helper.log("Button 'COMPRAR EL TOTAL LOOK' present" );
			} else {
				Helper.log("Button 'COMPRAR EL TOTAL LOOK' is not present" );
			}
			
			//Si el link Salir se encuentra presente se procede a realizar logout
			if(selenium.isElementPresent("xpath=html/body/div/div[1]/div[1]/div[1]/div/ul/li[3]/a")){
				Claireandbruce.logout(selenium);
			}
							
			if(selenium.isElementPresent("xpath=//div[@id='bundleSummary']/div/div[2]/div/button")){
				selenium.click("xpath=//div[@id='bundleSummary']/div/div[2]/div/button");
			}else {
				Helper.log("Button 'COMPRAR EL TOTAL LOOK' is not present");
			}
			
			if(selenium.isTextPresent("0 artículos 0 €")){
				Helper.log("Size unselected - Test OK");
				selenium.isTextPresent("ELIGE TALLA");
			} else {
				Helper.log("No products that require size");
			}			
		} else {
			Helper.log("ARE NOT ACTIVE IMAGES OF TOTAL LOOK FOR TESTING");
		}		
	}
}
