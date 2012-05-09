package testcases;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import lib.ElementNotFoundException;
import lib.Helper;
import lib.Claireandbruce;

import claireandbruce.com.test.cart.CBT26_Test_CorrectAddProduct_Cart_LogonUser;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

public class Pruebas extends ClaireandbruceTestCase {
		
	@Test
	public void test_FooterMiddleNavigation_Tendencias() throws Exception{
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		Helper.log("AMBIENTE DE PRUEBA: "+selenium.getLocation()+"\n");
		
		if(selenium.isTextPresent("Salir")){
			Claireandbruce.logout(selenium);
		}
		
		int columna=1, literal;
		
		if(selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[1]/h3/cufon/canvas")){
			
			//Se recorre la columna de ropa y zapatos.
			while(selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div["+columna+"]/h3/cufon/canvas") && columna<=2){
				literal=1;
				
				//Se recorre los links
				while(selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div["+columna+"]/ul/li["+literal+"]/a")){
					String textoLink = selenium.getText("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div["+columna+"]/ul/li["+literal+"]/a");
					Helper.clickAndVerify(selenium, "xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div["+columna+"]/ul/li["+literal+"]/a", 
							textoLink, "class=breadcrumbs-present");
					Helper.log("Bread crumbs '"+textoLink+"'. OK.");
					assertTrue(selenium.isElementPresent("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+literal+"]/div/div/strong"));
					Helper.log("Link "+textoLink+" underlined");
					///Se regresa a HomePage
					selenium.click("xpath=//img[@alt='Claire and Bruce']");
					selenium.waitForPageToLoad("25000");
					
					literal++;
				}
				columna++;
			}
			
		}else {
			Helper.log("Link 'ROPA' not found in Outstanding");
		}	
	}
}
