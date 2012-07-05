package claireandbruce.com.test.basicsFlows;

import static org.junit.Assert.assertTrue;
import com.thoughtworks.selenium.Selenium;
import junit.framework.Assert;
import lib.Helper;
import basics.ClaireandbruceTestCase;
/**
 * 
 * 
 * Se validara la funcionalidad del carrito de compras cuando se 
 * elimine un producto del carrito de compras, ademas la  prueba 
 * aplicara cuando se eliminen el total de productos del carrito 
 * de compras pues se   verificara la existencia de    articulos 
 * en el carrito de compra.
 * el éxito de la prueba se evidenciara cuando se elimine un item
 * o todos los items del carrito de compras y  este vacio.	
 * 
 * @author NEWSHORE
 *
 */
public class LibShoppingCart3DeleterItemShoppingCart extends ClaireandbruceTestCase {
	
	public static void CBT24(Selenium selenium) throws Exception
	{		
		//----------***** SE DESPLIEGA LA VENTANA *****---------------------\\
		Helper.log(" ");	
		Helper.log("Se inicia prueba para eliminar un producto del carrito de compras");
		
		//------------Se verifica que el carrito de compras contenga productos-------
		Helper.log("Se da clic en el carrito de compras en el header");
		selenium.click("id=cartHeader");
	
		Helper.log("Se busca el icono para eliminar un producto por el carrito de compras");
		if(selenium.isElementPresent("class=btn-remove")){			
			selenium.click("class=btn-remove");
			Helper.log("Se remueve el producto del carrito de compras");
			
			// El sistema confirma que se eliminará el producto
			Helper.log("Se carga mensaje de confirmación para eliminar el producto");
			assertTrue(selenium.getConfirmation().matches("¿Está seguro de que desea eliminar este artículo de la cesta de la compra[\\s\\S]$"));
			Helper.log("Se confirma que se eliminará el producto del carrito de compras");
			selenium.waitForPageToLoad("10000");			
		} else {
			Assert.fail("Error: no hay productos en el carrito de compras");
			selenium.waitForPageToLoad("10000");				
		}		
		
	}
	
}
