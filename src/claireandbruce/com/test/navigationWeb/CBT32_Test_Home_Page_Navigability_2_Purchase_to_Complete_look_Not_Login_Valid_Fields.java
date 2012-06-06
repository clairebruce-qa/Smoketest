package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT32_Test_Home_Page_Navigability_2_Purchase_to_Complete_look_Not_Login_Valid_Fields extends ClaireandbruceTestCase {

	@Test
	public void CBT32 () throws Exception{
		//Tener desplegada la interfaz del primer estilo (bohemian-style)
		//selenium.open("bohemian-style.html");
		selenium.open("");
		selenium.waitForPageToLoad("20000");
		
		//Si el link Salir se encuentra presente se procede a realizar logout
		if(selenium.isElementPresent("xpath=html/body/div/div[1]/div[1]/div[1]/div/ul/li[3]/a")){
			Claireandbruce.logout(selenium);
		}
		
		int contador=2;
		while(contador<5){
			if(contador==2){
				selenium.click("xpath=html//div/a/img");
				selenium.waitForPageToLoad("15000");
			} else {
				selenium.click("xpath=//div["+contador+"]/div/a/img");
				selenium.waitForPageToLoad("15000");
			}
			
			//Se verifica que se encuentren activos los elementos (Compra el total look, Envio y devolucion, Guia de tallas)
			if(selenium.isElementPresent("xpath=.//*[@id='total-look']")){
				Helper.log("Pestaña 'COMPRA EL TOTAL LOOK' presente" );
			} else { 
				Helper.log("Pestaña 'COMPRA EL TOTAL LOOK' no está presente" );
			}
			if(selenium.isElementPresent("xpath=.//*[@id='product_addtocart_form']/div[2]/div[3]/div[1]/div[1]")){
				Helper.log("Link 'ENVÍO Y DEVOLUCIÓN' presente" );
			} else {
				Helper.log("Link 'ENVÍO Y DEVOLUCIÓN' no está presente");
			}
			if(selenium.isElementPresent("xpath=.//*[@id='product_addtocart_form']/div[2]/div[3]/div[1]/div[2]")){
				Helper.log("Link 'GUÍA DE TALLAS presente" );
			} else {
				Helper.log("Link 'GUÍA DE TALLAS' no está presente");
			}
			//Se verifica que se encuentre activo el boton Compra el total look
			if(selenium.isElementPresent("xpath=.//*[@id='bundleSummary']/div/div[2]/div/button")) {
				Helper.log("Botón 'COMPRAR EL TOTAL LOOK' presente" );
			} else {
				Helper.log("Botón 'COMPRAR EL TOTAL LOOK' no está presente" );
			}
						
			int div1 = 2, div2 = 4, cont=1;
			String path="";
			while(selenium.isTextPresent("Seleccionar una talla")){
				//Click en cada menu de despligue de talla tomando como valor max 4 productos por total look
				selenium.click("css=div.selreplace_selectbutton");
				selenium.click("//fieldset[@id='product-options-wrapper']/dl/div[4]/div[3]/div[6]/div[9]/div/div/div[2]");
				Helper.log("Talla seleccionada");							
			}
			div1=2;
			while(selenium.isElementPresent("xpath=//fieldset[@id='product-options-wrapper']/dl/div["+div1+"]/div[3]/div[4]")){
				selenium.click("//fieldset[@id='product-options-wrapper']/dl/div["+div1+"]/div[3]/div[4]");
				selenium.isTextPresent("Cuidados y lavado");
				selenium.click("id=closeinfo");
				div1+=2;
				//Helper.log("Links are checked 'Mas sobre este producto' in xpath= "+"//fieldset[@id='product-options-wrapper']/dl/div["+div1+"]/div[3]/div[4]");
			}
			//Click en Envio y Devolucion
			if(selenium.isElementPresent("xpath=.//*[@id='product_addtocart_form']/div[2]/div[3]/div[1]/div[1]")){
				selenium.click("xpath=.//*[@id='product_addtocart_form']/div[2]/div[3]/div[1]/div[1]");
				selenium.isElementPresent("xpath=//div[@id='pop-shipping']/div/h2/cufon/canvas");
				selenium.click("xpath=//div[@id='pop-shipping']/div/div");
				Helper.log("Link 'ENVÍO Y DEVOLUCIÓN' encontrado y verificado");
			}else{
				Helper.log("Link 'ENVÍO Y DEVOLUCIÓN' no se encontró para realizar la prueba");
			}
			
			//Click en Guia de tallas
			if(selenium.isElementPresent("xpath=//form[@id='product_addtocart_form']/div[2]/div[3]/div/div[2]")){
				selenium.click("xpath=//form[@id='product_addtocart_form']/div[2]/div[3]/div/div[2]");
				selenium.isElementPresent("xpath=//div[@id='size-guide']/p/img");
				//Click afuera
				//selenium.click("xpath=//div");
				Helper.log("'GUÍA DE TALLAS' Link verificado");
			} else {
				Helper.log("'GUÍA DE TALLAS' Link no encontrado para realizar la verificación de éste");
			}
			
			//Se verifica que se encuentre vacío el carrito de compras. Para mayor facilidad al comprobar la cantidad de articulos ingresados
			while(!selenium.isTextPresent("0 artículos 0 €")){
				//Remover articulos mientras el carrito no este vacío
				selenium.click("id=cartHeader");
				selenium.click("class=btn-remove");
				assertTrue(selenium.getConfirmation().matches("¿Está seguro de que desea eliminar este artículo de la cesta de la compra[\\s\\S]$"));
				selenium.waitForPageToLoad("10000");
			}
			
			if(selenium.isElementPresent("xpath=//div[@id='bundleSummary']/div/div[2]/div/button")){
				selenium.click("xpath=//div[@id='bundleSummary']/div/div[2]/div/button");
				selenium.waitForPageToLoad("30000");
			}else {
				Helper.log("Botón 'COMPRAR EL TOTAL LOOK' no está presente");
			}
			
			String precioTotal;
			precioTotal = selenium.getText("xpath=//div[@id='bundleSummary']/div/div/div/span/span");
				
			if(!selenium.isElementPresent("xpath=//span[2]/span")){
				selenium.click("xpath=//div[@id='top-cart-container']/div/strong");				
			}
			
			if(selenium.getText("xpath=//span[2]/span").equals(precioTotal)){
				Helper.log("Precio final del 'TOTAL LOOK': "+precioTotal+" coincide con el precio total de los artículos añadidos al carrito de compras: "+selenium.getText("xpath=//ol[@id='mini-cart']/li/span/span[2]/span"));				
			} else {
				Helper.log("Precio final del 'TOTAL LOOK': "+precioTotal+" no coincide con el precio total de los artículos añadidos al carrito de compras: "+selenium.getText("xpath=//ol[@id='mini-cart']/li/span/span[2]/span"));
				Helper.log("Artículos añadidos al carrito de compras: "+selenium.getText("xpath=//div[@id='top-cart-container']/div/strong"));
			}	
			//Se regresa a home
			selenium.click("xpath=//img[contains(@src,'http://static-pre-cb.newshore.es/skin/frontend/cb/cb/images/logo.png')]");
			selenium.waitForPageToLoad("15000");
			contador++;
		}			
	}
}
