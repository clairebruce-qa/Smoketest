package claireandbruce.com.test.account;

import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;
import org.testng.Assert;

import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;

import basics.ClaireandbruceTestCase;
/**
 * 
 *Este Caso de Prueba verificar� el correcto funcionamiento del proceso  encargado
 *de las modificaciones  realizadas a las direcciones previamente ingresadas  a la
 *cuenta de un usuario. El �xito del proceso se evaluar�  al mostrar  mensajes  de
 *advertencia  "Utilice  solo  letras (a-z o A-Z) en  este campo."  en los  campos
 *Nombre, Apellidos y  Poblaci�n; luego de ingresar en ellos caracteres especiales 
 *( $%&# ) y n�meros.
 * 
 * 
 * @author NEWSHORE
 *
 */
public class Test_IncorrectEditionAddress_SpecialCharacters_Account extends ClaireandbruceTestCase {

	@Test
	public void CBT70() throws Exception{
		
		
		
		Helper.log("*** CBT70 *** ");
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		int i =(int)(Math.random()*100);
		
		//El usuario debe tener su sesi�n iniciada
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			
			Lib_CorrectLogon_ValidUser_Accout.CBT55(selenium);
		
		}
		
		
		
		//Ingresar a traves del bot�n 'TUS DIRECCIONES' �rea privada'
		if(selenium.isElementPresent("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p")){
			selenium.click("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p");
			
		}
		
		
		selenium.waitForPageToLoad("60000");
		if(selenium.isElementPresent("xpath=.//*[@id='spanNewAddress']"))
		{
				
			// Campos Nombre, Apellidos, Direcci�n, Poblaci�n, C�digo Postal, Tel�fono con valores vac�os
			// Campos Provinc�a y Pa�s	con la selecci�n por defecto.
			selenium.click("xpath=.//*[@id='spanNewAddress']");
			
			selenium.type("xpath=.//*[@id='firstname']",""); //Nombre
			selenium.type("xpath=.//*[@id='lastname']",""); //Apellidos
			selenium.type("xpath=.//*[@id='street_1']","");	//Direcci�n
			selenium.type("xpath=.//*[@id='city']",""); //Poblaci�n
			selenium.type("xpath=.//*[@id='zip']",""); //C�digo postal
			selenium.type("xpath=.//*[@id='telephone']",""); //Tel�fono M�vil
						
			selenium.click("xpath=.//*[@id='form-validate-']/div[2]/button[2]"); //Click en bot�n Guardar
			//selenium.waitForPageToLoad("10000");
			if(!selenium.isElementPresent("xpath=//div[@id='advice-required-entry-firstname']")){
				Assert.fail("Campo nombre es obligatorio");
			}
			
			if(!selenium.isElementPresent("xpath=//div[@id='advice-required-entry-lastname']")){
				Assert.fail("Campo nombre es obligatorio");
			}
			if(!selenium.isElementPresent("xpath=//div[@id='advice-required-entry-street_1']")){
				Assert.fail("Campo nombre es obligatorio");
			}
			if(!selenium.isElementPresent("xpath=//div[@id='advice-required-entry-city']")){
				Assert.fail("Campo nombre es obligatorio");
			}
			if(!selenium.isElementPresent("xpath=//div[@id='advice-required-entry-zip']")){
				Assert.fail("Campo nombre es obligatorio");
			}
			
			if("POR FAVOR SELECCIONA UNA POBLACION".equals(selenium.getText("xpath=.//*[@id='form-validate-']/div[1]/ul[2]/li[2]/div[3]/div/div[1]")))
			{
				Assert.fail("Campo poblaci�n esta por defecto");
			}
			if(!selenium.isElementPresent("xpath=//*[@id='advice-required-entry-telephone']")){
				Assert.fail("Campo Tel�fono permite debe ser obligatorio");
			}
			
			
			// Campo Nombre, Apellidos, Poblaci�n con valores n�mericos
			//selenium.click("xpath=.//*[@id='spanNewAddress']");
			
			selenium.type("xpath=.//*[@id='firstname']","Sandra Milena"+i); //Nombre
			selenium.type("xpath=.//*[@id='lastname']","Torres Valencia"+i); //Apellidos
			selenium.type("xpath=.//*[@id='city']","Barcelona"+i); //Poblaci�n
			selenium.type("xpath=.//*[@id='zip']","jhfd");// C�digo Postal
			selenium.click("xpath=.//*[@id='form-validate-']/div[2]/button[2]"); //Click en bot�n Guardar
			//selenium.waitForPageToLoad("10000");
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-name-firstname']")){
				Assert.fail("Formato no valido para campo nombre");
			}
			
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-name-lastname']")){
				Assert.fail("Formato no valido para campo apellido");
			}
			
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-name-city']")){
				Assert.fail("Formato no valido para campo poblaci�n");
			}
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-number-zip']")){
				Assert.fail("Formato no valido para campo c�digo postal");
			}
			
			
			// Campo Nombre, Apellidos, Poblaci�n con valores n�mericos
			//selenium.click("xpath=.//*[@id='spanNewAddress']");
			
			selenium.type("xpath=.//*[@id='firstname']","$%&%"); //Nombre
			selenium.type("xpath=.//*[@id='lastname']","%�%�$"); //Apellidos
			selenium.type("xpath=.//*[@id='street_1']","$&/()");	//Direcci�n
			selenium.type("xpath=.//*[@id='city']","$�%$�$�"); //Poblaci�n
			selenium.type("xpath=.//*[@id='zip']","$%&/()");// C�digo Postal
			selenium.click("xpath=.//*[@id='form-validate-']/div[2]/button[2]"); //Click en bot�n Guardar
			//selenium.waitForPageToLoad("10000");
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-name-firstname']")){
				Assert.fail("Formato no valido para campo nombre");
			}
			
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-name-lastname']")){
				Assert.fail("Formato no valido para campo apellido");
			}
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-name-city']")){
				Assert.fail("Formato no valido para campo poblaci�n");
			}
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-number-zip']")){
				Assert.fail("Formato no valido para campo c�digo postal");
			}
		
		}
		else
		{
			Assert.fail("Element not found");
		}
		
	}

}
