package testcases;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

import com.thoughtworks.selenium.Selenium;

public class MailingAddress extends ClaireandbruceTestCase{
	
	@Test
	public static void testMailingAddress(Selenium selenium) throws Exception {
		//Primera direccion
		selenium.type("document.forms[1].elements[5]", "cl 1");
		//Segunda direccion
		selenium.type("document.forms[1].elements[6]", "cl 23");
		//Poblacion
		selenium.type("document.forms[1].elements[7]", "Barcelona");
		//Provincia
		selenium.click("css=div.input-box.region > div.selreplace_select");
		selenium.click("//div[@value='139']");
		//Codigo postal
		selenium.type("document.forms[1].elements[10]", "1234");
		//Telefono
		selenium.type("document.forms[1].elements[12]", "56789");
		
	}
	
}
