package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.*;
import lib.Helper;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

/**
 * @author NEWSHORE
 * Testlink: Local CBT34 - Privalia CBT68
 */
public class TestHomePageNavigability4PurchaseToLookPieceByPieceUserNotLoginNoValidFields extends ClaireandbruceTestCase{
	
	
	private String message;

	@Test
	public void cbt68() throws Exception
	{
		Helper.log("Prueba de navegabilidad por total look compra prenda por prenda");
		Helper.log("Se carga la p�gina "+ClaireandbruceUrl);
		selenium.open("");
		
		if(selenium.isElementPresent("link=Salir")) {
			Helper.log("Se presenta usuario con sesi�n iniciada al cargar la p�gina de C+B");
			selenium.click("link=Salir");
			selenium.waitForPageToLoad("15000");
			
			if(selenium.isElementPresent("id=email")){
				Helper.log("Se regresa a Homepage");
				selenium.click("xpath=//img");
				selenium.waitForPageToLoad("15000");
			}
		}
		

		if(!selenium.isElementPresent("xpath=//div/a/img"))
		{
			
			message="ERROR: Elemento no encontrado";
			Helper.log(message);
			
		}
		else{
			Helper.log("Se ingresa a la imagen");
		selenium.click("xpath=//div/a/img");
		
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("id=total-look-part"));
		Helper.log("Se ingresa a la pesta�a 'COMPRA PRENDA POR PRENDA'");
		selenium.click("id=total-look-part");
		
		
		 int i=2;
		 int j=1;
		 int fila=7;
		 int talla=1;
		 boolean inventario = true;
			while(selenium.isElementPresent("xpath=.//*[@id='product-options-wrapper']/dl/div["+i+"]/div[3]/div[7]/div[3]/div/button")){
				
				inventario=true;
				//Verificacion de la cantidad de botones
				//Si existe la talla la selecciona si no solo agrega al carrito de compra
				if(selenium.isElementPresent("//div[contains(@class, 'selreplace_selectinner')]")){
					Helper.log("Se selecciona una talla");
					//Se selecciona la primera talla encontrada del producto y se verifica que se selecciono correctamente		
					do {						
						//Click sobre combo seleccionar una talla
						selenium.click("//div[contains(@class, 'selreplace_selectinner')]");
						//Se selecciona una talla
						talla++;
						if(selenium.isElementPresent("xpath=//div["+fila+"]/div/div/div["+talla+"]")){
							selenium.click("xpath=//div["+fila+"]/div/div/div["+talla+"]");	
							if(selenium.isElementPresent("xpath=//div["+(fila-1)+"]/div[2]/div[4]")){
								selenium.click("xpath=//div["+(fila-1)+"]/div[2]/div[4]");
								inventario=false;
								Helper.log("El producto: "+selenium.getText("xpath=.//*[@id='product-options-wrapper']/dl/div["+i+"]/div[3]/div[3]/a")+
										" no est� en el inventario para la talla:"+selenium.getText("xpath=//div["+fila+"]/div/div/div["+talla+"]"));
							} else {
								inventario=true;
								break;
							}
						} else {
							inventario = true; //producto simple
							break;
						}
						Helper.log("inventario                 *** "+inventario);
					}while(inventario==false);
					fila --;
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
			Helper.log("Se eliminan todos los productos que se han a�adido al carrito de compras");
			while(!selenium.isTextPresent("0 art�culos 0 �")){
				//Remover articulos mientras el carrito no este vac�o
				selenium.click("id=cartHeader");
				selenium.click("class=btn-remove");
				assertTrue(selenium.getConfirmation().matches("�Est� seguro de que desea eliminar este art�culo de la cesta de la compra[\\s\\S]$"));
				selenium.waitForPageToLoad("10000");
			}			
		}
	}
}