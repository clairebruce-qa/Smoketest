package claireandbruce.com.test.cartShopping;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT78_Test_CorrectChangeUnits_TuCompra extends ClaireandbruceTestCase {
		
	
	@Test
	public void CBT78() throws Exception{
		
		selenium.open("");
		selenium.waitForPageToLoad("10000");
		//Se define a través de que botón se ingresará a la interfaz Shopping Cart
		if(selenium.isTextPresent("Envío gratis toda España")) {
			//Click en el botón compralo ahora ubicado en el menu desplegable "articulos", se compara con el canvas
			Helper.clickAndVerify(selenium, "css=button.checkout-link", "", "css=h1 > cufon.cufon.cufon-canvas > canvas");
		} else {
			//Click en el botón comprar ahora ubicado debajo del menu desplegable "artículos", se compara con el canvas
			Helper.clickAndVerify(selenium, "xpath=.//*[@id='quick-access']/div[1]/div/a", "", "css=h1 > cufon.cufon.cufon-canvas > canvas");
		}
		
		//Posición del campo cantidad a modificar.
		int fila=2;	
		int filaPrecio=4;
		//Se declaran variables string para separar los caracteres que pertenecen al precio sin unidad de moneda
		String precio, precioTotal;
		while(selenium.isElementPresent("//table[@id='shopping-cart-table']/tbody/tr["+fila+"]/td[2]/input")){
			//Se obtiene cantidad inicial para modificarla anexando una unidad mas
			int cantidad=Integer.parseInt(selenium.getValue("//table[@id='shopping-cart-table']/tbody/tr["+fila+"]/td[2]/input"));	
			cantidad=cantidad+1;
			
			selenium.type("//table[@id='shopping-cart-table']/tbody/tr["+fila+"]/td[2]/input[2]", ""+cantidad);
			selenium.click("xpath=.//*[@id='coupon_code']");
			
			selenium.isConfirmationPresent();
			
			//Se obtienen los valores para verificarlos 
			int cantidadNueva=Integer.parseInt(selenium.getValue("//table[@id='shopping-cart-table']/tbody/tr["+fila+"]/td[2]/input"));
			double precioUnitario, precioTotalProducto;
			
			if(fila==2){
				precio = selenium.getText("//td[4]/span/span");
				precioTotal = selenium.getText("//td[5]/span/span");
			}else {
				precio=selenium.getText("//tr["+filaPrecio+"]/td[4]/span/span");
				precioTotal=selenium.getText("//tr["+filaPrecio+"]/td[5]/span/span");
				filaPrecio=filaPrecio+3;
			}
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
			Helper.log("Cant "+cantidadNueva);
			Helper.log("Precio un "+precioUnitario);
			Helper.log("Precio t "+precioTotalProducto);
			
			DecimalFormat myFormatter = new DecimalFormat("0.00");
			String precioTotalCalculado = myFormatter.format(cantidadNueva*precioUnitario);
			
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
			Helper.log("Precio CAL "+auxPrecioCal);
			assertEquals(precioTotalProducto+"", auxPrecioCal);
			Helper.log("CantidadNueva= "+cantidadNueva+" PrecioUnitario= "+precioUnitario+" precioTotal= "+precioTotalProducto+" assertEquals "+auxPrecioCal);
			fila= fila+3;
		}
	}
}
