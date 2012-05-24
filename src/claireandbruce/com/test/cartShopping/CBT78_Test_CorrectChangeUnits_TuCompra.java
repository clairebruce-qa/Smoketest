package claireandbruce.com.test.cartShopping;

import java.text.DecimalFormat;
import com.thoughtworks.selenium.Selenium;
import basics.ClaireandbruceTestCase;

public class CBT78_Test_CorrectChangeUnits_TuCompra extends ClaireandbruceTestCase {
		
	public void CBT78(Selenium selenium) throws Exception{
		
		selenium.open("http://pre-cb.newshore.es/es_es/checkout/cart/");
		selenium.waitForPageToLoad("10000");
		//Posición del campo cantidad a modificar.
		int fila=2;	
		int filaPrecio=4;
		
		//Se declaran variables string para separar los caracteres que pertenecen al precio sin unidad de moneda
		String precio, precioTotal;
		int cantidad, cantidadNueva;
		double precioUnitario, precioFinal;
		//Primer artículo el cual posee un xpath diferente
		if(fila==2){
			if(selenium.isElementPresent("xpath=//td[2]/input[2]")){
				cantidad = Integer.parseInt(selenium.getValue("xpath=//td[2]/input[2]"));
				cantidad = cantidad +1;
				selenium.type("xpath=//td[2]/input[2]", ""+cantidad);
				
				precio = selenium.getText("//td[4]/span/span");
				precioTotal = selenium.getText("//td[5]/span/span");
				
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
				index=0;
				while(index<precioTotal.length()-2) {
					if(precioTotal.charAt(index)!=','){
						auxString+=precioTotal.charAt(index);
					} else {
						auxString+=".";
					}
					index++;					
				}
				precioFinal = Double.parseDouble(auxString);
								
				//Se multiplica la cantidad por el precio unitario para obtener el precio esperado.
				precioFinal = cantidad*Double.parseDouble(precio);

				//Se transforma a formato de dos decimales
				DecimalFormat myFormatter = new DecimalFormat("0.00");
				String precioTotalEsperado = precioFinal+"";
				//Se recorre el valor para cambiar comas por puntos
			}
		} else {
			
		}
	}
}
