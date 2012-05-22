package claireandbruce.com.test.basicosFlujos;

import junit.framework.Assert;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

/**
 * Se automatiza el añadir un producto simple a la cesta.
 * @author NEWSHORE
 *
 */
public class Test_CorrectAddProduct_Cart_SimpleProduct extends ClaireandbruceTestCase {

	@Test
	public void CBT_SimpleProduct() {
		
		//Para efecto de la prueba
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		//Se selecciona una categoría entre Bolsos y Accesorios (Categorías que poseen productos simples)
		int categoria = (int) (Math.random()*(4-3) +3);
		
		if(selenium.isElementPresent("xpath=.//*[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas")){
			selenium.click("xpath=.//*[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas");
		} else {
			Assert.fail("ERROR. Categoría no encontrada");
		}
	}
	
	
	//producto
}
