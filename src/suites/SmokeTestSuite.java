package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import claireandbruce.com.test.cart.*;
import claireandbruce.com.test.login.*;


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
	CBT2_Test_CorrectLogon_ValidUser_TuCuenta.class,
	CBT3_Test_IncorrectLogon_InvalidUserFormat_TuCuenta.class,
	CBT4_Test_IncorrectLogon_InvalidPassword_TuCuenta.class,
	CBT23_Test_CorrectAddProduct_Cart_NoLoginUser.class,
	CBT24_Test_IncorrectAddProduct_UnselectedSize_Cart.class
	
})

public class SmokeTestSuite {

}
