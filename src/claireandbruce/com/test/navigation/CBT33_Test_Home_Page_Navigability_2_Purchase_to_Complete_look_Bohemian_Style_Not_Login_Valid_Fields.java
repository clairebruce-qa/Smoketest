package claireandbruce.com.test.navigation;

import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT33_Test_Home_Page_Navigability_2_Purchase_to_Complete_look_Bohemian_Style_Not_Login_Valid_Fields extends ClaireandbruceTestCase {

	@Test
	public void test_Home_Page_Navigability_2_Purchase_to_Complete_look_Bohemian_Style_Not_Login_Valid_Fields () throws Exception{
		//Tener desplegada la interfaz del primer estilo (bohemian-style)
		//selenium.open("bohemian-style.html");
		selenium.open("");
		selenium.waitForPageToLoad("20000");
		//La prueba se realiza solo si el total look se encuentra
		if(selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[3]/div[1]/a/img")){
			selenium.click("xpath=html/body/div/div[2]/div/div/div[1]/div[3]/div[1]/a/img");
			selenium.waitForPageToLoad("15000");
			
			//Se verifica que se encuentren activos los elementos (Compra el total look, Envio y devolucion, Guia de tallas)
			if(selenium.isElementPresent("xpath=.//*[@id='total-look']")){
				Helper.log("Element Tab 'COMPRA EL TOTAL LOOK' present" );
			} else { 
				Helper.log("Element Tab 'COMPRA EL TOTAL LOOK' is not present" );
			}
			if(selenium.isElementPresent("xpath=.//*[@id='product_addtocart_form']/div[2]/div[3]/div[1]/div[1]")){
				Helper.log("Element Tab 'ENVIO Y DEVOLUCION' present" );
			} else {
				Helper.log("Element Tab 'ENVIO Y DEVOLUCION' is not present");
			}
			if(selenium.isElementPresent("xpath=.//*[@id='product_addtocart_form']/div[2]/div[3]/div[1]/div[2]")){
				Helper.log("Element Tab 'GUIA DE TALLAS present" );
			} else {
				Helper.log("Element Tab 'GUIA DE TALLAS' is not present");
			}
			//Se verifica que se encuentre activo el boton Compra el total look
			if(selenium.isElementPresent("xpath=.//*[@id='bundleSummary']/div/div[2]/div/button")) {
				Helper.log("Button 'COMPRAR EL TOTAL LOOK' present" );
			} else {
				Helper.log("Button 'COMPRAR EL TOTAL LOOK' is not present" );
			}
			
			//Si el link Salir se encuentra presente se procede a realizar logout
			if(selenium.isElementPresent("xpath=html/body/div/div[1]/div[1]/div[1]/div/ul/li[3]/a")){
				Claireandbruce.logout(selenium);
			}
			
			int div1 = 2, div2 = 4, cont=1;
			String path="";
			while(selenium.isTextPresent("Seleccionar una talla")){
				//Click en cada menu de despligue de talla tomando como valor max 4 productos por total look
				while(!selenium.isElementPresent("xpath=.//*[@id='product-options-wrapper']/dl/div["+div1+"]/div[3]/div[6]/div["+div2+"]/div/div[1]")){
					cont++;
					
					if(cont==2){
						div2=5;
					} else if(cont==3){
						div2=7;
					} else if(cont==4){
						cont=1;
						div1+=2;
						div2=4;
					}					
				}
				path="xpath=.//*[@id='product-options-wrapper']/dl/div["+div1+"]/div[3]/div[6]/div["+div2+"]/div/div[1]";
				Helper.log("Element in xpath="+path+" present");
				if(selenium.getText(path).equals("Seleccionar una talla")){
					selenium.click(path);
					selenium.click("class=selreplace_option");
					Helper.log("Size selected");
				}			
			}
			div1=2;
			while(selenium.isElementPresent("xpath=//fieldset[@id='product-options-wrapper']/dl/div["+div1+"]/div[3]/div[4]")){
				selenium.click("//fieldset[@id='product-options-wrapper']/dl/div["+div1+"]/div[3]/div[4]");
				selenium.isTextPresent("Cuidados y lavado");
				selenium.click("id=closeinfo");
				div1+=2;
				Helper.log("Links are checked 'Mas sobre este producto' in xpath= "+"//fieldset[@id='product-options-wrapper']/dl/div["+div1+"]/div[3]/div[4]");
			}
			//Click en Envio y Devolucion
			if(selenium.isElementPresent("xpath=.//*[@id='product_addtocart_form']/div[2]/div[3]/div[1]/div[1]")){
				selenium.click("xpath=.//*[@id='product_addtocart_form']/div[2]/div[3]/div[1]/div[1]");
				selenium.isElementPresent("xpath=//div[@id='pop-shipping']/div/h2/cufon/canvas");
				selenium.click("xpath=//div[@id='pop-shipping']/div/div");
				Helper.log("It finds and verifies the operation of the element 'ENVIO Y DEVOLUCION'");
			}else{
				Helper.log("Element 'ENVIO Y DEVOLUCION' not found to test its operation");
			}
			
			//Click en Guia de tallas
			if(selenium.isElementPresent("xpath=//form[@id='product_addtocart_form']/div[2]/div[3]/div/div[2]")){
				selenium.click("xpath=//form[@id='product_addtocart_form']/div[2]/div[3]/div/div[2]");
				selenium.isElementPresent("xpath=//div[@id='size-guide']/p/img");
				//Click afuera
				//selenium.click("xpath=//div");
				Helper.log("It finds and verifies the operation of the element 'GUIA DE TALLAS'");
			} else {
				Helper.log("Element 'GUIA DE TALLAS' not found to test its operation");
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
				Helper.log("Button 'COMPRAR EL TOTAL LOOK' is not present");
			}
			
			String precioTotal;
			precioTotal = selenium.getText("xpath=//div[@id='bundleSummary']/div/div/div/span/span");
				
			if(!selenium.isElementPresent("xpath=//span[2]/span")){
				selenium.click("xpath=//div[@id='top-cart-container']/div/strong");				
			}
			
			if(selenium.getText("xpath=//span[2]/span").equals(precioTotal)){
				Helper.log("Final price of TOTAL LOOK: "+precioTotal+" coincides with the total price of the items added to shopping cart: "+selenium.getText("xpath=//ol[@id='mini-cart']/li/span/span[2]/span"));
				
			} else {
				Helper.log("Final price of TOTAL LOOK: "+precioTotal+" does not match the total price of the items added to shopping cart: "+selenium.getText("xpath=//ol[@id='mini-cart']/li/span/span[2]/span"));
				Helper.log("Annexed the following items to Cart: "+selenium.getText("xpath=//div[@id='top-cart-container']/div/strong"));
			}	
			
			
		} else {
			Helper.log("ARE NOT ACTIVE IMAGES OF TOTAL LOOK FOR TESTING");
		}		
	}
}
