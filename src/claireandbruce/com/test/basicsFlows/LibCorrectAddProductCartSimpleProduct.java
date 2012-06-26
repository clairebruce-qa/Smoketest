package claireandbruce.com.test.basicsFlows;



import lib.Helper;



import com.thoughtworks.selenium.Selenium;

import basics.ClaireandbruceTestCase;

/**
 * Se automatiza el añadir un producto simple a la cesta.
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
		Helper.log("Si el producto encontrado es configurable se continuará con la búsqueda");
		//Se selecciona una categoría entre Bolsos y Accesorios (Categorías que poseen productos simples)		
		//Haga mientras encuentre el menú de selección de talla (producto configurable)
		do {

			int categoria = (int) (Math.random()*(5-3+1))+3;
			Helper.log("Buscando categoría en la posición "+categoria+" del menú superior");
			
			if(selenium.isElementPresent("xpath=//ul[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas")){

				Helper.log("Se ingresa a la categoría ubicada en la posición "+categoria+" del menú superior");
				selenium.click("//ul[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas");				

				selenium.waitForPageToLoad("60000");
				Helper.log("Categoría actual: "+selenium.getTitle());
				if(selenium.getTitle().startsWith("Bolsos") || selenium.getTitle().startsWith("Accesorios")){
					//Selecciona una subcategoría
					int subcategoria =  (int)(Math.random()*(7))+1; 
					Helper.log("Buscando Subcategoría en la posición "+subcategoria+" del menú lateral izquierdo");
					if(selenium.isElementPresent("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+subcategoria+"]/div/div")){
						
						Helper.log("Se ingresa a la subcategoría ubicada en la posición "+subcategoria+" del menú lateral izquierdo");
						
						selenium.click("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+subcategoria+"]/div/div");
						selenium.waitForPageToLoad("50000");					
							
						//Se selecciona uno de los artículos de ésta subcategoría
						int columnaArticulo = (int)(Math.random()*(3))+1;
						int filaArticulo = (int)(Math.random()*(2))+1;
						Helper.log("Subcategoría actual: "+selenium.getTitle());
						Helper.log("Buscando Producto ubicado en la posición columna: "+columnaArticulo+" en la fila: "+filaArticulo);
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
		//Clic en botón "AÑADIR A LA CESTA"
		selenium.click("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[7]/div/button");
		Helper.log(nombreProducto);
		Helper.clickAndVerify(selenium, "id=cartHeader", texto, "xpath=//p[2]/span");
		*/
		
		//Se comprueba con el producto ha sido agregado a través de su nombre
		Helper.log("Se busca el botón 'AÑADIR A LA CESTA' para agregar el producto al carrito de compras");
		//Clic en botón "AÑADIR A LA CESTA"
		selenium.click("xpath=//div[7]/div/button");
		Helper.log("Se ha presionado el botón 'AÑADIR A LA CESTA' se está esperando confirmación de que el producto ha sido añadido a la cesta");
		String id= "xpath=//a[contains(text(),'"+nombreProducto+"')]";
		selenium.click("id=cartHeader");
		if(selenium.isElementPresent(id)){
			Helper.log("El producto ha sido añadido con éxito al carrito de compras");
		} else {
			Helper.log("El producto no ha sido añadido al carrito de compras "+id);
		} 
		return nombreProducto;
	}	
}