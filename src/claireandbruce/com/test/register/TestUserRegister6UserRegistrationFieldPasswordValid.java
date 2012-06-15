package claireandbruce.com.test.register;

import junit.framework.Assert;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * 	Verificar la validación del campo contraseña en longitud, este campo recibe cualquier tipo de carácter numérico, alfabético.
 * 	El éxito del caso de prueba se reflejara en el aviso de correcciones para el usuario de los datos ingresados.
 *  CBT7
 * @author NEWSHORE
 * 
 */
public class TestUserRegister6UserRegistrationFieldPasswordValid extends ClaireandbruceTestCase{
	
	@Test
	public void CBT7(){
		
		Helper.log("Se carga la página "+ClaireandbruceUrl);
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		Helper.log("Se inicia proceso de registro con contraseña no válida");
		if(!selenium.isElementPresent("link=Regístrate")) {
			if(selenium.isElementPresent("link=Salir")) {
				Helper.log("Se encuentra iniciada una sesión al cargar la página de C+B");
				selenium.click("link=Salir");
				selenium.waitForPageToLoad("15000");
			}
		}
		Helper.log("Se hace clic en 'Regístrate'");
		selenium.click("link=Regístrate");
		selenium.waitForPageToLoad("30000");
	
		Helper.log("Se ingresa una contraseña de 4 digitos");
		selenium.type("id=password", "1234");
		Helper.log("Se espera mensaje de alerta sobre longitud de la contraseña");
		if (!"Introduzca 6 o más caracteres. Se ignorarán los espacios antes o después.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("No se muestra aviso de cantidad de carácteres mínima");
		}
		Helper.log("Se ingresa una contraseña vacía");
		selenium.type("id=password", "");
		Helper.log("Se espera mensaje de alerta sobre Campo obligatorio");
		if (!"Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-password"))) {
			Assert.fail("Permite el campo contraseña vacío");
		}

		Helper.log("Se ingresa contraseña con longitud correcta pero que posee caracteres especiales");
		selenium.type("id=password", "%&\"Â·$");
		Helper.log("Se espera aceptación de la contraseña");
		if ("Introduzca 6 o más caracteres. Se ignorarán los espacios antes o después.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("Muestra mensaje de error, los datos estan correctos");
		}

		Helper.log("Se ingresa contraseña de 6 digitos (números)");
		selenium.type("id=password", "123456");
		Helper.log("Se espera aceptación de la contraseña");
		if ("Introduzca 6 o más caracteres. Se ignorarán los espacios antes o después.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("Muestra mensaje de error, los datos estan correctos");
		}
		
		Helper.log("Se ingresa contraseña de 6 digitos con letras mayúsculas y minúsculas");
		selenium.type("id=password", "aFRDFT");
		Helper.log("Se espera aceptación de la contraseña");
		if ("Introduzca 6 o más caracteres. Se ignorarán los espacios antes o después.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("Muestra mensaje de error, los datos estan correctos");
		}
		
		
		
	}

}
