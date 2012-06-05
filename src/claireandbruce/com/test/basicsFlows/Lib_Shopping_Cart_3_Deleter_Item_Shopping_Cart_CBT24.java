package claireandbruce.com.test.basicsFlows;

import static org.junit.Assert.assertTrue;


import org.junit.After;
import org.junit.Test;

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
public class Lib_Shopping_Cart_3_Deleter_Item_Shopping_Cart_CBT24 extends ClaireandbruceTestCase {
	
	public static void CBT24(Selenium selenium) throws Exception
	{		
		//----------***** SE DESPLIEGA LA VENTANA *****---------------------\\
				
		// SE PONE EN COMENTARIO CUANDO SE CORRA EN EL FLUJO, SE ACTIVA CUANDO SE CORRE UNITARIO
				
		/*selenium.open("");
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		selenium.click("//a[@id='overridelink']");
		}
		*/
		
		//------------Se verifica que el carrito de compras contenga productos-------
		Helper.log("\n*CBT24* Eliminar un producto del carrito de compras");
		selenium.click("id=cartHeader");
	
		if(selenium.isElementPresent("class=btn-remove")){			
			selenium.click("class=btn-remove");
			Helper.log("Eliminar producto");
			// El sistema confirma que se eliminará el producto
			assertTrue(selenium.getConfirmation().matches("¿Está seguro de que desea eliminar este artículo de la cesta de la compra[\\s\\S]$"));
			selenium.waitForPageToLoad("10000");
			Helper.log("Confirmación para eliminar el artículo");
		} else {
			Assert.fail("Error: No hay productos en el carrito de compras");
			selenium.waitForPageToLoad("10000");				
		}		
		
		// Se termina la ejecución y se cierra el selenium
	}
	
	//   SE PONE EN COMENTARIO PARA CORRER EN EL FLUJO
	/*
	@After
	public void afterTest(){
		selenium.stop();
	}*/	
}
