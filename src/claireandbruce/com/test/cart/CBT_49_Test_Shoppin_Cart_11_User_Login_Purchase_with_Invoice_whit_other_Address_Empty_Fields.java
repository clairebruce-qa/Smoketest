package claireandbruce.com.test.shopping;

import static org.junit.Assert.*;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT_49_Test_Shoppin_Cart_11_User_Login_Purchase_with_Invoice_whit_other_Address_Empty_Fields extends ClaireandbruceTestCase{

	CBT23_Test_Shopping_Cart_1_Add_Other_Item_Shopping_Cart tb = new CBT23_Test_Shopping_Cart_1_Add_Other_Item_Shopping_Cart();
	@Test
	public void testCBT49() throws Exception {
		 
		tb.CBT23();
		selenium.click("link=Compra ahora");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=span.nobr > cufon.cufon.cufon-canvas > canvas");
		assertTrue(selenium.isElementPresent("//form[@id='co-shipping-method-form']/fieldset/dl/dd[2]/ul/li/div"));
		selenium.click("xpath=(//button[@type='button'])[4]");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=showFakeBilling");
		assertTrue(selenium.isElementPresent("id=fakeCompany"));
		selenium.click("id=showFakeBillingExtended");
		assertTrue(selenium.isElementPresent("id=showFakeBillingExtended"));
		assertTrue(selenium.isElementPresent("id=billing:firstname"));
		selenium.type("id=fakebilling:taxvat", "");
		selenium.type("id=billing:firstname", "");
		selenium.click("id=billing:lastname");
		selenium.type("id=billing:lastname", "");
		assertTrue(selenium.isElementPresent("id=advice-required-entry-billing:firstname"));
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-billing:firstname"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-billing:lastname"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("id=p_method_sermepa");
		selenium.click("css=button.button.btn-checkout");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-billing:street1"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-billing:city"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Por favor selecciona una provincia".equals(selenium.getText("//li[@id='billing-new-address-form']/fieldset/ul/li[5]/div[2]/div/div/div/div"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-billing:postcode"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("España".equals(selenium.getText("//li[@id='billing-new-address-form']/fieldset/ul/li[6]/div[2]/div/div/div/div"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Campo obligatorio.".equals(selenium.getText("id=advice-required-entry-billing:telephone"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Credit card number does not match credit card type.".equals(selenium.getText("id=advice-validate-cc-type-sermepa_cc_number"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("--Seleccione--".equals(selenium.getText("css=li > div.input-box.validation-passed > div.selreplace_select > div > div.selreplace_selectinner"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Mes".equals(selenium.getText("css=div.v-fix > div.selreplace_select > div > div.selreplace_selectinner"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Año".equals(selenium.getText("//li[@id='sermepa_cc_type_exp_div']/div/div[2]/div/div/div"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("".equals(selenium.getText("id=sermepa_cc_cid"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		assertEquals("off", selenium.getValue("id=agreement-1"));
	}

}
