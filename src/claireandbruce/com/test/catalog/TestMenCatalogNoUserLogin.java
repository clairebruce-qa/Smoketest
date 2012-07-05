package claireandbruce.com.test.catalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/** 
 * Testlink: Local CBT86  - Privalia CBT66
 * @author NEWSHORE
 *
 */
public class TestMenCatalogNoUserLogin extends ClaireandbruceTestCase {
	@Test
	public void cbt66() throws Exception{
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		if(selenium.isTextPresent("Salir")){
			Claireandbruce.logout(selenium);
		}
		
		//Enlace en Header HOMBRE para ingresar al catalogo
		if(selenium.isElementPresent("xpath=html/body/div/div[1]/div[1]/div[1]/div/div[2]/ul/li[2]/a/cufon/canvas")){
			selenium.click("xpath=html/body/div/div[1]/div[1]/div[1]/div/div[2]/ul/li[2]/a/cufon/canvas");
			selenium.waitForPageToLoad("30000");
			if(selenium.isElementPresent("xpath=.//*[@id='privacy-policy']")){
				Helper.log("OK. Is requested to accept terms");
				//Se aceptan para efectos del correcto funcionamiento de la prueba
				selenium.click("xpath=.//*[@id='form-subscribe']/input[3]");
			} else {
				Helper.log("Failed. Is not requested to accept terms");
			}
			
			//Click en botón ¿EMPEZAMOS?
			if(selenium.isElementPresent("css=div.b-center")){
			selenium.click("css=div.b-center");
			} else {
				Helper.log("Button ¿EMPEZAMOS? not found");
			}
			
			//Click en botón "AHORA, ESCOGE TUS MARCAS" sin seleccionar tipo de vestido
			if(selenium.isElementPresent("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[2]/div[3]/div/div[2]")){
				selenium.click("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[2]/div[3]/div/div[2]");
				//Texto de advertencia sobre la seleccion del tipo de vestido.
				if(selenium.isTextPresent("Seleccionar un tipo de vestido")){
					Helper.log("Text 'Seleccionar un tipo de vestido' is present. Test OK");
				} else {
					Helper.log("Text 'Seleccionar un tipo de vestido' is not present. Test Failed");
				}
			} else {
				Helper.log("Button 'AHORA, ESCOGE TUS MARCAS' not found");
			}
			
			//Click en la imagen correspondiente a un tipo de vestido
			if(selenium.isElementPresent("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[2]/div[2]/div[1]/div[1]/img")){
				selenium.click("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[2]/div[2]/div[5]/div[1]/img");
				selenium.isElementPresent("class=img-clothes selected");
				selenium.click("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[2]/div[2]/div[5]/div[1]/img");
				//Se seleccionan camisetas, zapatos
				selenium.click("xpath=//div[2]/div/img");
				selenium.click("xpath=//div[7]/div[2]/img");
			}
			//Click en el boton 'AHORA, ESCOGE TUS MARCAS'
			selenium.click("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[2]/div[3]/div/div[2]");
			//selenium.waitForPageToLoad("25000");
			//Click en el boton 'AHORA, ELIGE TU ESTILO' sin ingresar marcas
			selenium.click("xpath=//form[@id='form-subscribe-men']/div/div[2]/div[3]/div[3]/div/div[2]");
			//Se verifica el texto de advertencia
			if(selenium.isTextPresent("Ingrese por lo menos una marca")){
				Helper.log("Text 'Ingrese por lo menos una marca' is present. Test OK");
			} else {
				Helper.log("Text 'Ingrese por lo menos una marca' is not present. Test Failed");
			}
			
			selenium.type("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[3]/div[2]/div[1]/div[1]/input", "IKKS");
			selenium.type("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[3]/div[2]/div[2]/div[3]/input", "Diesel");
			//Click en el boton 'AHORA, ELIGE TU ESTILO'
			selenium.click("xpath=//form[@id='form-subscribe-men']/div/div[2]/div[3]/div[3]/div/div[2]");
			
			//Click en el botón "Y POR ULTIMO..." sin seleccionar estilo
			selenium.click("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[4]/div[3]/div/div[2]");
			if(selenium.isTextPresent("Seleccione por lo menos un estilo")){
				Helper.log("Text 'Seleccione por lo menos un estilo' is present. Test OK");
			} else {
				Helper.log("Text 'Seleccione por lo menos un estilo' is not present. Test Failed");
			}
			
			selenium.click("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[4]/div[2]/div[1]/div[3]");
			selenium.click("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[4]/div[2]/div[1]/div[3]");
			selenium.click("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[4]/div[2]/div[5]/div[3]");
			selenium.click("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[4]/div[2]/div[2]/div[3]");
			
			//Click en el botón "Y POR ULTIMO..."
			selenium.click("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[4]/div[3]/div/div[2]");
			//Click en el botón "ENVIA" sin ingresar datos del usuario
			selenium.click("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[5]/div[3]/div/div[2]");
			
			if(selenium.isTextPresent("Campo obligatorio.")){
				Helper.log("Text 'Campo obligatorio.' is present. Test OK");
			} else {
				Helper.log("Text 'Campo obligatorio.' is not present. Test Failed");
			}
			
			selenium.type("xpath=.//*[@id='username']", "$%$&% 234524");
			selenium.type("xpath=(//input[@id='email'])[2]", "gmail.com");
			selenium.click("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[5]/div[3]/div/div[2]");
			assertTrue(selenium.getText("xpath=.//*[@id='advice-validate-name-username']").equals("Utilice sólo letras (a-z o A-Z) en este campo."));
			assertTrue(selenium.getText("xpath=.//*[@id='advice-validate-email-email']").equals("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
			
			selenium.type("xpath=.//*[@id='username']", "");
			selenium.type("xpath=(//input[@id='email'])[2]", "");
			selenium.click("css=div.fifth-step > div.footer-men > div.button-men > div.b-center");
			assertEquals("Campo obligatorio.", selenium.getText("id=advice-required-entry-username"));
			assertEquals("Campo obligatorio.", selenium.getText("id=advice-required-entry-email"));
			
			selenium.type("xpath=.//*[@id='username']", " ");
			selenium.type("xpath=(//input[@id='email'])[2]", " ");
			selenium.click("css=div.fifth-step > div.footer-men > div.button-men > div.b-center");
			assertEquals("Campo obligatorio.", selenium.getText("id=advice-required-entry-username"));
			assertEquals("Campo obligatorio.", selenium.getText("id=advice-required-entry-email"));
			
			selenium.type("xpath=.//*[@id='username']", "Carlos");
			selenium.type("xpath=(//input[@id='email'])[2]", "claireandbruceqa@gmail.com");
			selenium.click("xpath=.//*[@id='form-subscribe-men']/div/div[2]/div[5]/div[3]/div/div[2]");
		
			selenium.isTextPresent("AHORA QUE YA SABEMOS LO QUE TE GUSTA, LLENAREMOS NUESTRA TIENDA CON VUESTRAS PETICIONES");
			
		} else {
			Helper.log("Element not found");
		}
		
	}
}
