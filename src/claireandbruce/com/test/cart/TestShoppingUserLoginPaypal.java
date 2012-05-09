package testcases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import junit.framework.Assert;
import lib.Claireandbruce;
import lib.Helper;
import basics.ClaireandbruceTestCase;

public class TestShoppingUserLoginPaypal extends ClaireandbruceTestCase{
	
	@Test
	public void TestShoppingPaypalUserLogin() throws Exception{
	
		selenium.deleteAllVisibleCookies();  
		  selenium.open("");

		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		  }	
		
		
		
	Claireandbruce.login(selenium, username, password);
	
	String message=null;	
	
	//selenium.open("/es_es");
/*	selenium.click("css=span > cufon.cufon.cufon-canvas > canvas");
	selenium.waitForPageToLoad("30000");
	selenium.click("css=div.div-filter > div");
	selenium.waitForPageToLoad("30000");
	assertTrue(selenium.isElementPresent("css=div.div-filter > div > strong"));
	selenium.click("id=tlImageProduct_5273");
	selenium.waitForPageToLoad("30000");
	assertTrue(selenium.isElementPresent("css=div.selreplace_selectinner"));
	selenium.click("css=div.selreplace_select");
	selenium.click("//div[@value='952']");
	selenium.click("css=div.add-to-box > div.add-to-cart > button.button");

	assertTrue(selenium.isTextPresent("1 artículo 53,10 €"));
		
	
	selenium.click("id=cartHeader");
	selenium.click("css=button.checkout-link");
	selenium.waitForPageToLoad("30000");
	selenium.click("css=strong > cufon.cufon.cufon-canvas > canvas");
	assertTrue(selenium.isTextPresent("53,10 €"));
	selenium.click("xpath=(//button[@type='button'])[3]");
	
	selenium.click("id=shipping-address-select-5");
	
	selenium.click("id=p_method_paypal_standard");
	
	selenium.click("id=p_method_paypal_standard");
	assertEquals("on", selenium.getValue("id=shipping-address-select-5"));
	assertEquals("on", selenium.getValue("id=p_method_paypal_standard"));
	selenium.click("css=button.button.btn-checkout");
	selenium.waitForPageToLoad("50000");
	assertTrue(selenium.isElementPresent("link=Sandbox de PayPal de PayPal"));
	selenium.click("link=Sandbox de PayPal de PayPal");
	selenium.waitForPageToLoad("30000");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout");
		try { if ("Member Log In".equals(selenium.getText("css=h3.first"))) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}*/
	
	//selenium.open("/es_es");
	//selenium.click("css=span > cufon.cufon.cufon-canvas > canvas");
	//selenium.waitForPageToLoad("30000");
	
	//assertTrue(selenium.isTextPresent("No tienes productos en tu carrito de compra"));
	//assertTrue(selenium.isTextPresent("53,10 €"));
	selenium.click("css=span > cufon.cufon.cufon-canvas > canvas");
	selenium.waitForPageToLoad("50000");
	assertTrue(selenium.isTextPresent("> Ropa"));
	selenium.click("css=div.div-filter > div");
	selenium.waitForPageToLoad("30000");
	assertTrue(selenium.isElementPresent("css=div.div-filter > div > strong"));
	selenium.click("id=tlImageProduct_5273");
	selenium.waitForPageToLoad("30000");
	assertTrue(selenium.isTextPresent("> T-SHIRT Tank NAVY"));
	selenium.click("css=div.selreplace_selectinner");
	selenium.click("//div[@value='952']");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout");
		try { if ("S".equals(selenium.getText("css=div.selreplace_selectinner"))) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}

	selenium.click("css=div.add-to-box > div.add-to-cart > button.button");
	selenium.click("id=cartHeader");
	
	assertTrue(selenium.isElementPresent("//*[@id='mini-cart']/div/li/div/p[1]/a"));
	
	selenium.click("//*[@id='quick-access']/div[1]/div");
	
	//selenium.waitForPageToLoad("30000");
	//Verifica 
	selenium.click("xpath=(//button[@type='button'])[3]");
	
	selenium.waitForPageToLoad("30000");
	
	selenium.click("id=shipping-address-select-5");
	
	//Helper.clickAndVerify(selenium, "xpath o identificador del objeto sobre 
	//el que se hara click", "Texto para verificar", "xpath o identificador del lugar 
	//donde se busca la palabra a comparar");
	Helper.clickAndVerify(selenium, "id=p_method_paypal_standard", "Pagar por Paypal","xpath=//*[@id='checkout-payment-method-load']/dt[2]/label/a");
	
	//assertTrue(selenium.isElementPresent("link=Sandbox de PayPal de PayPal"));
	
	
	//assertTrue(selenium.isTextPresent("TOTAL"));
	//assertEquals("on", selenium.getValue("id=shipping-address-select-5"));
	assertEquals("on", selenium.getValue("id=p_method_paypal_standard"));
	
	//selenium.click("css=button.button.btn-checkout");
	//selenium.waitForPageToLoad("50000");
	//selenium.click("link=Sandbox de PayPal de PayPal");
	//selenium.waitForPageToLoad("30000");
	//assertTrue(selenium.isElementPresent("name=submit"));

	
	//selenium.open("/es_es/customer/account/");
	
	//if (("".equals(selenium.getText("css=b")))){
		//message = "No compro";
	//}else {
		//message = selenium.getText("Ok");
	//}
	
	//if(message == null){
		//Helper.log("Login Error " + selenium.getLocation());
		//Assert.fail("Login Error " + selenium.getLocation());
		//SeleneseTestCase.fail("Login Error " + selenium.getLocation());
	//}
	Claireandbruce.logout(selenium);
	//Helper.log("Compra de pedidos pagos paypal " + message);
	
	
	selenium.close();
	
	}
	
	
	
}
