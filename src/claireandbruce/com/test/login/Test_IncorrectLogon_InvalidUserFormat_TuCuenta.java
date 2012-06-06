package claireandbruce.com.test.login;

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
 * @author NEWSHORE
 *
 */
public class Test_IncorrectLogon_InvalidUserFormat_TuCuenta extends ClaireandbruceTestCase{
	
	@Test
	public void CBT56() throws Exception {
		
		Claireandbruce.login(selenium, "claireandbruce@gmailcom", "123456");
		
		if (selenium.isTextPresent("Ingrese una dirección de correo electrónico válida. Por ejemplo: juanperez@dominio.com.")){
			Helper.log("Test-IncorrectLogon-InvalidUserFormat is Complete");
		}
	}
}