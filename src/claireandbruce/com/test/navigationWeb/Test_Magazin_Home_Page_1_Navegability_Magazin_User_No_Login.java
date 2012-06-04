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
 *  CBT30
 * 
 * */
public class Test_Magazin_Home_Page_1_Navegability_Magazin_User_No_Login extends ClaireandbruceTestCase{

	
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
		
		int n =(int)(Math.random()*(1-1+1)+1);
		int j =(int)(Math.random()*(4-1+1)+1);
	
		selenium.click("xpath=//div[2]/div/div/div/div/div/div[2]");
			
		//Se verifica que se encuentre vacío el carrito de compras.
		while(!selenium.isTextPresent("0 artículos 0 €")){
			//Remover artículos mientras el carrito no este vacío
			selenium.click("id=cartHeader");
			selenium.click("class=btn-remove");
			assertTrue(selenium.getConfirmation().matches("¿Está seguro de que desea eliminar este artículo de la cesta de la compra[\\s\\S]$"));
			selenium.waitForPageToLoad("10000");
		}
			
		
		
		// Se hace verificación de que si hay productos en el magazin
		if(!selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[1]/p/map["+n+"]/area["+j+"]")){
			//Helper.log("No se encuentra el link de detalle del producto");
		}
			
			selenium.click("xpath=html/body/div/div[2]/div/div/div[1]/div[1]/p/map["+n+"]/area["+j+"]");
				
			selenium.waitForPageToLoad("30000");
			
			int contador = 1;
			int categoria= 1;
			
			//Haga mientras NO encuentre el botón AÑADIR A LA CESTA
			
		
			//Si se encuentra este botón se encuentra visualizado un producto configurable.
			if(selenium.isElementPresent("class=selreplace_selectinner"))	{
				//Click sobre combo seleccionar una talla
				selenium.click("class=selreplace_selectinner");
					
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
				{//Se selecciona una de las tallas disponibles del producto y se verifica que se seleccionó correctamente		
					
					Helper.clickAndVerify(selenium, "xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[9]/div[4]/div/div/div["+i+"]",selenium.getText("xpath=//form[@id='product_addtocart_form']/div[3]/div[3]/div/div[9]/div[4]/div/div/div["+i+"]") , "xpath=//div[9]/div[3]/div/div");}
				else{									   
					Helper.clickAndVerify(selenium, "class=selreplace_option",selenium.getText("class=selreplace_option") , "class=selreplace_selectinner");
				}
				
				//Clic en botón "AÑADIR A LA CESTA"

				selenium.click("xpath=//div[9]/div/button");
				Helper.log(nombreProducto);
				String texto ="";
				//Se comprueba con el precio del producto que este ha sido agregado
				if(selenium.isElementPresent("class=special-price")) {
					texto = selenium.getText("class=special-price");
				} else {
					texto = selenium.getText("class=price");
				}
				
				Helper.clickAndVerify(selenium, "id=cartHeader", texto, "xpath=//p[2]/span");
			} else {
				//Se encuentra actualmente en un producto simple
				//Clic en botón "AÑADIR A LA CESTA"

				selenium.click("xpath=//button");
				Helper.log(nombreProducto);
				String texto ="";
				//Se comprueba con el precio del producto que este ha sido agregado
				if(selenium.isElementPresent("class=special-price")) {
					texto = selenium.getText("class=special-price");
				} else {
					texto = selenium.getText("class=price");
				}
				
				Helper.clickAndVerify(selenium, "id=cartHeader", texto, "xpath=//p[2]/span");
			}
				
		
	}
}
