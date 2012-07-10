package claireandbruce.com.test.basicsFlows;


import org.junit.Assert;
import lib.Helper;
import basics.ClaireandbruceTestCase;
import com.thoughtworks.selenium.Selenium;
/**
 * 
 * @author NEWSHORE
 *
 */
public class LibPayCreditCard extends ClaireandbruceTestCase{

	public static void credit_Card(Selenium selenium) throws Exception {
		
		Helper.log("\nSe inicia proceso de PAGO CON TARJETA DE CRÉDITO");
		
		Helper.log("Se verifica que se encuentre una dirección de envío por defecto señalada");
		if(!("Compra ahora").equals(selenium.getTitle())) {	
			Helper.log("Se busca método de ingreso a la interfaz 'Compra ahora'");
			if(selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el botón 'CÓMPRALO AHORA' del header");
				selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
				Helper.log("Se hace clic en el botón 'CÓMPRALO AHROA' del header");
				selenium.waitForPageToLoad("30000");
			} else {
				Helper.log("Se busca ingresar a la interfaz 'Compra ahora' por el botón 'COMPRA AHORA' ubicado en la parte superior de la interfaz");
				selenium.click("xpath=//div/div/div/a");
				Helper.log("Se hace clic en el botón 'COMPRA AHORA' ubicado en la parte superior de la página");
				selenium.waitForPageToLoad("30000");
			}
			Helper.log("Se presiona el botón 'CONTINUA' de la interfaz 'Shopping Cart'");
			selenium.click("xpath=(//button[@type='button'])[3]");
			selenium.waitForPageToLoad("20000");
		}

			//Se selecciona método de pago: Cheque
			//selenium.click("xpath=.//*[@id='p_method_sermepa']");
			//Se selecciona tipo de tarjeta
			Helper.log("Se selecciona pago con Tarjeta de Crédito");
			selenium.click("id=p_method_sermepa");
			Helper.log("Se selecciona que la tarjeta es VISA");
			selenium.click("xpath=//div[@value='VI']");
			//Se ingresan datos de la tarjeta de crédito
			Helper.log("Se ingresa el número de la tarjeta de crédito");
			selenium.type("id=cc_number_part1","4548");
			selenium.type("id=cc_number_part2","8120");
			selenium.type("id=cc_number_part3","4940");
			selenium.type("id=cc_number_part4","0004");
			if(selenium.getValue("name=payment[cc_number]").equals("")){
				selenium.type("name=payment[cc_number]", "4548812049400004");
			}
			//Helper.log("DATOS DE TARJETA DE CRÉDITO"+selenium.getValue("name=payment[cc_number]"));
			Helper.log("Se selecciona como fecha de vigencia: Mes:12-DICIEMBRE y Año:2012");
			//Se selecciona mes y año de vigencia
			
			if(selenium.isElementPresent("xpath=(//div[@value='12'])[2]")){
				selenium.click("//ul/li[3]/div/div/div/div/div");
				selenium.click("xpath=//li[@id='sermepa_cc_type_exp_div']/div/div/div[2]/div/div/div[13]");				
			} else {
				selenium.click("xpath=//li[3]/div/div/div/div/div");
				selenium.click("xpath=//div[@value='12']");
			}
			
			if(selenium.isElementPresent("xpath=(//div[@value='2012'])[2]")){
				selenium.click("//ul/li[3]/div/div[2]/div/div/div");
				selenium.click("xpath=(//div[@value='2012'])[2]");
			} else {
				selenium.click("xpath=//li[3]/div/div[2]/div/div/div[2]");
				selenium.click("xpath=//div[@value='2012']");
			}				
			//Se ingresa código de seguridad
			Helper.log("Se ingresa el código de seguridad: 123");
			selenium.type("xpath=//li[@id='sermepa_cc_type_cvv_div']/div/div/input","123");
			//Se aceptan términos y condiciones
			Helper.log("Se aceptan términos y condiciones y políticas de privacidad");
			selenium.click("id=agreement-1");
			//Se presiona el botón PAGAR
			Helper.log("Se presiona el botón 'PAGAR'");
			selenium.click("xpath=//div[@id='checkout-buttons-container']/button");
			
			if(selenium.isAlertPresent() || selenium.isTextPresent("El número de tarjeta de crédito no se ajusta al tipo de tarjeta de crédito.")){
				Helper.log("************ Se encontró la alerta 'El número de la tarjeta de crédito no se ajusta al tipo de tarjeta de crédito");
				Assert.fail("Datos de tarjeta de crédito no válidos");
			} else {
				Helper.log("Se espera carga de interfaz con mensaje de confirmación del pedido");
				selenium.waitForPageToLoad("40000");
				//SI EL TITULO DE LA PAGINA ES COMPRAR AHORA FALLAR
		    }			
			
			if(selenium.isTextPresent("Recibirás un e-mail con tu confirmación de compra a:")){
				Helper.log("PEDIDO REALIZADO!!");
			} else {
				Assert.fail("PEDIDO NO REALIZADO!!");
				Helper.log("PEDIDO NO REALIZADO!!");
			}
							
		
	}	
}