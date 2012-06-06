package claireandbruce.com.test.cartShopping;

import junit.framework.Assert;



import org.junit.Test;


import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartConfigurableProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;


import basics.ClaireandbruceTestCase;
/**
 * 
 * @author NEWSHORE
 *
 */

public class TestShoppingCart1AddOtherItemShoppingCart extends ClaireandbruceTestCase{

	@Test
	public void CBT22() throws Exception{
		
		//Previo ingreso a la pagina c+b
		
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
	}
}