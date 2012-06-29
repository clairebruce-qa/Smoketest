package claireandbruce.com.test.cartShopping;


import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import basics.ClaireandbruceTestCase;


/**
 *  Este Caso de Prueba verificará el correcto funcionamiento del proceso encargado 
 *  de añadir un producto  a la cesta. El éxito del proceso se evaluará al permitir 
 *  observar el producto en la cesta al hacer clic en el link de artículos  ubicado 
 *  en el header.
 *  @author NEWSHORE
 *  CBT76
 * */


public class TestCorrectAddProductCartNoLoginUser extends ClaireandbruceTestCase {

	@Test
	public void CBT76() throws Exception{
		
		selenium.open("");
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}

		//El usuario no debe tener su sesión iniciada
		if(selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			Claireandbruce.logout(selenium);
		}		
		
		//Se verifica que se encuentre vacío el carrito de compras.
		while(!selenium.isTextPresent("0 artículos 0 €")){
			//Remover artículos mientras el carrito no este vacío
			selenium.click("id=cartHeader");
			selenium.click("class=btn-remove");
			assertTrue(selenium.getConfirmation().matches("¿Está seguro de que desea eliminar este artículo de la cesta de la compra[\\s\\S]$"));
			selenium.waitForPageToLoad("10000");
		}
		
		
		
		//Se selecciona una categoría entre Bolsos, Zapatos y Accesorios (Categorías que poseen productos configurables )
			
		int contador = 1;
		int categoria= 1;
		//Haga mientras NO encuentre el botón AÑADIR A LA CESTA
		
		do {			
			Helper.log("Categoría "+categoria);
			categoria = (int) (Math.random()*(4-1+1))+1;
			if(contador == 4) {
				categoria = 1;
			}
			if(selenium.isElementPresent("xpath=//ul[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas")){
				selenium.click("//ul[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas");
			
				selenium.waitForPageToLoad("30000");
				
				//Selecciona una subcategoría
				int subcategoria =  (int)(Math.random()*(7))+1; 
				Helper.log("Categoría actual: "+selenium.getTitle());
				Helper.log("Subcategoria "+subcategoria);
				if(selenium.isElementPresent("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+subcategoria+"]/div/div")){
										
					selenium.click("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+subcategoria+"]/div/div");
					selenium.waitForPageToLoad("30000");					
						
					//Se selecciona uno de los artículos de ésta subcategoría
					int columnaArticulo = (int)(Math.random()*(3))+1;
					int filaArticulo = (int)(Math.random()*(2))+1;
					Helper.log("Subcategoría actual: "+selenium.getTitle());
					Helper.log("Producto: "+columnaArticulo+" en la fila: "+filaArticulo);
					if(!selenium.isElementPresent("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a")){
						Helper.log("no se encontro el nombre del producto");
					}
					else{
						nombreProducto = selenium.getText("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a");
						selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a");
						selenium.waitForPageToLoad("60000");
					}
				
					Helper.log("Producto actual: "+selenium.getTitle());						
				}				
			}
			contador++;
		} while(!selenium.isElementPresent("xpath=//div[9]/div/button") && !selenium.isElementPresent("xpath=//button") );
		
		//Si se encuentra este botón se encuentra visualizado un producto configurable.
		if(selenium.isElementPresent("xpath=//div[9]/div/button"))	{
			//Click sobre combo seleccionar una talla
			selenium.click("xpath=//div[8]/div[3]/div/div");
				
			int i =(int)(Math.random()*(5-2+1))+2;
			int cont=1;	
			while(!selenium.isElementPresent("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[4]/div/div/div["+i+"]")) {
				i =(int)(Math.random()*(5-2+1))+2;
				cont++;
				if(cont==4){
					i=2;
					break;
				}
			}
			if(selenium.isElementPresent("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[4]/div/div/div["+i+"]"))
			{//Se selecciona una de las tallas disponibles del producto y se verifica que se seleccionó correctamente		
				Helper.clickAndVerify(selenium, "xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[4]/div/div/div["+i+"]",selenium.getText("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[4]/div/div/div["+i+"]") , "xpath=//div[8]/div[3]/div/div");}
			else{									   
				Helper.clickAndVerify(selenium, "xpath=//div[8]/div[3]/div/div",selenium.getText("xpath=//div[8]/div[3]/div/div") , "xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[3]/div/div");
			}
			
			//Clic en botón "AÑADIR A LA CESTA"
			selenium.click("xpath=//div[9]/div/button");
			Helper.log(nombreProducto);
			//String texto ="";
			//Se comprueba con el producto ha sido agregado a través de su nombre
			//Clic en botón "AÑADIR A LA CESTA"
			selenium.click("xpath=//div[9]/div/button");
			selenium.click("id=cartHeader");
			String id= "xpath=//a[contains(text(),'"+nombreProducto+"')]";
			if(selenium.isElementPresent(id)){
				Helper.log("El producto ha sido añadido con éxito al carrito de compras");
			} else {
				Helper.log("El producto no ha sido añadido al carrito de compras");
			}
		} else {
			//Se encuentra actualmente en un producto simple
			//Clic en botón "AÑADIR A LA CESTA"
			selenium.click("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div/button");
			Helper.log("Se ha presionado el botón 'AÑADIR A LA CESTA' se está esperando confirmación de que el producto ha sido añadido a la cesta");
			String id= "xpath=//a[contains(text(),'"+nombreProducto+"')]";
			selenium.click("id=cartHeader");
			if(selenium.isElementPresent(id)){
				Helper.log("El producto ha sido añadido con éxito al carrito de compras");
			} else {
				Helper.log("El producto no ha sido añadido al carrito de compras "+id);
			} 
		}
			
			
	}	
}