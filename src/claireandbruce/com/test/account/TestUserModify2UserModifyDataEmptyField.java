package claireandbruce.com.test.account;

import static org.junit.Assert.assertTrue;
import lib.Helper;
import org.junit.Test;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import basics.ClaireandbruceTestCase;

/**
 * Testlink: Local CBT9 - Privalia CBT32
 * @author NEWSHORE
 *
 */
public class TestUserModify2UserModifyDataEmptyField extends ClaireandbruceTestCase{

	@Test
	public void cbt32 () throws Exception{
		
		Helper.log("*** CBT32 *** MODIFICACIÓN DE DATOS BÁSICOS - CAMPOS VACÍOS");
		LibCorrectLogonValidUserAccout.CBT55(selenium);
	
		if(!selenium.getTitle().equals("Mi cuenta")) {
			selenium.click("link=Mi cuenta");
			selenium.waitForPageToLoad("10000");
		}
		//Click en el link "Tus datos personales"
		Helper.clickAndVerify(selenium, "class=item account-configuration", "", "//form[@id='form-validate']/div/div/div/cufon[3]/canvas");
		//selenium.waitForPageToLoad("20000");
		//Se ingresa campo nombre vacio
		selenium.type("id=firstname", "");
		
		//Se ingresa campo apellidos vacio
		selenium.type("id=lastname", "");
		//Se verifica mensaje de advertencia "Campo obligatorio." en el campo Nombre
		assertTrue(selenium.getText("xpath=.//*[@id='advice-required-entry-firstname']").equals("Campo obligatorio."));
		Helper.log("Se verifica que el campo Nombre muestra mensaje de advertencia 'Campo obligatorio.'");
		
		//Se ingresa campo email vacio
		selenium.type("id=email", "");
		//Se verifica mensaje de advertencia "Campo obligatorio." en el campo Apellidos
		assertTrue(selenium.getText("xpath=.//*[@id='advice-required-entry-lastname']").equals("Campo obligatorio."));
		Helper.log("Se verifica que el campo Apellidos muestra mensaje de advertencia 'Campo obligatorio.'");
		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		
		//Se verifica que los mensajes advertencia "Campo obligatorio." permanezcan
		assertTrue(selenium.getText("xpath=.//*[@id='advice-required-entry-firstname']").equals("Campo obligatorio."));
		Helper.log("Se verifica que el campo Nombre permanece mostrando mensaje de advertencia 'Campo obligatorio.'");
		assertTrue(selenium.getText("xpath=.//*[@id='advice-required-entry-lastname']").equals("Campo obligatorio."));
		Helper.log("Se verifica que el campo Apellidos permanece mostrando mensaje de advertencia 'Campo obligatorio.'");
		assertTrue(selenium.getText("xpath=.//*[@id='advice-required-entry-email']").equals("Campo obligatorio."));
		Helper.log("Se verifica que el campo Email permanece mostrando mensaje de advertencia 'Campo obligatorio.'\n");
		
	}
}
