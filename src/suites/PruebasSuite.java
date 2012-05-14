package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import testcases.Pruebas;

import claireandbruce.com.test.account.CBT9_Test_User_Modify_2_User_Modify_Data_Empty_Field;
import claireandbruce.com.test.account.CBT10_Test_User_Modify_3_User_Modify_Data_Invalid_Name_Field;
import claireandbruce.com.test.account.CBT11_Test_User_Modify_4_User_Modify_Data_Field_EMail_Invalid;
import claireandbruce.com.test.account.CBT12_Test_User_Modify_5_User_Modify_Field_Date_Born_Invalid;
import claireandbruce.com.test.cartShopping.*;
import claireandbruce.com.test.navigationWeb.CBT31_Test_Home_Page_Navigability_1_Navigability_for_Look_Not_Login;

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
	
	//se declaran las clases que contienen cada una un testcase
	//LoginWithCredentiasl.class,
	//Pruebas.class
	CBT9_Test_User_Modify_2_User_Modify_Data_Empty_Field.class,
	CBT10_Test_User_Modify_3_User_Modify_Data_Invalid_Name_Field.class,
	CBT11_Test_User_Modify_4_User_Modify_Data_Field_EMail_Invalid.class,
	CBT12_Test_User_Modify_5_User_Modify_Field_Date_Born_Invalid.class,
	CBT31_Test_Home_Page_Navigability_1_Navigability_for_Look_Not_Login.class
	
})

public class PruebasSuite {

}
