package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;

import basics.ClaireandbruceTestCase;


/**
 * Se verifica el correcto  funcionamiento para  el modulo del  magaz�n que
 * esta en la  ventana  de Pagina  principal,  permite ver  im�genes de los 
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
		 //Verifica que las imagenes si esten disponibles en el carrusel
		if(!selenium.isElementPresent("xpath=.//*[@id='carousel-subhome']/ul/li[2]/div/img"))
		{
			Helper.log("No se encuentran im�genes disponibles en el carrusel");
			message="ERROR: THIS ELEMENT NOT FOUND";
			Helper.log(message);
			
		}
		
		//Verifica si los botones de navegacion estan presentes
		if(!selenium.isElementPresent("xpath=//div[@id='carousel-subhome']/div[2]")){
			Helper.log("El bot�n de navegaci�n no se encuentra");
		}
		
		if(!selenium.isElementPresent("xpath=//div[@id='carousel-subhome']/div[3]")){
			Helper.log("El bot�n de navegaci�n no se encuentra");
		}
		
		//verifica sin se agregan los productos correctamente al carrito de compras
		
		int n =(int)(Math.random()*(1-1+1)+1);
		int j =(int)(Math.random()*(4-1+1)+1);
	
		Helper.log("Se verifica si se agregan los productos al carrito de compras");
		selenium.click("xpath=//div[2]/div/div/div/div/div/div[2]");
			
		//Se verifica que se encuentre vac�o el carrito de compras.
		while(!selenium.isTextPresent("0 art�culos 0 �")){
			//Remover art�culos mientras el carrito no este vac�o
			Helper.log("Se elimina el producto a�adido al carrito de compras");
			selenium.click("id=cartHeader");
			selenium.click("class=btn-remove");
			assertTrue(selenium.getConfirmation().matches("�Est� seguro de que desea eliminar este art�culo de la cesta de la compra[\\s\\S]$"));
			selenium.waitForPageToLoad("10000");
		}
			
		
		
		// Se hace verificaci�n de que si hay productos en el magazin
		if(!selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[1]/p/map["+n+"]/area["+j+"]")){
			Helper.log("No se encuentra el link de detalle del producto");
		}
			
			selenium.click("xpath=html/body/div/div[2]/div/div/div[1]/div[1]/p/map["+n+"]/area["+j+"]");
				
			selenium.waitForPageToLoad("30000");
			
			int contador = 1;
			int categoria= 1;
			
			//Haga mientras NO encuentre el bot�n A�ADIR A LA CESTA
			
		
			if(selenium.isElementPresent("xpath=//img[2]")){
				selenium.click("xpath=//img[2]");
				selenium.waitForPageToLoad("15000");
			}
			//Si se encuentra este bot�n se encuentra visualizado un producto configurable.
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
				{//Se selecciona una de las tallas disponibles del producto y se verifica que se seleccion� correctamente
					Helper.log("Se selecciona la talla");
					Helper.clickAndVerify(selenium, "xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[4]/div/div/div["+i+"]",selenium.getText("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[4]/div/div/div["+i+"]") , "xpath=//div[8]/div[3]/div/div");}
				else{									   
					Helper.clickAndVerify(selenium, "xpath=//div[8]/div[3]/div/div",selenium.getText("xpath=//div[8]/div[3]/div/div") , "xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[3]/div/div");
				}
				
				//Clic en bot�n "A�ADIR A LA CESTA"
				Helper.log("Se ha presionado el bot�n 'A�ADIR A LA CESTA' se est� esperando confirmaci�n de que el producto ha sido a�adido a la cesta");
				selenium.click("xpath=//div[9]/div/button");
				//Se comprueba con el producto ha sido agregado a trav�s de su nombre
				Helper.log("Se da clic en el carrito de compras del header");
				selenium.click("id=cartHeader");
				Helper.log("Se verifica que el producto muestra en el carrito de compras");
				String id= "xpath=//a[contains(text(),'"+nombreProducto+"')]";
				if(selenium.isElementPresent(id)){
					Helper.log("El producto ha sido a�adido con �xito al carrito de compras");
				} else {
					Helper.log("El producto no ha sido a�adido al carrito de compras");
				}
			} else {
				//Se encuentra actualmente en un producto simple
				//Clic en bot�n "A�ADIR A LA CESTA"
				Helper.log("Clic en el bot�n 'A�ADIR A LA CESTA' de un producto simple");
				selenium.click("xpath=//button");
				Helper.log(nombreProducto);
				String texto ="";
				//Se comprueba con el precio del producto que este ha sido agregado
				if(selenium.isElementPresent("class=special-price")) {
					Helper.log("Se encuentra el producto con promoci�n");
					texto = selenium.getText("class=special-price");
				} else {
					texto = selenium.getText("class=price");
				}
				Helper.log("Se verifica que el producto muestra en el carrito de compras");
				String id= "xpath=//a[contains(text(),'"+nombreProducto+"')]";
				if(selenium.isElementPresent(id)){
					Helper.log("El producto ha sido a�adido con �xito al carrito de compras");
				} else {
					Helper.log("El producto no ha sido a�adido al carrito de compras");
				}				
			}		
	}
}