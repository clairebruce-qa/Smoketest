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

import claireandbruce.com.test.cartShopping.CBT78_Test_CorrectChangeUnits_TuCompra;
import claireandbruce.com.test.cartShopping.CBT79_Test_CorrectAddProduct_Cart_LogonUser;

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
		CBT78_Test_CorrectChangeUnits_TuCompra.CBT78(selenium);
	}
}
