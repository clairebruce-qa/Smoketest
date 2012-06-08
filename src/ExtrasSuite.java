

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import claireandbruce.com.test.account.TestUserAddresModify1EditShippingAddressUserwithEmptyFields;
import claireandbruce.com.test.account.TestSubscriptionsYesNoAccount;
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
	
	TestUserRegister2UserRegistrationEmptyField.class,    //CBT3
	TestUserRegister3UserRegistrationFieldEMailInvalid.class, //CBT4
	TestUserModify1UserModifyDataValidField.class,        //CBT8
	TestUserModify2UserModifyDataEmptyField.class,        //CBT9
	TestUserModify3UserModifyDataNoValidNameField.class,  //CBT10
	TestUserModify4UserModifyDataFieldEMailNoValid.class, //CBT11
	TestUserAddresModify1EditShippingAddressUserwithEmptyFields.class, //CBT16
	TestIncorrectLogonInvalidUserFormatAccount.class, 	  //CBT56
	TestIncorrectLogonInvalidPasswordAccount.class,		  //CBT57
	TestSubscriptionsYesNoAccount.class,				  //CBT81
	TestSendMessageFormularioContactoInvalidDataAccount.class //CBT98
	
	
})

public class ExtrasSuite {

}
