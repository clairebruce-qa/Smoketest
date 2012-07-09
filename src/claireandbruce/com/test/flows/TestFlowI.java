package claireandbruce.com.test.flows;

import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import claireandbruce.com.test.basicsFlows.LibAddressExist;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.basicsFlows.LibPayPal;
import claireandbruce.com.test.basicsFlows.LibWindowPayPal;
import claireandbruce.com.test.basicsFlows.LibWithoutPurchase;

import basics.ClaireandbruceTestCase;

/**
 * Esta clase prueba los casos b�sicos para el flujo I.
 * @author NEWSHORE
 *
 */
public class TestFlowI extends ClaireandbruceTestCase{

	/** En este metodo de test se hace una prueba unitaria para el flujo I
	 * 
	 *  FlujoI: Login + ProductoSimple + Direcci�nExistente + SinFactura + PagoPayPal
	 * @throws Exception
	 */
	@Test
	public void test_flow1() throws Exception {
		
		Helper.log("Flujo 1. Login + ProductoSimple + Direcci�nExistente + SinFactura + PagoPayPal");		
		LibWindowPayPal.CBT_Paypal(selenium);
		
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			Helper.log("Se inicia sesi�n en la p�gina de C+B");
			LibCorrectLogonValidUserAccout.CBT55(selenium);		
		}
		
		//Se a�ade un producto nuevamente
		String nombreProducto= LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		
		// Se verifica si existe una direcci�n por defecto y si esta seleccionada
		LibAddressExist.CBT_Address(selenium);
		
		// Se verifica que el env�o se hara sin factura
		LibWithoutPurchase.CBT_WPurchase(selenium);
		
		// Se efectua el pago con Paypal
		LibPayPal.CBT_Paypal(selenium,nombreProducto);
		
		
	}
}
