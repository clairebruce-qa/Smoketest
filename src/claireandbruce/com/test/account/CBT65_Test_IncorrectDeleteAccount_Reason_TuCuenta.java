package claireandbruce.com.test.account;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

/*
 *Este   Caso de Prueba verificará  el correcto 
 *funcionamiento  del proceso  encargado de dar
 *de  baja (eliminar) la  cuenta  de un usuario 
 *en   el portal,  al  validar  la selección de
 *razones causantes  del deseo  de  eliminación
 *de la cuenta por parte del  usuario. El éxito 
 *del proceso se evaluará al mostrar el mensaje
 * "Seleccione una de las opciones anteriores".
 */

public class CBT65_Test_IncorrectDeleteAccount_Reason_TuCuenta extends ClaireandbruceTestCase {

	
	@Test
	public void CBT65() throws Exception{
		
		//Despliega la pagina de Claireandbruce
		selenium.open("");

		selenium.waitForPageToLoad("15000");
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}
		selenium.waitForPageToLoad("30000");	
		//-----------------------------------Autenticar el Usuario----------------------------------
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			
			int i =(int)(Math.random()*100);
			String username = System.getProperty("my.username","usuarioQa"+i+"@gmail.com");
						System.out.println(username);
			
			selenium.click("//a[contains(text(),'Regístrate')]");
			selenium.waitForPageToLoad("60000");
			selenium.isElementPresent("css=label.required");
			
			if(selenium.isTextPresent("")){
			selenium.type("id=firstname", "Claire");
			selenium.type("id=lastname", "andBruceQA");
			selenium.type("id=email_address", username);
			selenium.click("name=gender");
			selenium.click("css=div.selreplace_selectbutton");
			selenium.click("//div[@value='14']");
			selenium.click("css=span.dob-month > div.selreplace_select > div > div.selreplace_selectbutton");
			selenium.click("xpath=(//div[@value='8'])[2]");
			selenium.click("css=span.dob-year > div.selreplace_select > div > div.selreplace_selectbutton");
			selenium.click("//div[@value='1988']");
			selenium.type("id=password", "123456");
			selenium.click("css=input.fieldset-float-left-align.validate-terms");
			selenium.click("id=registerSubmitButton");
			
			  
		  }
		
		if(!("Tu Cuenta").equals(selenium.getTitle())){
			  selenium.open("/es_es/customer/account/");
			  
		  }
		//-----------***** la interfaz de AREA PRIVADA esta cargada*****-----------------
		assertTrue(selenium.isElementPresent("class=menu-item"));
		assertTrue(selenium.isElementPresent("css=div.item.account-configuration"));
		assertTrue(selenium.isTextPresent("Contraseña y bajas"));
		selenium.click("//div[2]/li[3]/a/span");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getText("css=div.infounsubscribe-subtitle").equals("¿Quieres desactivar tu cuenta?"));
		
		//-------------- BOTON DAR DE BAJA PARA SIEMPRE TU CUENTA ----------------------
		assertTrue(selenium.isElementPresent("css=#unsubscribe1 > div.buttons-set.form-buttons > button.button"));
		selenium.click("css=#unsubscribe1 > div.buttons-set.form-buttons > button.button");
		
		assertTrue(selenium.isElementPresent("css=a.buttoncancelunsubscribe > span"));//verifica que el boton cancelar si esta habilitado
		selenium.click("css=#form-validate-unsubscribe > div.buttons-set.form-buttons > button.button");
		
		assertTrue(selenium.isTextPresent("Seleccione una de las opciones anteriores"));
		
	}}
}
