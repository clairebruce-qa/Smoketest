package claireandbruce.com.test.account;

import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * Caso de prueba diseñado para verificar la correcto despliegue y funcionamiento de la 
 * interfaz del formulario de contacto "Contáctenos". Cuando las listas de despliegue no 
 * son seleccionadas o los datos ingresados no son datos válidos, antes de enviar el mensaje.
 * @author María Fernanda Rodríguez Vargas
 *
 */
public class CBT45_Test_SendMessage_FormularioContacto_InvalidData_TuCuenta  extends ClaireandbruceTestCase {

	@Test
	public void test_SendMessage_FormularioContacto_InvalidData_TuCuenta() throws Exception{
		
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
		
		selenium.type("xpath=.//*[@id='name']", "");
		selenium.type("xpath=.//*[@id='lastname']", "");
		selenium.type("xpath=.//*[@id='email']", "@gmail.com ");
		
		//Seleccion de un tipo de consulta
		selenium.click("xpath=.//*[@id='reason-0']/div/div[1]/div/div[1]");
		selenium.click("xpath=.//*[@id='reason-0']/div/div[2]/div/div/div[1]");
		
		//Seleccion de un motivo de consulta
		selenium.click("xpath=.//*[@id='reason-1']/div/div[1]/div/div[1]");
		selenium.click("xpath=.//*[@id='reason-1']/div/div[2]/div/div/div[1]");
		
		selenium.type("xpath=.//*[@id='comment']", "");
		//Click en boton enviar
		selenium.click("xpath=.//*[@id='contactForm']/div[2]/button");

		//Se comprueban mensajes de advertencia en la interfaz
		assertTrue(selenium.getText("xpath=.//*[@id='advice-required-entry-name']").equals("Campo obligatorio.")); //Campo nombre
		Helper.log("Warning Message 'Campo obligatorio.' OK");
		assertTrue(selenium.getText("xpath=.//*[@id='advice-validate-email-email']").equals("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com.")); //Campo correo electronico
		Helper.log("Warning Message 'Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com.' OK");
		assertTrue(selenium.getText("xpath=.//*[@id='advice-validate-contacts-type']").equals("Seleccione una de las opciones.")); //Seleccion de tipo de consulta
		Helper.log("Warning Message 'Seleccione una de las opciones.' OK");
		assertTrue(selenium.getText("xpath=.//*[@id='advice-validate-contacts-theme']").equals("Seleccione una de las opciones.")); //Seleccion de motivo de consulta
		Helper.log("Warning Message 'Seleccione una de las opciones.' OK");
		assertTrue(selenium.getText("xpath=.//*[@id='advice-required-entry-comment']").equals("Campo obligatorio.")); //Mensaje vacío
		Helper.log("Warning Message 'Campo obligatorio.' OK");
		
		selenium.type("xpath=.//*[@id='email']", "");
		//Click en boton enviar
		selenium.click("xpath=.//*[@id='contactForm']/div[2]/button");
		assertTrue(selenium.getText("xpath=.//*[@id='advice-required-entry-email']").equals("Campo obligatorio.")); //Campo correo electronico
		Helper.log("Warning Message 'Campo obligatorio.' OK");
		
		
		
	}
}
