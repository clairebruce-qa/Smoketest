package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;


/*
 * Se verifica el correcto  funcionamiento para  el modulo del  magazín que
 * esta en la  ventana  de Pagina  principal,  permite ver  imágenes de los 
 * productos  tanto de el  magazin de manera  general  como  en  detalle  y 
 * permite compras  al instante. En esta prueba se verificara la navegacion
 * a traves del magazin, asi como la correcta adicion al carrito de compras 
 * de los productos seleccionados por el cliente.
 * 
 * 
 * 
 * */
public class CBT30_Test_Magazin_Home_Page_1_Navegability_Magazin_User_No_Login extends ClaireandbruceTestCase{

	
	private String message;

	@Test
	public void CBT30() throws Exception{
		
		
		selenium.open("");
		
		 if(selenium.isTextPresent("Salir")){
			  Claireandbruce.logout(selenium);
			  
		  }
		 //Verifica que las imagenes si esten disponibles en el carrusel
		if(!selenium.isElementPresent("xpath=.//*[@id='carousel-subhome']/ul/li[2]/div/img"))
		{
			
			message="ERROR: THIS ELEMENT NOT FOUND";
			Helper.log(message);
			
		}
		
		//Verifica si los botones de navegacion estan presentes
		if(!selenium.isElementPresent("xpath=//div[@id='carousel-subhome']/div[2]")){
			Helper.log("El boton de navegacion no se encuentra");
		}
		
		if(!selenium.isElementPresent("xpath=//div[@id='carousel-subhome']/div[3]")){
			Helper.log("El boton de navegacion no se encuentra");
		}
		
		//verifica sin se agregan los productos correctamente al carrito de compras
		
		int i =(int)(Math.random()*(4-1+1)+1);
		
		selenium.click("xpath=//div[@id='carousel-subhome']/div[2]");
		
		if(!selenium.isElementPresent("xpath=//map["+i+"]/area["+i+"]")){
			Helper.log("No se encuentra el link de detalle del producto");
		}
		/*while(selenium.isElementPresent("xpath=.//*[@id='magazine-carousel-content']/p/map["+i+"]/area["+i+"]"))
		{
			
			
		
			//selenium.click("xpath=//map["+i+"]/area["+i+"]");
			
			Helper.waitForElement(selenium, "xpath=.//*[@id='magazine-carousel-content']/p/map["+i+"]/area["+i+"]", "No se encuentra el elemento");
			
			/*String check=selenium.getText("xpath=html/body/div/div[2]/div/div/div/div[1]/p/map["+i+"]/div/div/div[2]/div[2]/div[2]");
			System.out.println(check);
			if(selenium.isElementPresent("//div[contains(@class, 'selreplace_selectinner')]")){
				//Click sobre combo seleccionar una talla
				selenium.click("//div[contains(@class, 'selreplace_selectinner')]");
				//Se selecciona la primera talla encontrada del producto y se verifica que se selecciono correctamente		
				Helper.clickAndVerify(selenium, "//div[@class='selreplace_option']",selenium.getText("xpath=//div[@class='selreplace_option']") , "//div[contains(@class, 'selreplace_selectinner')]");
			}
			Helper.waitForElement(selenium, "css=button.button-shopping-now", "No se encuentra el elemento");
			selenium.click("css=button.button-shopping-now");
			Helper.waitForElement(selenium, "id=cartHeader", "No se encuentra el elemento");
			
			selenium.click("id=cartHeader");
			
			if(selenium.isElementPresent("xpath=.//*[@id='mini-cart']/div/li/div/p[1]/a"))
			{
				if(check.equals(selenium.getText("xpath=.//*[@id='mini-cart']/div/li/div/p[1]/a")))
				{
				
				Helper.log("ADD IN SHOPPING CART:"+check);
				}
			}
			else
			{
				Helper.log("El producto no esta en el inventario :"+check);
			}
			//Helper.clickAndVerify(selenium, "id=cartHeader", check,"xpath=.//*[@id='mini-cart']/div/li/div/p[1]/a");
			
			
			//Elimina todos los productos del Carrito de Compras
			while(!selenium.isTextPresent("0 artículos 0 €")){
				//Remover articulos mientras el carrito no este vacío
				selenium.click("id=cartHeader");
				selenium.click("class=btn-remove");
				assertTrue(selenium.getConfirmation().matches("¿Está seguro de que desea eliminar este artículo de la cesta de la compra[\\s\\S]$"));
				selenium.waitForPageToLoad("10000");
			}
			
			
		}
		}*/
		
	}
}
