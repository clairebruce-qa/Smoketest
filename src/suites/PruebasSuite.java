package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import testcases.Pruebas;

import claireandbruce.com.test.account.Test_User_Addres_Modify_1_Edit_Shipping_Address_User_with_Empty_Fields;
import claireandbruce.com.test.account.Test_Subscriptions_YesNo_TuCuenta;
import claireandbruce.com.test.account.Test_User_Modify_1_User_Modify_Data_valid_Field;
import claireandbruce.com.test.account.Test_SendMessage_FormularioContacto_InvalidData_TuCuenta;
import claireandbruce.com.test.account.Test_User_Modify_2_User_Modify_Data_Empty_Field;
import claireandbruce.com.test.account.Test_User_Modify_3_User_Modify_Data_Invalid_Name_Field;
import claireandbruce.com.test.account.Test_User_Modify_4_User_Modify_Data_Field_EMail_Invalid;
import claireandbruce.com.test.account.CBT12_Test_User_Modify_5_User_Modify_Field_Date_Born_Invalid;
import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;
import claireandbruce.com.test.basicsFlows.Lib_CorrectAddProduct_Cart_SimpleProduct;
import claireandbruce.com.test.cartShopping.*;
import claireandbruce.com.test.login.Test_IncorrectLogon_InvalidUserFormat_TuCuenta;
import claireandbruce.com.test.login.Test_IncorrectLogon_InvalidPassword_TuCuenta;
import claireandbruce.com.test.navigationWeb.CBT32_Test_Home_Page_Navigability_2_Purchase_to_Complete_look_Not_Login_Valid_Fields;
import claireandbruce.com.test.navigationWeb.Test_Home_Page_Navigability_1_Navigability_for_Look_Not_Login;
import claireandbruce.com.test.register.Test_User_Register_2_User_Registration_Empty_Field;
import claireandbruce.com.test.register.Test_User_Register_3_UserRegistration_Field_EMail_Invalid;

/**
 * 
 * 	Login.class,
 *
 * 
 * @author Administrator
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	Test_User_Register_2_User_Registration_Empty_Field.class,
	Test_User_Register_3_UserRegistration_Field_EMail_Invalid.class,
	Test_User_Modify_1_User_Modify_Data_valid_Field.class,
	Test_User_Modify_2_User_Modify_Data_Empty_Field.class,
	Test_User_Modify_3_User_Modify_Data_Invalid_Name_Field.class,
	Test_User_Modify_4_User_Modify_Data_Field_EMail_Invalid.class,
	Test_User_Addres_Modify_1_Edit_Shipping_Address_User_with_Empty_Fields.class,
	Test_IncorrectLogon_InvalidUserFormat_TuCuenta.class,
	Test_IncorrectLogon_InvalidPassword_TuCuenta.class,
	Test_Subscriptions_YesNo_TuCuenta.class,
	Test_SendMessage_FormularioContacto_InvalidData_TuCuenta.class
	
	
})

public class PruebasSuite {

}
