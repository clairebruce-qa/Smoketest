package claireandbruce.com.test.basicsFlows;

import lib.Helper;
import com.thoughtworks.selenium.Selenium;
import basics.ClaireandbruceTestCase;

/**
 * Se automatiza el añadir un producto simple a la cesta.
 * @author NEWSHORE
 *
 */
public class LibCorrectAddProductCartConfigurableProduct extends ClaireandbruceTestCase {

	public static String CBT_ConfigurableProduct(Selenium selenium) throws Exception {
		
		Helper.log(" ");
		Helper.log("Se inicia proceso para añadir un producto configurable al carrito de compras");
		Helper.log("Se busca un producto configurable para agregar al carrito de compras");
		Helper.log("Si el producto encontrado es simple se continuará con la búsqueda");
		int categoria = (int) (Math.random()*(4-1+1))+1;
		//Para efecto de la prueba
		//selenium.open(ClaireandbruceUrl);
		//selenium.waitForPageToLoad("30000");

		
		//Se selecciona una categoría entre Bolsos, Zapatos y Accesorios (Categorías que poseen productos configurables )
		
		int contador = 1;
		//Haga mientras encuentre el menú de selección de talla (producto configurable)
		do {			
			Helper.log("Buscando categoría en la posición "+categoria+" del menú superior");
			categoria = (int) (Math.random()*(4-1+1))+1;
			if(contador == 4) {
				categoria = 1;
			}
			if(selenium.isElementPresent("xpath=//ul[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas")){

				Helper.log("Se ingresa a la categoría ubicada en la posición "+categoria+" del menú superior");
				selenium.click("//ul[@id='nav']/li["+categoria+"]/h2/a/span/cufon/canvas");
				
				selenium.waitForPageToLoad("40000");
				
				//Selecciona una subcategoría
				int subcategoria =  (int)(Math.random()*(7))+1; 
				Helper.log("Buscando Subcategoría en la posición "+subcategoria+" del menú lateral izquierdo");
				if(selenium.isElementPresent("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+subcategoria+"]/div/div")){
										
					Helper.log("Se ingresa a la subcategoría ubicada en la posición "+subcategoria+" del menú lateral izquierdo");
					selenium.click("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+subcategoria+"]/div/div");
					selenium.waitForPageToLoad("60000");					
						
					//Se selecciona uno de los artículos de ésta subcategoría
					int columnaArticulo = (int)(Math.random()*(3))+1;
					int filaArticulo = (int)(Math.random()*(2))+1;
					Helper.log("Subcategoría actual: "+selenium.getTitle());
					Helper.log("Buscando Producto ubicado en la posición columna: "+columnaArticulo+" en la fila: "+filaArticulo);
					if(!selenium.isElementPresent("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a")){
						Helper.log("No se encontró el nombre del producto");
					}
					else{
						nombreProducto = selenium.getText("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a");
						Helper.log("Ingresando al producto "+nombreProducto);
						selenium.click("xpath=html/body/div/div[3]/div[1]/div/div[2]/ul["+filaArticulo+"]/li["+columnaArticulo+"]/div[3]/a");
						Helper.log("Esperando carga de la interfaz con el detalle del producto "+nombreProducto);
						selenium.waitForPageToLoad("65000");
					}
				
					Helper.log("Producto actual: "+selenium.getTitle());						
				}				
			}
			contador++;
		} while(!selenium.isElementPresent("xpath=//div[9]/div/button") );
		
		//Si se encuentra este botón se encuentra visualizado un producto configurable.
		Helper.log("Se busca el botón 'AÑADIR A LA CESTA' para agregar el producto al carrito de compras");
		if(selenium.isElementPresent("xpath=//div[9]/div/button"))	{
			//Click sobre combo seleccionar una talla
			Helper.log("Se despliega el combo para seleccionar talla");
			selenium.click("xpath=//div[8]/div[3]/div/div");
				
			int i =(int)(Math.random()*(5-2+1))+2;
			int cont=1;	
			while(!selenium.isElementPresent("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[4]/div/div/div["+i+"]")) {
				Helper.log("Buscando una talla disponible");
				i =(int)(Math.random()*(5-2+1))+2;
				cont++;
				if(cont==4){
					i=2;
					break;
				}
			}
			if(selenium.isElementPresent("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[4]/div/div/div["+i+"]"))
			{//Se selecciona una de las tallas disponibles del producto y se verifica que se seleccionó correctamente
				Helper.log("Se selecciona la talla");
				Helper.clickAndVerify(selenium, "xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[4]/div/div/div["+i+"]",selenium.getText("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[4]/div/div/div["+i+"]") , "xpath=//div[8]/div[3]/div/div");}
			else{									   
				Helper.clickAndVerify(selenium, "xpath=//div[8]/div[3]/div/div",selenium.getText("xpath=//div[8]/div[3]/div/div") , "xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[8]/div[3]/div/div");
			}
			
			//Clic en botón "AÑADIR A LA CESTA"
			Helper.log("Se ha presionado el botón 'AÑADIR A LA CESTA' se está esperando confirmación de que el producto ha sido añadido a la cesta");
			selenium.click("xpath=//div[9]/div/button");
			//Se comprueba con el producto ha sido agregado a través de su nombre
			Helper.log("Se da clic en el carrito de compras del header");
			selenium.click("id=cartHeader");
			Helper.log("Se verifica que el producto muestra en el carrito de compras");
			String id= "xpath=//a[contains(text(),'"+nombreProducto+"')]";
			if(selenium.isElementPresent(id)){
				Helper.log("El producto ha sido añadido con éxito al carrito de compras");
			} else {
				Helper.log("El producto no ha sido añadido al carrito de compras");
			}
		} 
		return nombreProducto;
	}	
}