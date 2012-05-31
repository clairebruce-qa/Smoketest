package claireandbruce.com.test.cartShopping;

import junit.framework.Assert;


import org.junit.Test;


import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_ConfigurableProduct;


import basics.ClaireandbruceTestCase;


public class CBT22_Test_Shopping_Cart_1_Add_Other_Item_Shopping_Cart extends ClaireandbruceTestCase{
	

	
	

	@Test
	public void CBT22() throws Exception{
	
	
		//Previo ingreso a la pagina c+b
		
		
		 for(int i=0; i<3;i++)
		 {
			Lib_CorrectAddProduct_Cart_ConfigurableProduct.CBT_ConfigurableProduct(selenium);
			//Se agregan productos al carrito de compras
		 }
	
		if(selenium.isTextPresent("0 artículos 0 €")){
			Assert.fail("Error : product no add");
		}
		
	}

}
