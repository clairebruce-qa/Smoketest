package claireandbruce.com.test.basicsFlows;

import java.text.DecimalFormat;

import junit.framework.Assert;
import lib.Helper;
import org.junit.Test;

import com.thoughtworks.selenium.Selenium;

import basics.ClaireandbruceTestCase;

/**
 * Seleccón aleatoria de un tipo de envío del pedido entre 
 * Envío Standard(1) y Envío Express(2)
 * 
 * En ocasiones presenta inconvenientes al no encontrar el elemento mostrando el mensaje:
 * " ERROR: Command execution failure. Please search the user group at https://groups.google.com/
 *   forum/#!forum/selenium-users for error details from the log window.  The error message is: Acceso denegado."
 * Pero en una segunda ejecución no presenta dicho inconveniente.
 * @author NEWSHORE
 * Especificacion en el test case C&BT-112:Test_TypeShipping 
 */
public class Test_TypeShipping extends ClaireandbruceTestCase {

	public static void typeShipping(Selenium selenium){
		
		if(selenium.isAlertPresent()){
			selenium.getAlert();
		}
		//Para efectos de la prueba unitaria
		selenium.open("http://pre-cb.newshore.es/es_es/checkout/cart/");
		selenium.waitForPageToLoad("20000");
		//Test_CorrectAddProduct_Cart_SimpleProduct test = new Test_CorrectAddProduct_Cart_SimpleProduct();
		
		//Se verifica que el carrito no este vacío
		if(!selenium.isTextPresent("El carrito de compras está vacío")){
			//Se selecciona un tipo de envío
			int tipoEnvio = (int)(Math.random()*(2-1+1))+1;
			String precioTotalCalculado = "";
						
			//Se obtiene el subtotal para separar los caracteres que corresponden a la moneda del subtotal
			String auxString = selenium.getText("id=total-price-page-checkout");
			String str_subtotal="";
			int index = 0;
			while(index < auxString.length()-2) {
				if(auxString.charAt(index)!= ',') {
					str_subtotal+=auxString.charAt(index);
				} else {
					str_subtotal+= ".";
				}	
				index++;
			}
			
			double subtotal = Double.parseDouble(str_subtotal);			
			double valorEnvio = 0.00;		
			String str_valorEnvio ="";
			
			double total=0.00;
			
			//Envío 1= Standard - Envío 2= Express
			if(tipoEnvio==1){
				Helper.log("TIPO DE ENVÍO STANDARD");
				//selenium.click("xpath=.//*[@id='s_method_flatrate_flatrate']");
				//selenium.waitForPageToLoad("10000");
				//Clic sobre tipo de envío Standard
				//selenium.click("xpath=.//*[@id='s_method_flatrate_flatrate']");
				//selenium.waitForPageToLoad("10000");
				
				//Obtener valor de envío Standard
				auxString = selenium.getText("css=div.value-method-checkout.float-right > span.price");
				//Se eliminan comas presentes, cambian por puntos para realizar los cálculos necesarios del valor de Envío
				index = 0;
				while(index < auxString.length()-2){
					if(auxString.charAt(index)!=','){
						str_valorEnvio += auxString.charAt(index);
					} else {
						str_valorEnvio += '.';
					}					
					index++;
				}
				valorEnvio = Double.parseDouble(str_valorEnvio);
				//Helper.log("VALOR ENVÍO "+valorEnvio);
				//Total = subtotal + valorEnvio
				total = subtotal+valorEnvio;
				DecimalFormat myFormatter = new DecimalFormat("0.00");
				precioTotalCalculado = myFormatter.format(total);			
				
			} else {
				Helper.log("TIPO DE ENVÍO EXPRESS");
				//Clic en tipo de envío Express
				selenium.click("xpath=.//*[@id='s_method_tablerate_bestway']");
				selenium.waitForPageToLoad("10000");
				
				//Se obtiene el valor de este tipo de envío
				auxString = selenium.getText("//dd[2]/ul/li/div/div/span");				
				//Se eliminan comas presentes, cambian por puntos para realizar los cálculos necesarios del valor de envío express
				index = 0;
				while(index < auxString.length()-2){
					if(auxString.charAt(index)!=','){
						str_valorEnvio += auxString.charAt(index);
					} else {
						str_valorEnvio += '.';
					}					
					index++;
				}
				valorEnvio = Double.parseDouble(str_valorEnvio);
				total = subtotal+valorEnvio;
				DecimalFormat myFormatter = new DecimalFormat("0.00");
				precioTotalCalculado = myFormatter.format(total);
			}
			
			//Se eliminan comas presentes, cambian por puntos para realizar los cálculos necesarios del total esperado
			index=0;
			auxString ="";
			while(index < precioTotalCalculado.length()) {
				if(precioTotalCalculado.charAt(index)!=','){
					auxString +=precioTotalCalculado.charAt(index);
				} else {
					auxString +=".";
				}
				index++;
			}
			precioTotalCalculado = auxString;
			Helper.log("Precio total Calculado "+precioTotalCalculado);
			
			//Se obtiene el valor total con gastos de Envío visualizada en la aplicación
			String str_total = selenium.getText("css=html.cufon-active body.checkout-cart-index div.wrapper div.main div.col-main div.cart div.totals div#totals-block table#shopping-cart-totals-table tfoot#price-checkout-top.price-checkout-top tr td.a-right strong span.price cufon.cufon cufontext");
			totalParaPayPal=str_total;
			
			//Se eliminan comas presentes, cambian por puntos para realizar los cálculos necesarios del total visualizado
			index=0;
			auxString ="";
			while(index < str_total.length()) {
				if(str_total.charAt(index)!=','){
					auxString +=str_total.charAt(index);
				} else {
					auxString +=".";
				}
				index++;
			}
			Helper.log("valor mostrado "+auxString);
			//Se comparan los valores calculados y los valores obtenidos de la aplicación
			if(auxString.equals(precioTotalCalculado)){
				Helper.log("VALOR PEDIDO "+subtotal+" + GASTOS DE ENVÍO "+valorEnvio+" = VALOR PEDIDO CON GASTOS DE ENVÍO "+precioTotalCalculado);
				Helper.log("OK");
			} else {
				Helper.log("KO. TOTAL: "+auxString+" TOTAL ESPERADO: "+precioTotalCalculado);
				Helper.log("KO. VALOR PEDIDO "+subtotal+" + GASTOS DE ENVÍO "+valorEnvio+" = VALOR PEDIDO CON GASTOS DE ENVÍO "+precioTotalCalculado);
				Assert.fail("TOTAL NO PRESENTE");
			}			
		} else {			
			Assert.fail("CARRITO DE COMPRAS VACÍO");
		}
	}
}