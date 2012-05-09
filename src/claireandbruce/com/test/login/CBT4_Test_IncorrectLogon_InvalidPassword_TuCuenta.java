package claireandbruce.com.test.login;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;
import org.junit.Assert;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

/**
 * Este Caso de Prueba verificará el correcto funcionamiento del proceso de login de un usuario 
 * en el portal, al validar la información ingresada por el usuario al momento de realizar esta 
 * acción y/o al presionar el botón “ENTRAR”. El éxito del caso de prueba será la validación del 
 * email ingresado y por consecuencia la posterior muestra del mensaje de advertencia sobre formato 
 * de email no válido
 * @author MARIA FERNANDA RODRIGUEZ VARGAS
 *
 */

public class CBT4_Test_IncorrectLogon_InvalidPassword_TuCuenta extends ClaireandbruceTestCase{
	
	@Test
	public void testIncorrectLogon_InvalidUserFormat() throws Exception {
			
		Claireandbruce.login(selenium, "claireandbruceqa@gmail.com", "zxcvbn");
			
		if(selenium.isTextPresent("Usuario o contraseña inválidos.")){
			Helper.log("Test-IncorrectLogon-InvalidPassword Complete");
		}else {
			Helper.log("Test-IncorrectLogon-InvalidPassword Failed");
		}
			
	}	
}