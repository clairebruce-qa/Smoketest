package claireandbruce.com.test.navigability;

import static org.junit.Assert.*;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

public class CBT_52_Test_Home_Page_Navigability_10_Test_NavigationByCategoryOutStanding_Bags_Accesories extends ClaireandbruceTestCase{
	@Test
	public void CBT52() throws Exception {
		
		selenium.open("/es_es/");
		int i=1;
		
		
		while(selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[3]/ul/li["+i+"]/a")){
			//Remover articulos mientras el carrito no este vacío
			
			String text= selenium.getText("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[3]/ul/li["+i+"]/a");
			System.out.println("\n ESTE ES EL BENDITO TEXTO"+text);
			Helper.clickAndVerify(selenium, "xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[3]/ul/li["+i+"]/a", text, "class=breadcrumbs-present");
			Helper.clickAndVerify(selenium, "xpath=html/body/div/div[2]/ul/li[1]/a", "Tu cuenta", "css=li..last > a.text-lucida-black");
			i++;
			
		}
		 i=0;
		while(selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[4]/ul/li["+i+"]/a")){
			//Remover articulos mientras el carrito no este vacío
			
			String text= selenium.getText("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[3]/ul/li["+i+"]/a");
			System.out.println("\n ESTE ES EL BENDITO TEXTO"+text);
			Helper.clickAndVerify(selenium, "xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[3]/ul/li["+i+"]/a", text, "class=breadcrumbs-present");
			Helper.clickAndVerify(selenium, "xpath=html/body/div/div[2]/ul/li[1]/a", "Tu cuenta", "css=li..last > a.text-lucida-black");
			i++;
			
		}

	
	}
}
