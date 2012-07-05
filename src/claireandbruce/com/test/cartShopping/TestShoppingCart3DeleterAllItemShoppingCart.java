package claireandbruce.com.test.cartShopping;

import static org.junit.Assert.assertTrue;



import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartConfigurableProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import junit.framework.Assert;
import lib.Helper;
import basics.ClaireandbruceTestCase;
/**	Se validara la funcionalidad del carrito de compras cuando se 
 * 	elimine un producto del carrito de compras, ademas 	la prueba 
 * 	aplicara cuando se eliminen el total de productos del carrito 
 * 	de compras pues se 	verificara la existencia de 	articulos 
 * 	en el carrito de compra.
	el �xito de la prueba se evidenciara cuando se elimine un item
	o todos los items del carrito de compras y  este vacio
	
	@author NEWSHORE
	Testlink: Local CBT24  - Privalia CBT65
	*/
public class TestShoppingCart3DeleterAllItemShoppingCart extends ClaireandbruceTestCase {
	
	@Test
	public void cbt65() throws Exception
	{			
		//----------***** SE DESPLIEGA LA VENTANA *****---------------------\\
				
		Helper.log("Se inicia proceso para eliminar todos los productos que se encuentran en el carrito de compras");
		Helper.log("Se carga la p�gina "+ClaireandbruceUrl);
		selenium.open("");
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		selenium.click("//a[@id='overridelink']");
		}
				
		//------------Se verifica que el carrito de compras contenga productos-------
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		LibCorrectAddProductCartConfigurableProduct.CBT_ConfigurableProduct(selenium);
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		Helper.log("Se hace clic en el header para desplegar el carrito de compras");
		selenium.click("id=cartHeader");

		if(selenium.isElementPresent("class=btn-remove")){
			Helper.log("Se eliminan los art�culos encontrados hasta que el carrito de compras quede vac�o");
			int numArticulos = 0;
			while(!selenium.isTextPresent("0 art�culos 0 �")){
				numArticulos++;
				//Remover  todos los art�culos mientras el carrito no este vac�o
				Helper.log("Se hace clic en el header");
				selenium.click("id=cartHeader");
				Helper.log("Se hace clic en el icono para eliminar el art�culo");
				selenium.click("class=btn-remove");
				Helper.log("Se confirma que se desea eliminar el art�culo");
				assertTrue(selenium.getConfirmation().matches("�Est� seguro de que desea eliminar este art�culo de la cesta de la compra[\\s\\S]$"));
				selenium.waitForPageToLoad("10000");
			}			
			Helper.log("Total art�culos eliminados: "+numArticulos+" art�culos");
		}
		else {
			Assert.fail("Error: no hay productos en el carrito de compras");
			selenium.waitForPageToLoad("10000");				
		}
	}
}
