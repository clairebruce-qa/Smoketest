package claireandbruce.com.test.cartShopping;

import static org.junit.Assert.*;
import junit.framework.Assert;
import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibAddressExist;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;

import basics.ClaireandbruceTestCase;
/**
 * El usuario registrado (cliente) accede a el carrito de compras con productos unos productos 
 * agregados y determina la forma de pago, la direcci�n de env�o. este  caso  de prueba valida
 * los campos cuando el usuario necesita  factura y la direcci�n  de env�o  es  diferente a la
 * direcci�n de la factura, los campos a ingresar est�n vac�os.
 * 
 * @author NEWSHORE
 *
 */
public class TestShoppinCart11UserLoginPurchaseWithInvoiceWhitOtherAddressEmptyFields extends ClaireandbruceTestCase{

	TestShoppingCart1AddOtherItemShoppingCart tb = new TestShoppingCart1AddOtherItemShoppingCart();
	@Test
	public void CBT48() throws Exception {
		 
		
		
		if(!selenium.isElementPresent("xpath=//a[contains(text(), 'Salir')]")){
			
			LibCorrectLogonValidUserAccout.CBT55(selenium);
			
		}
		
		while(!selenium.isTextPresent("0 art�culos 0 �")){
			
			//Remover  todos los art�culos mientras el carrito no este vac�o
			selenium.click("id=cartHeader");
			selenium.click("class=btn-remove");
			assertTrue(selenium.getConfirmation().matches("�Est� seguro de que desea eliminar este art�culo de la cesta de la compra[\\s\\S]$"));
			selenium.waitForPageToLoad("10000");
		}
		tb.CBT22();
		//-----****** Verif�ca que la pagina de Tu Compra esta desplegada de lo contrario la carga *****----\\
		
		if(!("Compra ahora").equals(selenium.getTitle())) {		
			if(selenium.isElementPresent("xpath=//ol[@id='mini-cart']/li/div/button")){
				selenium.click("xpath=//ol[@id='mini-cart']/li/div/button");
				selenium.waitForPageToLoad("30000");
			} else {
				selenium.click("xpath=//div/div/div/a");
				selenium.waitForPageToLoad("30000");
			}
			selenium.click("xpath=(//button[@type='button'])[3]");
			selenium.waitForPageToLoad("20000");
		}
			
		//------***** Verifica que exista al menos una direcci�n ****------\\
		
			if(selenium.isElementPresent("name=shipping_address_id")){	
				selenium.click("name=shipping_address_id"); // Si encuentra la direcci�n la selecciona
				Helper.log("existe una direcci�n por defecto seleccionada");
			}
			else{		
				Helper.log("Se agrego la direcci�n existente por defecto");
				Assert.fail("Error: no existe una direcci�n");
			}		
		
		if(!("on").equals(selenium.getValue("xpath=.//*[@id='showFakeBilling']"))) {
		
		//----- El Formulario para los datos de facturaci�n -----\\
		
		selenium.click("id=showFakeBilling");// Selecciona el env�o de factura
		
		if(!selenium.isElementPresent("xpath=.//*[@id='fakeCompany']")|| selenium.isElementPresent("xpath.//*[@id='fakebilling:taxvat']")){
			Assert.fail("Error: Elementos no encontrados");
		}
					
		//selenium.type("xpath=.//*[@id='fakeCompany']",""); //Nombre Compa��a 
		//selenium.type("xpath=.//*[@id='fakebilling:taxvat']",""); // Nif/Cif 
		
		
		//----- Direcci�n diferente a la direcci�n por defecto ------\\
		
	
		selenium.click("id=showFakeBillingExtended");
		assertTrue(selenium.isElementPresent("id=showFakeBillingExtended"));
		assertTrue(selenium.isElementPresent("id=billing:firstname"));
		
			
		selenium.type("id=billing:firstname", "");
		 if (!selenium.isElementPresent("id=advice-required-entry-billing:firstname")){
			 Assert.fail("Campo nombre acepta valores vac�os");
		 }
		selenium.click("id=billing:lastname");
		selenium.type("id=billing:lastname", "");
		if ( !selenium.isElementPresent("id=advice-required-entry-billing:lastname"))	{ 
			Assert.fail("Campo Apellido acepta valores vac�os");
		 }

		// Validaciones 
		selenium.click("xpath=.//*[@id='checkout-buttons-container']/button");
		
		
		
	
		if ( !selenium.isElementPresent("id=advice-required-entry-billing:street1")) {
			Assert.fail("Campo direcci�n acepta valores vac�os");
			
		}

		
			if (!selenium.isElementPresent("id=advice-required-entry-billing:city")) {
				Assert.fail("Campo Poblaci�n acepta valores vac�os");
			}

		
			if("Por favor selecciona una provincia".equals(selenium.getText("//li[@id='billing-new-address-form']/fieldset/ul/li[5]/div[2]/div/div/div/div"))) {
				Assert.fail("Campo Provincia acepta valores vac�os");
			}

			if (!"Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-billing:postcode"))) {
				Assert.fail("Campo c�digo postal acepta valores vac�os");
			}
	
			if (!selenium.isElementPresent("id=advice-required-entry-billing:telephone")) {
				 Assert.fail("Campo tel�fono es obligatorio");
			}

	
			if (!"Seleccione una de las opciones.".equals(selenium.getText("xpath=//div[@id='advice-validate-one-required-by-name-p_method_sermepa']"))) {
				 Assert.fail("No seleccion� m�todo de pago, no se muestra mensaje de advertencia sobre Tarjeta de Cr�dito");
			}
			
			if(selenium.isTextPresent("Check/Money")){
				if (!"Seleccione una de las opciones.".equals(selenium.getText("xpath=.//*[@id='advice-validate-one-required-by-name-p_method_checkmo']"))) {
					Assert.fail("No seleccion� m�todo de pago, no se muestra mensaje de advertencia sobre el Cheque");
				}
			}			

			if (!"Seleccione una de las opciones.".equals(selenium.getText("xpath=.//*[@id='advice-validate-one-required-by-name-p_method_paypal_express']"))) {
				 Assert.fail("No seleccion� m�todo de pago, no se muestra mensaje de advertencia sobre PayPal");
			}
			if(("off").equals(selenium.getValue("id=agreement-1"))) {
				selenium.click("id=agreement-1");						
			} else {
				Assert.fail("Error:  Se deben aceptar los t�rminos y condiciones y las pol�ticas de privacidad");
			}
		
	
	}
	}

}
