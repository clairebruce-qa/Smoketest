package claireandbruce.com.test.shopping.card;

import static org.junit.Assert.*;

import junit.framework.Assert;
import org.junit.Test;

import lib.Claireandbruce;
import lib.Helper;
import basics.ClaireandbruceTestCase;
/*
 * El TestShoppingWithLogin prueba la agregacion de un articulo  a
 * la cesta de compra con un usuario logueado, cuando 
 * 1. el carrito de compras esta vacio
 * 2. se agrega un unico articulo en este caso una camisa
 * 
 * Camisa: T-SHIRT Tank NAVY de valor 53,10 €
 * 

 * 
 * 
 * */
public class TestShoppingWithLogin extends ClaireandbruceTestCase{
	
	
	/*
	//@Test
	public void TestLogin() throws Exception{
		Claireandbruce.login(selenium, username, password);
		
	}
	*/
	
	@Test
	public void TestCarritoCompraLogin() throws Exception{
		
		
		
		//Para Abrir otra ventana
		selenium.deleteAllVisibleCookies();  
		  selenium.open("");

		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		  }
		  Claireandbruce.login(selenium, username, password);
		//Helper.waitForElement(selenium, "xpath=//*[@id='nav']/li[1]/a/span/cufon/canvas", "Log-out link not found in the page");
		
		// se comento linea anterior y se cambio la forma en la que se busca el link de salir
		Helper.waitForElement(selenium, "//a[contains(@href, 'https://pre-cb.newshore.es/es_es/customer/account/logout/')]", "Log-out link not found in the page");
		
		//Seleccion del Catalago de Ropa de la seccion femenina
		selenium.click("xpath=//*[@id='nav']/li[1]/a/span/cufon/canvas");
		selenium.waitForPageToLoad("50000");
		//este click es innecesario
		//selenium.click("xpath=//div/strong");
		
		//assertTrue(selenium.isTextPresent("productos encontrados"));
		
		//Para que sin importar el nombre de la imagen le de clic al primer producto 
		
		selenium.click("xpath=//div[@class='div-filter']");
		
		Helper.clickAndVerify(selenium, "class=product", "Seleccionar una talla","xpath=//*[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[3]/div/div[1]");
		
		
		
		Helper.clickAndVerify(selenium, "div /class=selreplace_option", "S","xpath=//*[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[3]/div/div[1]");
		
		
		//assertTrue(selenium.isTextPresent("1 artículo"));
		//*[@id='tlImageProduct_5273']
		//assertTrue(selenium.isTextPresent("1 artículo"));
		/*assertEquals("1", selenium.getValue("id=qtyitemcarthidden_40"));
		assertTrue(selenium.isTextPresent("Añade una dirección de envío"));
		assertTrue(selenium.isTextPresent("S"));
		assertTrue(selenium.isTextPresent("2 articulos 106,20 €"));
		assertTrue(selenium.isTextPresent("2 X 53,10 €"));
		assertTrue(selenium.isTextPresent("106,20 €"));
		assertTrue(selenium.isTextPresent("Barcelona"));
		assertEquals("4355234", selenium.getValue("id=shipping:postcode"));
		assertEquals("34232342", selenium.getValue("id=shipping:telephone"));
		assertEquals("4548812049400004", selenium.getValue("id=sermepa_cc_number"));
		assertTrue(selenium.isTextPresent("0 artículos 0 €"));
		selenium.click("id=cartHeader");*/
		Claireandbruce.logout(selenium);
	}
	
	/*
	//@Test
	public void TestLogout() throws Exception{
		Claireandbruce.logout(selenium);
	}
	*/
}
