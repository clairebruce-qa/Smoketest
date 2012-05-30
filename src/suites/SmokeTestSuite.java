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
	
	CBT2_Test_User_Register_1_User_registration_valid_field.class,
	Test_User_Addres_1_Add_Shipping_Address_User_with_Valid_Fields.class,
	CBT22_Test_Shopping_Cart_1_Add_Other_Item_Shopping_Cart.class,
	Test_Magazin_Home_Page_1_Navegability_Magazin_User_No_Login.class,
	Test_Home_Page_Navigability_1_Navigability_for_Look_Not_Login.class,
	CBT33_Test_Home_Page_Navigability_3_Purchase_to_Complete_look_Not_Login_No_valid_Field.class,
	CBT34_Test_Home_Page_Navigability_4_Purchase_to_look_piece_by_piece_User_Not_Login_No_Valid_Fields.class,
	Test_Home_Page_Navigability_6_Test_NavigationByCategoryHeader_Mark.class,
	CBT42_Test_Home_Page_Navegability_7_Navigability_Menu_Languaje.class,
	CBT48_Test_Shoppin_Cart_11_User_Login_Purchase_with_Invoice_whit_other_Address_Empty_Fields.class,
	CBT49_Test_IncidentsPurchaseorders_1_ViewOrderhistory.class,
	Lib_CorrectLogon_ValidUser_Accout.class,
	CBT71_Test_CorrectLogon_ValidUser_Checkout.class,
	Test_CorrectAddProduct_Cart_NoLoginUser.class,
	CBT78_Test_CorrectChangeUnits_TuCompra.class,
	CBT82_Test_EditionAddress_CancelButton_TuCuenta.class,
	CBT83_Test_ForgottenPassword_ValidUser_TuCuenta.class,
	CBT86_Test_MenCatalog_NoUserLogin.class,
	CBT90_Test_NavigationByCategoryHeader.class,
	CBT91_Test_FooterMiddleNavigation_AtencionAlCliente.class,
	CBT92_Test_NavigationTopQuestions.class,
	CBT93_Test_FooterTopNavigation.class,
	CBT94_Test_FooterMiddleNavigation_Mujer.class,
	CBT95_Test_FooterMiddleNavigation_Marcas.class,
	CBT96_Test_FooterMiddleNavigation_Tendencias.class,
	CBT97_Test_SendMessage_FormularioContacto_TuCuenta.class,
	CBT99_Test_Ayuda_FAQs_TuCuenta.class,
	Test_HeaderHomePageNavigation_Tendencias.class,

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
