package claireandbruce.com.test.login.checkout;

import static org.junit.Assert.*;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import claireandbruce.com.test.cartShopping.CBT76_Test_CorrectAddProduct_Cart_NoLoginUser;

import basics.ClaireandbruceTestCase;

public class CBT71_Test_CorrectLogon_ValidUser_Checkout extends ClaireandbruceTestCase{
	
	
	/*
	 * Este Caso de Prueba  verificar� el correcto   funcionamiento
	 * del proceso de login  de  un usuario durante el checkout, al
	 * validar la informaci�n  ingresada por el usuario  al momento
	 * de realizar esta acci�n.   El �xito del caso de prueba  ser�
	 * la verificaci�n del usuario en el sistema al mostrar mensaje
	 * de saludo en el Header y el redireccionamiento a la interfaz
	 * "TU COMPRA"
	 * 
	 * */
	CBT76_Test_CorrectAddProduct_Cart_NoLoginUser tb23=new CBT76_Test_CorrectAddProduct_Cart_NoLoginUser();
	
	@Test
	public void CBT71() throws Exception
	{

		
		selenium.open("");
		  if(selenium.isTextPresent("Salir")){
			  
			  while(!selenium.isTextPresent("0 art�culos 0 �")){
					//Remover articulos mientras el carrito no este vac�o
					selenium.click("xpath=.//*[@id='cartHeader']");
					selenium.click("class=btn-remove");
					assertTrue(selenium.getConfirmation().matches("�Est� seguro de que desea eliminar este art�culo de la cesta de la compra[\\s\\S]$"));
					selenium.waitForPageToLoad("10000");
				}
			  Claireandbruce.logout(selenium);
		  }else{

			while(!selenium.isTextPresent("0 art�culos 0 �")){
				//Remover articulos mientras el carrito no este vac�o
				selenium.click("xpath=.//*[@id='cartHeader']");
				selenium.click("class=btn-remove");
				assertTrue(selenium.getConfirmation().matches("�Est� seguro de que desea eliminar este art�culo de la cesta de la compra[\\s\\S]$"));
				selenium.waitForPageToLoad("10000");
			}}
		

		tb23.CBT76();
		String text= selenium.getText("xpath=.//*[@id='cartHeader']");
		assertTrue(selenium.isElementPresent("link=Compra ahora"));
		
		
		selenium.click("link=Compra ahora");
		selenium.waitForPageToLoad("60000");
		assertTrue(selenium.isElementPresent("css=div.product-brand"));
		selenium.click("class=button btn-proceed-checkout btn-checkout");
		selenium.waitForPageToLoad("60000");
		if(selenium.getTitle().equals("/es_es/aitcheckout/checkout/"))
		{
			Helper.log("Page CheckOut Failed!!!!!!!");
		}
		
		//selenium.open("/es_es/aitcheckout/checkout/");
		selenium.type("id=email", "claireandbruceqa@gmail.com");
		selenium.type("id=pass", "123456");
		selenium.click("id=send2");
		selenium.waitForPageToLoad("60000");
		selenium.click("id=cartHeader");
				
		if (!text.equals(selenium.getText("xpath=.//*[@id='cartHeader']"))) 
		{
			Helper.log("Product Error no found "+selenium.getText("xpath=.//*[@id='cartHeader']"));
			
		}
		
		if(selenium.getTitle().equals("/es_es/aitcheckout/checkout/index/"))
		{
			Helper.log("Login CheckOut Failed!!!!!!!");
		}
		
		
		while(!selenium.isTextPresent("0 art�culos 0 �")){
			//Remover articulos mientras el carrito no este vac�o
			selenium.click("xpath=.//*[@id='cartHeader']");
			selenium.click("class=btn-remove");
			assertTrue(selenium.getConfirmation().matches("�Est� seguro de que desea eliminar este art�culo de la cesta de la compra[\\s\\S]$"));
			selenium.waitForPageToLoad("10000");
		}
	}
		
		
		
		
	}


