package claireandbruce.com.test.basicsFlows;



import lib.Helper;



import com.thoughtworks.selenium.Selenium;

import basics.ClaireandbruceTestCase;

/**
 * Se automatiza el a�adir un producto simple a la cesta.
 * @author NEWSHORE
 *
 */
public class LibCorrectAddProductCartSimpleProduct extends ClaireandbruceTestCase {

	public static String CBT_SimpleProduct(Selenium selenium) throws Exception {
		
		//Para efecto de la prueba
		//selenium.open(ClaireandbruceUrl);
		//selenium.waitForPageToLoad("30000");
		
		
		int counterOut = 1;
		//Se selecciona una categor�a entre Bolsos y Accesorios (Categor�as que poseen productos simples)		
		//Haga mientras encuentre el men� de selecci�n de talla (producto configurable)
		do {

			int categoria = (int) (Math.random()*(4-3+1))+3;
			Helper.log("Categor�a "+categoria);
			
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
					nombreProducto = selenium.getText("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a");
					if(!selenium.isElementPresent("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a")){
						Helper.log("no se encontro el nombre del producto");
					}
					else{
						selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a");

						selenium.waitForPageToLoad("65000");
					}
					Helper.log("Producto actual: "+selenium.getTitle());						
				}				
			} 
			counterOut = counterOut + 1;
		} while(!selenium.isElementPresent("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[7]/div/button") || counterOut == 10);
		
		/*String texto ="";
		if(selenium.isElementPresent("class=special-price")) {
			texto = selenium.getText("class=special-price");
		} else {
			texto = selenium.getText("class=price");
		}
		//Clic en bot�n "A�ADIR A LA CESTA"
		selenium.click("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[7]/div/button");
		Helper.log(nombreProducto);
		Helper.clickAndVerify(selenium, "id=cartHeader", texto, "xpath=//p[2]/span");
		*/
		
		//Se comprueba con el producto ha sido agregado a trav�s de su nombre
		//Clic en bot�n "A�ADIR A LA CESTA"
		selenium.click("xpath=//div[7]/div/button");
		String id= "xpath=//a[contains(text(),'"+nombreProducto+"')]";
		selenium.click("id=cartHeader");
		if(selenium.isElementPresent(id)){
			Helper.log("El producto ha sido a�adido con �xito al carrito de compras");
		} else {
			Helper.log("El producto no ha sido a�adido al carrito de compras "+id);
		} 
		return nombreProducto;
	}	
}