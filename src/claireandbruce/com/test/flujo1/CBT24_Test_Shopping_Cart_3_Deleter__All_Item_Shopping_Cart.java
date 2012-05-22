package claireandbruce.com.test.flujo1;

import static org.junit.Assert.assertTrue;



import org.junit.Test;
import junit.framework.Assert;
import basics.ClaireandbruceTestCase;

public class CBT24_Test_Shopping_Cart_3_Deleter__All_Item_Shopping_Cart extends ClaireandbruceTestCase {
	
	
/*	Se validara la funcionalidad del carrito de compras cuando se 
 * 	elimine un producto del carrito de compras, ademas 	la prueba 
 * 	aplicara cuando se eliminen el total de productos del carrito 
 * 	de compras pues se 	verificara la existencia de 	articulos 
 * 	en el carrito de compra.
	el �xito de la prueba se evidenciara cuando se elimine un item
	o todos los items del carrito de compras y  este vacio*/

	
	@Test
	public void CBT24() throws Exception
	{
		
		
		//----------***** SE DESPLIEGA LA VENTANA *****---------------------\\
		
	
		
		//------------Se verifica que el carrito de compras contenga productos-------
		
		selenium.click("id=cartHeader");

	
		if(selenium.isElementPresent("class=btn-remove")){
			
			selenium.click("class=btn-remove");
			
			// El sistema confirma que se eliminar� el producto
			assertTrue(selenium.getConfirmation().matches("�Est� seguro de que desea eliminar este art�culo de la cesta de la compra[\\s\\S]$"));
			selenium.waitForPageToLoad("10000");
			
			
		}
		else
		{
			Assert.fail("Error: no hay productos en el carrito de compras");
			selenium.waitForPageToLoad("10000");
				
		}
		
		
		// Se termina la ejecuci�n y se cierra el selenium
		
	

	}
	
	
	
	
	
}
