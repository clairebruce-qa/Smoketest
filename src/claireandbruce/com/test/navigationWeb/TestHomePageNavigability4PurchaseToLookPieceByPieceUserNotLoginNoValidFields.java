package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.*;
import junit.framework.AssertionFailedError;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * @author NEWSHORE
 * CBT34
 */
public class TestHomePageNavigability4PurchaseToLookPieceByPieceUserNotLoginNoValidFields extends ClaireandbruceTestCase{
	
	
	private String message;

	@Test
	public void CBT34() throws Exception
	{
		Helper.log("Prueba de navegabilidad por total look compra prenda por prenda");
		Helper.log("Se carga la página "+ClaireandbruceUrl);
		selenium.open("");
		
		if(selenium.isElementPresent("link=Salir")) {
			Helper.log("Se presenta usuario con sesión iniciada al cargar la página de C+B");
			selenium.click("link=Salir");
			selenium.waitForPageToLoad("15000");
			
			if(selenium.isElementPresent("id=email")){
				Helper.log("Se regresa a Homepage");
				selenium.click("xpath=//img");
				selenium.waitForPageToLoad("15000");
			}
		}
		

		if(!selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[3]/div[1]/a/img"))
		{
			
			message="ERROR: Elemento no encontrado";
			Helper.log(message);
			
		}
		else{
			Helper.log("Se ingrea a la imagen");
		selenium.click("xpath=html/body/div/div[2]/div/div/div[1]/div[3]/div[1]/a/img");
		
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("id=total-look-part"));
		Helper.log("Se ingresa a la pestaña 'COMPRA PRENDA POR PRENDA'");
		selenium.click("id=total-look-part");
		
		
		 int i=2;
		 int j=1;
		 
			while(selenium.isElementPresent("xpath=.//*[@id='product-options-wrapper']/dl/div["+i+"]/div[3]/div[7]/div[3]/div/button")){
			
				//Verificacion de la cantidad de botones
				//Si existe la talla la selecciona si no solo agrega al carrito de compra
				if(selenium.isElementPresent("//div[contains(@class, 'selreplace_selectinner')]")){
					Helper.log("Se selecciona una talla");
					//Click sobre combo seleccionar una talla
					selenium.click("//div[contains(@class, 'selreplace_selectinner')]");
					//Se selecciona la primera talla encontrada del producto y se verifica que se selecciono correctamente		
					Helper.clickAndVerify(selenium, "//div[@class='selreplace_option']",selenium.getText("xpath=//div[@class='selreplace_option']") , "//div[contains(@class, 'selreplace_selectinner')]");
				}
				
				////div[contains(@class, 'selreplace_selectinner')]
				
				String text= selenium.getText("xpath=.//*[@id='product-options-wrapper']/dl/div["+i+"]/div[3]/div[3]/a");
				
				//Add product in shopping Cart and verify
				selenium.click("xpath=.//*[@id='product-options-wrapper']/dl/div["+i+"]/div[3]/div[7]/div[3]/div/button");
	
				//Busca el producto en el carrito de compras
				if(selenium.isElementPresent("xpath=.//*[@id='mini-cart']/div["+j+"]/li/div/p[1]/a"))
				{
					if(text.equals(selenium.getText("xpath=.//*[@id='mini-cart']/div["+j+"]/li/div/p[1]/a")))
					{					
						Helper.log("Se ha agregado al carrito de compras: "+text);
					}
				}
				else
				{
					Helper.log("El producto no esta en el inventario :"+text);
				}
				
				//load look part for part
				selenium.click("//div[contains(@id, 'total-look-part')]");
				i+=2;
				j++;
				
			}
		
			//Elimina todos los productos del Carrito de Compras
			Helper.log("Se eliminan todos los productos que se han añadido al carrito de compras");
			while(!selenium.isTextPresent("0 artículos 0 €")){
				//Remover articulos mientras el carrito no este vacío
				selenium.click("id=cartHeader");
				selenium.click("class=btn-remove");
				assertTrue(selenium.getConfirmation().matches("¿Está seguro de que desea eliminar este artículo de la cesta de la compra[\\s\\S]$"));
				selenium.waitForPageToLoad("10000");
			}			
		}
	}
}