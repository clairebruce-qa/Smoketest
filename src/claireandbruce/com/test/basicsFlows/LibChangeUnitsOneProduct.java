package claireandbruce.com.test.basicsFlows;

import static org.junit.Assert.assertEquals;
import java.text.DecimalFormat;
import junit.framework.Assert;
import lib.Helper;

import com.thoughtworks.selenium.Selenium;

import basics.ClaireandbruceTestCase;

/**
 * Especificación de la prueba en el TestCase  C&BT-110:Test_ChangeUnits_OneProduct
 * @author NEWSHORE
 *
 */
public class LibChangeUnitsOneProduct extends ClaireandbruceTestCase{

	public static void changeUnits(Selenium selenium) throws Exception{
		Helper.log(" ");
		Helper.log("Se inicia proceso de cambio de unidades de un producto");
		if(!selenium.getTitle().equals("Cesta de la Compra")){
			Helper.log("La interfaz actual no corresponde a 'Cesta de la Compra' Se busca el ingreso a ésta");
			if(selenium.isElementPresent("link=Compra ahora")){
				Helper.log("Se ingrea a través del link 'Compra ahora'");
				selenium.click("link=Compra ahora");
				selenium.waitForPageToLoad("20000");
			} else {
				Helper.log("Se ingresa a través del carrito de compras");
				if(!selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
					selenium.click("id=cartHeader");
				}				
				selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
				selenium.waitForPageToLoad("20000");			
			}			
		}		

		//Se declaran variables string para separar los caracteres que pertenecen al precio sin unidad de moneda
		String precioTotal = null;
		if(selenium.isElementPresent("//table[@id='shopping-cart-table']/tbody/tr[2]/td[2]/input")){
			//Se obtiene cantidad inicial para modificarla anexando una unidad mas
			int cantidad=Integer.parseInt(selenium.getValue("//table[@id='shopping-cart-table']/tbody/tr[2]/td[2]/input"));
			int cantidadNueva1 =0;
			cantidadNueva1=cantidad+1;
			Helper.log("Se cambian las unidades actuales "+cantidad+" por "+cantidadNueva1);
			selenium.type("//table[@id='shopping-cart-table']/tbody/tr[2]/td[2]/input[2]", ""+cantidadNueva1);
			
			if(selenium.isAlertPresent()){
				Helper.log("UNIDADES NO DISPONIBLES EN INVENTARIO\nSE VISUALIZA MENSAJE DE ALERTA!");
				Helper.log("Se busca otro producto");
				int producto = (int)(Math.random()*(2-1+1))+1;
				if(producto==1){
					LibCorrectAddProductCartConfigurableProduct.CBT_ConfigurableProduct(selenium);
				} else {
					LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
				}
				LibChangeUnitsOneProduct.changeUnits(selenium);
			} else {
				Helper.log("Se inicia verificación de los precios de acuerdo a la cantidad del producto nueva");
				//Se obtienen los valores para verificarlos 
				int cantidadNueva=Integer.parseInt(selenium.getValue("//table[@id='shopping-cart-table']/tbody/tr[2]/td[2]/input"));
				double precioUnitario, precioTotalProducto;
				
				precioTotal = selenium.getText("//td[5]/span/span");
				
				//Se separan los caracteres que pertenecen a la unidad de moneda 
				int indexChar=0;
				String auxPrecio="";
				while(indexChar <= (precioTotal.length()-2)) {
					if(precioTotal.charAt(indexChar)!= ',' && precioTotal.charAt(indexChar)!='.') {
						auxPrecio+=precioTotal.charAt(indexChar);
					} else if(precioTotal.charAt(indexChar)==','){
						auxPrecio+= ".";
					}					
					indexChar++;
				}
				precioUnitario=Double.parseDouble(auxPrecio);
				precioTotalProducto = precioUnitario;
				precioUnitario=precioUnitario/cantidad;			
				
				DecimalFormat myFormatter = new DecimalFormat("0.00");
				//Se da formato al precio unitario obtenido
				auxPrecio = myFormatter.format(precioUnitario);
				
				//Se cambia la coma por punto para hacer los cálculos necesarios Precio unitario
				int indexCharCal=0;
				String auxPrecioCal="";
				while(indexCharCal < auxPrecio.length()) {
					if(auxPrecio.charAt(indexCharCal)!=',' && auxPrecio.charAt(indexCharCal)!='.'){
						auxPrecioCal+=auxPrecio.charAt(indexCharCal);
					}else if(auxPrecio.charAt(indexCharCal)==','){
						auxPrecioCal+=".";
					}							
					indexCharCal++;
				}
				precioUnitario = Double.parseDouble(auxPrecioCal);
				Helper.log("Precio unitario: "+precioUnitario);
				
				//Se da formato al precio total calculado
				String precioTotalCalculado = myFormatter.format(cantidadNueva*precioUnitario);
				//Se da formato al precio total que se visualiza en la aplicación
				String precioTotalApp = myFormatter.format(precioTotalProducto);
				
				//Se cambia la coma por punto para hacer los cálculos necesarios Precio total calculado
				indexCharCal=0;
				auxPrecioCal="";
				while(indexCharCal < precioTotalCalculado.length()) {
					if(precioTotalCalculado.charAt(indexCharCal)!=',' && precioTotalCalculado.charAt(indexCharCal)!='.'){
						auxPrecioCal+=precioTotalCalculado.charAt(indexCharCal);
					}else if(precioTotalCalculado.charAt(indexCharCal)==','){
						auxPrecioCal+=".";
					}							
					indexCharCal++;
				}
				precioTotalCalculado = auxPrecioCal;
				Helper.log("Precio Total Esperado: "+precioTotalCalculado);
				//Se cambia la coma por punto para hacer los cálculos necesarios precio total visualizado
				indexCharCal=0;
				auxPrecioCal="";
				while(indexCharCal < precioTotalApp.length()) {
					if(precioTotalApp.charAt(indexCharCal)!=',' && precioTotalApp.charAt(indexCharCal)!='.'){
						auxPrecioCal+=precioTotalApp.charAt(indexCharCal);
					}else if(precioTotalApp.charAt(indexCharCal)==','){
						auxPrecioCal+=".";
					}							
					indexCharCal++;
				}
				precioTotalApp = auxPrecioCal;
				Helper.log("Precio total visualizado en la aplicación: "+precioTotalApp);
				assertEquals(precioTotalCalculado, precioTotalApp);
				Helper.log("CantidadNueva= "+cantidadNueva+" PrecioUnitario= "+precioUnitario+" precioTotal= "+precioTotalApp+" PrecioEsperado "+precioTotalCalculado);	
			}					
		} else {
			Assert.fail("ELEMENTO NO ENCONTRADO PARA REALIZAR CAMBIO DE UNIDADES");
		}		
	}
}