package claireandbruce.com.test.cartShopping;

import junit.framework.Assert;
import lib.Helper;



import org.junit.Test;


import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartConfigurableProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;


import basics.ClaireandbruceTestCase;
/**
 * 
 * @author NEWSHORE
 * CBT22
 */

public class TestShoppingCart1AddOtherItemShoppingCart extends ClaireandbruceTestCase{

	@Test
	public void CBT22() throws Exception{
		
		//Previo ingreso a la pagina c+b
		Helper.log("Se inicia proceso para agregar otro producto al carrito de compras");
		Helper.log("Se carga la página "+ClaireandbruceUrl);
		selenium.open(ClaireandbruceUrl);
		selenium.waitForPageToLoad("30000");
		
		if(!selenium.isElementPresent("xpath=//a[contains(text(), 'Salir')]")){			
			LibCorrectLogonValidUserAccout.CBT55(selenium);			
		}			 
			LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
			//Lib_CorrectAddProduct_Cart_ConfigurableProduct.CBT_ConfigurableProduct(selenium);
			
	
	
		if(selenium.isTextPresent("0 artículos 0 €")){
			Assert.fail("Error : product no add");
		}		
		Helper.log("Se ha añadido el producto al carrito de compras");
	}
}