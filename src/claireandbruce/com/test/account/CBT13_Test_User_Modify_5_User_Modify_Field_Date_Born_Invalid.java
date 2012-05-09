package claireandbruce.com.test.account;

import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT13_Test_User_Modify_5_User_Modify_Field_Date_Born_Invalid extends ClaireandbruceTestCase {

	@Test
	public void test_User_Modify_5_User_Modify_Field_Date_Born_Invalid () throws Exception{
		Claireandbruce.login(selenium, username,password);
		
		//Click en el link "Tu cuenta" Pagina Tu cuenta
		Helper.clickAndVerify(selenium, "class=item account-configuration", "", "//form[@id='form-validate']/div/div/div/cufon[3]/canvas");
		
		//Precondiciones
		selenium.type("xpath=.//*[@id='firstname']", "Claire");
		selenium.type("xpath=.//*[@id='lastname']", "andBruce");
		selenium.type("xpath=.//*[@id='email']", "claireandbruceqa@gmail.com");
		if(selenium.isElementPresent("xpath=//input[@name='gender']")){
			selenium.click("xpath=//input[@name='gender']");
		}
				
		//PASO 1. Testlink
		//Se verifica que la fecha de naciemiento se encuentre como 01/01/2012
		if(!(selenium.getText("xpath=//form[@id='form-validate']/div/div/ul/li[3]/div/div/div/span/div/div/div").equals("01") && 
			selenium.getText("xpath=//form[@id='form-validate']/div/div/ul/li[3]/div/div/div/span[2]/div/div/div").equals("01") &&
			selenium.getText("xpath=//form[@id='form-validate']/div/div/ul/li[3]/div/div/div/span[3]/div").equals("2012") )){
			//Eleccion del dia = 01
			selenium.click("xpath=//span/div/div/div[2]");
			selenium.click("xpath=//div[@value='1']");
			//Eleccion del mes = 01
			selenium.click("xpath=//span[2]/div/div/div[2]");
			selenium.click("xpath=(//div[@value='1'])[2]");
			//Eleccion del año 2012
			selenium.click("xpath=//span[3]/div/div/div[2]");
			selenium.click("xpath=//div[@value='2012']");			
		}

		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		
		if(selenium.isElementPresent("css=ul > li > span")){
			Helper.log("\nSE PERMITE GUARDAR INFORMACION CON FECHA DE NACIMIENTO IGUAL A 01/01/2012 \nESTO GENERA QUE NO SE VALIDE" +
					"EDAD DEL USUARIO QUE REALIZARA LAS COMPRAS");
		}else {
			Helper.log("\nNO SE PERMITIO GUARDAR INFORMACION DE USUARIO CON FECHA DE NACIMIENTO IGUAL A 01/01/2012");
		}
		
		//PASO 2. Testlink
		//Eleccion del dia = 01
		selenium.click("xpath=//span/div/div/div[2]");
		selenium.click("xpath=//div[@value='1']");
		//Eleccion del mes = 01
		selenium.click("xpath=//span[2]/div/div/div[2]");
		selenium.click("xpath=(//div[@value='1'])[2]");
		//Eleccion del año 2009
		selenium.click("xpath=//span[3]/div/div/div[2]");
		selenium.click("xpath=//div[@value='2009']");		
		
		//Se da click en el boton GUARDA TUS DATOS
		selenium.click("css=button.button");
		
		if(selenium.isElementPresent("css=ul > li > span")){
			Helper.log("\nSE PERMITE GUARDAR INFORMACION CON FECHA DE NACIMIENTO IGUAL A 01/01/2009 \nESTO GENERA QUE NO SE VALIDE" +
					"EDAD DEL USUARIO QUE REALIZARA LAS COMPRAS");
		}else {
			Helper.log("\nNO SE PERMITIO GUARDAR INFORMACION DE USUARIO CON FECHA DE NACIMIENTO IGUAL A 01/01/2012");
		}
	}
}
