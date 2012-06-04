package claireandbruce.com.test.account;

import junit.framework.Assert;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * 	Verificar la validación del campo contraseña en longitud, este campo recibe cualquier tipo de carácter numérico, alfabético.
 * 	El éxito del caso de prueba se reflejara en el aviso de correcciones para el usuario de los datos ingresados.
 * @author YULIANA MARÍA SAAVEDRA RUSSÍ
 *
 */
public class TestUserRegister6UserRegistrationFieldPasswordValid extends ClaireandbruceTestCase{
	
	@Test
	public void CBT7(){
		
		selenium.open("");
		selenium.click("link=Regístrate");
		selenium.waitForPageToLoad("30000");
	
		selenium.type("id=password", "1234");
		
	
		if (!"Introduzca 6 o más caracteres. Se ignorarán los espacios antes o después.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("No se muestra aviso de cantidad de carácteres mínima");
		}
		selenium.type("id=password", "");
		
		if (!"Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-password"))) {
			Assert.fail("Permite el campo contraseña vacío");
		}

		selenium.type("id=password", "%&\"Â·$");
		
		if ("Introduzca 6 o más caracteres. Se ignorarán los espacios antes o después.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("Muestra mensaje de error, los datos estan correctos");
		}

		selenium.type("id=password", "123456");
	
		if ("Introduzca 6 o más caracteres. Se ignorarán los espacios antes o después.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("Muestra mensaje de error, los datos estan correctos");
		}
		
		selenium.type("id=password", "aFRDFT");
		
		if ("Introduzca 6 o más caracteres. Se ignorarán los espacios antes o después.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("Muestra mensaje de error, los datos estan correctos");
		}
		
		
		
	}

}
