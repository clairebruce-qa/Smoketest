package claireandbruce.com.test.basicsFlows;

import java.text.DecimalFormat;
import junit.framework.Assert;
import lib.Helper;
import com.thoughtworks.selenium.Selenium;
import basics.ClaireandbruceTestCase;

/**
 * Seleccón aleatoria de un tipo de envío del pedido entre 
 * Envío Standard(1) y Envío Express(2)
 * @author NEWSHORE
 * 
 * Especificación en el test case C&BT-112:Test_TypeShipping 
 */
public class LibTypeShipping extends ClaireandbruceTestCase {

	public static void typeShipping(Selenium selenium){
		Helper.log(" ");
		Helper.log("Se inicia proceso de selección del 'Tipo de Envío' (Standard o Express)");
		
		if(selenium.isAlertPresent()){
			Helper.log("Se ha capturado una alerta presente");
			selenium.getAlert();
		}
		
		
		String titulo = selenium.getTitle();
		if(!titulo.equals("Cesta de la Compra")) {
		Helper.log("No se encontraba cargada la interfaz 'Cesta de la Compra' se ingresa a ésta");
			selenium.click("xpath=.//*[@id='quick-access']/div[1]/div/a");
			selenium.waitForPageToLoad("15000");
		}		
		
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
				if(auxString.charAt(index)!= ',' && auxString.charAt(index)!='.') {
					str_subtotal+=auxString.charAt(index);
				} else if(auxString.charAt(index)==','){
					str_subtotal+= ".";
				}	
				index++;
			}
			
			double subtotal = Double.parseDouble(str_subtotal);		
			Helper.log("Se obtiene el subtotal del pedido para realizar la verificación posteriormente");
			double valorEnvio = 0.00;		
			String str_valorEnvio ="";
			tipoEnvio=2;
			double total=0.00;
			//Envío 1= Standard - Envío 2= Express
			if(tipoEnvio==1){
				Helper.log("Tipo de Envío seleccionado STANDARD");
				//selenium.click("xpath=.//*[@id='s_method_flatrate_flatrate']");
				//selenium.waitForPageToLoad("10000");
				//Clic sobre tipo de envío Standard
				//selenium.click("xpath=.//*[@id='s_method_tablerate_bestway']");
				//selenium.waitForPageToLoad("10000");
				
				//Obtener valor de envío Standard
				auxString = selenium.getText("css=div.value-method-checkout.float-right > span.price");
				
				//Se eliminan comas presentes, cambian por puntos para realizar los cálculos necesarios del valor de Envío
				index = 0;
				while(index < auxString.length()-2){
					if(auxString.charAt(index)!=',' && auxString.charAt(index)!='.'){
						str_valorEnvio += auxString.charAt(index);
					} else if(auxString.charAt(index)==','){
						str_valorEnvio += '.';
					}					
					index++;
				}
				valorEnvio = Double.parseDouble(str_valorEnvio);
				Helper.log("El valor de envío encontrado es: "+valorEnvio);
				//Total = subtotal + valorEnvio
						
				
			} else {
				Helper.log("Tipo de Envío seleccionado EXPRESS");
				//Clic en tipo de envío Express
				selenium.click("xpath=.//*[@id='s_method_flatrate_flatrate']");
				selenium.waitForPageToLoad("15000");
				
				//Se obtiene el valor de este tipo de envío
				auxString = selenium.getText("//dd[2]/ul/li/div/div/span");				
				//Se eliminan comas presentes, cambian por puntos para realizar los cálculos necesarios del valor de envío express
				index = 0;
				while(index < auxString.length()-2){
					if(auxString.charAt(index)!=',' && auxString.charAt(index)!='.'){
						str_valorEnvio += auxString.charAt(index);
					} else if(auxString.charAt(index)==','){
						str_valorEnvio += '.';
					}					
					index++;
				}
				valorEnvio = Double.parseDouble(str_valorEnvio);
				Helper.log("Valor de envío encontrado: "+valorEnvio);				
			}
			
			total = subtotal+valorEnvio;
			Helper.log("Subtotal: "+subtotal+" Valor de envío: "+valorEnvio);
			DecimalFormat myFormatter = new DecimalFormat("0.00");
			precioTotalCalculado = myFormatter.format(total);	
			
			//Se eliminan comas presentes, cambian por puntos para realizar los cálculos necesarios del total esperado
			index=0;
			auxString ="";
			while(index < precioTotalCalculado.length()) {
				if(precioTotalCalculado.charAt(index)!=',' && precioTotalCalculado.charAt(index)!='.'){
					auxString +=precioTotalCalculado.charAt(index);
				} else if(precioTotalCalculado.charAt(index)==','){
					auxString +=".";
				}
				index++;
			}
			precioTotalCalculado = auxString;
			Helper.log("Precio total Esperado: "+precioTotalCalculado);
			Helper.log("Se obtiene el valor total del pedido con gastos de Envío");
			//Se obtiene el valor total con gastos de Envío visualizada en la aplicación
			String str_total = selenium.getText("xpath=/html/body/div/div[3]/div/div/div[6]/div/table/tfoot/tr/td[2]/strong/span/cufon/cufontext");
			totalParaPayPal=str_total;
			Helper.log("Valor total del pedido con gastos de envío visualizado es: "+str_total);
			//Se eliminan comas presentes, cambian por puntos para realizar los cálculos necesarios del total visualizado
			index=0;
			auxString ="";
			while(index < str_total.length()) {
				if(str_total.charAt(index)!=',' && str_total.charAt(index)!='.'){
					auxString +=str_total.charAt(index);
				} else if(str_total.charAt(index)==','){
					auxString +=".";
				}
				index++;
			}
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