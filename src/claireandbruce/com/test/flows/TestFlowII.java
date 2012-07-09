package claireandbruce.com.test.flows;

import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import claireandbruce.com.test.basicsFlows.LibPayCreditCard;
import claireandbruce.com.test.basicsFlows.LibWithPurchase;
import claireandbruce.com.test.basicsFlows.LibAddressExist;
import claireandbruce.com.test.basicsFlows.LibChangeUnitsOneProduct;
import claireandbruce.com.test.basicsFlows.LibCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.basicsFlows.LibTypeShipping;
import basics.ClaireandbruceTestCase;

/**
 * FlujoII: Login + ProductoSimple + CambioUnidad de un Producto + TipoEnv�o + 
 * Direcci�nExistente + Factura + PagoTarjetaCr�dito
 * @author NEWSHORE
 *
 */
public class TestFlowII extends ClaireandbruceTestCase {

	/**En este m�todo de test se hace una prueba unitaria para el flujo II
	 * 
	 * @throws Exception
	 */
	
	@Test
	public void test_flow2() throws Exception{		
		
		Helper.log("FlujoII: Login + ProductoSimple + CambioUnidad de un Producto + TipoEnv�o + \nDirecci�nExistente + Factura + PagoTarjetaCr�dito");
		Helper.log(" ");
		// El Usuario se Autentica
		LibCorrectLogonValidUserAccout.CBT55(selenium);
				
		//Se a�ade un producto para realizar para eliminarlo posteriormente 
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		
		//Se a�ade un producto para realizar cambio de unidades
		LibChangeUnitsOneProduct.changeUnits(selenium);
		
		//Se selecciona el tipo de env�o
		LibTypeShipping.typeShipping(selenium);
		
		// Se verifica si existe una direcci�n por defecto y si esta seleccionada
		LibAddressExist.CBT_Address(selenium);
		
		// Se verifica que el env�o se hara sin factura
		LibWithPurchase.shippingWithPurchase(selenium);
		
		// Se efectua el pago con Tarjeta de Cr�dito
		LibPayCreditCard.credit_Card(selenium);
		
	}
}
