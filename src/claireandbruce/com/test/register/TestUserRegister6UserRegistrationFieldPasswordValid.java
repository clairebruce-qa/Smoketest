package claireandbruce.com.test.register;

import junit.framework.Assert;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * 	Verificar la validaci�n del campo contrase�a en longitud, este campo recibe cualquier tipo de car�cter num�rico, alfab�tico.
 * 	El �xito del caso de prueba se reflejara en el aviso de correcciones para el usuario de los datos ingresados.
 *  CBT7
 * @author NEWSHORE
 * 
 */
public class TestUserRegister6UserRegistrationFieldPasswordValid extends ClaireandbruceTestCase{
	
	@Test
	public void CBT7(){
		
		Helper.log("Se carga la p�gina "+ClaireandbruceUrl);
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		Helper.log("Se inicia proceso de registro con contrase�a no v�lida");
		if(!selenium.isElementPresent("link=Reg�strate")) {
			if(selenium.isElementPresent("link=Salir")) {
				Helper.log("Se encuentra iniciada una sesi�n al cargar la p�gina de C+B");
				selenium.click("link=Salir");
				selenium.waitForPageToLoad("15000");
			}
		}
		Helper.log("Se hace clic en 'Reg�strate'");
		selenium.click("link=Reg�strate");
		selenium.waitForPageToLoad("30000");
	
		Helper.log("Se ingresa una contrase�a de 4 digitos");
		selenium.type("id=password", "1234");
		Helper.log("Se espera mensaje de alerta sobre longitud de la contrase�a");
		if (!"Introduzca 6 o m�s caracteres. Se ignorar�n los espacios antes o despu�s.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("No se muestra aviso de cantidad de car�cteres m�nima");
		}
		Helper.log("Se ingresa una contrase�a vac�a");
		selenium.type("id=password", "");
		Helper.log("Se espera mensaje de alerta sobre Campo obligatorio");
		if (!"Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-password"))) {
			Assert.fail("Permite el campo contrase�a vac�o");
		}

		Helper.log("Se ingresa contrase�a con longitud correcta pero que posee caracteres especiales");
		selenium.type("id=password", "%&\"·$");
		Helper.log("Se espera aceptaci�n de la contrase�a");
		if ("Introduzca 6 o m�s caracteres. Se ignorar�n los espacios antes o despu�s.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("Muestra mensaje de error, los datos estan correctos");
		}

		Helper.log("Se ingresa contrase�a de 6 digitos (n�meros)");
		selenium.type("id=password", "123456");
		Helper.log("Se espera aceptaci�n de la contrase�a");
		if ("Introduzca 6 o m�s caracteres. Se ignorar�n los espacios antes o despu�s.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("Muestra mensaje de error, los datos estan correctos");
		}
		
		Helper.log("Se ingresa contrase�a de 6 digitos con letras may�sculas y min�sculas");
		selenium.type("id=password", "aFRDFT");
		Helper.log("Se espera aceptaci�n de la contrase�a");
		if ("Introduzca 6 o m�s caracteres. Se ignorar�n los espacios antes o despu�s.".equals(selenium.getText("id=advice-validate-password-password"))) {
			Assert.fail("Muestra mensaje de error, los datos estan correctos");
		}
		
		
		
	}

}
