package claireandbruce.com.test.cartShopping;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import basics.ClaireandbruceTestCase;
import lib.Claireandbruce;
import lib.ElementNotFoundException;
import lib.Helper;

public class CBT22_Test_Shopping_Cart_1_Add_Other_Item_Shopping_Cart extends ClaireandbruceTestCase{
	

	
	@Test
	public void CBT22() throws Exception{
	
		
		//Previo ingreso a la pagina c+b
		  if(!selenium.isTextPresent("Salir")){
			  Claireandbruce.login(selenium, username, password);
		  }

			while(!selenium.isTextPresent("0 artículos 0 €")){
				//Remover articulos mientras el carrito no este vacío
				selenium.click("id=cartHeader");
				selenium.click("class=btn-remove");
				assertTrue(selenium.getConfirmation().matches("¿Está seguro de que desea eliminar este artículo de la cesta de la compra[\\s\\S]$"));
				selenium.waitForPageToLoad("10000");
			}
		
		Helper.waitForElement(selenium, "//a[contains(text(),'Salir')]", "Log-out link not found in the page");

		 
		Helper.clickAndVerify(selenium, "css=span > cufon.cufon.cufon-canvas > canvas", "Ropa", "css=span.breadcrumbs-present");
		String texto = selenium.getText("css=div.div-filter > div");
		Helper.clickAndVerify(selenium, "css=div.div-filter > div", texto, "css=span.breadcrumbs-present");
		
		//Se ingresa en el primer producto
		String texto2 = selenium.getText("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul[1]/li[1]/div[3]"); //Nombre de la prenda
		Helper.clickAndVerify(selenium, "//li/div/a/img", texto2, "class=breadcrumbs-present");
		selenium.waitForPageToLoad("70000");
		
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
		
		Helper.clickAndVerify(selenium, "css=span > cufon.cufon.cufon-canvas > canvas", "Ropa", "css=span.breadcrumbs-present");
		String texto3 = selenium.getText("css=div.div-filter > div");
		Helper.clickAndVerify(selenium, "css=div.div-filter > div", texto3, "css=span.breadcrumbs-present");
		
		//Se ingresa en el primer producto
		String texto4 = selenium.getText("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul[1]/li[2]/div[3]"); //Nombre de la prenda
		Helper.clickAndVerify(selenium, "//li[2]/div/a/img", texto4, "//*[@id='product_addtocart_form']/div[3]/div[3]/div/div[3]");
		selenium.waitForPageToLoad("90000");
		
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
		
		
	}
	/*@After
	public void closed() throws Exception{

		while(!selenium.isTextPresent("0 artículos 0 €")){
			//Remover articulos mientras el carrito no este vacío
			selenium.click("id=cartHeader");
			selenium.click("class=btn-remove");
			assertTrue(selenium.getConfirmation().matches("¿Está seguro de que desea eliminar este artículo de la cesta de la compra[\\s\\S]$"));
			selenium.waitForPageToLoad("10000");
		}
		Claireandbruce.logout(selenium);
		selenium.stop();
	}*/	
}
