package claireandbruce.com.test.account;

import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;
import org.testng.Assert;

import claireandbruce.com.test.basicsFlows.Lib_CorrectLogon_ValidUser_Accout;

import basics.ClaireandbruceTestCase;
/**
 * 
 *Este Caso de Prueba verificará el correcto funcionamiento del proceso  encargado
 *de las modificaciones  realizadas a las direcciones previamente ingresadas  a la
 *cuenta de un usuario. El éxito del proceso se evaluará  al mostrar  mensajes  de
 *advertencia  "Utilice  solo  letras (a-z o A-Z) en  este campo."  en los  campos
 *Nombre, Apellidos y  Población; luego de ingresar en ellos caracteres especiales 
 *( $%&# ) y números.
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
		
		//El usuario debe tener su sesión iniciada
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")){
			
			Lib_CorrectLogon_ValidUser_Accout.CBT55(selenium);
		
		}
		
		
		
		//Ingresar a traves del botón 'TUS DIRECCIONES' Área privada'
		if(selenium.isElementPresent("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p")){
			selenium.click("xpath=html/body/div/div[2]/div[1]/div/div/div[2]/a[2]/div/div/p");
			
		}
		
		
		selenium.waitForPageToLoad("60000");
		if(selenium.isElementPresent("xpath=.//*[@id='spanNewAddress']"))
		{
				
			// Campos Nombre, Apellidos, Dirección, Población, Código Postal, Teléfono con valores vacíos
			// Campos Provincía y País	con la selección por defecto.
			selenium.click("xpath=.//*[@id='spanNewAddress']");
			
			selenium.type("xpath=.//*[@id='firstname']",""); //Nombre
			selenium.type("xpath=.//*[@id='lastname']",""); //Apellidos
			selenium.type("xpath=.//*[@id='street_1']","");	//Dirección
			selenium.type("xpath=.//*[@id='city']",""); //Población
			selenium.type("xpath=.//*[@id='zip']",""); //Código postal
			selenium.type("xpath=.//*[@id='telephone']",""); //Teléfono Móvil
						
			selenium.click("xpath=.//*[@id='form-validate-']/div[2]/button[2]"); //Click en botón Guardar
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
				Assert.fail("Campo población esta por defecto");
			}
			if(!selenium.isElementPresent("xpath=//*[@id='advice-required-entry-telephone']")){
				Assert.fail("Campo Teléfono permite debe ser obligatorio");
			}
			
			
			// Campo Nombre, Apellidos, Población con valores númericos
			//selenium.click("xpath=.//*[@id='spanNewAddress']");
			
			selenium.type("xpath=.//*[@id='firstname']","Sandra Milena"+i); //Nombre
			selenium.type("xpath=.//*[@id='lastname']","Torres Valencia"+i); //Apellidos
			selenium.type("xpath=.//*[@id='city']","Barcelona"+i); //Población
			selenium.type("xpath=.//*[@id='zip']","jhfd");// Código Postal
			selenium.click("xpath=.//*[@id='form-validate-']/div[2]/button[2]"); //Click en botón Guardar
			//selenium.waitForPageToLoad("10000");
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-name-firstname']")){
				Assert.fail("Formato no valido para campo nombre");
			}
			
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-name-lastname']")){
				Assert.fail("Formato no valido para campo apellido");
			}
			
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-name-city']")){
				Assert.fail("Formato no valido para campo población");
			}
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-number-zip']")){
				Assert.fail("Formato no valido para campo código postal");
			}
			
			
			// Campo Nombre, Apellidos, Población con valores númericos
			//selenium.click("xpath=.//*[@id='spanNewAddress']");
			
			selenium.type("xpath=.//*[@id='firstname']","$%&%"); //Nombre
			selenium.type("xpath=.//*[@id='lastname']","%·%·$"); //Apellidos
			selenium.type("xpath=.//*[@id='street_1']","$&/()");	//Dirección
			selenium.type("xpath=.//*[@id='city']","$·%$·$·"); //Población
			selenium.type("xpath=.//*[@id='zip']","$%&/()");// Código Postal
			selenium.click("xpath=.//*[@id='form-validate-']/div[2]/button[2]"); //Click en botón Guardar
			//selenium.waitForPageToLoad("10000");
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-name-firstname']")){
				Assert.fail("Formato no valido para campo nombre");
			}
			
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-name-lastname']")){
				Assert.fail("Formato no valido para campo apellido");
			}
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-name-city']")){
				Assert.fail("Formato no valido para campo población");
			}
			if(!selenium.isElementPresent("xpath=.//*[@id='advice-validate-number-zip']")){
				Assert.fail("Formato no valido para campo código postal");
			}
		
		}
		else
		{
			Assert.fail("Element not found");
		}
		
	}

}
