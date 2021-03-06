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
 * Testlink: Local CBT22  - Privalia CBT14
 */

public class TestShoppingCart1AddOtherItemShoppingCart extends ClaireandbruceTestCase{

	@Test
	public void cbt14() throws Exception{
		
		//Previo ingreso a la pagina c+b
		Helper.log("Se inicia proceso para agregar otro producto al carrito de compras");
		Helper.log("Se carga la p�gina "+ClaireandbruceUrl);
		selenium.open(ClaireandbruceUrl);
		selenium.waitForPageToLoad("30000");
		
		if(!selenium.isElementPresent("xpath=//a[contains(text(), 'Salir')]")){			
			LibCorrectLogonValidUserAccout.CBT55(selenium);			
		}			 
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		if(selenium.isTextPresent("1 art�culo")){
			LibCorrectAddProductCartConfigurableProduct.CBT_ConfigurableProduct(selenium);
		}
		
			
		if(selenium.isTextPresent("0 art�culos 0 �")){
			Assert.fail("Error : product no add");
		}		
		Helper.log("Se ha a�adido el producto al carrito de compras");
	}
}