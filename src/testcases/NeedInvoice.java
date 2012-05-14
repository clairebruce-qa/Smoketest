package testcases;

import org.junit.Test;

import com.thoughtworks.selenium.Selenium;
import basics.ClaireandbruceTestCase;

public class NeedInvoice extends ClaireandbruceTestCase{

	@Test
	public static void testNeedInvoice(Selenium selenium) {
		//Seleccionar "Necesito una factura"
		selenium.click("id=showFakeBilling");
		//Cambio de nombre de usuario - por nombre de la Compañia
		selenium.type("id=fakeCompany", "xyz");
		//Seleccion de la opcion "La direccion de factura es diferente a la de envio
		selenium.click("id=showFakeBillingExtended");
		//Se cambia el nombre por el de la compañia
		selenium.type("id=billing:firstname", "xyz");
		selenium.type("id=billing:lastname", "");
		//Se cambia la direccion por la de la Compañia
		selenium.type("id=billing:street1", "cl 123");
		selenium.type("id=billing:street2", "cl 27 8");		
	}
}
