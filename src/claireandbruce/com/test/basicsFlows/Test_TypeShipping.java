package claireandbruce.com.test.basicsFlows;

import java.text.DecimalFormat;

import junit.framework.Assert;
import lib.Helper;
import org.junit.Test;

import com.thoughtworks.selenium.Selenium;

import basics.ClaireandbruceTestCase;

/**
 * Selecc�n aleatoria de un tipo de env�o del pedido entre 
 * Env�o Standard(1) y Env�o Express(2)
 * 
 * En ocasiones presenta inconvenientes al no encontrar el elemento mostrando el mensaje:
 * " ERROR: Command execution failure. Please search the user group at https://groups.google.com/
 *   forum/#!forum/selenium-users for error details from the log window.  The error message is: Acceso denegado."
 * Pero en una segunda ejecuci�n no presenta dicho inconveniente.
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
		
		//Se verifica que el carrito no este vac�o
		if(!selenium.isTextPresent("El carrito de compras est� vac�o")){
			//Se selecciona un tipo de env�o
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
			
			//Env�o 1= Standard - Env�o 2= Express
			if(tipoEnvio==1){
				Helper.log("TIPO DE ENV�O STANDARD");
				//selenium.click("xpath=.//*[@id='s_method_flatrate_flatrate']");
				//selenium.waitForPageToLoad("10000");
				//Clic sobre tipo de env�o Standard
				//selenium.click("xpath=.//*[@id='s_method_flatrate_flatrate']");
				//selenium.waitForPageToLoad("10000");
				
				//Obtener valor de env�o Standard
				auxString = selenium.getText("css=div.value-method-checkout.float-right > span.price");
				//Se eliminan comas presentes, cambian por puntos para realizar los c�lculos necesarios del valor de Env�o
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
				//Helper.log("VALOR ENV�O "+valorEnvio);
				//Total = subtotal + valorEnvio
				total = subtotal+valorEnvio;
				DecimalFormat myFormatter = new DecimalFormat("0.00");
				precioTotalCalculado = myFormatter.format(total);			
				
			} else {
				Helper.log("TIPO DE ENV�O EXPRESS");
				//Clic en tipo de env�o Express
				selenium.click("xpath=.//*[@id='s_method_tablerate_bestway']");
				selenium.waitForPageToLoad("10000");
				
				//Se obtiene el valor de este tipo de env�o
				auxString = selenium.getText("//dd[2]/ul/li/div/div/span");				
				//Se eliminan comas presentes, cambian por puntos para realizar los c�lculos necesarios del valor de env�o express
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
			
			//Se eliminan comas presentes, cambian por puntos para realizar los c�lculos necesarios del total esperado
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
			
			//Se obtiene el valor total con gastos de Env�o visualizada en la aplicaci�n
			String str_total = selenium.getText("css=html.cufon-active body.checkout-cart-index div.wrapper div.main div.col-main div.cart div.totals div#totals-block table#shopping-cart-totals-table tfoot#price-checkout-top.price-checkout-top tr td.a-right strong span.price cufon.cufon cufontext");
			totalParaPayPal=str_total;
			
			//Se eliminan comas presentes, cambian por puntos para realizar los c�lculos necesarios del total visualizado
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
			//Se comparan los valores calculados y los valores obtenidos de la aplicaci�n
			if(auxString.equals(precioTotalCalculado)){
				Helper.log("VALOR PEDIDO "+subtotal+" + GASTOS DE ENV�O "+valorEnvio+" = VALOR PEDIDO CON GASTOS DE ENV�O "+precioTotalCalculado);
				Helper.log("OK");
			} else {
				Helper.log("KO. TOTAL: "+auxString+" TOTAL ESPERADO: "+precioTotalCalculado);
				Helper.log("KO. VALOR PEDIDO "+subtotal+" + GASTOS DE ENV�O "+valorEnvio+" = VALOR PEDIDO CON GASTOS DE ENV�O "+precioTotalCalculado);
				Assert.fail("TOTAL NO PRESENTE");
			}			
		} else {			
			Assert.fail("CARRITO DE COMPRAS VAC�O");
		}
	}
}