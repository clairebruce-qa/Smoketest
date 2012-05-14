package testcases;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import com.thoughtworks.selenium.Selenium;

import basics.ClaireandbruceTestCase;

public class ShoppingWithoutLogin extends ClaireandbruceTestCase{
	
		//Compra directa
	@Test
	public static void testShoppingWithoutLogin(Selenium selenium) throws Exception {
	
		String message = null;
		String username= "xcvb@gmail.com";
		String password = "asdfgh";
		
		selenium.deleteAllVisibleCookies();		
		selenium.open("");

		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}
		
		Helper.log("Open Homepage");
		
		if(selenium.isTextPresent("Salir")) {
			Claireandbruce.logout(selenium);
		}
		//Helper.clickAndVerify(selenium, "xpath o identificador del objeto sobre el que se hara click", "Texto para verificar", "xpath o identificador del lugar donde se busca la palabra a comparar");
		
		//Click en "ROPA" se realiza la comparacion con el menu lateral izquierdo 
		Helper.clickAndVerify(selenium, "xpath=//*[@id='nav']/li[1]/a/span/cufon/canvas", "Dresses", "xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a[1]/div/div");
		//Click en "Vestidos" se realiza la comparacion con el texto del menu de navegacion
		//Se puede entrar a realizar el click a traves del path del primer item de la lista = selenium.click("xpath=//div[@class='div-filter']");
		Helper.clickAndVerify(selenium, "xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a[1]/div/div", "Dresses", "class=breadcrumbs-present");
		//Click en el primer producto se realiza comparacion con texto seleccionar una talla 
		Helper.clickAndVerify(selenium, "class=product", "Seleccionar una talla", "xpath=.//*[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[3]/div/div[1]");
		//Click en boton añadir a la cesta se compara con el mensaje "ELIGE TALLA"
		Helper.clickAndVerify(selenium, "css=div.add-to-box > div.add-to-cart > button.button", "Elige talla", "id=text-size-error");
	
		//Click sobre combo seleccionar una talla
		selenium.click("//div[contains(@class, 'selreplace_selectinner')]");
		//Se selecciona la primera talla encontrada del producto
		selenium.click("//div[@class='selreplace_option']");
		//Helper.clickAndVerify(selenium, "//div[@class='selreplace_option']", "S", "xpath=.//*[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[3]/div/div[1]");
		//Click en boton añadir a la cesta se compara con el mensaje del menu superior que se despliega
		Helper.clickAndVerify(selenium, "css=div.add-to-box > div.add-to-cart > button.button", "Envío gratis toda España", "css=div.message-top-cartheader");
		
		if(selenium.isTextPresent("Envío gratis toda España")) {
			//Click en el botón compralo ahora ubicado en el menu desplegable "articulos", se compara con el canvas
			Helper.clickAndVerify(selenium, "css=button.checkout-link", "", "css=h1 > cufon.cufon.cufon-canvas > canvas");
		} else {
			//Click en el botón comprar ahora ubicado debajo del menu desplegable "articulos", se compara con el canvas
			Helper.clickAndVerify(selenium, "xpath=.//*[@id='quick-access']/div[1]/div/a", "", "css=h1 > cufon.cufon.cufon-canvas > canvas");
		}
		
		//Se determina si el boton CONTINUA se encuentra
		if(selenium.isElementPresent("(//button[@type='button'])[3]")){
			//Click en el botón "CONTINUA", se compara con el canvas de "¿ERES CLIENTE? ENTRA AHORA" CANVAS--> ENTRA
			Helper.clickAndVerify(selenium, "xpath=(//button[@type='button'])[3]", "", "xpath=//form[@id='login-form']/div/cufon[3]/canvas");
			Claireandbruce.login(selenium, username, password);
		} else { //En caso de no encontrarse el boton CONTINUA se evalua si la posibilidad de esto es que el pedido sea menor a 60 €
			//if(Double.parseDouble(selenium.getText("xpath=.//*[@id='price-checkout-top']/tr/td[2]/strong/span/cufon[1]/cufontext/text()")) < 60.00) {
			
				Helper.log("VALOR "+selenium.getText("xpath=.//*[@id='price-checkout-top']/tr/td[2]/strong/span/cufon[1]/cufontext/text()"));
				
			//}
			
		}
			
		

		/*if(selenium.isElementPresent("class=button btn-proceed-checkout btn-checkout"))
		{
			Helper.log("BOTON CONTINUA PRESENTE");
			selenium.click("//button[@type='button'])[3]");
		} else {
			Helper.log("BOTON CONTINUA NO ESTA PRESENTE");
			Helper.log("CAMPO "+selenium.isElementPresent("document.forms[1].elements[5]"));
			if(selenium.isElementPresent("css=div.extend_image_product")) {
				
			}
		}*/
		
		//Ingreso de informacion de usuario referente a direccion de envio del pedido
		//MailingAddress.testMailingAddress(selenium);
		//Seleccion de facturacion
		//NeedInvoice.testNeedInvoice(selenium);
			
		//selenium.type("document.forms[1].elements[3]", "nom");
		//selenium.type("document.forms[1].elements[4]", "ap");
		//Primera direccion
		//selenium.type("document.forms[1].elements[5]", "cl 1");
		//Segunda direccion
		//selenium.type("document.forms[1].elements[6]", "cl 23");
		//Poblacion
		//selenium.type("document.forms[1].elements[7]", "Barcelona");
		//Helper.log("CAMPO2 "+selenium.isElementPresent("document.forms[1].elements[7]"));
		
			//Provincia
			//selenium.click("css=div.input-box.region > div.selreplace_select");
			//selenium.click("//div[@value='139']");
			//Codigo postal
			//selenium.type("document.forms[1].elements[10]", "1234");
			//Telefono
			//selenium.type("document.forms[1].elements[12]", "56789");
			
			
		
	}

}
