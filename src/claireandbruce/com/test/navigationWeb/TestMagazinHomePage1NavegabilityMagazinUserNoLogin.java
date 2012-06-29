package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;

import basics.ClaireandbruceTestCase;


/**
 * Se verifica el correcto  funcionamiento para  el modulo del  magazín que
 * esta en la  ventana  de Pagina  principal,  permite ver  imágenes de los 
 * productos  tanto de el  magazin de manera  general  como  en  detalle  y 
 * permite compras  al instante. En esta prueba se verificara la navegacion
 * a traves del magazin, asi como la correcta adicion al carrito de compras 
 * de los productos seleccionados por el cliente.
 * 
 * @author NEWSHORE
 * CBT30
 * 
 * */
public class TestMagazinHomePage1NavegabilityMagazinUserNoLogin extends ClaireandbruceTestCase{

	
	private String message;

	@Test
	public void CBT30() throws Exception{
		
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
		 //Verifica que las imagenes si esten disponibles en el carrusel
		if(!selenium.isElementPresent("xpath=.//*[@id='carousel-subhome']/ul/li[2]/div/img"))
		{
			Helper.log("No se encuentran imágenes disponibles en el carrusel");
			message="ERROR: THIS ELEMENT NOT FOUND";
			Helper.log(message);
			
		}
		
		//Verifica si los botones de navegacion estan presentes
		if(!selenium.isElementPresent("xpath=//div[@id='carousel-subhome']/div[2]")){
			Helper.log("El botón de navegación no se encuentra");
		}
		
		if(!selenium.isElementPresent("xpath=//div[@id='carousel-subhome']/div[3]")){
			Helper.log("El botón de navegación no se encuentra");
		}
		
		//verifica sin se agregan los productos correctamente al carrito de compras
		
		int n =(int)(Math.random()*(1-1+1)+1);
		int j =(int)(Math.random()*(4-1+1)+1);
	
		Helper.log("Se verifica si se agregan los productos al carrito de compras");
		selenium.click("xpath=//div[2]/div/div/div/div/div/div[2]");
			
		//Se verifica que se encuentre vacío el carrito de compras.
		while(!selenium.isTextPresent("0 artículos 0 €")){
			//Remover artículos mientras el carrito no este vacío
			Helper.log("Se elimina el producto añadido al carrito de compras");
			selenium.click("id=cartHeader");
			selenium.click("class=btn-remove");
			assertTrue(selenium.getConfirmation().matches("¿Está seguro de que desea eliminar este artículo de la cesta de la compra[\\s\\S]$"));
			selenium.waitForPageToLoad("10000");
		}
			
		
		
		// Se hace verificación de que si hay productos en el magazin
		if(!selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[1]/p/map["+n+"]/area["+j+"]")){
			Helper.log("No se encuentra el link de detalle del producto");
		}
			
			selenium.click("xpath=html/body/div/div[2]/div/div/div[1]/div[1]/p/map["+n+"]/area["+j+"]");
				
			selenium.waitForPageToLoad("30000");
			
			int contador = 1;
			int categoria= 1;
			
			//Haga mientras NO encuentre el botón AÑADIR A LA CESTA
			
		
			if(selenium.isElementPresent("xpath=//img[2]")){
				selenium.click("xpath=//img[2]");
				selenium.waitForPageToLoad("15000");
			}
			//Si se encuentra este botón se encuentra visualizado un producto configurable.
			if(selenium.isElementPresent("xpath=//div[9]/div/button"))	{
				//Click sobre combo seleccionar una talla
				Helper.log("Se despliega el combo para seleccionar talla");
				selenium.click("xpath=//div[8]/div[3]/div/div");
					
				int i =(int)(Math.random()*(5-2+1))+2;
				int cont=1;	
				while(!selenium.isElementPresent("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[4]/div/div/div["+i+"]")) {
					Helper.log("Buscando una talla disponible");
					i =(int)(Math.random()*(5-2+1))+2;
					cont++;
					if(cont==4){
						i=2;
						break;
					}
				}
				if(selenium.isElementPresent("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[4]/div/div/div["+i+"]"))
				{//Se selecciona una de las tallas disponibles del producto y se verifica que se seleccionó correctamente
					Helper.log("Se selecciona la talla");
					Helper.clickAndVerify(selenium, "xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[4]/div/div/div["+i+"]",selenium.getText("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[4]/div/div/div["+i+"]") , "xpath=//div[8]/div[3]/div/div");}
				else{									   
					Helper.clickAndVerify(selenium, "xpath=//div[8]/div[3]/div/div",selenium.getText("xpath=//div[8]/div[3]/div/div") , "xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[3]/div/div");
				}
				
				//Clic en botón "AÑADIR A LA CESTA"
				Helper.log("Se ha presionado el botón 'AÑADIR A LA CESTA' se está esperando confirmación de que el producto ha sido añadido a la cesta");
				selenium.click("xpath=//div[9]/div/button");
				//Se comprueba con el producto ha sido agregado a través de su nombre
				Helper.log("Se da clic en el carrito de compras del header");
				selenium.click("id=cartHeader");
				Helper.log("Se verifica que el producto muestra en el carrito de compras");
				String id= "xpath=//a[contains(text(),'"+nombreProducto+"')]";
				if(selenium.isElementPresent(id)){
					Helper.log("El producto ha sido añadido con éxito al carrito de compras");
				} else {
					Helper.log("El producto no ha sido añadido al carrito de compras");
				}
			} else {
				//Se encuentra actualmente en un producto simple
				//Clic en botón "AÑADIR A LA CESTA"
				Helper.log("Clic en el botón 'AÑADIR A LA CESTA' de un producto simple");
				selenium.click("xpath=//button");
				Helper.log(nombreProducto);
				String texto ="";
				//Se comprueba con el precio del producto que este ha sido agregado
				if(selenium.isElementPresent("class=special-price")) {
					Helper.log("Se encuentra el producto con promoción");
					texto = selenium.getText("class=special-price");
				} else {
					texto = selenium.getText("class=price");
				}
				Helper.log("Se verifica que el producto muestra en el carrito de compras");
				String id= "xpath=//a[contains(text(),'"+nombreProducto+"')]";
				if(selenium.isElementPresent(id)){
					Helper.log("El producto ha sido añadido con éxito al carrito de compras");
				} else {
					Helper.log("El producto no ha sido añadido al carrito de compras");
				}				
			}		
	}
}