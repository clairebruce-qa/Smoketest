package claireandbruce.com.test.basicsFlows;

import static org.junit.Assert.assertTrue;
import lib.Helper;
import com.thoughtworks.selenium.Selenium;
import basics.ClaireandbruceTestCase;

/**
 * Se automatiza el a�adir un producto simple a la cesta.
 * @author MARIA FERNANDA RODRIGUEZ
 *
 */
public class Lib_CorrectAddProduct_Cart_ConfigurableProduct extends ClaireandbruceTestCase {

	public static String CBT_ConfigurableProduct(Selenium selenium) throws Exception {
		
		int categoria = (int) (Math.random()*(4-1+1))+1;
		//Para efecto de la prueba
		selenium.open(ClaireandbruceUrl);
		selenium.waitForPageToLoad("30000");
		
		//Se verifica que el carrito este vacio 
		while(!selenium.isTextPresent("0 art�culos 0 �")){
			
			//Remover  todos los art�culos mientras el carrito no este vac�o
			selenium.click("id=cartHeader");
			selenium.click("class=btn-remove");
			assertTrue(selenium.getConfirmation().matches("�Est� seguro de que desea eliminar este art�culo de la cesta de la compra[\\s\\S]$"));
			selenium.waitForPageToLoad("10000");
		}
		
		
		//Se selecciona una categor�a entre Bolsos, Zapatos y Accesorios (Categor�as que poseen productos configurables )
		
		
		//Haga mientras encuentre el men� de selecci�n de talla (producto configurable)
		do {			
			Helper.log("Categor�a "+categoria);
			categoria = (int) (Math.random()*(4-1+1))+1;
			
			if(selenium.isElementPresent("xpath=//ul[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas")){

				selenium.click("//ul[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas");
				
				selenium.waitForPageToLoad("30000");
				
				//Selecciona una subcategor�a
				int subcategoria =  (int)(Math.random()*(7))+1; 
				Helper.log("Categor�a actual: "+selenium.getTitle());
				Helper.log("Subcategoria "+subcategoria);
				if(selenium.isElementPresent("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+subcategoria+"]/div/div")){
										
					selenium.click("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+subcategoria+"]/div/div");
					selenium.waitForPageToLoad("30000");					
						
					//Se selecciona uno de los art�culos de �sta subcategor�a
					int columnaArticulo = (int)(Math.random()*(3))+1;
					int filaArticulo = (int)(Math.random()*(2))+1;
					Helper.log("Subcategor�a actual: "+selenium.getTitle());
					Helper.log("Producto: "+columnaArticulo+" en la fila: "+filaArticulo);
					if(!selenium.isElementPresent("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a")){
						Helper.log("no se encontro el nombre del producto");
					}
					else{
						nombreProducto = selenium.getText("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a");
						selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a");
						selenium.waitForPageToLoad("55000");
					}
				
					Helper.log("Producto actual: "+selenium.getTitle());						
				}				
			} 
		} while(!selenium.isElementPresent("xpath=//div[9]/div[3]/div/div") && !selenium.isElementPresent("xpath=//div[10]/div/button") );
		
		if(selenium.isElementPresent("class=selreplace_select"))
		{
			//Click sobre combo seleccionar una talla
			selenium.click("xpath=//div[9]/div[3]/div/div");
				
			int i =(int)(Math.random()*(5-2+1))+2;
			int cont=1;	
			while(!selenium.isElementPresent("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[9]/div[4]/div/div/div["+i+"]")) {
				i =(int)(Math.random()*(5-2+1))+2;
				cont++;
				if(cont==4){
					i=2;
					break;
				}
				Helper.log("talla "+i);
			}
			if(selenium.isElementPresent("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[9]/div[4]/div/div/div["+i+"]"))
			{//Se selecciona una de las tallas disponibles del producto y se verifica que se seleccion� correctamente		
				Helper.clickAndVerify(selenium, "xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[9]/div[4]/div/div/div["+i+"]",selenium.getText("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[9]/div[4]/div/div/div["+i+"]") , "xpath=//div[9]/div[3]/div/div");}
			else{									   
					Helper.clickAndVerify(selenium, "xpath=//div[9]/div[3]/div/div",selenium.getText("xpath=//div[9]/div[3]/div/div") , "xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[9]/div[3]/div/div");
				}
				
			//Clic en bot�n "A�ADIR A LA CESTA"

			selenium.click("xpath=//div[10]/div/button");
			Helper.log(nombreProducto);
			String texto ="";
			//Se comprueba con el precio del producto que este ha sido agregado
			if(selenium.isElementPresent("class=special-price")) {
				texto = selenium.getText("class=special-price");
			} else {
				texto = selenium.getText("class=price");
			}
			
			Helper.clickAndVerify(selenium, "id=cartHeader", texto, "class=price");
		} 
		return nombreProducto;
	}	
}