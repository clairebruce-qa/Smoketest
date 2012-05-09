package claireandbruce.com.test.account;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

/**
 * 
 * Caso de prueba dise�ado para verificar el correcto despliegue y funcionamiento 
 * de la interfaz del formulario de contacto "Cont�ctenos".
 * @author Mar�a Fernanda Rodr�guez Vargas
 *
 */
public class CBT44_Test_SendMessage_FormularioContacto_TuCuenta extends ClaireandbruceTestCase {
	
	@Test
	public void test_SendMessage_FormularioContacto_TuCuenta() throws Exception{
		
		Claireandbruce.login(selenium, username, password);
		
		//Se obtienen los datos basicos del usuario para comparar en [Contactenos]
		selenium.click("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[1]/div/div/p");
		selenium.waitForPageToLoad("15000");
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
		selenium.waitForPageToLoad("15000");
		assertTrue(selenium.getTitle().startsWith("help"));
	}

}
