package claireandbruce.com.test.account;

import static org.junit.Assert.assertTrue;
import lib.Helper;
import org.junit.Test;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import basics.ClaireandbruceTestCase;
/**
 * Caso de prueba diseñado para verificar la correcto despliegue y funcionamiento de la 
 * interfaz del formulario de contacto "Contáctenos". Cuando las listas de despliegue no 
 * son seleccionadas o los datos ingresados no son datos válidos, antes de enviar el mensaje.
 * CBT98
 * @author NEWSHORE
 *
 */
public class TestSendMessageFormularioContactoInvalidDataAccount  extends ClaireandbruceTestCase {

	@Test
	public void CBT98() throws Exception{
		
		LibCorrectLogonValidUserAccout.CBT55(selenium);
		
		//Se obtienen los datos básicos del usuario para comparar en [Contáctenos]
		Helper.log("Se ingresa a la información de la cuenta para obtener los datos de usuario");
		selenium.click("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[1]/div/div/p");
		selenium.waitForPageToLoad("15000");
		String nombre = selenium.getValue("xpath=.//*[@id='firstname']");
		String apellidos = selenium.getValue("xpath=.//*[@id='lastname']");
		
		//Click en el link "Formulario contacto"
		selenium.click("xpath=html/body/div/div[2]/div[2]/div[1]/div[3]/a[1]");
		selenium.waitForPageToLoad("15000");
		Helper.log("Se verifican datos de usuario cargados en el formulario");
		assertTrue(selenium.getValue("xpath=.//*[@id='name']").equals(nombre));
		assertTrue(selenium.getValue("xpath=.//*[@id='lastname']").equals(apellidos));
		assertTrue(selenium.getValue("xpath=.//*[@id='email']").equals(username));
		
		Helper.log("Se ingresa en el campo Nombre un dato vacío");
		selenium.type("xpath=.//*[@id='name']", "");
		Helper.log("Se ingresa en el campo Apellidos un dato vacío");
		selenium.type("xpath=.//*[@id='lastname']", "");
		Helper.log("Se ingresa en el campo Email un dato vacío");
		selenium.type("xpath=.//*[@id='email']", "@gmail.com ");
		
		//Selección de un tipo de consulta
		Helper.log("Se selecciona como 'Tipo de Consulta' la opción 'SELECCIONE UNA OPCIÓN'");
		selenium.click("xpath=.//*[@id='reason-0']/div/div[1]/div/div[1]");
		selenium.click("xpath=.//*[@id='reason-0']/div/div[2]/div/div/div[1]");
		
		//Seleccion de un motivo de consulta
		Helper.log("Se selecciona como 'Motivo de Consulta' la opción 'SELECCIONE UNA OPCIÓN'");
		selenium.click("xpath=.//*[@id='reason-1']/div/div[1]/div/div[1]");
		selenium.click("xpath=.//*[@id='reason-1']/div/div[2]/div/div/div[1]");
		
		Helper.log("Se ingresa en mensaje un dato vacío");
		selenium.type("xpath=.//*[@id='comment']", "");
		//Click en boton enviar
		Helper.log("Se hace clic en el botón 'ENVIAR'");
		selenium.click("xpath=.//*[@id='contactForm']/div[2]/button");

		//Se comprueban mensajes de advertencia en la interfaz
		Helper.log("Se comprueban mensajes de advertencia en la interfaz");
		assertTrue("Mensaje 'Campo obligatorio' no visualizado",selenium.getText("xpath=.//*[@id='advice-required-entry-name']").equals("Campo obligatorio.")); //Campo nombre
		Helper.log("Mensaje de advertencia 'Campo obligatorio.' OK");
		assertTrue("Mensaje sobre formato de emil no visualizado", selenium.getText("xpath=.//*[@id='advice-validate-email-email']").equals("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com.")); //Campo correo electronico
		Helper.log("Mensaje de advertencia 'Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com.' OK");
		assertTrue("Mensaje 'Seleccione una de las opciones.' no visualizado", selenium.getText("xpath=.//*[@id='advice-validate-contacts-type']").equals("Seleccione una de las opciones.")); //Seleccion de tipo de consulta
		Helper.log("Mensaje de advertencia 'Seleccione una de las opciones.' OK");
		assertTrue("Mensaje 'Seleccione una de las opciones.' no visualizado", selenium.getText("xpath=.//*[@id='advice-validate-contacts-theme']").equals("Seleccione una de las opciones.")); //Seleccion de motivo de consulta
		Helper.log("Mensaje de advertencia 'Seleccione una de las opciones.' OK");
		assertTrue("Mensaje 'Campo obligatorio' no visualizado", selenium.getText("xpath=.//*[@id='advice-required-entry-comment']").equals("Campo obligatorio.")); //Mensaje vacío
		Helper.log("Mensaje de advertencia 'Campo obligatorio.' OK");
		
		Helper.log("Se ingresa en el campo Email un dato vacío");
		selenium.type("xpath=.//*[@id='email']", "");
		//Click en boton enviar
		Helper.log("Se hace clic en el botón 'ENVIAR'");
		selenium.click("xpath=.//*[@id='contactForm']/div[2]/button");
		Helper.log("Se confirma mensaje 'Campo obligatorio.' en la interfaz");
		assertTrue("Mensaje 'Campo obligatorio' no visualizado", selenium.getText("xpath=.//*[@id='advice-required-entry-email']").equals("Campo obligatorio.")); //Campo correo electronico
		Helper.log("Mensaje de advertencia 'Campo obligatorio.' OK");
		
	}
}