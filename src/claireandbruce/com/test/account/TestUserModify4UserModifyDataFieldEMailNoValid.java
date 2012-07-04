package claireandbruce.com.test.account;

import static org.junit.Assert.assertTrue;
import lib.Helper;
import org.junit.Test;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import basics.ClaireandbruceTestCase;
/**
 * CBT11
 * @author NEWSHORE
 *
 */
public class TestUserModify4UserModifyDataFieldEMailNoValid extends ClaireandbruceTestCase {

	@Test
	public void CBT11 () throws Exception{
		Helper.log("Se inicia prueba de modificación de datos con email en formato no válido");
		LibCorrectLogonValidUserAccout.CBT55(selenium);
		
		Helper.log("Se ingresa a la interfaz 'Información de Cuenta'");
		//Click en el link "Tu cuenta" Pagina Tu cuenta
		Helper.clickAndVerify(selenium, "css=div.item.account-configuration > div.content > p", "", "//form[@id='form-validate']/div/div/div/cufon[3]/canvas");
		
		//PASO 1. Testlink
		//Se ingresa en el campo email {@gmail.com}
		Helper.log("Se ingresa en el campo email @gmail.com");
		selenium.type("id=email", "@gmail.com");
		//Se da click en el boton GUARDA TUS DATOS
		Helper.log("Se hace clic en el botón 'GUARDA TUS DATOS'");
		selenium.click("css=button.button");
		//Se verifica mensaje de advertencia sobre formato de email no válido
		Helper.log("Se verifica el texto 'Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com.'");
		assertTrue("Mensaje de advertencia", selenium.getText("xpath=//div[@id='advice-validate-email-email']").equals("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
		
		//PASO 2. Testlink
		//Se ingresa en el campo email {claireandbruce@gmail}
		Helper.log("Se ingresa en el campo email claireandbruce@gmail");
		selenium.type("id=email", "claireandbruce@gmail");
		//Se da click en el boton GUARDA TUS DATOS
		Helper.log("Se hace clic en el botón 'GUARDA TUS DATOS'");
		selenium.click("css=button.button");
		//Se verifica mensaje de advertencia sobre formato de email no válido
		Helper.log("Se verifica el texto 'Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com.'");
		assertTrue("Mensaje de advertencia",selenium.getText("xpath=//div[@id='advice-validate-email-email']").equals("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
	
		//PASO 3. Testlink
		//Se ingresa en el campo email {claireandBruce@.com}
		Helper.log("Se ingresa en el campo email claireandBruce@.com");
		selenium.type("id=email", "claireandBruce@.com");
		//Se da click en el boton GUARDA TUS DATOS
		Helper.log("Se hace clic en el botón 'GUARDA TUS DATOS'");
		selenium.click("css=button.button");
		//Se verifica mensaje de advertencia sobre formato de email no válido
		Helper.log("Se verifica el texto 'Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com.'");
		assertTrue("Mensaje de advertencia", selenium.getText("xpath=//div[@id='advice-validate-email-email']").equals("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
		
		//PASO 4. Testlink
		//Se ingresa en el campo email {claireandbrucegmail.com}
		Helper.log("Se ingresa en el campo email claireandbrucegmail.com");
		selenium.type("id=email", "claireandbrucegmail.com");
		//Se da click en el boton GUARDA TUS DATOS
		Helper.log("Se hace clic en el botón 'GUARDA TUS DATOS'");
		selenium.click("css=button.button");
		//Se verifica mensaje de advertencia sobre formato de email no válido
		Helper.log("Se verifica el texto 'Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com.'");
		assertTrue("Mensaje de advertencia", selenium.getText("xpath=//div[@id='advice-validate-email-email']").equals("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com."));
		
	}
}