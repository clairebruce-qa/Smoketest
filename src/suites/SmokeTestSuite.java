package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import claireandbruce.com.test.account.*;
import claireandbruce.com.test.basicsFlows.LibCorrectLogonValidUserAccout;
import claireandbruce.com.test.cartShopping.*;
import claireandbruce.com.test.catalog.*;
import claireandbruce.com.test.login.*;
import claireandbruce.com.test.login.checkout.*;
import claireandbruce.com.test.navigationWeb.*;
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
	
	TestUserRegisterAccount1UserRegistrationValidFieldForAccount.class,//CBT2
	TestUserAddres1AddShippingAddressUserWithValidFields.class,//CBT13
	TestUserRegisterheckoutUserRegistrationValidFieldString.class,//CBT20
	TestShoppingCart1AddOtherItemShoppingCart.class,//CBT22
	TestShoppingCart3DeleterAllItemShoppingCart.class,//CBT24
	TestUserRegister7UserRegistrationvalidfieldwithEMailRegister.class,//CBT28
	TestHomePageNavigability1NavigabilityForLookNotLogin.class,//CBT31
	TestHomePageNavigability3PurchaseToCompleteLookNotLoginNoValidField.class,//CBT33
	TestHomePageNavigability4PurchaseToLookPieceByPieceUserNotLoginNoValidFields.class,//CBT34
	TestHomePageNavigability6TestNavigationByCategoryHeaderMark.class,//CBT39
	TestHomePageNavegability7NavigabilityMenuLanguage.class,//CBT42
	TestShoppinCart11UserLoginPurchaseWithInvoiceWhitOtherAddressEmptyFields.class,//CBT48
	TestIncidentsPurchaseorders1ViewOrderhistory.class,//CBT49
	TestCorrectAddProductCartNoLoginUser.class,//CBT76
	TestEditionAddressCancelButtonAccount.class,//CBT82
	TestForgottenPasswordValidUserTuCuenta.class,//CBT83
	TestForgottenPasswordInvalidUserTuCuenta.class,//CBT84
	TestMenCatalogNoUserLogin.class,//CBT86
	TestNavigationByCategoryHeader.class,//CBT90
	TestFooterMiddleNavigationAtencionAlCliente.class,//CBT91
	TestMagazinHomePage1NavegabilityMagazinUserNoLogin.class,//CBT30
	TestNavigationTopQuestions.class,//CBT92
	TestFooterTopNavigation.class,//CBT93
	TestFooterMiddleNavigationMujer.class,//CBT94
	TestFooterMiddleNavigationMarcas.class,//CBT95
	TestFooterMiddleNavigationTendencias.class,//CBT96
	TestSendMessageFormularioContactoAccount.class,//CBT97
	TestAyudaFAQsAccount.class,//CBT99
	TestHeaderHomePageNavigationTendencias.class,//CBT100
	TestUserRegister6UserRegistrationFieldPasswordValid.class,//CBT7
	TestIncorrectPasswordChangeInvalidOldPassAccount.class,//CBT61
	TestCorrectPasswordChangeSpacesNewPassAccount.class,//CBT62
	TestIncorrectEditionAddressSpecialCharactersAccount.class,//CBT70
	TestIncorrectLogonInvalidUserFormatCheckout.class,//CBT72
	TestIncorrectLogonNovalidPasswordCheckout.class,//CBT73
	TestIncorrectLogonInvalidPasswordSpaceCheckout.class,//CBT74
	TestIncorrectLogonInvalidPasswordEmptyCheckout.class,//CBT75
	TestCorrectChangeUnitsAccount.class,//CBT78
	
	

	//PARA AGREGAR
	//CBT71_Test_CorrectLogon_ValidUser_Checkout.class,

	//----------------->CASOS QUE CORREN<----------------\\
	/*CBT3_Test_User_Register_2_User_Registration_Empty_Field.class,
	CBT4_Test_User_Register_3_UserRegistration_Field_EMail_Invalid.class,
	CBT8_Test_User_Modify_1_User_Modify_Data_valid_Field.class,
	CBT9_Test_User_Modify_2_User_Modify_Data_Empty_Field.class,
	CBT10_Test_User_Modify_3_User_Modify_Data_Invalid_Name_Field.class,
	CBT11_Test_User_Modify_4_User_Modify_Data_Field_EMail_Invalid.class,
	CBT16_Test_User_Addres_Modify_1_Edit_Shipping_Address_User_with_Empty_Fields.class,
	CBT32_Test_Home_Page_Navigability_2_Purchase_to_Complete_look_Not_Login_Valid_Fields.class,
	CBT56_Test_IncorrectLogon_InvalidUserFormat_TuCuenta.class,
	CBT57_Test_IncorrectLogon_InvalidPassword_TuCuenta.class,
	CBT81_Test_Subscriptions_YesNo_TuCuenta.class,
	CBT98_Test_SendMessage_FormularioContacto_InvalidData_TuCuenta.class*/
	
	//----------------->ESTOS NO APLICAN <-------------------------
	//CBT38_Test_Home_Page_Navigability_5_Navigability_Video_CB_NetWorks.class,
	//CBT43_Test_Home_Page_Navegability_8_Navigability_Field_Search.class,
	//CBT50_Test_Home_Page_Navigability_9_Test_NavigationByCategoryOutStanding_Mark.class,
	//CBT51_Test_Home_Page_Navigability_10_Test_NavigationByCategoryOutStanding_Bags_Accesories.class,
	//CBT64_Test_CorrectDeleteAccount_TuCuenta.class,
	//CBT102_Test_NavigationCategoriesOutstanding_RopaZapatos_Homepage.class
})

public class SmokeTestSuite {

}
