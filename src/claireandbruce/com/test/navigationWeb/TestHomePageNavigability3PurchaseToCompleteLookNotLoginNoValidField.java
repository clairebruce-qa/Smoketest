package claireandbruce.com.test.navigationWeb;

import lib.Claireandbruce;
import lib.Helper;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

/**
 * 
 * @author NEWSHORE
 *
 */
public class TestHomePageNavigability3PurchaseToCompleteLookNotLoginNoValidField extends ClaireandbruceTestCase {
	
	@Test
	public void CBT33 () throws Exception{
		//Tener desplegada la interfaz del primer estilo (bohemian-style)
		//selenium.open("bohemian-style.html");
		Helper.log("Se prueba la navegabilidad por los Total Look");
		Helper.log("Se carga la página "+ClaireandbruceUrl);
		selenium.open("");
		selenium.waitForPageToLoad("20000");

		//La prueba se realiza solo si el total look se encuentra
		if(selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[3]/div[1]/a/img")){
			Helper.log("Se ingresa al look");
			selenium.click("xpath=html/body/div/div[2]/div/div/div[1]/div[3]/div[1]/a/img");
			Helper.log("Se espera la carga de la interfaz");
			selenium.waitForPageToLoad("15000");
			
			//Se verifica que se encuentren activos los elementos (Compra el total look, Envio y devolucion, Guia de tallas)
			if(selenium.isElementPresent("xpath=.//*[@id='total-look']")){
				Helper.log("Elemento 'COMPRA EL TOTAL LOOK' presente" );
			} else { 
				Helper.log("Elemento 'COMPRA EL TOTAL LOOK' no está presente" );
			}
			if(selenium.isElementPresent("xpath=.//*[@id='product_addtocart_form']/div[2]/div[3]/div[1]/div[1]")){
				Helper.log("Elemento 'ENVIO Y DEVOLUCION' presente" );
			} else {
				Helper.log("Elemento 'ENVIO Y DEVOLUCION' no está presente");
			}
			if(selenium.isElementPresent("xpath=.//*[@id='product_addtocart_form']/div[2]/div[3]/div[1]/div[2]")){
				Helper.log("Elemento 'GUIA DE TALLAS presente" );
			} else {
				Helper.log("Elemento 'GUIA DE TALLAS' no está presente");
			}
			//Se verifica que se encuentre activo el boton Compra el total look
			if(selenium.isElementPresent("xpath=.//*[@id='bundleSummary']/div/div[2]/div/button")) {
				Helper.log("Botón 'COMPRAR EL TOTAL LOOK' presente" );
			} else {
				Helper.log("Button 'COMPRAR EL TOTAL LOOK' no está presente" );
			}
			
			//Si el link Salir se encuentra presente se procede a realizar logout
			if(selenium.isElementPresent("xpath=html/body/div/div[1]/div[1]/div[1]/div/ul/li[3]/a")){
				Claireandbruce.logout(selenium);
			}
							
			if(selenium.isElementPresent("xpath=//div[@id='bundleSummary']/div/div[2]/div/button")){
				selenium.click("xpath=//div[@id='bundleSummary']/div/div[2]/div/button");
			}else {
				Helper.log("Botón 'COMPRAR EL TOTAL LOOK' no está presente");
			}
			
			if(selenium.isTextPresent("0 artículos 0 €")){
				Helper.log("Talla sin seleccionar - Test OK");
				selenium.isTextPresent("ELIGE TALLA");
			} else {
				Helper.log("El producto no exige la selección de una talla");
			}			
		} else {
			Helper.log("No se encuentran imagenes presentes para realizar la prueba");
		}		
	}
}
