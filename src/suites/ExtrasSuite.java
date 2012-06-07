package suites;

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
	
	TestUserRegister2UserRegistrationEmptyField.class,
	TestUserRegister3UserRegistrationFieldEMailInvalid.class,
	TestUserModify1UserModifyDataValidField.class,
	TestUserModify2UserModifyDataEmptyField.class,
	TestUserModify3UserModifyDataNoValidNameField.class,
	TestUserModify4UserModifyDataFieldEMailNoValid.class,
	TestUserAddresModify1EditShippingAddressUserwithEmptyFields.class,
	TestIncorrectLogonInvalidUserFormatAccount.class,
	TestIncorrectLogonInvalidPasswordAccount.class,
	TestSubscriptionsYesNoAccount.class,
	TestSendMessageFormularioContactoInvalidDataAccount.class
	
	
})

public class ExtrasSuite {

}
