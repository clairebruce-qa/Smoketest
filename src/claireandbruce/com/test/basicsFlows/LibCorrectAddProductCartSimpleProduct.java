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
		
		Helper.log(" ");
		Helper.log("Se busca un producto simple para agregar al carrito de compras");
		Helper.log("Si el producto encontrado es configurable se continuar� con la b�squeda");
		//Se selecciona una categor�a entre Bolsos y Accesorios (Categor�as que poseen productos simples)		
		//Haga mientras encuentre el men� de selecci�n de talla (producto configurable)
		do {

			int categoria = (int) (Math.random()*(5-3+1))+3;
			Helper.log("Buscando categor�a en la posici�n "+categoria+" del men� superior");
			
			if(selenium.isElementPresent("xpath=//ul[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas")){

				Helper.log("Se ingresa a la categor�a ubicada en la posici�n "+categoria+" del men� superior");
				selenium.click("//ul[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas");				

				selenium.waitForPageToLoad("60000");
				Helper.log("Categor�a actual: "+selenium.getTitle());
				if(selenium.getTitle().startsWith("Bolsos") || selenium.getTitle().startsWith("Accesorios")){
					//Selecciona una subcategor�a
					int subcategoria =  (int)(Math.random()*(7))+1; 
					Helper.log("Buscando Subcategor�a en la posici�n "+subcategoria+" del men� lateral izquierdo");
					if(selenium.isElementPresent("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+subcategoria+"]/div/div")){
						
						Helper.log("Se ingresa a la subcategor�a ubicada en la posici�n "+subcategoria+" del men� lateral izquierdo");
						
						selenium.click("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+subcategoria+"]/div/div");
						selenium.waitForPageToLoad("50000");					
							
						//Se selecciona uno de los art�culos de �sta subcategor�a
						int columnaArticulo = (int)(Math.random()*(3))+1;
						int filaArticulo = (int)(Math.random()*(2))+1;
						Helper.log("Subcategor�a actual: "+selenium.getTitle());
						Helper.log("Buscando Producto ubicado en la posici�n columna: "+columnaArticulo+" en la fila: "+filaArticulo);
						if(!selenium.isElementPresent("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a")){
							Helper.log("No se encontro el nombre del producto");
						}
						else{
							nombreProducto = selenium.getText("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a");
							
							selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a");
							Helper.log("Ingresando al producto "+nombreProducto);
							selenium.waitForPageToLoad("60000");
						}
						Helper.log("Producto actual: "+selenium.getTitle());						
					}
				}								
			} 
		} while(!selenium.isElementPresent("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[7]/div/button") );
		
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
		Helper.log("Se busca el bot�n 'A�ADIR A LA CESTA' para agregar el producto al carrito de compras");
		//Clic en bot�n "A�ADIR A LA CESTA"
		selenium.click("xpath=//div[7]/div/button");
		Helper.log("Se ha presionado el bot�n 'A�ADIR A LA CESTA' se est� esperando confirmaci�n de que el producto ha sido a�adido a la cesta");
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