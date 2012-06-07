package claireandbruce.com.test.cartShopping;

import static org.junit.Assert.assertTrue;



import org.junit.Test;
import junit.framework.Assert;
import basics.ClaireandbruceTestCase;
/**	Se validara la funcionalidad del carrito de compras cuando se 
 * 	elimine un producto del carrito de compras, ademas 	la prueba 
 * 	aplicara cuando se eliminen el total de productos del carrito 
 * 	de compras pues se 	verificara la existencia de 	articulos 
 * 	en el carrito de compra.
	el éxito de la prueba se evidenciara cuando se elimine un item
	o todos los items del carrito de compras y  este vacio
	
	@author NEWSHORE
	CBT24
	*/
public class TestShoppingCart3DeleterAllItemShoppingCart extends ClaireandbruceTestCase {
	
	


	
	@Test
	public void CBT24() throws Exception
	{
		
		
		//----------***** SE DESPLIEGA LA VENTANA *****---------------------\\
		
		
		// SE PONE EN COMENTARIO CUANDO SE CORRA EN EL FLUJO, SE ACTIVA CUANDO SE CORRE UNITARIO
		
		
		selenium.open("");
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		selenium.click("//a[@id='overridelink']");
		}
		
		
		//------------Se verifica que el carrito de compras contenga productos-------
		
		selenium.click("id=cartHeader");

	
		if(selenium.isElementPresent("class=btn-remove")){
			
			while(!selenium.isTextPresent("0 artículos 0 €")){
				
				//Remover  todos los artículos mientras el carrito no este vacío
				selenium.click("id=cartHeader");
				selenium.click("class=btn-remove");
				assertTrue(selenium.getConfirmation().matches("¿Está seguro de que desea eliminar este artículo de la cesta de la compra[\\s\\S]$"));
				selenium.waitForPageToLoad("10000");
			}
			
		}
		else
		{
			Assert.fail("Error: no hay productos en el carrito de compras");
			selenium.waitForPageToLoad("10000");
				
		}
		
		
		// Se termina la ejecución y se cierra el selenium
		
	

	}
	
//  SE PONE EN COMENTARIO PARA CORRER EN EL FLUJO
	/*
	@After
	public void afterTest(){
		selenium.stop();
	}*/
	
	
	
	
}
