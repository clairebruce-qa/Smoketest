package claireandbruce.com.test.cartShopping;

import junit.framework.Assert;



import org.junit.Test;


import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_ConfigurableProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;


import basics.ClaireandbruceTestCase;
 /**
  * CBT22
  * @author NEWSHORE
  *
  */

public class Test_Shopping_Cart_1_Add_Other_Item_Shopping_Cart extends ClaireandbruceTestCase{
	

	
	

	@Test
	public void CBT22() throws Exception{
	
	
		//Previo ingreso a la pagina c+b
		
		selenium.open(ClaireandbruceUrl);
		selenium.waitForPageToLoad("30000");
		
		if(!selenium.isElementPresent("xpath=//a[contains(text(), 'Salir')]")){
			
			Lib_CorrectLogon_ValidUser_Accout.CBT55(selenium);
			
		}
			 
			Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
			//Lib_CorrectAddProduct_Cart_ConfigurableProduct.CBT_ConfigurableProduct(selenium);
			
			
		
			
		
	
	
		if(selenium.isTextPresent("0 artículos 0 €")){
			Assert.fail("Error : product no add");
		}
		
	}

}
