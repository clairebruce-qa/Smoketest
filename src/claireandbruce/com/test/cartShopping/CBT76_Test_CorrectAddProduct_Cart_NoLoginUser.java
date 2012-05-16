package claireandbruce.com.test.cartShopping;


import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import basics.ClaireandbruceTestCase;


/*
 *  Este Caso de Prueba verificará el correcto funcionamiento del proceso encargado 
 *  de añadir un producto  a la cesta. El éxito del proceso se evaluará al permitir 
 *  observar el producto en la cesta al hacer clic en el link de artículos  ubicado 
 *  en el header.
 *  
 * */

public class CBT76_Test_CorrectAddProduct_Cart_NoLoginUser extends ClaireandbruceTestCase {
	
	@Before
	public void Before() throws Exception{
		
		selenium.open("");
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}

		//El usuario no debe tener su sesión iniciada
		if(selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			Claireandbruce.logout(selenium);
		}
		
		selenium.waitForPageToLoad("15000");
		
		//Se verifica que se encuentre vacío el carrito de compras.
		while(!selenium.isTextPresent("0 artículos 0 €")){
			//Remover artículos mientras el carrito no este vacío
			selenium.click("id=cartHeader");
			selenium.click("class=btn-remove");
			assertTrue(selenium.getConfirmation().matches("¿Está seguro de que desea eliminar este artículo de la cesta de la compra[\\s\\S]$"));
			selenium.waitForPageToLoad("10000");
		}
	}

	@Test
	public void CBT76() throws Exception{
		
		//----> Rango de manera aleatoria <-----
		int i =(int)(Math.random()*(4-2))+2;
		int j =(int)(Math.random()*(4-1))+1;
		//Previo ingreso a la página c+b
		
		
		
		//Clic en una categoria del menu "Header"
		
		//String check = selenium.getText("xpath=3//li[2]/h2/a/span/cufon/canvas");
		
		//Helper.clickAndVerify(selenium, "xpath=//li["+i+"]/h2/a/span/cufon/canvas", check, "css=span.breadcrumbs-present");
		selenium.click("xpath=//li["+j+"]/h2/a/span/cufon/canvas");
		selenium.waitForPageToLoad("60000");
		
	
		selenium.click("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+i+"]/div/div");
		selenium.waitForPageToLoad("30000");
	
	
		
		//Nombre de la prenda
		if(selenium.isElementPresent("//li["+i+"]/div/a/img[2]")){
			
		 String texto = selenium.getText("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul[1]/li["+i+"]/div[3]/a");
			
			Helper.clickAndVerify(selenium, "//li["+i+"]/div/a/img[2]", texto, "class=breadcrumbs-present");
			selenium.waitForPageToLoad("60000");
		
		//Se verifica que el artículo tenga la opción de seleccionar talla de lo contrario pasa directo al boton añadir a la cesta
		//Esto debido a que existen productos simples, y productos configurables
			if(selenium.isElementPresent("//div[contains(@class, 'selreplace_selectinner')]")){
				
				//Click sobre combo seleccionar una talla
				selenium.click("//div[contains(@class, 'selreplace_selectinner')]");
				
				if(selenium.isElementPresent("xpath=/html/body/div/div[3]/div/div/form/div[3]/div[3]/div/div[9]/div[4]/div/div/div["+i+"]"))
				{//Se selecciona la primera talla encontrada del producto y se verifica que se seleccionó correctamente		
				Helper.clickAndVerify(selenium, "xpath=/html/body/div/div[3]/div/div/form/div[3]/div[3]/div/div[9]/div[4]/div/div/div["+i+"]",selenium.getText("xpath=/html/body/div/div[3]/div/div/form/div[3]/div[3]/div/div[9]/div[4]/div/div/div["+i+"]") , "//div[contains(@class, 'selreplace_selectinner')]");}
				else{
					Helper.clickAndVerify(selenium, "//div[contains(@class, 'selreplace_option')]",selenium.getText("//div[contains(@class, 'selreplace_option')]") , "//div[contains(@class, 'selreplace_selectinner')]");
				}
			}
		
		//Clic en botón añadir a la cesta
			
			if(selenium.isElementPresent("css=div.add-to-box > div.add-to-cart > button.button"))
			{
				selenium.click("css=div.add-to-box > div.add-to-cart > button.button");
				//Se comprueba con el precio del producto que este ha sido agregado
				if(selenium.isElementPresent("class=special-price"))
				{
					texto = selenium.getText("class=special-price");
				}
				else
				{
					texto = selenium.getText("class=price");
				}
				
				Helper.clickAndVerify(selenium, "id=cartHeader", texto, "class=price");
			}
			else
			{
				Helper.log("Producto avance de temporada");
			}
		
		
		}
		else
		{
			Helper.log("NO SE ENCONTRO EL PRODUCTO");
		}
		
	}
	
	@After
	public void afterTest(){
		selenium.stop();
	}
}
