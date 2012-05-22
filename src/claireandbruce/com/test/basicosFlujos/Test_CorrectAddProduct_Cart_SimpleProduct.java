package claireandbruce.com.test.basicosFlujos;

import junit.framework.Assert;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

/**
 * Se automatiza el a�adir un producto simple a la cesta.
 * @author NEWSHORE
 *
 */
public class Test_CorrectAddProduct_Cart_SimpleProduct extends ClaireandbruceTestCase {

	@Test
	public void CBT_SimpleProduct() {
		
		//Para efecto de la prueba
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		//Se selecciona una categor�a entre Bolsos y Accesorios (Categor�as que poseen productos simples)
		int categoria = (int) (Math.random()*(4-3) +3);
		
		if(selenium.isElementPresent("xpath=.//*[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas")){
			selenium.click("xpath=.//*[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas");
		} else {
			Assert.fail("ERROR. Categor�a no encontrada");
		}
	}
	
	
	//producto
}
