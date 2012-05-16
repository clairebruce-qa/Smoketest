package claireandbruce.com.test.account;

import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

/* Se verificará la respuesta del sistema para  la validación de  campos
 * en el formulario de modificación de los datos  del usuario registrado
 * cuando se le dan valores con  formatos no validos en campo   nombre y 
 * apellido, el exito del caso de prueba sera la notificación al usuario
 * acerca de los formatos validos para los datos en los campos*/


public class CBT10_Test_User_Modify_3_User_Modify_Data_Invalid_Name_Field extends ClaireandbruceTestCase {

	
		
	
	@Test
	public void CBT10 () throws Exception{
		
		
		//El usuario no debe tener su sesión iniciada
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			Claireandbruce.login(selenium, username,password);
			
		}
		
		
		
		//Click en el link "Tu cuenta" Pagina Tu cuenta
		Helper.clickAndVerify(selenium, "class=item account-configuration", "", "//form[@id='form-validate']/div/div/div/cufon[3]/canvas");
		
		//PASO 2. Testlink
		//Se ingresa campo nombre {1235}
		selenium.type("xpath=.//*[@id='firstname']", "1235");
		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		//Se verifica mensaje de advertencia "Utilice sólo letras (a-z o A-Z) en este campo." en el campo Nombre
		assertTrue(selenium.getText("xpath=//div[@id='advice-validate-name-firstname']").equals("Utilice sólo letras (a-z o A-Z) en este campo."));
		
		//PASO 3. Testlink
		//Se ingresa un dato valido en el campo nombre para verificar la validez solo el campo apellido
		selenium.type("xpath=.//*[@id='firstname']", "x");
		//Se ingresa campo apellidos {1237}
		selenium.type("xpath=.//*[@id='lastname']", "1237");
		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		//Se verifica mensaje de advertencia "Utilice sólo letras (a-z o A-Z) en este campo." en el campo Apellidos
		assertTrue(selenium.getText("xpath=//div[@id='advice-validate-name-lastname']").equals("Utilice sólo letras (a-z o A-Z) en este campo."));
		
		//PASO 4. Testlink
		//Se ingresa un dato valido en el campo Apellidos para verificar la validez solo el campo nombre
		selenium.type("xpath=.//*[@id='lastname']", "x");
		//Se ingresa campo nombre {%&$>}
		selenium.type("xpath=.//*[@id='firstname']", "%&$>");
		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		//Se verifica mensaje de advertencia "Utilice sólo letras (a-z o A-Z) en este campo." en el campo Nombre
		assertTrue(selenium.getText("xpath=//div[@id='advice-validate-name-firstname']").equals("Utilice sólo letras (a-z o A-Z) en este campo."));
		
		//PASO 5. Testlink
		//Se ingresa un dato valido en el campo nombre para verificar la validez solo el campo apellido
		selenium.type("xpath=.//*[@id='firstname']", "x");
		//Se ingresa campo apellidos {%&$>}
		selenium.type("xpath=.//*[@id='lastname']", "%&$>");
		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		//Se verifica mensaje de advertencia "Utilice sólo letras (a-z o A-Z) en este campo." en el campo Apellidos
		assertTrue(selenium.getText("xpath=//div[@id='advice-validate-name-lastname']").equals("Utilice sólo letras (a-z o A-Z) en este campo."));
		
		//PASO 6. Testlink
		//Se ingresa un dato valido en el campo Apellidos para verificar la validez solo el campo nombre
		selenium.type("xpath=.//*[@id='lastname']", "x");
		//Se ingresa campo nombre {.}
		selenium.type("xpath=.//*[@id='firstname']", ".");
		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		selenium.click("id=email");
		
		if(!selenium.isTextPresent("Utilice sólo letras (a-z o A-Z) en este campo.")){
			Helper.log(" SE ESTA PERMITIENDO EL INGRESO DE UN NOMBRE CONTENIENDO COMO CARACTER UNICO UN PUNTO {.}");
		} else {
			Helper.log(" NO SE PERMITE EL INGRESO DE UN NOMBRE CONTENIENDO COMO CARACTER UNICO UN PUNTO {.}");
		}
		
		//PASO 7. Testlink
		//Se ingresa un dato valido en el campo nombre para verificar la validez solo el campo apellido
		selenium.type("xpath=.//*[@id='firstname']", "x");
		//Se ingresa campo apellidos {.}
		selenium.type("xpath=.//*[@id='lastname']", ".");
		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		selenium.click("id=email");

		if(!selenium.isTextPresent("Utilice sólo letras (a-z o A-Z) en este campo.")){
			Helper.log(" SE ESTA PERMITIENDO EL INGRESO DE APELLIDOS CONTENIENDO COMO CARACTER UNICO UN PUNTO {.}");
		} else {
			Helper.log(" NO SE PERMITE EL INGRESO DE UN APELLIDOS CONTENIENDO COMO CARACTER UNICO UN PUNTO {.}");
		}
		selenium.waitForPageToLoad("30000");
		//PASO 8. Testlink
		//Se ingresa campo nombre {Mafe.}
		selenium.type("xpath=.//*[@id='firstname']", "Mafe.");
		//Se ingresa un dato valido en el campo Apellidos para verificar la validez solo el campo nombre
		selenium.type("xpath=.//*[@id='lastname']", "x");
		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		selenium.click("id=email");
		
		if(!selenium.isTextPresent("Utilice sólo letras (a-z o A-Z) en este campo.")){
			Helper.log(" SE ESTA PERMITIENDO EL INGRESO DE UN NOMBRE CONTENIENDO EL CARACTER PUNTO {.} EN EL. Ejemplo: Mafe.");
		} else {
			Helper.log(" NO SE PERMITE EL INGRESO DE UN NOMBRE CONTENIENDO EL CARACTER PUNTO {.} EN EL. Ejemplo: Mafe.");
		}
		
		//PASO 9. Testlink
		//Se ingresa campo apellidos {Rodriguez.v}
		selenium.type("xpath=.//*[@id='lastname']", "Rodriguez.v");
		//Se ingresa un dato valido en el campo nombre para verificar la validez solo el campo apellido
		selenium.type("id=firstname", "x");		
		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		selenium.click("id=email");
		
		if(!selenium.isTextPresent("Utilice sólo letras (a-z o A-Z) en este campo.")){
			Helper.log(" SE ESTA PERMITIENDO EL INGRESO DE APELLIDOS CONTENIENDO EL CARACTER PUNTO {.} EN EL. Ejemplo: Rodriguez.v");
		} else {
			Helper.log(" NO SE PERMITE EL INGRESO DE UN APELLIDOS CONTENIENDO EL CARACTER PUNTO {.} EN EL Ejemplo: Rodriguez.v");
		}
		
	}
}
