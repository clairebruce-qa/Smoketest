package claireandbruce.com.test.cartShopping;

import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT77_Test_IncorrectAddProduct_UnselectedSize_Cart extends ClaireandbruceTestCase {
	
	@Before
	public void beforeTest() throws Exception{
		//Previo ingreso a la pagina c+b
		Claireandbruce.login(selenium,"claireandbruceqa@gmail.com","123456");
		
		//Click en menu Ropa y verificar en miga de pan
		Helper.clickAndVerify(selenium, "css=span > cufon.cufon.cufon-canvas > canvas", "Ropa", "css=span.breadcrumbs-present");
		String texto = selenium.getText("css=div.div-filter > div");
		Helper.clickAndVerify(selenium, "css=div.div-filter > div", texto, "css=span.breadcrumbs-present");
		
		//Se verifica que se encuentre vacío el carrito de compras.
		while(!selenium.isTextPresent("0 artículos 0 €")){
			//Remover articulos mientras el carrito no este vacío
			selenium.click("id=cartHeader");
			selenium.click("class=btn-remove");
			assertTrue(selenium.getConfirmation().matches("¿Está seguro de que desea eliminar este artículo de la cesta de la compra[\\s\\S]$"));
			selenium.waitForPageToLoad("10000");
		}
	}
	
	@Test
	public void CBT77() throws Exception{
		//Se ingresa al primer producto
		String texto = selenium.getText("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul[1]/li[1]/div[3]"); //Nombre de la prenda
		Helper.clickAndVerify(selenium, "//li/div/a/img", texto, "class=breadcrumbs-present");
		
		//Se verifica que el articulo tenga la opcion de seleccionar talla de lo contrario pasa directo al boton añadir a la cesta
		if(selenium.isElementPresent("//div[contains(@class, 'selreplace_selectinner')]")){
			//Click en boton añadir a la cesta
			selenium.click("css=div.add-to-box > div.add-to-cart > button.button");
			//Se comprueba que se muestre el mensaje "ELIGE UNA TALLA"
			selenium.isTextPresent("ELIGE UNA TALLA");	
		}		
	}
	
	@After
	public void afterTest(){
		selenium.stop();
	}

}
