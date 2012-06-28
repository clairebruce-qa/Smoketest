package claireandbruce.com.test.register;

import static org.junit.Assert.assertTrue;
import lib.Helper;

import org.junit.Test;
import basics.ClaireandbruceTestCase;
/**
 * CBT2
 * @author NEWSHORE
 *
 */
public class TestUserRegister1UserRegistrationValidField extends ClaireandbruceTestCase {
	
	public static String username2;

	@Test
	public void CBT2() throws Exception{
		
		Helper.log("Se eliminan cookies");
		selenium.deleteAllVisibleCookies();  
		Helper.log("Se carga la página "+ClaireandbruceUrl);
		selenium.open("");
		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		 
		  }	
		Helper.log("Se inicia proceso de registro de un usuario con datos válidos");
		  if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
				
				int i =(int)(Math.random()*1000);
				
				username2 = System.getProperty("my.username","stress_test_qa"+i+"@claireandbruce.com");
				//String username= "usuarioQa"+i+"@gmail.com";
				Helper.log("Se crea un usuario aleatorio: "+username2);
				Helper.log("Se ingresa en la interfaz para el registro del usuario");
				selenium.click("//a[contains(text(),'Regístrate')]");
				Helper.log("Se espera carga de la interfaz");
				selenium.waitForPageToLoad("30000");
				selenium.isElementPresent("css=label.required");
				
				if(selenium.isTextPresent("")){
				Helper.log("Se ingresan datos de usuario");
				selenium.type("id=firstname", "Claire");
				selenium.type("id=lastname", "andBruceQA");
				selenium.type("id=email_address", username2);
				selenium.click("name=gender");
				selenium.click("css=div.selreplace_selectbutton");
				selenium.click("//div[@value='14']");
				selenium.click("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("xpath=(//div[@value='2'])[2]");
				selenium.click("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectbutton");
				selenium.click("//div[@value='1988']");
				selenium.type("id=password", "123456");
				Helper.log("Se aceptan términos y condiciones y políticas de privacidad");
				selenium.click("css=input.fieldset-float-left-align.validate-terms");
				Helper.log("Se da clic en el botón para finalizar el proceso de registro");
				selenium.click("id=registerSubmitButton");
				Helper.log("Se espera carga de interfaz 'Mi cuenta'");
				selenium.waitForPageToLoad("30000");
				  
			  }
			
			if(!("Mi cuenta").equals(selenium.getTitle())){
				Helper.log("No se ha cargado la interfaz 'Mi cuenta'");
				  selenium.open("/es_es/customer/account/");
				  
			  }
			//-----------***** la interfaz de AREA PRIVADA esta cargada*****-----------------
			Helper.log("Se elimina la cuenta recientemente creada");
			assertTrue(selenium.isElementPresent("class=menu-item"));
			assertTrue(selenium.isElementPresent("css=div.item.account-configuration"));
			Helper.log("Se verifica que se encuentre el link 'Contraseña y bajas'");
			assertTrue(selenium.isTextPresent("Contraseña y bajas"));
			Helper.log("Se ingresa a la sección 'Contraseña y bajas'");
			selenium.click("//div[2]/li[3]/a/span");
			Helper.log("Se espera la carga de la interfaz");
			selenium.waitForPageToLoad("30000");
			assertTrue(selenium.getText("css=div.infounsubscribe-subtitle").equals("¿Quieres desactivar tu cuenta?"));
			assertTrue(selenium.isElementPresent("css=#unsubscribe1 > div.buttons-set.form-buttons > button.button"));
			Helper.log("Se hace clic en el link para dar de baja la cuenta");
			selenium.click("css=#unsubscribe1 > div.buttons-set.form-buttons > button.button");
			int j= (int)(Math.random()*(6))+1;
			Helper.log("Se selecciona aleatoriamente un motivo para dar de baja la cuenta");
			selenium.click("xpath=.//*[@id='form-validate-unsubscribe']/div[2]/ul/li["+j+"]/div/label");
			Helper.log("Se verifica que el botón cancelar esté activo");
			assertTrue(selenium.isElementPresent("css=a.buttoncancelunsubscribe > span"));//verifica que el boton cancelar si esta habilitado
			Helper.log("Se hace clic en el botón para dar de baja la cuenta");
			selenium.click("css=#form-validate-unsubscribe > div.buttons-set.form-buttons > button.button");
			selenium.waitForPageToLoad("30000");
			assertTrue(selenium.isTextPresent("Su cuenta ha sido desactivada con éxito."));
			Helper.log("Su cuenta ha sido desactivada con éxito");
		
			
		}}
			
	
	


}
