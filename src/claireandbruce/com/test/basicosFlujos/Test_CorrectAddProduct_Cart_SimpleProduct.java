package claireandbruce.com.test.basicosFlujos;

import junit.framework.Assert;
import lib.Helper;

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
		int categoria = 3;
		
		//Haga mientras encuentre el men� de selecci�n de talla (producto configurable)
		do {

			categoria = (int) (Math.random()*(4-3+1))+3;
			Helper.log("Categor�a "+categoria);
			if(selenium.isElementPresent("xpath=.//*[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas")){
				selenium.click("xpath=.//*[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas");
				//selenium.waitForPageToLoad("10000");
				
				//Selecciona una subcategor�a
				int subcategoria =  (int)(Math.random()*(7))+1; 
				Helper.log("Categor�a actual: "+selenium.getTitle());
				Helper.log("Subcategoria "+subcategoria);
				if(selenium.isElementPresent("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+subcategoria+"]/div/div")){
										
					selenium.click("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+subcategoria+"]/div/div");
					//selenium.waitForPageToLoad("10000");					
						
					//Se selecciona uno de los art�culos de �sta subcategor�a
					int columnaArticulo = (int)(Math.random()*(3))+1;
					int filaArticulo = (int)(Math.random()*(2))+1;
					Helper.log("Subcategor�a actual: "+selenium.getTitle());
					Helper.log("Producto: "+columnaArticulo+" en la fila: "+filaArticulo);
					selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a");
					selenium.waitForPageToLoad("20000");
					Helper.log("Producto actual: "+selenium.getTitle());	
							
				}
				
			} else {
				Assert.fail("ERROR. Categor�a no encontrada");
			}
		} while(selenium.isElementPresent("class=selreplace_select"));
		
		if(!selenium.isElementPresent("class=selreplace_select")){
			//Clic en bot�n "A�ADIR A LA CESTA"
			selenium.click("xpath=//div[7]/div/button");	
		}		
	}	
}
