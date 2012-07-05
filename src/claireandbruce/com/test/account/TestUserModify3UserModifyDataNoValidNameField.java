package claireandbruce.com.test.account;

import static org.junit.Assert.assertTrue;
import lib.Helper;
import org.junit.Test;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import basics.ClaireandbruceTestCase;

/** Se verificar� la respuesta del sistema para  la validaci�n de  campos
 * en el formulario de modificaci�n de los datos  del usuario registrado
 * cuando se le dan valores con  formatos no validos en campo   nombre y 
 * apellido, el exito del caso de prueba sera la notificaci�n al usuario
 * acerca de los formatos validos para los datos en los campos
 * 
 * Testlink: Local CBT10 - Privalia CBT55
 * @author NEWSHORE
 * */


public class TestUserModify3UserModifyDataNoValidNameField extends ClaireandbruceTestCase {
		
	
	@Test
	public void cbt55 () throws Exception{
		
		Helper.log("Se inicia prueba de modificaci�n de datos con valores no v�lidos");
		//El usuario no debe tener su sesi�n iniciada
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			LibCorrectLogonValidUserAccout.CBT55(selenium);		
		}
		
		//Click en el link "Tu cuenta" P�gina Tu cuenta
		Helper.clickAndVerify(selenium, "css=div.item.account-configuration > div.content > p", "", "//form[@id='form-validate']/div/div/div/cufon[3]/canvas");
		
		//PASO 2. Testlink
		//Se ingresa campo nombre {1235}
		Helper.log("Se ingresa campo nombre 1235");
		selenium.type("xpath=.//*[@id='firstname']", "1235");
		//Se da click en el boton GUARDA TUS DATOS
		Helper.log("Se da click en el boton GUARDA TUS DATOS");
		selenium.click("css=button.button");
		Helper.log("Se confirma mensaje 'Utilice s�lo letras (a-z o A-Z) en este campo.'");
		//Se verifica mensaje de advertencia "Utilice s�lo letras (a-z o A-Z) en este campo." en el campo Nombre
		assertTrue(selenium.getText("xpath=//div[@id='advice-validate-name-firstname']").equals("Utilice s�lo letras (a-z o A-Z) en este campo."));
		
		//PASO 3. Testlink
		//Se ingresa un dato valido en el campo nombre para verificar la validez solo el campo apellido
		selenium.type("xpath=.//*[@id='firstname']", "Claire");
		//Se ingresa campo apellidos {1237}
		Helper.log("Se ingresa campo apellido 1237");
		selenium.type("xpath=.//*[@id='lastname']", "1237");
		//Se da click en el boton GUARDA TUS DATOS
		Helper.log("Se da click en el boton GUARDA TUS DATOS");
		selenium.click("css=button.button");
		//Se verifica mensaje de advertencia "Utilice s�lo letras (a-z o A-Z) en este campo." en el campo Apellidos
		Helper.log("Se confirma mensaje 'Utilice s�lo letras (a-z o A-Z) en este campo.'");
		assertTrue(selenium.getText("xpath=//div[@id='advice-validate-name-lastname']").equals("Utilice s�lo letras (a-z o A-Z) en este campo."));
		
		//PASO 4. Testlink
		//Se ingresa un dato valido en el campo Apellidos para verificar la validez solo el campo nombre
		selenium.type("xpath=.//*[@id='lastname']", "Bruce");
		//Se ingresa campo nombre {%&$>}
		Helper.log("Se ingresa campo nombre %&$>");
		selenium.type("xpath=.//*[@id='firstname']", "%&$>");
		//Se da click en el boton GUARDA TUS DATOS
		Helper.log("Se da click en el boton GUARDA TUS DATOS");
		selenium.click("css=button.button");
		//Se verifica mensaje de advertencia "Utilice s�lo letras (a-z o A-Z) en este campo." en el campo Nombre
		Helper.log("Se confirma mensaje 'Utilice s�lo letras (a-z o A-Z) en este campo.'");
		assertTrue(selenium.getText("xpath=//div[@id='advice-validate-name-firstname']").equals("Utilice s�lo letras (a-z o A-Z) en este campo."));
		
		//PASO 5. Testlink
		//Se ingresa un dato valido en el campo nombre para verificar la validez solo el campo apellido
		selenium.type("xpath=.//*[@id='firstname']", "Claire");
		//Se ingresa campo apellidos {%&$>}
		Helper.log("Se ingresa campo apellidos %&$>");
		selenium.type("xpath=.//*[@id='lastname']", "%&$>");
		//Se da click en el boton GUARDA TUS DATOS
		Helper.log("Se da click en el boton GUARDA TUS DATOS");
		selenium.click("css=button.button");
		//Se verifica mensaje de advertencia "Utilice s�lo letras (a-z o A-Z) en este campo." en el campo Apellidos
		Helper.log("Se confirma mensaje 'Utilice s�lo letras (a-z o A-Z) en este campo.'");
		assertTrue(selenium.getText("xpath=//div[@id='advice-validate-name-lastname']").equals("Utilice s�lo letras (a-z o A-Z) en este campo."));
		
		//PASO 6. Testlink
		//Se ingresa un dato valido en el campo Apellidos para verificar la validez solo el campo nombre
		selenium.type("xpath=.//*[@id='lastname']", "Bruce");
		//Se ingresa campo nombre {.}
		Helper.log("Se ingresa en el campo nombre .");
		selenium.type("xpath=.//*[@id='firstname']", ".");
		//Se da click en el boton GUARDA TUS DATOS
		Helper.log("Se da click en el boton GUARDA TUS DATOS");
		selenium.click("css=button.button");
		selenium.click("id=email");
		
		if(!selenium.isTextPresent("Utilice s�lo letras (a-z o A-Z) en este campo.")){
			Helper.log(" SE ESTA PERMITIENDO EL INGRESO DE UN NOMBRE CONTENIENDO COMO CARACTER UNICO UN PUNTO {.}");
		} else {
			Helper.log(" NO SE PERMITE EL INGRESO DE UN NOMBRE CONTENIENDO COMO CARACTER UNICO UN PUNTO {.}");
		}
		
		//PASO 7. Testlink
		//Se ingresa un dato valido en el campo nombre para verificar la validez solo el campo apellido
		selenium.type("xpath=.//*[@id='firstname']", "Claire");
		//Se ingresa campo apellidos {.}
		Helper.log("Se ingresa en el campo apellido .");
		selenium.type("xpath=.//*[@id='lastname']", ".");
		//Se da click en el boton GUARDA TUS DATOS
		Helper.log("Se hace clic en el bot�n 'GUARDA TUS DATOS'");
		selenium.click("css=button.button");
		selenium.click("id=email");

		if(!selenium.isTextPresent("Utilice s�lo letras (a-z o A-Z) en este campo.")){
			Helper.log(" SE ESTA PERMITIENDO EL INGRESO DE APELLIDOS CONTENIENDO COMO CARACTER UNICO UN PUNTO {.}");
		} else {
			Helper.log(" NO SE PERMITE EL INGRESO DE UN APELLIDOS CONTENIENDO COMO CARACTER UNICO UN PUNTO {.}");
		}
		selenium.waitForPageToLoad("30000");
		//PASO 8. Testlink
		//Se ingresa campo nombre {Claire.}
		Helper.log("Se ingresa en el campo nombre 'Claire.'");
		selenium.type("xpath=.//*[@id='firstname']", "Claire.");
		//Se ingresa un dato valido en el campo Apellidos para verificar la validez solo el campo nombre
		selenium.type("xpath=.//*[@id='lastname']", "x");
		//Se da click en el boton GUARDA TUS DATOS
		Helper.log("Se hace clic en el bot�n 'GUARDA TUS DATOS'");
		selenium.click("css=button.button");
		selenium.click("id=email");
		
		if(!selenium.isTextPresent("Utilice s�lo letras (a-z o A-Z) en este campo.")){
			Helper.log(" SE ESTA PERMITIENDO EL INGRESO DE UN NOMBRE CONTENIENDO EL CARACTER PUNTO {.} EN EL. Ejemplo: Claire.");
		} else {
			Helper.log(" NO SE PERMITE EL INGRESO DE UN NOMBRE CONTENIENDO EL CARACTER PUNTO {.} EN EL. Ejemplo: Claire.");
		}
		
		//PASO 9. Testlink
		//Se ingresa campo apellidos {Bruce.}
		Helper.log("Se ingresa en el campo apellidos 'Bruce.'");
		selenium.type("xpath=.//*[@id='lastname']", "Bruce.");
		//Se ingresa un dato valido en el campo nombre para verificar la validez solo el campo apellido
		selenium.type("id=firstname", "Claire");		
		//Se da click en el boton GUARDA TUS DATOS
		Helper.log("Se hace clic en el bot�n 'GUARDA TUS DATOS'");
		selenium.click("css=button.button");
		selenium.click("id=email");
		
		if(!selenium.isTextPresent("Utilice s�lo letras (a-z o A-Z) en este campo.")){
			Helper.log(" SE ESTA PERMITIENDO EL INGRESO DE APELLIDOS CONTENIENDO EL CARACTER PUNTO {.} EN EL. Ejemplo: Bruce.");
		} else {
			Helper.log(" NO SE PERMITE EL INGRESO DE UN APELLIDOS CONTENIENDO EL CARACTER PUNTO {.} EN EL Ejemplo: Bruce.");
		}
		
	}
}
