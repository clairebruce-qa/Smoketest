package claireandbruce.com.test.basicosFlujos;

import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import lib.Helper;

import org.junit.Test;

import com.thoughtworks.selenium.Selenium;

import basics.ClaireandbruceTestCase;

/**
 * Se automatiza el a�adir un producto simple a la cesta.
 * @author MARIA FERNANDA RODRIGUEZ
 *
 */
public class Test_CorrectAddProduct_Cart_SimpleProduct extends ClaireandbruceTestCase {

	public static String CBT_SimpleProduct(Selenium selenium) {
		
		//Para efecto de la prueba
		selenium.open(ClaireandbruceUrl);
		selenium.waitForPageToLoad("30000");
		
		//Se verifica que el carrito este vacio 
		while(!selenium.isTextPresent("0 art�culos 0 �")){
			
			//Remover  todos los art�culos mientras el carrito no este vac�o
			selenium.click("id=cartHeader");
			selenium.click("class=btn-remove");
			assertTrue(selenium.getConfirmation().matches("�Est� seguro de que desea eliminar este art�culo de la cesta de la compra[\\s\\S]$"));
			selenium.waitForPageToLoad("10000");
		}
		
		
		//Se selecciona una categor�a entre Bolsos y Accesorios (Categor�as que poseen productos simples)
		
		
		//Haga mientras encuentre el men� de selecci�n de talla (producto configurable)
		do {

			int categoria = (int) (Math.random()*(4-3+1))+3;
			Helper.log("Categor�a "+categoria);
			
			if(selenium.isElementPresent("xpath=//ul[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas")){

				selenium.click("//ul[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas");
				
				selenium.waitForPageToLoad("10000");
				
				//Selecciona una subcategor�a
				int subcategoria =  (int)(Math.random()*(7))+1; 
				Helper.log("Categor�a actual: "+selenium.getTitle());
				Helper.log("Subcategoria "+subcategoria);
				if(selenium.isElementPresent("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+subcategoria+"]/div/div")){
										
					selenium.click("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+subcategoria+"]/div/div");
					selenium.waitForPageToLoad("30000");					
						
					//Se selecciona uno de los art�culos de �sta subcategor�a
					int columnaArticulo = (int)(Math.random()*(3))+1;
					int filaArticulo = (int)(Math.random()*(2))+1;
					Helper.log("Subcategor�a actual: "+selenium.getTitle());
					Helper.log("Producto: "+columnaArticulo+" en la fila: "+filaArticulo);
					nombreProducto = selenium.getText("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a");
					if(!selenium.isElementPresent("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a")){
						Helper.log("no se encontro el nombre del producto");
					}
					else{
						selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a");

					//	selenium.waitForPageToLoad("20000");

						selenium.waitForPageToLoad("30000");

					}
				
					//selenium.waitForPageToLoad("15000");
					Helper.log("Producto actual: "+selenium.getTitle());						
				}
				
			} 
		} while(selenium.isElementPresent("class=selreplace_select") || !selenium.isElementPresent("xpath=//div[7]/div/button") );
		
		if(!selenium.isElementPresent("class=selreplace_select")){
			//Clic en bot�n "A�ADIR A LA CESTA"

			selenium.click("xpath=//div[7]/div/button");
			Helper.log(nombreProducto);
		} 
		return nombreProducto;
	}	
}