package claireandbruce.com.test.cartShopping;

import static org.junit.Assert.assertEquals;
import java.text.DecimalFormat;
import junit.framework.Assert;
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
		
		//Posici�n del campo cantidad a modificar.
		int fila=2;	
		int filaPrecio=4;
		
		//Se declaran variables string para separar los caracteres que pertenecen al precio sin unidad de moneda
		String precio = null, precioTotal;
		int cantidad, cantidadNueva;
		double precioUnitario, precioFinalEsperado;
		//Primer art�culo el cual posee un xpath diferente
		do {
			if(fila==2){
				if(selenium.isElementPresent("xpath=//td[2]/input[2]")){
					cantidad = Integer.parseInt(selenium.getValue("xpath=//td[2]/input[2]"));
					cantidad = cantidad +1;
					selenium.type("xpath=//td[2]/input[2]", ""+cantidad);
					
					cantidadNueva = Integer.parseInt(selenium.getValue("xpath=//td[2]/input[2]"));
					if(selenium.isAlertPresent()){
						Helper.log("UNIDADES NO DISPONIBLES EN INVENTARIO\nSE VISUALIZA MENSAJE DE ALERTA!");
					} else {
						if(selenium.isElementPresent("xpath=//span/div/span/span")){
							precio = selenium.getText("xpath=//span/div/span/span");
						} else if(selenium.isElementPresent("xpath=//span/div/p/span")){
							precio = selenium.getText("xpath=//p[3]/span");
						}
									
						//Se recorren los precios para eliminar referencia a unidad de moneda
						int index=0;
						String auxString="";
						while(index<precio.length()-2){
							if(precio.charAt(index)!=','){
								auxString+=precio.charAt(index);
							} else {
								auxString+=".";
							}
							index++;
						}
						precioUnitario = Double.parseDouble(auxString);
						precioTotal = selenium.getText("//td[5]/span/span");
						auxString="";
						index=0;
						while(index<precioTotal.length()-2) {
							if(precioTotal.charAt(index)!=','){
								auxString+=precioTotal.charAt(index);
							} else {
								auxString+=".";
							}
							index++;					
						}
						String str_precioFinal = auxString;
										
						//Se multiplica la cantidad por el precio unitario para obtener el precio esperado.
						precioFinalEsperado = cantidadNueva*precioUnitario;
		
						//Se transforma a formato de dos decimales
						//Se transforma a formato de dos decimales
						DecimalFormat myFormatter = new DecimalFormat("0.00");
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
						Helper.log("precio esperado "+precioTotalEsperado);
						Helper.log("precio final "+str_precioFinal);
						cantidadNueva = Integer.parseInt(selenium.getValue("xpath=//td[2]/input[2]"));
						assertEquals(str_precioFinal, precioTotalEsperado);
						Helper.log("CantidadNueva= "+cantidadNueva+" PrecioUnitario= "+precioUnitario+" precioTotal= "+str_precioFinal+" assertEquals "+precioTotalEsperado);						
					}	
					fila+=3;
				}
			} else {
				
				cantidad = Integer.parseInt(selenium.getValue("xpath=//tr["+fila+"]/td[2]/input[2]"));
				cantidad = cantidad +1;
				selenium.type("xpath=//tr["+fila+"]/td[2]/input[2]", ""+cantidad);
				
				if(selenium.isAlertPresent()){
					selenium.getAlert();
					Helper.log("UNIDADES NO DISPONIBLES EN INVENTARIO\nSE VISUALIZA MENSAJE DE ALERTA!");
					Assert.fail("UNIDADES NO DISPONIBLES EN INVENTARIO\nSE VISUALIZA MENSAJE DE ALERTA!");
				} else {
					cantidadNueva = Integer.parseInt(selenium.getValue("xpath=//tr["+fila+"]/td[2]/input[2]"));
				
					if(selenium.isElementPresent("xpath=//tr["+filaPrecio+"]/td[4]/span/div/p[3]/span")){
						precio =  selenium.getText("xpath=//tr["+filaPrecio+"]/td[4]/span/div/p[3]/span");
					}else {
						precio = selenium.getText("xpath=//tr["+filaPrecio+"]/td[4]/span/div/span/span");
					}					
					precioTotal = selenium.getText("xpath=//tr["+filaPrecio+"]/td[5]/span/span");
					
					//Se recorren los precios para eliminar referencia a unidad de moneda
					int index=0;
					String auxString="";
					while(index<precio.length()-2){
						if(precio.charAt(index)!=','){
							auxString+=precio.charAt(index);
						} else {
							auxString+=".";
						}
						index++;
					}
					precioUnitario = Double.parseDouble(auxString);
					auxString="";
					index=0;
					while(index<precioTotal.length()-2) {
						if(precioTotal.charAt(index)!=','){
							auxString+=precioTotal.charAt(index);
						} else {
							auxString+=".";
						}
						index++;					
					}
					String str_precioFinal = auxString;
									
					//Se multiplica la cantidad por el precio unitario para obtener el precio esperado.
					precioFinalEsperado = cantidadNueva*precioUnitario;
					//Se transforma a formato de dos decimales
					DecimalFormat myFormatter = new DecimalFormat("0.00");
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
					assertEquals(str_precioFinal, precioTotalEsperado);
					Helper.log("CantidadNueva= "+cantidadNueva+" PrecioUnitario= "+precioUnitario+" precioTotal= "+str_precioFinal+" assertEquals "+precioTotalEsperado);	
				
					filaPrecio+=3;
					fila+=3;
				}				
			}
		
		}while(selenium.isElementPresent("xpath=//tr["+fila+"]/td[2]/input[2]"));		
	}
}