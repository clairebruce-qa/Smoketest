package basics;
import org.junit.Assert;
import org.junit.Test;

import lib.Helper;
import lib.Claireandbruce;

public class TestTeraBoxPortalAccess extends ClaireandbruceTestCase {
	
	@Test	
	public void testTB491() throws Exception {
		tc= "491";	
		//TB-491:Try Access without entring data
		selenium.deleteAllVisibleCookies();
		
		selenium.open("portal/Login.aspx");
		
		Helper.log("Open page portal/Login.aspx");
	
		//check Autenticación con cuenta telefonica.net is on the page
		Helper.waitForElement(selenium, "//*[@id='ctl00_ContentPlaceHolder1_LabelLoginTitle']", "Inicio de sesión  not found in "+ selenium.getLocation());
	
		Helper.log("Login the user and password empty");
	
		selenium.type("ctl00_ContentPlaceHolder1_TextBoxUserName", "");
		selenium.type("ctl00_ContentPlaceHolder1_TextBoxPassword", "");
		selenium.click("ctl00_ContentPlaceHolder1_LabelLogin");
		
		Helper.waitForElement(selenium, "//*[@id='ctl00_ContentPlaceHolder1_RequiredFieldValidatorTextBoxUserName']", "*");
		Helper.waitForElement(selenium, "//*[@id='ctl00_ContentPlaceHolder1_RequiredFieldValidatorTextBoxPassword']", "*");			
	}

	@Test
	public void testTB492() throws Exception{
		tc= "492";
		
		//TB-492:Try Access Without Password
		selenium.deleteAllVisibleCookies();
		
		selenium.open("portal/Login.aspx");
		
		Helper.log("Open page portal/Login.aspx");
	
		//check Autenticación con cuenta telefonica.net is on the page
		Helper.waitForElement(selenium, "//*[@id='ctl00_ContentPlaceHolder1_LabelLoginTitle']", "Inicio de sesión  not found in "+ selenium.getLocation());
	
		Helper.log("Login the user and password empty");
	
		//login con usuario correcto y sin password
		selenium.type("ctl00_ContentPlaceHolder1_TextBoxUserName", username);
		selenium.type("ctl00_ContentPlaceHolder1_TextBoxPassword", "");
		selenium.click("ctl00_ContentPlaceHolder1_LabelLogin");
		Assert.assertEquals("Por favor ingrese Contraseña",selenium.getText("//*[@id='ctl00_ContentPlaceHolder1_ValidationSummary1']"));
		
		//login con usuario pizza y sin password
		selenium.type("ctl00_ContentPlaceHolder1_TextBoxUserName", "pizza");
		selenium.type("ctl00_ContentPlaceHolder1_TextBoxPassword", "");
		selenium.click("ctl00_ContentPlaceHolder1_LabelLogin");			
		Assert.assertEquals("Por favor ingrese Contraseña",selenium.getText("//*[@id='ctl00_ContentPlaceHolder1_ValidationSummary1']"));
	}

	@Test
	public void testTB493() throws Exception{
		tc= "493";
		//TB-493:Try Access-wrong password
		Assert.assertEquals("Su inicio de sesión no se completó correctamente. Inténtelo nuevamente.",Claireandbruce.login(selenium, username, "1"));
	
		Assert.assertEquals("Su inicio de sesión no se completó correctamente. Inténtelo nuevamente.",Claireandbruce.login(selenium, username, "¿"));
	
		Assert.assertEquals("Su inicio de sesión no se completó correctamente. Inténtelo nuevamente.",Claireandbruce.login(selenium, username, "_"));
	
		Assert.assertEquals("Su inicio de sesión no se completó correctamente. Inténtelo nuevamente.",Claireandbruce.login(selenium, username, "*"));
	
		Assert.assertEquals("Su inicio de sesión no se completó correctamente. Inténtelo nuevamente.",Claireandbruce.login(selenium, username, "!"));	
	}

	@Test
	public void testTB494() throws Exception{
		tc= "494";
		//TB-494:Try Access With an User Special Character
		Assert.assertEquals("Su inicio de sesión no se completó correctamente. Inténtelo nuevamente.",Claireandbruce.login(selenium, "*", "$"));
	
		//TB-494:Try Access With an User Special Character
		Assert.assertEquals("Su inicio de sesión no se completó correctamente. Inténtelo nuevamente.",Claireandbruce.login(selenium, "*", "*"));
	}

	@Test
	public void testTB496() throws Exception{
		tc= "496";
		//TB-496:Try access-Password Special Character
		
		selenium.deleteAllVisibleCookies();
		
		selenium.open("portal/Login.aspx");
		
		Helper.log("Open page portal/Login.aspx");
	
		//check Autenticación con cuenta telefonica.net is on the page
		Helper.waitForElement(selenium, "//*[@id='ctl00_ContentPlaceHolder1_LabelLoginTitle']", "Inicio de sesión  not found in "+ selenium.getLocation());
	
		Helper.log("Login the user and password empty");
	
		selenium.type("ctl00_ContentPlaceHolder1_TextBoxUserName", "");
		selenium.type("ctl00_ContentPlaceHolder1_TextBoxPassword", "%$·%/%$·/$&(");
		selenium.click("ctl00_ContentPlaceHolder1_LabelLogin");
		Assert.assertEquals("Por favor ingrese el Usuario",selenium.getText("//*[@id='ctl00_ContentPlaceHolder1_ValidationSummary1']"));
	}

	@Test
	public void testTB1163() throws Exception{
		tc= "1163";
		
		//TB-1163:Acess Terabox - valid user
		Assert.assertEquals("loginOk",Claireandbruce.login(selenium, username, password));
	}
}
