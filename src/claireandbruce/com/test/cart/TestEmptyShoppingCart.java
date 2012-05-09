package claireandbruce.com.test.shopping;

import static org.junit.Assert.*;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lib.Claireandbruce;
import lib.Helper;
import basics.ClaireandbruceTestCase;
/*
 * El TestEmptyShoppingCart prueba la compra de un articulo  a
 * la cesta de compra con un usuario logueado, cuando 
 * 1. el carrito de compras esta vacio
 * 2. se agrega un unico articulo en este caso una camisa
 * 
 * Camisa: T-SHIRT Tank NAVY de valor 53,10 € talla: S marca :HILFIGER DENIM
 * 

 * 
 * 
 * */
public class TestEmptyShoppingCart extends ClaireandbruceTestCase{
	
	
	@Before
	public void beforeTest() throws Exception{
		
		//El usuario no debe tener sesion iniciada
		  Claireandbruce.login(selenium, username, password);
		  
		  Helper.waitForElement(selenium, "//a[contains(text(),'Salir')]", "Log-out link not found in the page");
		//Click en menu Ropa y verificar en miga de pan
		
		
		//Se verifica que se encuentre vacío el carrito de compras.
		while(!selenium.isTextPresent("0 artículos 0 €")){
			//Remover articulos mientras el carrito no este vacío
			selenium.click("id=cartHeader");
			selenium.click("class=btn-remove");
			assertTrue(selenium.getConfirmation().matches("¿Está seguro de que desea eliminar este artículo de la cesta de la compra[\\s\\S]$"));
			selenium.waitForPageToLoad("10000");
		}
	}
	
	@Test
	public void test_CorrectAddProduct_Cart_NoLoginUser() throws Exception{
	
		Helper.clickAndVerify(selenium, "css=span > cufon.cufon.cufon-canvas > canvas", "Ropa", "css=span.breadcrumbs-present");
		String texto = selenium.getText("css=div.div-filter > div");
		Helper.clickAndVerify(selenium, "css=div.div-filter > div", texto, "css=span.breadcrumbs-present");
		
		//Se ingresa en el primer producto
		String texto2 = selenium.getText("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul[1]/li[1]/div[3]"); //Nombre de la prenda
		Helper.clickAndVerify(selenium, "//li/div/a/img", texto2, "class=breadcrumbs-present");
		selenium.waitForPageToLoad("10000");
		
		//Se verifica que el articulo tenga la opcion de seleccionar talla de lo contrario pasa directo al boton añadir a la cesta
		if(selenium.isElementPresent("//div[contains(@class, 'selreplace_selectinner')]")){
			//Click sobre combo seleccionar una talla
			selenium.click("//div[contains(@class, 'selreplace_selectinner')]");
			//Se selecciona la primera talla encontrada del producto y se verifica que se selecciono correctamente		
			Helper.clickAndVerify(selenium, "//div[@class='selreplace_option']",selenium.getText("xpath=//div[@class='selreplace_option']") , "//div[contains(@class, 'selreplace_selectinner')]");
		}
		
		//Click en boton añadir a la cesta
		selenium.click("css=div.add-to-box > div.add-to-cart > button.button");
		//Se comprueba con el precio del producto que este ha sido agregado
		texto = selenium.getText("xpath=//div[5]/div/span/span");
		selenium.isTextPresent("1 artículo "+texto+" €");			
	}
	
	@After
	public void afterTest() throws Exception{
		
		while(!selenium.isTextPresent("0 artículos 0 €")){
			//Remover articulos mientras el carrito no este vacío
			selenium.click("id=cartHeader");
			selenium.click("class=btn-remove");
			assertTrue(selenium.getConfirmation().matches("¿Está seguro de que desea eliminar este artículo de la cesta de la compra[\\s\\S]$"));
			selenium.waitForPageToLoad("10000");
		}
		Claireandbruce.logout(selenium);
		selenium.stop();
	}
	
	
	
}
