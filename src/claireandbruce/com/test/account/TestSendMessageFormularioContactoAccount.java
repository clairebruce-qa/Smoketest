package claireandbruce.com.test.account;


import static org.junit.Assert.*;
import lib.Helper;
import org.junit.Test;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import basics.ClaireandbruceTestCase;

/**
 * 
 * Caso de prueba diseñado para verificar el correcto despliegue y funcionamiento 
 * de la interfaz del formulario "Contáctenos".
 * CBT97
 * @author NEWSHORE
 *
 */
public class TestSendMessageFormularioContactoAccount extends ClaireandbruceTestCase {
	
	@Test
	public void CBT97() throws Exception{
		
		Helper.log("\n*** CASO DE PRUEBA *** CBT97. ENVÍO DE FORMULARIO DE CONTACTO");
		
		LibCorrectLogonValidUserAccout.CBT55(selenium);
		
		//Se obtienen los datos básicos del usuario para comparar en [Contactenos]
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
		
		//Selección de un tipo de consulta
		selenium.click("xpath=.//*[@id='reason-0']/div/div[1]/div/div[1]");
		selenium.click("xpath=.//*[@id='reason-0']/div/div[2]/div/div/div["+((int)(Math.random()*(3))+2)+"]");
		
		//Selección de un motivo de consulta
		selenium.click("xpath=.//*[@id='reason-1']/div/div[1]/div/div[1]");
		selenium.click("xpath=.//*[@id='reason-1']/div/div[2]/div/div/div["+((int)(Math.random()*(5))+2)+"]");
		
		selenium.type("xpath=.//*[@id='comment']", "Mensaje prueba QA");
		//Click en boton enviar
		selenium.click("xpath=.//*[@id='contactForm']/div[2]/button");
		
		//assertTrue(selenium.getConfirmation().matches("Aunque esta página está cifrada, la información que ha introducido va a enviarse por una conexión sin cifrar, y podría ser leída fácilmente por terceras personas.\n¿Está seguro de que desea enviar esta información[\\s\\S]$"));
		selenium.waitForPageToLoad("10000");
		assertTrue("Mensaje de confirmación, sobre el mensaje enviado, no encontrado",selenium.isTextPresent("Su solicitud ha sido enviada y le responderemos con la mayor brevedad posible.Gracias por contactar con nosotros"));
		
	}
}