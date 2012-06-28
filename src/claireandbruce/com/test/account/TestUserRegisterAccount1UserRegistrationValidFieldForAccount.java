package claireandbruce.com.test.account;

import static org.junit.Assert.assertTrue;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

/**
 * El objetivo será mostrar y verificar el correcto   funcionamiento de la  aplicación,
 * para registrar un nuevo usuario, se ingresara los campos solicitados por el sistema, 
 * el éxito del caso de prueba será la verificación del usuario en el sistema  con  la,
 * confirmacion de registro en el correo electrónico,  y  el  redireccionamiento  a la
 * página de Tu Cuenta de ClaireandBruce, el ingreso para el registro sera mediante el 
 * enlace de tu cuenta.
 * 
 * CBT29
 * @author NEWSHORE
 *
 */

public class TestUserRegisterAccount1UserRegistrationValidFieldForAccount extends ClaireandbruceTestCase {
	
	public static String username2;

	@Test
	public void CBT29() throws Exception{
		
		Helper.log("Se inicia proceso de registro por Tu Cuenta, con datos válidos");
		// Elimina las cookies
		Helper.log("Se eliminan cookies del navegador");
		selenium.deleteAllVisibleCookies();
		Helper.log("Se carga la página "+ClaireandbruceUrl);
		selenium.open("");
		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		 
		  }	
		
		  if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
				
				int i =(int)(Math.random()*100);
				username2 = System.getProperty("my.username","stress_test_qa"+i+"@gmail.com");
				//String username= "usuarioQa"+i+"@gmail.com";
				System.out.println(username2);
				Helper.log("Se ingresa a la interfaz 'Tu cuenta'");
				selenium.click("//a[contains(text(),'Tu cuenta')]");
				Helper.log("Se espera carga de la interfaz");
				selenium.waitForPageToLoad("30000");
				
				Helper.log("Se ingresa el correo electrónico para el registro de usuario");
				selenium.type("id=emailreg", username2);
				Helper.log("Se hace clic en el botón 'Registrarme'");
				selenium.click("id=send3");
				Helper.log("Se espera carga de la interfaz");
				selenium.waitForPageToLoad("30000");
				selenium.isElementPresent("css=label.required");
				
				if(selenium.isTextPresent("")){
					Helper.log("Se ingresan datos de usuario");
				selenium.type("id=firstname", "Claire");
				selenium.type("id=lastname", "andBruceQA");
				selenium.type("id=email_address", username2);
				selenium.click("name=gender");
				Helper.log("Se selecciona fecha de nacimiento");
				selenium.click("css=div.selreplace_selectbutton");
				selenium.click("//div[@value='14']");
				selenium.click("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("xpath=(//div[@value='3'])[2]");
				selenium.click("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("//div[@value='1988']");
				selenium.type("id=password", "123456");
				Helper.log("Se aceptan términos y condiciones, y políticas de privacidad");
				selenium.click("css=input.fieldset-float-left-align.validate-terms");
				Helper.log("Se hace clic en el botón 'SIGUE CON TU COMPRA'");
				selenium.click("id=registerSubmitButton");
				Helper.log("Se espera carga de la interfaz");
				selenium.waitForPageToLoad("30000");
				  
			  }
			
			if(!("Mi cuenta").equals(selenium.getTitle())){
				  selenium.open("/es_es/customer/account/");
				  
			  }
			//-----------***** la interfaz de AREA PRIVADA esta cargada*****-----------------
			Helper.log("Se inicia proceso para dar de baja la cuenta");
			assertTrue(selenium.isElementPresent("class=menu-item"));
			assertTrue(selenium.isElementPresent("css=div.item.account-configuration"));
			assertTrue(selenium.isTextPresent("Contraseña y bajas"));
			Helper.log("Se hace clic en el link 'Contraseña y bajas'");
			selenium.click("//div[2]/li[3]/a/span");
			Helper.log("Se espera carga de la interfaz");
			selenium.waitForPageToLoad("30000");
			assertTrue(selenium.getText("css=div.infounsubscribe-subtitle").equals("¿Quieres desactivar tu cuenta?"));
			assertTrue(selenium.isElementPresent("css=#unsubscribe1 > div.buttons-set.form-buttons > button.button"));
			Helper.log("Se hace clic en el botón para desactivar la cuenta");
			selenium.click("css=#unsubscribe1 > div.buttons-set.form-buttons > button.button");
			int j= (int)(Math.random()*(6))+1;
			Helper.log("Se hace clic en un motivo para dar de baja la cuenta");
			selenium.click("xpath=.//*[@id='form-validate-unsubscribe']/div[2]/ul/li["+j+"]/div/label");
			Helper.log("Se verifica el botón para cancelar la cuenta");
			assertTrue(selenium.isElementPresent("css=a.buttoncancelunsubscribe > span"));//verifica que el boton cancelar si esta habilitado
			Helper.log("Se hace clic en el botón para dar de baja la cuenta");
			selenium.click("css=#form-validate-unsubscribe > div.buttons-set.form-buttons > button.button");
			Helper.log("Se espera carga de la interfaz");
			selenium.waitForPageToLoad("30000");
			assertTrue(selenium.isTextPresent("Su cuenta ha sido desactivada con éxito."));
			Helper.log("La cuenta ha sido desactivada con éxito");
			
		}}
			
	
	


}
