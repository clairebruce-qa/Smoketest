package claireandbruce.com.test.cartShopping;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import lib.Helper;

import org.junit.Test;

//import claireandbruce.com.test.basicosFlujos.Test_CorrectAddProduct_Cart_SimpleProduct;

import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_ConfigurableProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;
import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;

import com.thoughtworks.selenium.Selenium;
import basics.ClaireandbruceTestCase;

public class CBT78_Test_CorrectChangeUnits_TuCompra extends ClaireandbruceTestCase {
		
	@Test
	public void CBT78() throws Exception{
		selenium.open("");
		selenium.waitForPageToLoad("20000");
		//Lib_CorrectLogon_ValidUser_Accout.CBT55(selenium);
		Lib_CorrectAddProduct_Cart_ConfigurableProduct.CBT_ConfigurableProduct(selenium);
		Lib_CorrectAddProduct_Cart_SimpleProduct.CBT_SimpleProduct(selenium);
		
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
		String precio, precioTotal;
		int cantidad, cantidadNueva;
		double precioUnitario, precioFinal = 0, precioFinalEsperado;
		//Primer artículo el cual posee un xpath diferente
		do {
			if(fila==2){
				if(selenium.isElementPresent("xpath=//td[2]/input[2]")){
					cantidad = Integer.parseInt(selenium.getValue("xpath=//td[2]/input[2]"));
					cantidad = cantidad +1;
					selenium.type("xpath=//td[2]/input[2]", ""+cantidad);
					
					if(selenium.isAlertPresent()){
						Helper.log("UNIDADES NO DISPONIBLES EN INVENTARIO\nSE VISUALIZA MENSAJE DE ALERTA!");
					} else {
						precio = selenium.getText("xpath=//td[4]/span/span");
									
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
						precioFinalEsperado = cantidad*precioUnitario;
		
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
					Helper.log("UNIDADES NO DISPONIBLES EN INVENTARIO\nSE VISUALIZA MENSAJE DE ALERTA!");
				} else {
					precio = selenium.getText("xpath=//tr["+filaPrecio+"]/td[4]/span/span");
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
					precioFinalEsperado = cantidad*precioUnitario;
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
					cantidadNueva = Integer.parseInt(selenium.getValue("xpath=//td[2]/input[2]"));
					assertEquals(str_precioFinal, precioTotalEsperado);
					Helper.log("CantidadNueva= "+cantidadNueva+" PrecioUnitario= "+precioUnitario+" precioTotal= "+str_precioFinal+" assertEquals "+precioTotalEsperado);	
				
					filaPrecio+=3;
					fila+=3;
				}				
			}
		
		}while(selenium.isElementPresent("xpath=//tr["+fila+"]/td[2]/input[2]"));		
	}
}