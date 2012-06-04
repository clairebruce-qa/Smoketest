package claireandbruce.com.test.account;

import junit.framework.Assert;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * 	Verificar la validaci�n del campo contrase�a en longitud, este campo recibe cualquier tipo de car�cter num�rico, alfab�tico.
 * 	El �xito del caso de prueba se reflejara en el aviso de correcciones para el usuario de los datos ingresados.
 * @author YULIANA MAR�A SAAVEDRA RUSS�
 *
 */
public class TestUserRegister6UserRegistrationFieldPasswordValid extends ClaireandbruceTestCase{
	
	@Test
	public void CBT7(){
		
		selenium.open("");
		selenium.click("link=Reg�strate");
		selenium.waitForPageToLoad("30000");
	
		selenium.type("id=password", "1234");
		
	
		if (!"Introduzca 6 o m�s caracteres. Se ignorar�n los espacios antes o despu�s.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("No se muestra aviso de cantidad de car�cteres m�nima");
		}
		selenium.type("id=password", "");
		
		if (!"Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-password"))) {
			Assert.fail("Permite el campo contrase�a vac�o");
		}

		selenium.type("id=password", "%&\"·$");
		
		if ("Introduzca 6 o m�s caracteres. Se ignorar�n los espacios antes o despu�s.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("Muestra mensaje de error, los datos estan correctos");
		}

		selenium.type("id=password", "123456");
	
		if ("Introduzca 6 o m�s caracteres. Se ignorar�n los espacios antes o despu�s.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("Muestra mensaje de error, los datos estan correctos");
		}
		
		selenium.type("id=password", "aFRDFT");
		
		if ("Introduzca 6 o m�s caracteres. Se ignorar�n los espacios antes o despu�s.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("Muestra mensaje de error, los datos estan correctos");
		}
		
		
		
	}

}
