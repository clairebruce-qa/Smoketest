

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import claireandbruce.com.test.account.TestSubscriptionsYesNoAccount;
import claireandbruce.com.test.account.TestUserAddressModify1EditShippingAddressUserwithEmptyFields;
import claireandbruce.com.test.account.TestUserModify1UserModifyDataValidField;
import claireandbruce.com.test.account.TestSendMessageFormularioContactoInvalidDataAccount;
import claireandbruce.com.test.account.TestUserModify2UserModifyDataEmptyField;
import claireandbruce.com.test.account.TestUserModify3UserModifyDataNoValidNameField;
import claireandbruce.com.test.account.TestUserModify4UserModifyDataFieldEMailNoValid;
import claireandbruce.com.test.login.TestIncorrectLogonInvalidUserFormatAccount;
import claireandbruce.com.test.login.TestIncorrectLogonInvalidPasswordAccount;
import claireandbruce.com.test.register.TestUserRegister2UserRegistrationEmptyField;
import claireandbruce.com.test.register.TestUserRegister3UserRegistrationFieldEMailInvalid;

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
	

	TestUserModify2UserModifyDataEmptyField.class,        		//CBT9 - CBT32
	TestUserRegister2UserRegistrationEmptyField.class,    		//CBT3 - CBT52 
	TestUserRegister3UserRegistrationFieldEMailInvalid.class, 	//CBT4 - CBT53
	TestUserModify1UserModifyDataValidField.class,        		//CBT8 - CBT54
	TestUserModify3UserModifyDataNoValidNameField.class,  		//CBT10 - CBT55
	TestUserModify4UserModifyDataFieldEMailNoValid.class, 		//CBT11 - CBT56
	TestUserAddressModify1EditShippingAddressUserwithEmptyFields.class, //CBT16 - CBT57
	TestIncorrectLogonInvalidUserFormatAccount.class, 	  		//CBT56 - CBT58
	TestIncorrectLogonInvalidPasswordAccount.class,		  		//CBT57 - CBT59
	TestSubscriptionsYesNoAccount.class,				  		//CBT81 - CBT60
	TestSendMessageFormularioContactoInvalidDataAccount.class 	//CBT98 - CBT61
	
	
})

public class ExtrasSuite {

}
