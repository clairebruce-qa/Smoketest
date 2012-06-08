package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.*;
import junit.framework.AssertionFailedError;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * 
 * @author NEWSHORE
 * CBT34
 */
public class TestHomePageNavigability4PurchaseToLookPieceByPieceUserNotLoginNoValidFields extends ClaireandbruceTestCase{
	
	
	private String message;

	@Test
	public void CBT34() throws Exception
	{
		selenium.open("");
		
		if(selenium.isElementPresent("link=Salir")) {
			selenium.click("link=Salir");
			selenium.waitForPageToLoad("15000");
			
			if(selenium.isElementPresent("id=email")){
				selenium.click("xpath=//img");
				selenium.waitForPageToLoad("15000");
			}
		}
		

		if(!selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[3]/div[1]/a/img"))
		{
			
			message="ERROR: THIS ELEMENT NOT FOUND";
			Helper.log(message);
			
		}
		else{
		selenium.click("xpath=html/body/div/div[2]/div/div/div[1]/div[3]/div[1]/a/img");
		
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("id=total-look-part"));
		selenium.click("id=total-look-part");
		
		
		 int i=2;
		 int j=1;
		 
			while(selenium.isElementPresent("xpath=.//*[@id='product-options-wrapper']/dl/div["+i+"]/div[3]/div[7]/div[3]/div/button")){
			
				//Verificacion de la cantidad de botones
				//Si existe la talla la selecciona si no solo agrega al carrito de compra
				if(selenium.isElementPresent("//div[contains(@class, 'selreplace_selectinner')]")){
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
						Helper.log("ADD IN SHOPPING CART:"+text);
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