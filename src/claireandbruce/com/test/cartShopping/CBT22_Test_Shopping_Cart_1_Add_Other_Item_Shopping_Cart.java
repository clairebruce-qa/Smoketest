package claireandbruce.com.test.cartShopping;

import junit.framework.Assert;



import org.junit.Test;


import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_ConfigurableProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;


import basics.ClaireandbruceTestCase;


public class CBT22_Test_Shopping_Cart_1_Add_Other_Item_Shopping_Cart extends ClaireandbruceTestCase{
	

	
	

	@Test
	public void CBT22() throws Exception{
	
	
		//Previo ingreso a la pagina c+b
		
		selenium.open(ClaireandbruceUrl);
		selenium.waitForPageToLoad("30000");
		
		
			 
			Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
			Lib_CorrectAddProduct_Cart_ConfigurableProduct.CBT_ConfigurableProduct(selenium);
		
	
	
		if(selenium.isTextPresent("0 artículos 0 €")){
			Assert.fail("Error : product no add");
		}
		
	}

}
