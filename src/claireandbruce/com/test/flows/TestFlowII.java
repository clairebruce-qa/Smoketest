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
 * FlujoII: Login + ProductoSimple + CambioUnidad de un Producto + TipoEnvío + 
 * DirecciónExistente + Factura + PagoTarjetaCrédito
 * @author NEWSHORE
 *
 */
public class TestFlowII extends ClaireandbruceTestCase {

	/**En este método de test se hace una prueba unitaria para el flujo II
	 * 
	 * @throws Exception
	 */
	
	@Test
	public void test_flow2() throws Exception{		
		
		Helper.log("FlujoII: Login + ProductoSimple + CambioUnidad de un Producto + TipoEnvío + \nDirecciónExistente + Factura + PagoTarjetaCrédito");
		Helper.log(" ");
		// El Usuario se Autentica
		LibCorrectLogonValidUserAccout.CBT55(selenium);
				
		//Se añade un producto para realizar para eliminarlo posteriormente 
		LibCorrectAddProductCartSimpleProduct.CBT_SimpleProduct(selenium);
		
		//Se añade un producto para realizar cambio de unidades
		LibChangeUnitsOneProduct.changeUnits(selenium);
		
		//Se selecciona el tipo de envío
		LibTypeShipping.typeShipping(selenium);
		
		// Se verifica si existe una dirección por defecto y si esta seleccionada
		LibAddressExist.CBT_Address(selenium);
		
		// Se verifica que el envío se hara sin factura
		LibWithPurchase.shippingWithPurchase(selenium);
		
		// Se efectua el pago con Tarjeta de Crédito
		LibPayCreditCard.credit_Card(selenium);
		
	}
}
