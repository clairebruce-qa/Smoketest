package claireandbruce.com.test.cartShopping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT76_Test_CorrectAddProduct_Cart_NoLoginUser extends ClaireandbruceTestCase {
	
	@Before
	public void beforeTest() throws Exception{
		//Previo ingreso a la página c+b
		selenium.open("");
		if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
			selenium.click("//a[@id='overridelink']");
		}

		//El usuario no debe tener su sesión iniciada
		if(selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			Claireandbruce.logout(selenium);
		}
		//Click en menu Ropa y verificar en miga de pan
		Helper.clickAndVerify(selenium, "css=span > cufon.cufon.cufon-canvas > canvas", "Ropa", "css=span.breadcrumbs-present");
		String texto = selenium.getText("css=div.div-filter > div");
		Helper.clickAndVerify(selenium, "css=div.div-filter > div", texto, "css=span.breadcrumbs-present");
		
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
	public void test_CorrectAddProduct_Cart_NoLoginUser() throws Exception{
		//Se ingresa en el primer producto
		String texto = selenium.getText("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul[1]/li[1]/div[3]"); //Nombre de la prenda
		Helper.clickAndVerify(selenium, "//li/div/a/img", texto, "class=breadcrumbs-present");
		selenium.waitForPageToLoad("15000");
		
		//Se verifica que el artículo tenga la opción de seleccionar talla de lo contrario pasa directo al boton añadir a la cesta
		//Esto debido a que existen productos simples, y productos configurables
		if(selenium.isElementPresent("//div[contains(@class, 'selreplace_selectinner')]")){
			//Click sobre combo seleccionar una talla
			selenium.click("//div[contains(@class, 'selreplace_selectinner')]");
			//Se selecciona la primera talla encontrada del producto y se verifica que se seleccionó correctamente		
			Helper.clickAndVerify(selenium, "//div[@class='selreplace_option']",selenium.getText("xpath=//div[@class='selreplace_option']") , "//div[contains(@class, 'selreplace_selectinner')]");
		}
		
		//Clic en botón añadir a la cesta
		selenium.click("css=div.add-to-box > div.add-to-cart > button.button");
		//Se comprueba con el precio del producto que este ha sido agregado
		texto = selenium.getText("xpath=//div[5]/div/span/span");
		selenium.isTextPresent("1 artículo "+texto+" €");
	}
	
	@After
	public void afterTest(){
		selenium.stop();
	}
}
