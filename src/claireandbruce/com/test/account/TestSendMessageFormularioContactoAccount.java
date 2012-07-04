package claireandbruce.com.test.account;


import static org.junit.Assert.*;
import lib.Helper;
import org.junit.Test;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import basics.ClaireandbruceTestCase;

/**
 * 
 * Caso de prueba dise�ado para verificar el correcto despliegue y funcionamiento 
 * de la interfaz del formulario "Cont�ctenos".
 * CBT97
 * @author NEWSHORE
 *
 */
public class TestSendMessageFormularioContactoAccount extends ClaireandbruceTestCase {
	
	@Test
	public void CBT97() throws Exception{
		
		Helper.log("\n*** CASO DE PRUEBA *** CBT97. ENV�O DE FORMULARIO DE CONTACTO");
		
		LibCorrectLogonValidUserAccout.CBT55(selenium);
		
		//Se obtienen los datos b�sicos del usuario para comparar en [Contactenos]
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
		
		//Selecci�n de un tipo de consulta
		selenium.click("xpath=.//*[@id='reason-0']/div/div[1]/div/div[1]");
		selenium.click("xpath=.//*[@id='reason-0']/div/div[2]/div/div/div["+((int)(Math.random()*(3))+2)+"]");
		
		//Selecci�n de un motivo de consulta
		selenium.click("xpath=.//*[@id='reason-1']/div/div[1]/div/div[1]");
		selenium.click("xpath=.//*[@id='reason-1']/div/div[2]/div/div/div["+((int)(Math.random()*(5))+2)+"]");
		
		selenium.type("xpath=.//*[@id='comment']", "Mensaje prueba QA");
		//Click en boton enviar
		selenium.click("xpath=.//*[@id='contactForm']/div[2]/button");
		
		//assertTrue(selenium.getConfirmation().matches("Aunque esta p�gina est� cifrada, la informaci�n que ha introducido va a enviarse por una conexi�n sin cifrar, y podr�a ser le�da f�cilmente por terceras personas.\n�Est� seguro de que desea enviar esta informaci�n[\\s\\S]$"));
		selenium.waitForPageToLoad("10000");
		assertTrue("Mensaje de confirmaci�n, sobre el mensaje enviado, no encontrado",selenium.isTextPresent("Su solicitud ha sido enviada y le responderemos con la mayor brevedad posible.Gracias por contactar con nosotros"));
		
	}
}