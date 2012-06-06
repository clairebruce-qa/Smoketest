package claireandbruce.com.test.login;

import lib.Claireandbruce;
import lib.Helper;
import org.junit.Assert;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

/**
 * Este Caso de Prueba verificar� el correcto funcionamiento del proceso de login de un usuario 
 * en el portal, al validar la informaci�n ingresada por el usuario al momento de realizar esta 
 * acci�n y/o al presionar el bot�n �ENTRAR�. El �xito del caso de prueba ser� la validaci�n del 
 * email ingresado y por consecuencia la posterior muestra del mensaje de advertencia sobre formato 
 * de email no v�lido
 * @author NEWSHORE
 *
 */
public class Test_IncorrectLogon_InvalidUserFormat_TuCuenta extends ClaireandbruceTestCase{
	
	@Test
	public void CBT56() throws Exception {
		
		Claireandbruce.login(selenium, "claireandbruce@gmailcom", "123456");
		
		if (selenium.isTextPresent("Ingrese una direcci�n de correo electr�nico v�lida. Por ejemplo: juanperez@dominio.com.")){
			Helper.log("Test-IncorrectLogon-InvalidUserFormat is Complete");
		}
	}
}