package claireandbruce.com.test.cartShopping;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import junit.framework.Assert;
import lib.Claireandbruce;
import lib.Helper;
import basics.ClaireandbruceTestCase;

public class CBT1_Test_Shoppin_Cart_User_Login_Valid_Fields_With_Paypal extends ClaireandbruceTestCase{
	
	private Test_CorrectAddProduct_Cart_NoLoginUser cbt76;

	@Test
	public void CBT1() throws Exception{
	
		selenium.deleteAllVisibleCookies();  
		 
		

		
	Claireandbruce.login(selenium, username, password);
	
	String message=null;	
	// Se instancia el caso numero CBT76 para agregar productos al carrito de compras
	cbt76 = new Test_CorrectAddProduct_Cart_NoLoginUser();
	
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
