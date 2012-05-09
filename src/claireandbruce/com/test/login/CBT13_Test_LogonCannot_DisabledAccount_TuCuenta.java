package claireandbruce.com.test.login;

import static org.junit.Assert.*;
import junit.framework.Assert;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.account.CBT11_Test_CorrectDeleteAccount_TuCuenta;

import basics.ClaireandbruceTestCase;


/*
 * Este  Caso de  Prueba   verificará el  correcto  funcionamiento del  proceso de login
 *  a la cuenta de un  usuario  (que  previamente  ha  sido  desactivada) en el  portal.
 *  El éxito del proceso se evaluará al mostrar el mensaje "Esta cuenta no esta activa".
 * 
 * 
 * */
public class CBT13_Test_LogonCannot_DisabledAccount_TuCuenta  extends ClaireandbruceTestCase{

	/*
	 * Este  Caso  de Prueba  verificará el correcto funcionamiento del proceso 
	 * de login a la cuenta de un usuario (que previamente ha sido desactivada)
	 * en el portal. El éxito del  proceso  se  evaluará  al mostrar el mensaje
	 *  "Esta cuenta no esta activa".
	 *  
	 */
	
	/*-------- Se Instancia el caso de prueba 11--------
	 * Este caso crea un usuario y luego lo da de baja
	 * este usuario sera el   utilizado en la   prueba
	 */
	
	CBT11_Test_CorrectDeleteAccount_TuCuenta tb11= new CBT11_Test_CorrectDeleteAccount_TuCuenta();
	private static String username2;
	
	
	@Test
	public void CBT13() throws Exception{
	
		
		//-------Despligue Interfaz Principal-------
		selenium.open("");
		Helper.log("Test in : "+selenium.getLocation());
		//-------Autenticar Usuario--------
		
		 tb11.CBT11();
		 
		 username2=tb11.username2;
		 System.out.println("Este es el usuario de prueba "+tb11.username2);
		 
		 if(selenium.isTextPresent("Salir")){
			 Claireandbruce.logout(selenium);
		 }
		
		 Claireandbruce.login(selenium, username2, password);
		// String error = "Login Error https://pre-cb.newshore.es/es_es/customer/account/login/";
			/*if(!error.equals(Claireandbruce.login(selenium, username2, password)))
			{
				
				Helper.log("Error Test Failed!!!!!!" );
				Assert.fail("Login Error " + selenium.getLocation());
			}*/
		 if(!selenium.isTextPresent("Esta cuenta no esta activa")){
			 Assert.fail("Error Test Failed!!!!!  :" +selenium.getLocation());
		 }
		  
		
		
		
		
		
	}
}
