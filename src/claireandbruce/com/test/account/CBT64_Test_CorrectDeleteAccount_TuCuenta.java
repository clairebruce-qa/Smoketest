package claireandbruce.com.test.account;

import static org.junit.Assert.*;

import java.util.ArrayList;

import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT64_Test_CorrectDeleteAccount_TuCuenta extends ClaireandbruceTestCase{
	
	
	public static String username2;

	/*
	 *Este Caso de Prueba  verificar�  el correcto  funcionamiento  del proceso
	 *encargado de dar de baja (eliminar) la cuenta de un usuario en el portal, 
	 *al validar la selecci�n de razones causantes  del deseo de eliminaci�n de
	 *la cuenta por parte del usuario. 
	 *El  �xito  del proceso se evaluar� al mostrar el mensaje "Su cuenta    ha
	 *sido  desactivada con �xito.".  As�   como informar a trav�s del  mensaje
	 *"Esta cuenta no esta activa" cuando  se intente  acceder   nuevamente  al 
	 *sistema con la  informaci�n  de un usuario  que ha  desactivado su cuenta 
	 *previamente. 
	 * 
	 * */
	@Test
	public void CBT64() throws Exception{
		
		//Despliega la pagina de Claireandbruce
		selenium.open("");

		selenium.waitForPageToLoad("15000");
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}
		selenium.waitForPageToLoad("20000");		
		//-----------------------------------Autenticar el Usuario----------------------------------
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			
			int i =(int)(Math.random()*100);
			username2 = System.getProperty("my.username","usuarioQa"+i+"@gmail.com");
			//String username= "usuarioQa"+i+"@gmail.com";
			System.out.println(username2);
			
			selenium.click("//a[contains(text(),'Reg�strate')]");
			selenium.waitForPageToLoad("30000");
			selenium.isElementPresent("css=label.required");
			
			if(selenium.isTextPresent("")){
			selenium.type("id=firstname", "Claire");
			selenium.type("id=lastname", "andBruceQA");
			selenium.type("id=email_address", username2);
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
			selenium.waitForPageToLoad("30000");
			  
		  }
		
		if(!("Tu Cuenta").equals(selenium.getTitle())){
			  selenium.open("/es_es/customer/account/");
			  
		  }
		//-----------***** la interfaz de AREA PRIVADA esta cargada*****-----------------
		assertTrue(selenium.isElementPresent("class=menu-item"));
		assertTrue(selenium.isElementPresent("css=div.item.account-configuration"));
		assertTrue(selenium.isTextPresent("Contrase�a y bajas"));
		selenium.click("//div[2]/li[3]/a/span");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getText("css=div.infounsubscribe-subtitle").equals("�Quieres desactivar tu cuenta?"));
		assertTrue(selenium.isElementPresent("css=#unsubscribe1 > div.buttons-set.form-buttons > button.button"));
		selenium.click("css=#unsubscribe1 > div.buttons-set.form-buttons > button.button");
		int j= (int)(Math.random()*(6))+1;
		selenium.click("xpath=.//*[@id='form-validate-unsubscribe']/div[2]/ul/li["+j+"]/div/label");
		assertTrue(selenium.isElementPresent("css=a.buttoncancelunsubscribe > span"));//verifica que el boton cancelar si esta habilitado
		selenium.click("css=#form-validate-unsubscribe > div.buttons-set.form-buttons > button.button");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Su cuenta ha sido desactivada con �xito."));
	
		
	}}

}
