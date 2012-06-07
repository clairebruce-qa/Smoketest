package claireandbruce.com.test.register;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * CBT3
 * @author NEWSHORE
 *
 */
public class TestUserRegister2UserRegistrationEmptyField extends ClaireandbruceTestCase{

	@Before
	public void setUp() throws Exception {
		selenium.deleteAllVisibleCookies();  
		selenium.open("");
		  if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
		   selenium.click("//a[@id='overridelink']");
		   System.out.print("Si entra");
		  }	
		
		selenium.click("//a[contains(text(),'Reg�strate')]");
		selenium.waitForPageToLoad("30000");
		selenium.isElementPresent("css=label.required");
		
	}

	@Test
	public void CBT3() throws Exception {
	
		selenium.click("id=registerSubmitButton");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("id=advice-required-entry-firstname")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("id=advice-required-entry-lastname")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("id=advice-required-entry-email_address")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("id=advice-required-entry-password")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("id=advice-validate-terms-")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}