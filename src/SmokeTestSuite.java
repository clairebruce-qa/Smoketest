

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import claireandbruce.com.test.account.*;
import claireandbruce.com.test.cartShopping.TestCorrectAddProductCartNoLoginUser;
import claireandbruce.com.test.cartShopping.TestCorrectChangeUnitsAccount;
import claireandbruce.com.test.cartShopping.TestIncidentsPurchaseorders1ViewOrderhistory;
import claireandbruce.com.test.cartShopping.TestShoppinCart11UserLoginPurchaseWithInvoiceWhitOtherAddressEmptyFields;
import claireandbruce.com.test.cartShopping.TestShoppingCart1AddOtherItemShoppingCart;
import claireandbruce.com.test.cartShopping.TestShoppingCart3DeleterAllItemShoppingCart;
import claireandbruce.com.test.catalog.TestMenCatalogNoUserLogin;
import claireandbruce.com.test.login.checkout.TestIncorrectLogonInvalidPasswordEmptyCheckout;
import claireandbruce.com.test.login.checkout.TestIncorrectLogonInvalidPasswordSpaceCheckout;
import claireandbruce.com.test.login.checkout.TestIncorrectLogonInvalidUserFormatCheckout;
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

	TestHeaderHomePageNavigationTendencias.class, 								//CBT100 - CBT5	
	TestUserAddress1AddShippingAddressUserWithValidFields.class, 				//CBT13  - CBT6
	TestHomePageNavigability1NavigabilityForLookNotLogin.class, 				//CBT31  - CBT7
	TestHomePageNavigability6TestNavigationByCategoryHeaderMark.class, 			//CBT39  - CBT8
	TestCorrectAddProductCartNoLoginUser.class, 								//CBT76  - CBT9
	TestMagazinHomePage1NavegabilityMagazinUserNoLogin.class, 					//CBT30  - CBT10
	TestNavigationTopQuestions.class, 											//CBT92  - CBT11
	TestFooterMiddleNavigationMarcas.class, 									//CBT95  - CBT12
	TestIncidentsPurchaseorders1ViewOrderhistory.class, 						//CBT49  - CBT13
	TestShoppingCart1AddOtherItemShoppingCart.class, 							//CBT22  - CBT14
	TestCorrectChangeUnitsAccount.class, 										//CBT78  - CBT15
	TestShoppinCart11UserLoginPurchaseWithInvoiceWhitOtherAddressEmptyFields.class, //CBT48 - CBT16
	TestForgottenPasswordValidUserAccount.class,   								//CBT83  - CBT17
	TestFooterMiddleNavigationTendencias.class, 								//CBT96  - CBT18
	TestFooterMiddleNavigationAtencionAlCliente.class, 							//CBT91  - CBT19
	TestCorrectPasswordChangeAccount.class, 									//CBT60  - CBT20
	TestIncorrectPasswordChangeInvalidOldPassAccount.class, 					//CBT61  - CBT21
	TestFooterTopNavigation.class, 												//CBT93  - CBT22
	TestCorrectPasswordChangeSpacesNewPassAccount.class, 						//CBT62  - CBT23
	TestUserRegister6UserRegistrationFieldPasswordValid.class, 					//CBT7   - CBT24
	TestIncorrectLogonInvalidUserFormatCheckout.class, 							//CBT72  - CBT25
	TestIncorrectLogonInvalidPasswordSpaceCheckout.class, 						//CBT74  - CBT27
	TestIncorrectLogonInvalidPasswordEmptyCheckout.class, 						//CBT75  - CBT28
	TestSendMessageFormularioContactoAccount.class, 							//CBT97  - CBT29
	TestUserRegister7UserRegistrationvalidfieldwithEMailRegister.class, 		//CBT28  - CBT30
	TestUserRegister1UserRegistrationValidField.class, 							//CBT2   - CBT31
	TestForgottenPasswordInvalidUserAccount.class,  							//CBT84  - CBT33
	TestIncorrectEditionAddressSpecialCharactersAccount.class, 					//CBT70  - CBT34
	TestUserRegisterCheckout1UserRegistrationValidField.class, 					//CBT18  - CBT35
	TestUserRegisterCheckoutUserRegistrationValidFieldString.class, 			//CBT20  - CBT44
	TestUserRegisterCheckoutUserRegistrationValidFieldDate.class, 				//CBT21  - CBT47
	TestUserRegisterAccount1UserRegistrationValidFieldForAccount.class, 		//CBT29  - CBT50
	TestCatalogWomen1TestCatalogWomenFilter.class, 								//CBT40  - CBT51
	TestCatalogWomen2TestCatalogWomenFilterPriceViewsProductLook.class, 		//CBT41  - CBT62
	TestEditionAddressCancelButtonAccount.class,    							//CBT82  - CBT63
	TestAyudaFAQsAccount.class, 												//CBT99  - CBT64
	TestShoppingCart3DeleterAllItemShoppingCart.class, 							//CBT24  - CBT65
	TestMenCatalogNoUserLogin.class, 											//CBT86  - CBT66
	TestHomePageNavigability3PurchaseToCompleteLookNotLoginNoValidField.class,  //CBT33  - CBT67
	TestHomePageNavigability4PurchaseToLookPieceByPieceUserNotLoginNoValidFields.class, //CBT34 - CBT68
	TestHomePageNavegability7NavigabilityMenuLanguage.class, 					//CBT42  - CBT69
	TestNavigationByCategoryHeader.class, 										//CBT90  - CBT70
	TestFooterMiddleNavigationMujer.class, 										//CBT94  - CBT71
	
	
})

public class SmokeTestSuite {

}
