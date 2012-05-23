package claireandbruce.com.test.basicosFlujos;

import static org.junit.Assert.assertEquals;
import java.text.DecimalFormat;
import junit.framework.Assert;
import lib.Helper;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

public class Test_ChangeUnits_OneProduct extends ClaireandbruceTestCase{

	@Test
	public void changeUnits() throws Exception{
		selenium.open("http://pre-cb.newshore.es/es_es/checkout/cart/");
		selenium.waitForPageToLoad("10000");
		
		//Posición del campo cantidad a modificar.
		//int fila=2;	
		//int filaPrecio=4;
		
		//Se declaran variables string para separar los caracteres que pertenecen al precio sin unidad de moneda
		String precio, precioTotal;
		if(selenium.isElementPresent("//table[@id='shopping-cart-table']/tbody/tr[2]/td[2]/input")){
			//Se obtiene cantidad inicial para modificarla anexando una unidad mas
			int cantidad=Integer.parseInt(selenium.getValue("//table[@id='shopping-cart-table']/tbody/tr[2]/td[2]/input"));	
			cantidad=cantidad+1;
			
			selenium.type("//table[@id='shopping-cart-table']/tbody/tr[2]/td[2]/input[2]", ""+cantidad);
			
			if(selenium.isAlertPresent()){
				Helper.log("UNIDADES NO DISPONIBLES EN INVENTARIO\nSE VISUALIZA MENSAJE DE ALERTA!");
			} else {
				//Se obtienen los valores para verificarlos 
				int cantidadNueva=Integer.parseInt(selenium.getValue("//table[@id='shopping-cart-table']/tbody/tr[2]/td[2]/input"));
				double precioUnitario, precioTotalProducto;
				
				precio = selenium.getText("//td[4]/span/span");
				precioTotal = selenium.getText("//td[5]/span/span");
				
				//Se separan los caracteres que pertenecen a la unidad de moneda 
				int indexChar=0;
				String auxPrecio="",auxPrecioT="";
				while(indexChar <= (precio.length()-2)) {
					if(precio.charAt(indexChar)!=','){
						auxPrecio+=precio.charAt(indexChar);
					}else {
						auxPrecio+=".";
					}
					if(precioTotal.charAt(indexChar)!=','){
						auxPrecioT+=precioTotal.charAt(indexChar);
					}else {
						auxPrecioT+=".";
					}				
					indexChar++;
				}
				precioUnitario=Double.parseDouble(auxPrecio);
				precioTotalProducto=Double.parseDouble(auxPrecioT);
				
				DecimalFormat myFormatter = new DecimalFormat("0.00");
				String precioTotalCalculado = myFormatter.format(cantidadNueva*precioUnitario);
				String precioTotalApp = myFormatter.format(precioTotalProducto);
				
				//Se cambia la coma por punto para hacer los cálculos necesarios Precio total calculado
				int indexCharCal=0;
				String auxPrecioCal="";
				while(indexCharCal < precioTotalCalculado.length()) {
					Helper.log("aux "+auxPrecioCal);
					if(precioTotalCalculado.charAt(indexCharCal)!=','){
						auxPrecioCal+=precioTotalCalculado.charAt(indexCharCal);
					}else {
						auxPrecioCal+=".";
					}							
					indexCharCal++;
				}
				precioTotalCalculado = auxPrecioCal;
				
				//Se cambia la coma por punto para hacer los cálculos necesarios precio total visualizado
				indexCharCal=0;
				auxPrecioCal="";
				while(indexCharCal < precioTotalApp.length()) {
					Helper.log("aux "+auxPrecioCal);
					if(precioTotalApp.charAt(indexCharCal)!=','){
						auxPrecioCal+=precioTotalApp.charAt(indexCharCal);
					}else {
						auxPrecioCal+=".";
					}							
					indexCharCal++;
				}
				precioTotalApp = auxPrecioCal;
				
				assertEquals(precioTotalApp, auxPrecioCal);
				Helper.log("CantidadNueva= "+cantidadNueva+" PrecioUnitario= "+precioUnitario+" precioTotal= "+precioTotalApp+" assertEquals "+auxPrecioCal);	
			}					
		} else {
			Assert.fail("ELEMENTO NO ENCONTRADO PARA REALIZAR CAMBIO DE UNIDADES");
		}		
	}
}