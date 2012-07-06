package claireandbruce.com.test.cartShopping;

import static org.junit.Assert.assertEquals;
import java.text.DecimalFormat;
import lib.Helper;
import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartConfigurableProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import basics.ClaireandbruceTestCase;
/**
 * 
 * @author NEWSHORE
 * Testlink: Local CBT78  - Privalia CBT15
 */
public class TestCorrectChangeUnitsAccount extends ClaireandbruceTestCase {
		
	@Test
	public void cbt15() throws Exception{
		
		selenium.open("");
		selenium.waitForPageToLoad("20000");
		LibCorrectAddProductCartConfigurableProduct.CBT_ConfigurableProduct(selenium);
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		
		if(!selenium.getTitle().equals("Cesta de la Compra")){
			if(selenium.isElementPresent("link=Compra ahora")){
				selenium.click("link=Compra ahora");
				selenium.waitForPageToLoad("15000");
			} else {
				selenium.click("id=cartHeader");
				selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
				selenium.waitForPageToLoad("15000");			
			}			
		}	
		
		//Posición del campo cantidad a modificar.
		int fila=2;	
		int filaPrecio=4;
		
		//Se declaran variables string para separar los caracteres que pertenecen al precio sin unidad de moneda
		String precioTotal;
		int cantidad;
		double precioUnitario, precioFinalEsperado;
		//Primer artículo el cual posee un xpath diferente
		do {
			if(fila==2){
				if(selenium.isElementPresent("xpath=//td[2]/input[2]")){
				
					cantidad = Integer.parseInt(selenium.getValue("xpath=//td[2]/input[2]"));
					int cantidadNueva1=cantidad+1;
					selenium.type("xpath=//td[2]/input[2]", ""+cantidadNueva1);
					
					cantidadNueva1 = Integer.parseInt(selenium.getValue("xpath=//td[2]/input[2]"));
					if(selenium.isAlertPresent()){
						Helper.log("UNIDADES NO DISPONIBLES EN INVENTARIO\nSE VISUALIZA MENSAJE DE ALERTA!");
						selenium.getAlert();
						Helper.log("Se elimina el producto y se busca otro producto");
						selenium.click("link=Eliminar");
						TestCorrectChangeUnitsAccount test = new TestCorrectChangeUnitsAccount();
						test.cbt15();
					} else {
						precioTotal = selenium.getText("//td[5]/span/span");
						//Se recorren los precios para eliminar referencia a unidad de moneda
						int index=0;
						String auxString="";
						while(index<precioTotal.length()-2){
							if(precioTotal.charAt(index)!=','){
								auxString+=precioTotal.charAt(index);
							} else {
								auxString+=".";
							}
							index++;
						}
						precioUnitario = Double.parseDouble(auxString);
						precioTotal = ""+precioUnitario;
						precioUnitario = precioUnitario/cantidad;
						
						DecimalFormat myFormatter = new DecimalFormat("0.00");
						//Se da formato al precio unitario obtenido
						String auxPrecio = myFormatter.format(precioUnitario);
						
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
						
						int cantidadNueva = Integer.parseInt(selenium.getValue("xpath=//td[2]/input[2]"));				
						//Se multiplica la cantidad por el precio unitario para obtener el precio esperado.
						precioFinalEsperado = cantidadNueva*precioUnitario;
		
						//Se transforma a formato de dos decimales
						String precioTotalEsperado = myFormatter.format(precioFinalEsperado);
						//Se recorre el valor para cambiar comas por puntos
						
						index=0;
						auxString="";
						while(index<precioTotalEsperado.length()) {
							if(precioTotalEsperado.charAt(index)!=','){
								auxString+=precioTotalEsperado.charAt(index);
							} else {
								auxString+=".";
							}
							index++;					
						}
						precioTotalEsperado = auxString;
						Helper.log("Precio Esperado "+precioTotalEsperado);
						Helper.log("Precio Final "+precioTotal);
						cantidadNueva = Integer.parseInt(selenium.getValue("xpath=//td[2]/input[2]"));
						assertEquals(precioTotal, precioTotalEsperado);
						Helper.log("CantidadNueva= "+cantidadNueva+" PrecioUnitario= "+precioUnitario+" precioTotal= "+precioTotal+" assertEquals "+precioTotalEsperado);						
					}	
					fila+=3;
				}
			} else {
				
				cantidad = Integer.parseInt(selenium.getValue("xpath=//tr["+fila+"]/td[2]/input[2]"));
				cantidad = cantidad +1;
				selenium.type("xpath=//tr["+fila+"]/td[2]/input[2]", ""+cantidad);
				
				if(selenium.isAlertPresent()){
					Helper.log("UNIDADES NO DISPONIBLES EN INVENTARIO\nSE VISUALIZA MENSAJE DE ALERTA!");
					selenium.getAlert();
					Helper.log("Se elimina el producto y se busca otro producto");
					selenium.click("link=Eliminar");
					TestCorrectChangeUnitsAccount test = new TestCorrectChangeUnitsAccount();
					test.cbt15();
				} else {
					int cantidadNueva = Integer.parseInt(selenium.getValue("xpath=//tr["+fila+"]/td[2]/input[2]"));
				
					precioTotal = selenium.getText("xpath=//tr["+filaPrecio+"]/td[5]/span/span");
					
					//Se recorren los precios para eliminar referencia a unidad de moneda
					int index=0;
					String auxString="";
					while(index<precioTotal.length()-2){
						if(precioTotal.charAt(index)!=','){
							auxString+=precioTotal.charAt(index);
						} else {
							auxString+=".";
						}
						index++;
					}
					precioUnitario = Double.parseDouble(auxString);
					DecimalFormat myFormatter = new DecimalFormat("0.00");
					//Se da formato al precio unitario obtenido
					String auxPrecio = myFormatter.format(precioUnitario);
					
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
					
					precioTotal = ""+precioUnitario;
					precioUnitario = precioUnitario/cantidad;					
									
					//Se multiplica la cantidad por el precio unitario para obtener el precio esperado.
					precioFinalEsperado = cantidadNueva*precioUnitario;
					//Se transforma a formato de dos decimales
					String precioTotalEsperado = myFormatter.format(precioFinalEsperado);
					//Se recorre el valor para cambiar comas por puntos
					
					index=0;
					auxString="";
					while(index<precioTotalEsperado.length()) {
						if(precioTotalEsperado.charAt(index)!=','){
							auxString+=precioTotalEsperado.charAt(index);
						} else {
							auxString+=".";
						}
						index++;					
					}
					precioTotalEsperado = auxString;
					cantidadNueva = Integer.parseInt(selenium.getValue("xpath=//tr["+fila+"]/td[2]/input[2]"));
					assertEquals(precioTotal, precioTotalEsperado);
					Helper.log("CantidadNueva= "+cantidadNueva+" PrecioUnitario= "+precioUnitario+" precioTotal= "+precioTotal+" assertEquals "+precioTotalEsperado);	
				
					filaPrecio+=3;
					fila+=3;
				}				
			}
		
		}while(selenium.isElementPresent("xpath=//tr["+fila+"]/td[2]/input[2]"));		
	}
}