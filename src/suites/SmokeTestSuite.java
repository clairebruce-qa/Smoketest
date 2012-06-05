package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import claireandbruce.com.test.account.*;
import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;
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
	
	TestUserRegister1UserRegistrationValidField.class,//CBT2
	Test_User_Addres_1_Add_Shipping_Address_User_with_Valid_Fields.class,//CBT13
	Test_Shopping_Cart_1_Add_Other_Item_Shopping_Cart.class,//CBT22
	CBT24_Test_Shopping_Cart_3_Deleter__All_Item_Shopping_Cart.class,//CBT24
	TestUserRegister7UserRegistrationvalidfieldwithEMailRegister.class,//CBT28
	Test_Home_Page_Navigability_1_Navigability_for_Look_Not_Login.class,//CBT31
	CBT33_Test_Home_Page_Navigability_3_Purchase_to_Complete_look_Not_Login_No_valid_Field.class,//CBT33
	CBT34_Test_Home_Page_Navigability_4_Purchase_to_look_piece_by_piece_User_Not_Login_No_Valid_Fields.class,//CBT34
	Test_Home_Page_Navigability_6_Test_NavigationByCategoryHeader_Mark.class,//CBT39
	CBT42_Test_Home_Page_Navegability_7_Navigability_Menu_Languaje.class,//CBT42
	Test_Shoppin_Cart_11_User_Login_Purchase_with_Invoice_whit_other_Address_Empty_Fields.class,//CBT48
	Test_IncidentsPurchaseorders_1_ViewOrderhistory.class,//CBT49
	Test_CorrectAddProduct_Cart_NoLoginUser.class,//CBT76
	CBT82_Test_EditionAddress_CancelButton_TuCuenta.class,//CBT82
	Test_ForgottenPassword_ValidUser_TuCuenta.class,//CBT83
	TestForgottenPasswordInvalidUserTuCuenta.class,//CBT84
	CBT86_Test_MenCatalog_NoUserLogin.class,//CBT86
	CBT90_Test_NavigationByCategoryHeader.class,//CBT90
	Test_FooterMiddleNavigation_AtencionAlCliente.class,//CBT91
	Test_Magazin_Home_Page_1_Navegability_Magazin_User_No_Login.class,//CBT30
	Test_NavigationTopQuestions.class,//CBT92
	Test_FooterTopNavigation.class,//CBT93
	CBT94_Test_FooterMiddleNavigation_Mujer.class,//CBT94
	Test_FooterMiddleNavigation_Marcas.class,//CBT95
	Test_FooterMiddleNavigation_Tendencias.class,//CBT96
	Test_SendMessage_FormularioContacto_TuCuenta.class,//CBT97
	CBT99_Test_Ayuda_FAQs_TuCuenta.class,//CBT99
	Test_HeaderHomePageNavigation_Tendencias.class,//CBT100
	TestUserRegister6UserRegistrationFieldPasswordValid.class,//CBT7
	Test_IncorrectPasswordChange_InvalidOldPass_Account.class,//CBT61
	Test_CorrectPasswordChange_SpacesNewPass_Account.class,//CBT62
	Test_IncorrectEditionAddress_SpecialCharacters_Account.class,//CBT70
	TestIncorrectLogonInvalidUserFormatCheckout.class,//CBT72
	TestIncorrectLogonNovalidPasswordCheckout.class,//CBT73
	TestIncorrectLogonInvalidPasswordSpaceCheckout.class,//CBT74
	Test_IncorrectLogon_InvalidPasswordEmpty_Checkout.class,//CBT75
	Test_CorrectChangeUnits_TuCompra.class,//CBT78
	
	

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
