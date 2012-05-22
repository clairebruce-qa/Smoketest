package claireandbruce.com.test.login;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import junit.framework.Assert;
import lib.*;
import basics.ClaireandbruceTestCase;

/**
 * Este Caso de Prueba verificará el correcto funcionamiento del proceso de login de un usuario 
 * en el portal, al validar la información ingresada por el usuario al momento de realizar esta 
 * acción y/o al presionar el botón “ENTRAR”. El éxito del caso de prueba será la verificación del 
 * usuario en el sistema y la redirección de este al "AREA PRIVADA" de "Tu cuenta"
 * @author MARIA FERNANDA RODRIGUEZ VARGAS
 *
 */
public class CBT55_Test_CorrectLogon_ValidUser_TuCuenta extends ClaireandbruceTestCase {

	@Test
	public void CBT55() throws Exception {
		String mensaje = null;
		Claireandbruce.login(selenium, username,password);
		
		//Se comprueba en caso tal de que el usuario no se encuentre creado.
		if(selenium.isTextPresent("Usuario o contraseña inválido")) {
			assertEquals(username, selenium.getValue("id=emailreg"));
		}
		
		Helper.log("Login the user "+ username + " with password " + password);

		if (selenium.isElementPresent("class=user") && selenium.isElementPresent("class=welcome-user-register")){
			mensaje = "loginOk";
		}else if (selenium.isElementPresent("//div[@id='error-message-login']")){
			mensaje = selenium.getText("ferrorLogin");
		}
		
		if(mensaje == null){
			Helper.log("Login Error " + selenium.getLocation());
			Assert.fail("Login Error " + selenium.getLocation());
		}
		Helper.log("Login message is "+mensaje);
	
	}
	
	//	SE PONE EN COMENTARIO PARA CORRER EN EL FLUJO
	// 	PARA PRUEBAS UNITARIAS SE ACTIVA
	/*
	@After
	public void afterTest(){
		selenium.stop();
	}*/
}
