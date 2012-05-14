package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.*;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT38_Test_Home_Page_Navigability_5_Navigability_Video_CB_NetWorks extends ClaireandbruceTestCase {
	
	private String mensage;

	@Test
	public void CBT39() throws Exception{
		
	//Se despliega la ventana principal de C+B
	selenium.open("/es_es/");
	
	//Se verifican que los links esten habilitados
	
	//1. Video de C+B de bienvenida
	assertTrue(selenium.isElementPresent("css=.container>p"));
	
	assertTrue(selenium.isElementPresent("css=div.footer-youtube.float-rigth"));
	assertTrue(selenium.isElementPresent("css=div.footer-twitter.float-rigth"));
	assertTrue(selenium.isElementPresent("css=div.footer-facebook.float-rigth"));
	assertTrue(selenium.isElementPresent("link=Regístrate"));
	assertTrue(selenium.isElementPresent("link=Tu cuenta"));
	assertTrue(selenium.isElementPresent("css=div.footer-youtube.float-rigth"));
	selenium.click("css=div.footer-youtube.float-rigth");
	
	if(!selenium.isElementPresent("//div[@id='channel-header-main']/div/div/h1")){
		mensage="ERROR EN DESPLIEGUE DE INTERFAZ EN YOUTUBE";
	}
	selenium.selectWindow("null");
	
	selenium.click("css=div.footer-twitter.float-rigth");
	
	if(!selenium.isElementPresent("css=div.footer-twitter.float-rigth"))
	{
		mensage="ERROR EN DESPLIEGUE DE INTERFAZ EN TWITTER";
	}
	
	selenium.selectWindow("null");
	selenium.click("css=div.footer-facebook.float-rigth");
	if(!selenium.isElementPresent("//a[@href='http://www.facebook.com/claireandbruce']")){
		mensage="ERROR EN DESPLIEGUE DE INTERFAZ EN FACEBOOK";
	}
	Helper.log(mensage);
	
	
	}
}
