package claireandbruce.com.test.cartShopping;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import basics.ClaireandbruceTestCase;
import lib.Claireandbruce;
import lib.ElementNotFoundException;
import lib.Helper;

public class CBT22_Test_Shopping_Cart_1_Add_Other_Item_Shopping_Cart extends ClaireandbruceTestCase{
	

	
	private CBT76_Test_CorrectAddProduct_Cart_NoLoginUser cb76;

	@Test
	public void CBT22() throws Exception{
	
		
		cb76= new CBT76_Test_CorrectAddProduct_Cart_NoLoginUser();
		//Previo ingreso a la pagina c+b
		  if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
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

		 for(int i=0; i<2;i++)
		 {
			cb76.CBT76(); 
		 }
	
		if(selenium.isTextPresent("0 artículos 0 €")){
			Assert.fail("Error : product no add");
		}
		
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
