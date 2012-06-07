package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import claireandbruce.com.test.account.*;
import claireandbruce.com.test.cartShopping.TestAddressExist;
import claireandbruce.com.test.cartShopping.TestChangeUnitsOneProduct;
import claireandbruce.com.test.cartShopping.TestCorrectAddProductCartConfigurableProduct;
import claireandbruce.com.test.cartShopping.TestCorrectAddProductCartNoLoginUser;
import claireandbruce.com.test.cartShopping.TestCorrectAddProductCartSimpleProduct;
import claireandbruce.com.test.cartShopping.TestCorrectChangeUnitsAccount;
import claireandbruce.com.test.cartShopping.TestIncidentsPurchaseorders1ViewOrderhistory;
import claireandbruce.com.test.cartShopping.TestShoppinCart11UserLoginPurchaseWithInvoiceWhitOtherAddressEmptyFields;
import claireandbruce.com.test.cartShopping.TestShoppingCart1AddOtherItemShoppingCart;
import claireandbruce.com.test.cartShopping.TestShoppingCart3DelerterItemShoppingCart;
import claireandbruce.com.test.cartShopping.TestShoppingCart3DeleterAllItemShoppingCart;
import claireandbruce.com.test.cartShopping.TestTypeShipping;
import claireandbruce.com.test.cartShopping.TestWindowPayPal;
import claireandbruce.com.test.cartShopping.TestWithPurchase;
import claireandbruce.com.test.cartShopping.TestWithPurchaseAndOtherAddress;
import claireandbruce.com.test.cartShopping.TestWithoutPurchase;
import claireandbruce.com.test.catalog.TestMenCatalogNoUserLogin;
import claireandbruce.com.test.login.TestCorrectLogonValidUserAccount;
import claireandbruce.com.test.login.checkout.TestCorrectLogonValidUserCheckout;
import claireandbruce.com.test.login.checkout.TestIncorrectLogonInvalidPasswordEmptyCheckout;
import claireandbruce.com.test.login.checkout.TestIncorrectLogonInvalidPasswordSpaceCheckout;
import claireandbruce.com.test.login.checkout.TestIncorrectLogonInvalidUserFormatCheckout;
import claireandbruce.com.test.login.checkout.TestIncorrectLogonNoValidPasswordCheckout;
import claireandbruce.com.test.login.checkout.TestUserRegisterCheckout1UserRegistrationValidField;
import claireandbruce.com.test.login.checkout.TestUserRegisterCheckoutUserRegistrationValidFieldDate;
import claireandbruce.com.test.login.checkout.TestUserRegisterCheckoutUserRegistrationValidFieldString;
import claireandbruce.com.test.navigationWeb.TestCatalogWomen1TestCatalogWomenFilter;
import claireandbruce.com.test.navigationWeb.TestCatalogWomen2TestCatalogWomenFilterPriceViewsProductLook;
import claireandbruce.com.test.navigationWeb.TestFooterMiddleNavigationAtencionAlCliente;
import claireandbruce.com.test.navigationWeb.TestFooterMiddleNavigationMarcas;
import claireandbruce.com.test.navigationWeb.TestFooterMiddleNavigationMujer;
import claireandbruce.com.test.navigationWeb.TestFooterMiddleNavigationTendencias;
import claireandbruce.com.test.navigationWeb.TestFooterTopNavigation;
import claireandbruce.com.test.navigationWeb.TestHeaderHomePageNavigationTendencias;
import claireandbruce.com.test.navigationWeb.TestHomePageNavegability7NavigabilityMenuLanguage;
import claireandbruce.com.test.navigationWeb.TestHomePageNavigability1NavigabilityForLookNotLogin;
import claireandbruce.com.test.navigationWeb.TestHomePageNavigability3PurchaseToCompleteLookNotLoginNoValidField;
import claireandbruce.com.test.navigationWeb.TestHomePageNavigability4PurchaseToLookPieceByPieceUserNotLoginNoValidFields;
import claireandbruce.com.test.navigationWeb.TestHomePageNavigability6TestNavigationByCategoryHeaderMark;
import claireandbruce.com.test.navigationWeb.TestMagazinHomePage1NavegabilityMagazinUserNoLogin;
import claireandbruce.com.test.navigationWeb.TestNavigationByCategoryHeader;
import claireandbruce.com.test.navigationWeb.TestNavigationTopQuestions;
import claireandbruce.com.test.register.*;


/**
 * 
 * 	Login.class
 * 
 * @author Administrator
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	//se declaran las clases que contienen cada una un testcase
	
	//---------->CASOS A ENTREGAR<----------\\

	TestUserRegister1UserRegistrationValidField.class, //CBT2
	TestUserRegister6UserRegistrationFieldPasswordValid.class, //CBT7
	TestUserAddress1AddShippingAddressUserWithValidFields.class, //CBT13
	TestUserRegisterCheckout1UserRegistrationValidField.class, //CBT18
	TestUserRegisterCheckoutUserRegistrationValidFieldString.class, //CBT20
	TestUserRegisterCheckoutUserRegistrationValidFieldDate.class, //CBT21
	TestShoppingCart1AddOtherItemShoppingCart.class, //CBT22
	TestShoppingCart3DeleterAllItemShoppingCart.class, //CBT24
	TestUserRegister7UserRegistrationvalidfieldwithEMailRegister.class, //CBT28
	TestUserRegisterAccount1UserRegistrationValidFieldForAccount.class, //CBT29
	TestMagazinHomePage1NavegabilityMagazinUserNoLogin.class, //CBT30
	TestHomePageNavigability1NavigabilityForLookNotLogin.class, //CBT31
	TestHomePageNavigability3PurchaseToCompleteLookNotLoginNoValidField.class, //CBT33
	TestHomePageNavigability4PurchaseToLookPieceByPieceUserNotLoginNoValidFields.class, //CBT34
	TestHomePageNavigability6TestNavigationByCategoryHeaderMark.class, //CBT39
	TestCatalogWomen1TestCatalogWomenFilter.class, //CBT40
	TestCatalogWomen2TestCatalogWomenFilterPriceViewsProductLook.class, //CBT41
	TestHomePageNavegability7NavigabilityMenuLanguage.class, //CBT42
	TestShoppinCart11UserLoginPurchaseWithInvoiceWhitOtherAddressEmptyFields.class, //CBT48
	TestIncidentsPurchaseorders1ViewOrderhistory.class, //CBT49
	TestCorrectPasswordChangeAccount.class, //CBT60
	TestIncorrectPasswordChangeInvalidOldPassAccount.class, //CBT61
	TestCorrectPasswordChangeSpacesNewPassAccount.class, //CBT62
	TestIncorrectEditionAddressSpecialCharactersAccount.class, //CBT70
	TestIncorrectLogonInvalidUserFormatCheckout.class, //CBT72
	TestIncorrectLogonNoValidPasswordCheckout.class, //CBT73
	TestIncorrectLogonInvalidPasswordSpaceCheckout.class, //CBT74
	TestIncorrectLogonInvalidPasswordEmptyCheckout.class, //CBT75
	TestCorrectAddProductCartNoLoginUser.class, //CBT76
	TestCorrectChangeUnitsAccount.class, //CBT78
	TestEditionAddressCancelButtonAccount.class,    //CBT82
	TestForgottenPasswordValidUserAccount.class,   //CBT83
	TestForgottenPasswordInvalidUserAccount.class,  //CBT84
	TestMenCatalogNoUserLogin.class, //CBT86
	TestNavigationByCategoryHeader.class, //CBT90
	TestFooterMiddleNavigationAtencionAlCliente.class, //CBT91
	TestNavigationTopQuestions.class, //CBT92
	TestFooterTopNavigation.class, //CBT93
	TestFooterMiddleNavigationMujer.class, //CBT94
	TestFooterMiddleNavigationMarcas.class, //CBT95
	TestFooterMiddleNavigationTendencias.class, //CBT96
	TestSendMessageFormularioContactoAccount.class, //CBT97
	TestAyudaFAQsAccount.class, //CBT99
	TestHeaderHomePageNavigationTendencias.class, //CBT100
	
	// @Test correspondientes a algunas librerías de los Flujos	
	TestAddressExist.class, //CBL1 - CBT113
	TestChangeUnitsOneProduct.class, //CBL2 - CBT110
	TestCorrectAddProductCartConfigurableProduct.class, //CBL3 - CBT117
	TestCorrectAddProductCartSimpleProduct.class, //CBL4 - CBT111
	TestCorrectLogonValidUserCheckout.class, //CBL5 - CBT71
	TestCorrectLogonValidUserAccount.class, //CBL6 - CBT55
	TestShoppingCart3DelerterItemShoppingCart.class, //CBL7 - CBT118
	TestTypeShipping.class, //CBL8 - CBT112
	TestWindowPayPal.class, //CBL9 - CBT119
	TestWithPurchaseAndOtherAddress.class, //CBL10 - CBT120
	TestWithPurchase.class, //CBL11 - CBT
	TestWithoutPurchase.class, //CBL12 - CBT115
	
	
	
	
	
})

public class SmokeTestSuite {

}
