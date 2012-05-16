package claireandbruce.com.test.account;


import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Assert;
import org.junit.Test;


import basics.AfterFailure;
import basics.ClaireandbruceTestCase;

/**
 * 
 * Caso de prueba diseñado para verificar el correcto despliegue y funcionamiento 
 * de la interfaz del formulario "Contáctenos".
 * @author María Fernanda Rodríguez Vargas
 *
 */
public class CBT97_Test_SendMessage_FormularioContacto_TuCuenta extends ClaireandbruceTestCase {
	
	@Test
	public void CBT97() throws Exception{
		
		Claireandbruce.login(selenium, username, password);
		
		//Se obtienen los datos basicos del usuario para comparar en [Contactenos]
		selenium.click("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[1]/div/div/p");
		selenium.waitForPageToLoad("50000");
		String nombre = selenium.getValue("xpath=.//*[@id='firstname']");
		String apellidos = selenium.getValue("xpath=.//*[@id='lastname']");
		
		//Click en el link "Formulario contacto"
		selenium.click("xpath=html/body/div/div[2]/div[2]/div[1]/div[3]/a[1]");
		selenium.waitForPageToLoad("15000");
		assertTrue(selenium.getValue("xpath=.//*[@id='name']").equals(nombre));
		assertTrue(selenium.getValue("xpath=.//*[@id='lastname']").equals(apellidos));
		assertTrue(selenium.getValue("xpath=.//*[@id='email']").equals(username));
		
		//Seleccion de un tipo de consulta
		selenium.click("xpath=.//*[@id='reason-0']/div/div[1]/div/div[1]");
		selenium.click("xpath=.//*[@id='reason-0']/div/div[2]/div/div/div["+((int)(Math.random()*(3))+2)+"]");
		
		//Seleccion de un motivo de consulta
		selenium.click("xpath=.//*[@id='reason-1']/div/div[1]/div/div[1]");
		selenium.click("xpath=.//*[@id='reason-1']/div/div[2]/div/div/div["+((int)(Math.random()*(5))+2)+"]");
		
		selenium.type("xpath=.//*[@id='comment']", "Mensaje prueba QA");
		//Click en boton enviar
		selenium.click("xpath=.//*[@id='contactForm']/div[2]/button");
		selenium.waitForPageToLoad("30000");
		if((selenium.getTitle().startsWith("help")))
		{
			
			selenium.click("//a[contains(text(), 'Tu cuenta')]");
			
			if(!selenium.isTextPresent("Su solicitud ha sido enviada y le responderemos con la mayor brevedad posible.Gracias por contactar con nosotros")){
				Assert.fail(" Error " + selenium.getLocation());
			}
		}
		else
		{
			Assert.fail(" Error: Page no found : " + selenium.getLocation());
			
		}
		
		
	}

}
