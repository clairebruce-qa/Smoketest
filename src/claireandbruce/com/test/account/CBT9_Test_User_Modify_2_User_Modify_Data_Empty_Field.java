package claireandbruce.com.test.account;

import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT9_Test_User_Modify_2_User_Modify_Data_Empty_Field extends ClaireandbruceTestCase{

	@Test
	public void CBT9 () throws Exception{
		Claireandbruce.login(selenium, username,password);
		//selenium.waitForPageToLoad("10000");
		//Click en el link "Tu cuenta" Pagina Tu cuenta
		Helper.clickAndVerify(selenium, "class=item account-configuration", "", "//form[@id='form-validate']/div/div/div/cufon[3]/canvas");
		//selenium.waitForPageToLoad("20000");
		//Se ingresa campo nombre vacio
		selenium.type("id=firstname", "");
		
		//Se ingresa campo apellidos vacio
		selenium.type("id=lastname", "");
		//Se verifica mensaje de advertencia "Campo obligatorio." en el campo Nombre
		assertTrue(selenium.getText("xpath=.//*[@id='advice-required-entry-firstname']").equals("Campo obligatorio."));
		
		//Se ingresa campo email vacio
		selenium.type("id=email", "");
		//Se verifica mensaje de advertencia "Campo obligatorio." en el campo Apellidos
		assertTrue(selenium.getText("xpath=.//*[@id='advice-required-entry-lastname']").equals("Campo obligatorio."));
		
		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		
		//Se verifica que los mensajes advertencia "Campo obligatorio." permanezcan
		assertTrue(selenium.getText("xpath=.//*[@id='advice-required-entry-firstname']").equals("Campo obligatorio."));
		assertTrue(selenium.getText("xpath=.//*[@id='advice-required-entry-lastname']").equals("Campo obligatorio."));
		assertTrue(selenium.getText("xpath=.//*[@id='advice-required-entry-email']").equals("Campo obligatorio."));
		
	}
}
