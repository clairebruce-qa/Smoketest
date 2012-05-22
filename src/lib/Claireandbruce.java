package lib;
import static org.junit.Assert.assertEquals;

import java.awt.event.KeyEvent;

import com.thoughtworks.selenium.*;

import junit.framework.Assert;

public class Claireandbruce {

	static SeleneseTestCase stc = new SeleneseTestCase();
	static long small 	= 3000;
	static long medium 	= 7000;
	static long big 	= 20000;
	static String TIME_OUT = "30000";

	/**
	 * 
	 * Login to teraBox website
	 * 
	 * @param selenium
	 * @param username string
	 * @param password string
	 * @return String loginOk or the error message
	 */
	public static String login(Selenium selenium, String username, String password) throws Exception{
		//R2
		String message = null;
		Helper.log("Open Homepage");
		
		//Si no esta presente el formulario para ingresar los datos de usuario
		if(!selenium.isElementPresent("xpath=//form[@id='login-form']/div/cufon[3]/canvas")) {
			
			
			// comente prueba
			selenium.deleteAllVisibleCookies();
			
			selenium.open("");

			selenium.waitForPageToLoad("15000");
			if (selenium.isElementPresent("xpath=//a[@id='overridelink']")){
				selenium.click("//a[@id='overridelink']");
			}
			//selenium.waitForPageToLoad("60000");
			//check Autenticacion con cuenta is on the page
			Helper.waitForElement(selenium, "//a[contains(text(), 'Tu cuenta')]", "Inicio de sesion  not found in "+ selenium.getLocation());
	
			selenium.click("//a[contains(text(), 'Tu cuenta')]");
			//selenium.waitForPageToLoad("60000");			
		}
		selenium.waitForPageToLoad("60000");
		
		selenium.type("xpath=.//*[@id='email']", username);
		selenium.type("xpath=.//*[@id='pass']", password);		
		selenium.click("//button[contains(@id,'send2')]");		
		
		if (!selenium.isElementPresent( "class=validation-advice")){
			selenium.waitForPageToLoad("60000");
			
			if (selenium.isTextPresent("Salir")){
				message = "loginOk";
			}else if (selenium.isElementPresent("//div[@id='error-message-login']")){
				message = "Fail";
			}
		}
		
		if(message == null){
			Helper.log("Login Error " + selenium.getLocation());
			//Assert.fail("Login Error " + selenium.getLocation());
		}
		return message;
	}


	/**
	 * 
	 * Logout 
	 * 
	 * @param selenium
	 * @return null
	 * @throws Exception 
	 */
	
	public static void logout(Selenium selenium) throws Exception {

		Helper.waitForElement(selenium, "xpath=//a[contains(@href, '/customer/account/logout/')]", "Log-out link not found in the page");
		selenium.click("xpath=//a[contains(@href, '/customer/account/logout/')]");
		selenium.waitForPageToLoad("30000");
		if(!selenium.isElementPresent("//a[contains(text(), 'Salir')]")) {
			Helper.log("Logout done!");
		} else {
			Helper.log("NO Logout!");
		}
		
	}

	/**
	 * 
	 * ChangePassword
	 * 
	 * @param selenium
	 * @return null
	 * @throws Exception 
	 */
	
	public static void changePassword(Selenium selenium, String oldPass, String newPass) throws Exception {

		//Navigate to Manage Account page
		Helper.clickAndVerify(selenium, "//a[@id='Manage-account']", "My Account", "//a[@href='/costumer/account/app/ManageAccount']");
		
		//click "Change Password" link
		Helper.log("click Change Password Link at: " + selenium.getLocation());
		selenium.click("//a[@href='/costumer/account/changePasswordStepOne.jsp']");
		
		selenium.type("PASSWORD", newPass);
		selenium.click("//button[@id='changepassword']");
		selenium.waitForPageToLoad("15000");
		
		selenium.typeKeys("PASSWORD1", newPass);
		selenium.typeKeys("PASSWORD2", newPass);
		selenium.click("//button[@id='changepassword']");
		selenium.waitForPageToLoad("15000");
	
		//Se busca un texto para comprobar que se haya cargado parte del look and feel determinado
		Assert.assertTrue(selenium.isTextPresent("Your password has been changed and will be in effect next time you login"));
		
	}
	
	/**
	 * 
	 * Set the web site's language to ES and check
	 * 
	 * @param selenium
	 * @return null
	 */
	public static void setLanguageES(Selenium selenium) throws Exception {
		//R2

		Thread.sleep(small);

		//click settings
		Helper.log("click settings on page " + selenium.getLocation());
		selenium.open("/application/Configuration");
		
		//wait for the My Account settings page
		Helper.waitForElement(selenium, "//div[@id='conf-userinfo']", "My Account settings window not appear in the page");

		//click set language
		Helper.log("click set language on page " + selenium.getLocation());
		
		//select the language
		Helper.log("select Spanish language on page " + selenium.getLocation());
		selenium.click("class=jNiceSelectText");
		//selenium.select(Helper.getIDFieldName(selenium, "Language"), "label=English");
		// se escapea la letra enye  por \u00F1
		selenium.click("link=Espa\u00F1ol (Espa\u00F1a)");
		
		
		//click save button
		Helper.log("click save button on page " + selenium.getLocation());
		selenium.click("//div[@class='button-blue btn-apply changes right']");
		Thread.sleep(5000);
		

		//Verify language is EN
		for (int second = 0;; second++) {
			if (second >= 60) SeleneseTestCase.fail("timeout - //div[@id='logged right'] not found");
			try { if ("Bienvenido".equals(selenium.getText("//div[@class='logged right']").substring(1, 11))) break; } catch (Exception e) {}
			Thread.sleep(small);
		}	
		
		//click on software button in configuration section to asses english test
		Helper.log("click software  button on page " + selenium.getLocation());
		selenium.click("//li[@id='menu-soft']/a/cufon/canvas");
		for (int second = 0;; second++) {
			if (second >= 60) SeleneseTestCase.fail("not all the text is in spanish");
			try {if ("Aplicaciones".equals(selenium.getText("//li[@id='menu-soft']/a/cufon")) && "Instala".equals(selenium.getText("//div[@id='conf_software']/div/div[1]/div[1]").substring(0, 7))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		//return to the file manager page
		selenium.open("/application/FileExplorer");
		Thread.sleep(10000);
	}


	/**
	 * 
	 * Set the web site's language to EN and check
	 * 
	 * @param selenium
	 * @return null
	 */
	public static void setLanguageEN(Selenium selenium) throws Exception {
		//R2
		Thread.sleep(small);

		//click settings
		Helper.log("click settings on page " + selenium.getLocation());
		selenium.open("/application/Configuration");
		
		//wait for the My Account settings page
		Helper.waitForElement(selenium, "//div[@id='conf-userinfo']", "My Account settings window not appear in the page");

		//click set language
		Helper.log("click set language on page " + selenium.getLocation());
		
		//select the language
		Helper.log("select English language on page " + selenium.getLocation());
		selenium.click("class=jNiceSelectText");
		//selenium.select(Helper.getIDFieldName(selenium, "Language"), "label=English");
		selenium.click("link=English");
		
		//click save button
		Helper.log("click save button on page " + selenium.getLocation());
		selenium.click("//div[@class='button-blue btn-apply changes right']");
		Thread.sleep(5000);
		
		//Verify language is EN
		for (int second = 0;; second++) {
			if (second >= 60) SeleneseTestCase.fail("timeout - //div[@id='logged right'] not found");
			//Helper.log(selenium.getText("//a[@class='btn-exit right']"));
			try { if ("log out".equals(selenium.getText("//a[@class='btn-exit right']"))) break; } catch (Exception e) {}
			Thread.sleep(small);
		}	
		
		//click on software button in configuration section to asses english test
		Helper.log("click software  button on page " + selenium.getLocation());
		selenium.click("//li[@id='menu-soft']/a/cufon/canvas");
		for (int second = 0;; second++) {
			if (second >= 60) SeleneseTestCase.fail("not all the text is in engish");
			try {if ("Software".equals(selenium.getText("//li[@id='menu-soft']/a/cufon")) && "Download in your desktop the application in order to:".equals(selenium.getText("//div[@id='conf_software']/div/div[1]/div[1]"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		//return to the file manager page
		selenium.open("/application/FileExplorer");
		Thread.sleep(10000);
	}


	/**
	 * 
	 * Search for a string using the search box
	 * 
	 * @param selenium
	 * @param textToSearch
	 * @return null
	 */
	public static String search(Selenium selenium,String textToSearch) throws Exception{
		String message = null;
		
		//wait the search form
		Helper.log("wait the search form on page " + selenium.getLocation());
		Helper.waitForElement(selenium, "//*[@id='search']", "SearchTextBox not found in " + selenium.getLocation());

		//type the text to search
		Helper.log("type text to search: " + textToSearch +" on page " + selenium.getLocation());
		selenium.type("search", textToSearch);

		//click the search button
		Helper.log("click search button on page " + selenium.getLocation());
		selenium.click("search-submit");

		//wait for the results
		Helper.log("wait for the results and verify on page " + selenium.getLocation());
		Helper.waitForElement(selenium, "//div[@id='search_results_viewer_24_search_results_viewer_container']", "search_results_viewer_24_search_results_viewer_container not found in " + selenium.getLocation());

		//Assert.assertEquals("1 results.", selenium.getText("//div[@id='section-search']/div[1]/div[1]/span"));
			
		if(selenium.isElementPresent("//a[contains(.,'"+textToSearch+"')]")){
			
			message = "searchOk";
			
			Helper.log(message);
			return message;
		}else{
				message = "No match found in search for "+textToSearch;
			
				Helper.log(message);
				return message;
		}	
	}

	public static void gotoHomePage(Selenium selenium) throws Exception {

		Thread.sleep(3000);

		//click file manager link
		Helper.log("Redirect to location of file manager page (home) " + selenium.getLocation());
		  	//IPV: add on 28/06/2010
		
		//Redirect to folder /application/FileExplorer
		selenium.open("/application/FileExplorer");
		
		//wait file manager page
		Helper.log("wait file manager page on page " + selenium.getLocation());
		Helper.waitForElement(selenium, "//*[@id='filebrowser_container']", "File manager page not shown in " + selenium.getLocation());
		Thread.sleep(3000);
	}


	public static String deleteAllOnlineFiles(Selenium selenium) throws Exception {

		Helper.log("execute deleteAllOnlineFiles on page " + selenium.getLocation());
		
		Claireandbruce.gotoHomePage(selenium);

		if (!selenium.isElementPresent("//tr[@id[contains(.,'file_')]]")){

			Helper.log("There are no files or folders to delete in OnlineFiles " + selenium.getLocation());
			return ("There are no files or folders to delete in " +
			"OnlineFiles");
		}


		//click select all checkBox
		Helper.log("click select all checkBox on page " + selenium.getLocation());
		selenium.click("//input[@class='left selectAllChk']");
		
		Thread.sleep(small);

		//click delete button
		Thread.sleep(1000);//
		Helper.log("click delete button on page " + selenium.getLocation());
		selenium.click("//div[@class='button-grey btn-delete left']"); //IPV test
		//selenium.click("//*[@class='MoveToRecycleBin']");

		Thread.sleep(small);

		//wait for delete confirmation window and verify 
		Helper.log("wait for delete window and verify on page " + selenium.getLocation());
		Helper.waitForElement(selenium, "//div[@id='dialog-popup']", "Delete windows not shown");
		
		//wait for delete confirmation TEXT	
		Helper.log("wait for delete confirmation TEXT on page " + selenium.getLocation());
		
		//Helper.waitForText(selenium, "//div[@class='bg-right-btn']", "Accept"); 
		Helper.waitForElement(selenium, "//div[@class='bg-right-btn']", "Accept button not shown");

		//click  delete button to confirm
		Helper.log("click  delete button to confirm on page " + selenium.getLocation());
		//selenium.click("//div[@class='bg-right-btn']");
		selenium.click("//div[@id='confirm-generic']/div/div/div[4]/div/div");
		
		
		//Helper.waitForElementNoPresent(selenium, "//tr[@id[contains(.,'file_')]]", "Delete files windows is still present");

		Helper.waitForElement(selenium, "//*[@id='filebrowser_container']", "Online files page not shown");

		selenium.refresh();
		selenium.waitForPageToLoad(TIME_OUT);

		//assert that the "online files" is empty   
		SeleneseTestCase.assertEquals("/ this directory contains 0 folders and 0 files.", selenium.getText("//span[@class='headerMessage2']"));

		Helper.log("All files and folders deleted in OnlineFiles " + selenium.getLocation());
		
		return "ok";
	}


	public static void deleteOnlineFile(Selenium selenium, String fileName) throws Exception {

		Helper.log("execute deleteOnlineFile on page " + selenium.getLocation());

		if (selenium.isTextPresent("no results")){

			SeleneseTestCase.fail("There are no files or folders to delete in deleteOnlineFile");
		}

		//select the file to delete
		Helper.log("select the file to delete on page " + selenium.getLocation());
		Claireandbruce.selectFile(selenium, fileName);

		//wait for the delete link to be active
		Helper.waitForElement(selenium, "//div[@id='ctrl_grid_16_browser_container']/div[2]/div[1]/div[6]/div/div", "Delete link not present in "+ selenium.getLocation());

		//click delete link
		Helper.log("click delete link on page " + selenium.getLocation());
		selenium.click("//div[@id='ctrl_grid_16_browser_container']/div[2]/div[1]/div[6]/div/div");

		Thread.sleep(small);

		//wait for delete window and verify 
		Helper.log("wait for delete window and verify on page " + selenium.getLocation());
		Helper.waitForElement(selenium, "//div[@id='confirm-generic']/div/div/h2/cufon/canvas", "Delete windows not shown");
		
		Thread.sleep(small);
		
		//click delete button to confirm
		Helper.log("click delete button " + selenium.getLocation());
		selenium.click("//div[@id='confirm-generic']/div/div/div[4]/div/div");

		//assert the file do not exist anymore     
		stc.verifyFalse(selenium.isTextPresent(fileName));
	}

	/**
	 * 
	 * Upload a file using autoit
	 * 
	 * @param selenium
	 * @param String fileName
	 * @return null
	 */
	public static void uploadFile(Selenium selenium,String fileName) throws Exception {
		int cont = 0;
		
		//DB - I have changed the selenium timeout because it takes a lot of time to upload that kind
		// of files. At the end I reset the timeout to 30 seconds
		selenium.setTimeout("600000");
		
		gotoHomePage(selenium);
		
		//selenium.click("ctl00_SpacesControl_OnlineFiles_SpacesLink");
		Helper.waitForElement(selenium, "//div[@class='button-blue btn-upload-file left']", "The upload page do not appear");
		//default path location for files to upload
		String path = "C:\\Usuarios\\NEWSHORE\\workspace\\testware";
		Helper.log("executing uploadFile, path is: "+ path + " and fileName is: " + fileName);

		//click the upload button
		selenium.click("//div[@class='button-blue btn-upload-file left']");

		Helper.waitForElement(selenium, "//object[@id='MyApp']", "The flash uploader do not appears");


		//emulate page up
		selenium.keyPressNative("33");

		Thread.sleep(small);

		//ipv: pruebas, a�adido pskill en vez de killprocess
		//Helper.killProcess("Autoit3.exe");
		RunProgram.Exec(path + "\\pskill -t AutoIt3.exe"); //no se utiliza funcion porque no tiene control de excepciones
		
				
		//RunProgram.Exec(path + "\\killautoit.bat"); //no se utiliza funcion porque no tiene control de excepciones
		
		
		Helper.log("Waiting Autoit to finish");
		Thread.sleep(big); //NGM: A�adimos delay para comprobar si se soluciona el problema de sincron�a
		
		Helper.log("Running autoit with this parameter: "+ path +"\\psexec.exe -i \\\\127.0.0.1 "+ path +"\\uploadR2.bat " + path+"\\" + fileName);
		
		//se le pasa al m�todo Exec de la clase RunProgram la ejecuci�n de psexec para que este
		// lanze un bat que recibe un parametro con el fichero a subir, y este bat lanza
		// el autoit upload.au3 que recibe ese archivo como parametro		
		
		RunProgram.Exec(path +"\\psexec.exe -i \\\\127.0.0.1 "+ path +"\\uploadR2.bat " + path+"\\" + fileName);	
		
		Thread.sleep(small);
		
		Helper.log("Autoit launched");
		
		//DB - ************* commented until probe that the new upload is stable
		/*
		
		//do {
		//	selenium.click("//div[@class='close right']");
		//	Thread.sleep(2000);
		//	cont = cont+1;
		//	if (cont>1) Helper.log("cont mayor que 15, se engancho en el bucle"); //IPV: a veces se queda colgado el bucle
		//	
		//} while (selenium.isElementPresent("//div[@class='close right']") || (cont>15));
		 
		Thread.sleep(small);
		*/
		
		//DB - wait until file uploaded or passed 10 minutes (600000ms) with a check every 10 seconds
		do {
			Thread.sleep(10000);
			cont = cont+1;
			if (cont>60) Helper.log("cont excedio el tiempo de 10 minutos"); //IPV: a veces se queda colgado el bucle
		} while (!selenium.isVisible("//div[@id='file-upload']/div/div/div[1]/div[2]") && (cont<60));
		
		//DB -I reset the selenium timeout to 30 seconds
		selenium.setTimeout("30000");
		
		selenium.refresh();
		selenium.waitForPageToLoad(TIME_OUT);

		gotoHomePage(selenium); //IPV: para asegurar que sube bien
		
		Thread.sleep(small);
		
		//Verify the file is uploaded
		if (selenium.isElementPresent("//a[@title='"+fileName+"']") == false) {
			throw new ElementNotFoundException("Upload failed, file "+fileName+" not present in OnlineFiles");
		}
	}


	/**
	 * 
	 * Upload a 692 Mega Bytes file using autoit
	 * 
	 * @param selenium
	 * @param String fileName
	 * @return null
	 */
	public static void upload700MBFile(Selenium selenium,String fileName) throws Exception {
		int cont = 0;
		//I have changed the selenium timeout because it takes a lot of time to upload that kind
		// of files. At the end I reset the timeout to 30 seconds
		selenium.setTimeout("30000000");
		
		gotoHomePage(selenium);
		
		//selenium.click("ctl00_SpacesControl_OnlineFiles_SpacesLink");
		Helper.waitForElement(selenium, "//div[@class='button-blue btn-upload-file left']", "The upload page do not appear");
		//default path location for files to upload
		String path = "C:\\Usuarios\\NEWSHORE\\workspace\\testware";
		Helper.log("executing uploadFile, path is: "+ path + " and fileName is: " + fileName);

		//click the upload button
		selenium.click("//div[@class='button-blue btn-upload-file left']");

		Helper.waitForElement(selenium, "//object[@id='MyApp']", "The flash uploader do not appears");


		//selenium.click("PopUp_backgroundElement");

		//emulate page up
		selenium.keyPressNative("33");

		Thread.sleep(small);
		
		//ipv: pruebas, a�adido pskill en vez de killprocess
		//Helper.killProcess("Autoit3.exe");
		RunProgram.Exec(path + "\\pskill -t AutoIt3.exe"); //no se utiliza funcion porque no tiene control de excepciones
		
		Helper.log("Waiting Autoit to finish");
		Thread.sleep(big); //NGM: A�adimos delay para comprobar si se soluciona el problema de sincron�a
		
		Helper.log("Running autoit with this parameter: "+ path +"\\psexec.exe -i \\\\127.0.0.1 "+ path +"\\uploadR2.bat " + path+"\\" + fileName);
		
		//se le pasa al m�todo Exec de la clase RunProgram la ejecuci�n de psexec para que este
		// lanze un bat que recibe un parametro con el fichero a subir, y este bat lanza
		// el autoit upload.au3 que recibe ese archivo como parametro	
		RunProgram.Exec(path +"\\psexec.exe -i \\\\127.0.0.1 "+ path +"\\uploadR2.bat " + path+"\\" + fileName);	
		
		Helper.log("Autoit launched");
		
		//wait until file uploaded or passed 7 hours
		do {
			Thread.sleep(5000);
			cont = cont+1;
			if (cont>5040) Helper.log("cont excedio el tiempo de 7 horas"); //IPV: a veces se queda colgado el bucle
		} while (!selenium.isVisible("//div[@id='file-upload']/div/div/div[1]/div[2]") && (cont<5040));

		//wait until file uploaded and processed 7 hours
		//Thread.sleep(25200000);

		//I reset the selenium timeout to 30 seconds
		selenium.setTimeout("30000");
		
		selenium.refresh();
		selenium.waitForPageToLoad(TIME_OUT);

		gotoHomePage(selenium); //IPV: para asegurar que sube bien
		
		Thread.sleep(small);

		//Verify the file is uploaded
		if (selenium.isElementPresent("//a[@title='"+fileName+"']") == false) {
			throw new ElementNotFoundException("Upload failed, file "+fileName+" not present in OnlineFiles");
		}
	}
	
	
	/**
	 * 
	 * Select a file from OnlineFiles
	 * 
	 * @param selenium
	 * @param fileName
	 * @return null
	 */
	public static void selectFile(Selenium selenium, String fileName) throws Exception{

		Thread.sleep(small);
		
		Helper.log("execute selectFile: " + fileName);
		
		Helper.waitForElement(selenium, "//a[@title='" + fileName + "']", "File link with text "+ fileName + " not found");		
		//Se toma el atributo name del link con el nombre del folder o file ya que
		//servira para seleccionar el checkbox de ese folder-file porque lleva el mismo nombre
		

		String realFileName = selenium.getAttribute("//a[@title='" + fileName + "']/@name");

		//selenium.click(arg0);
		selenium.click("//input[@name='"+realFileName+"']");
		
	}

	
	/**
	 * 
	 * Select all file from OnlineFiles
	 * 
	 * @param selenium
	 * @return null
	 */
	public static void selectAllFile(Selenium selenium) throws Exception{

		Helper.log("execute selectAllFile");

		Helper.waitForElement(selenium, "//*[@id='ctl00_BodyPlaceHolder_DirectoryContents_DirectoryContentsGrid_GridHeaderCheckBox']", "Select All file checkbox not found in "+ selenium.getLocation() );
		selenium.click("//*[@id='ctl00_BodyPlaceHolder_DirectoryContents_DirectoryContentsGrid_GridHeaderCheckBox']");
		Thread.sleep(small);


	}

	/**
	 * 
	 * Edit the name of a file in OnlineFiles
	 * 
	 * @param selenium
	 * @param fileName
	 * @param newFileName
	 * @return null
	 */
	public static void editFileName(Selenium selenium, String fileName, String newFileName) throws Exception{

		Helper.log("execute selectFile editFfileName: " + fileName);
		
		Helper.waitForElement(selenium, "link="+fileName, "File is not present!");
		//click the edit img
		selenium.click(fileName);

		//set the new name
		selenium.type("RenameTextBox_0", newFileName);

		

		//emulate the "Enter" button
		selenium.keyPressNative("10");
		
		Thread.sleep(2000);
	

		Helper.waitForElement(selenium, "link="+newFileName, "The renamed file is not present!");
		Thread.sleep(2000);


	}

	/**
	 * 
	 * Select a folder from OnlineFiles
	 * 
	 * @param selenium
	 * @param folderName
	 * @return null
	 */
	public static void selectFolder(Selenium selenium, String folderName) throws Exception{		
		Thread.sleep(small);
		
		Helper.log("execute selectFolder: " + folderName);
		
		Helper.waitForElement(selenium, "//a[@title='" + folderName + "']", "Folder link with text "+ folderName + " not found");		
		//Se toma el atributo name del link con el nombre del folder o file ya que
		//servira para seleccionar el checkbox de ese folder-file porque lleva el mismo nombre
		

		String realFileName = selenium.getAttribute("//a[@title='" + folderName + "']/@name");

		//selenium.click(arg0);
		selenium.click("//input[@name='"+realFileName+"']");
	}


	public static void selectGuest(Selenium selenium, String name, String lastName, String userEmail) throws Exception{

		Helper.log("execute selectGuest: " + lastName + ", " + name);


		//verifico que exista el contacto
		Helper.waitForElement(selenium, "//span[@title='"+lastName+ ", "+name+"']", "lastName, name "+ lastName + ", "+name+" not found");
		//div[@id='tableContainer']/table/tbody/tr/td[2]/span

		//assert the guest e-mail is visible too     
		stc.verifyFalse(selenium.isTextPresent(userEmail));
		
		//obtengo el valor del link de apellido,nombre del contacto para obtener
		//el string con la llamada javascript que debo parsear entre (' y ') para obtener el string
		//que me permitir� clickear el checkbox con el value= a ese string
		String hreflink = selenium.getAttribute("//a[contains(.,'"+lastName+ ", "+name+"')]/@href");

		//parseo el valor del link y obtengo el valor del param value del checkbox
		String checkBoxValue = hreflink.substring(hreflink.indexOf("('") + 2, hreflink.indexOf("')"));	

		selenium.click("//input[@value='"+checkBoxValue+"']");

		Thread.sleep(small);
	}


	public static String addGuest(Selenium selenium, String name, String lastName, String email) throws Exception {
		String message = null;

		//wait and click Shared link in top toolbar	
		Helper.waitForElement(selenium, "//div[@id='main-subheader']/div[1]/div[1]/ul/li[5]", "Shared link in top toolbar in the page");
		selenium.click("//div[@id='main-subheader']/div[1]/div[1]/ul/li[5]/a/cufon/canvas");

		selenium.waitForPageToLoad("60000");
		
		//wait and click Guest list link
		Helper.waitForElement(selenium, "//div[@id='main-wrapper']/div[1]/div/div[1]/div/ul/li[2]", "Contact List link not found in the page");
		selenium.click("//div[@id='main-wrapper']/div[1]/div/div[1]/div/ul/li[2]/a/cufon[2]/canvas");
		
		Helper.log("button contact List clicked");
		//selenium.waitForPageToLoad(TIME_OUT);
		
		Helper.waitForElement(selenium, "//th[@name='EmailAddress']", "Concat List Not Loaded");
		

		//click the add guest button
		selenium.click("//div[@class='bg-right-btn' and contains(.,'add new')]");

		//wait for the add guest window
		Helper.waitForElement(selenium, "//div[@class='edit-info-form']", "Add contact windows not present in Contact List Page");

	
		//set FirstName field
		selenium.type(Helper.getIDFieldName(selenium, "sharing-addguest-name"), name);

			
		//set LastName field
		selenium.type(Helper.getIDFieldName(selenium, "sharing-addguest-lastname"), lastName);

		
		//set EmailAddress field
		selenium.type(Helper.getIDFieldName(selenium, "email-guest"), email);

		//click the Add button 
		selenium.click("//form[@id='form-sharing-addguest']/div[2]/div/div");
		
		//IPV: a�adir espera
		Thread.sleep(4000);
		
		if(selenium.isElementPresent("//label[@class='error']")){
			message = selenium.getText("//form[@id='form-sharing-addguest']/div[1]/label[4]");
			Helper.log(message);
			selenium.click("//div[@id='error']/div/div/div[3]/div/div");
		}else{
			//Helper.waitForElement(selenium, "//span[@title='"+email+"']", "Email "+email+" not present in the guest list page!");
			message = "addGuestOk";
		}
		
		Thread.sleep(3000);
		
		Helper.log(message);
		return message;

	}

	public static void deleteGuest (Selenium selenium, String name, String lastName, String userEmail) throws Exception {

		//wait and click Shared link in top toolbar	
		Helper.waitForElement(selenium, "//div[@id='main-subheader']/div[1]/div[1]/ul/li[5]", "Shared link in top toolbar in the page");
		selenium.click("//div[@id='main-subheader']/div[1]/div[1]/ul/li[5]/a/cufon/canvas");

		//wait and click Guest list link
		Helper.waitForElement(selenium, "//div[@id='main-wrapper']/div[1]/div/div[1]/div/ul/li[2]", "Contact List link not found in the page");
		selenium.click("//div[@id='main-wrapper']/div[1]/div/div[1]/div/ul/li[2]/a/cufon[2]/canvas");
		
		Helper.log("button contact List clicked");

		//select the user by email
		selectGuest(selenium, name, lastName, userEmail);


		selenium.click("//div[@id='file-buttons-guestlist']/div[4]/div/div");


		//wait for the delete window and verify 
		Helper.waitForElement(selenium, "//div[@id='sharing-deleteguests']", "delete Guests windos do not appears");

		//assert the box containing the "Are you sure you wish to delete these guests?" is shown
		stc.verifyTrue(selenium.getText("//div[@id='sharing-deleteguests']/div/div/form/label").matches("You have selected following contacts:"));


		//click the delete button to confirm
		selenium.click("//div[@id='sharing-deleteguests']/div/div/form/div/div/div");


		Helper.waitForElement(selenium, "//div[@id='tableContainer']", "Guest list page do not appear");

		//assert the guest do not exist anymore     
		stc.verifyFalse(selenium.isTextPresent(userEmail));
		
	}


	public static String deleteAllGuest (Selenium selenium) throws Exception {

		Helper.log("execute deleteAllGuest on page " + selenium.getLocation());

		Thread.sleep(6000);
		
		//wait and click Shared link in top toolbar	
		Helper.waitForElement(selenium, "//div[@id='main-subheader']/div[1]/div[1]/ul/li[5]", "Shared link in top toolbar in the page");
		selenium.click("//div[@id='main-subheader']/div[1]/div[1]/ul/li[5]/a/cufon/canvas");

		Thread.sleep(4000);
		
		//wait and click Guest list link
		Helper.waitForElement(selenium, "//div[@id='main-wrapper']/div[1]/div/div[1]/div/ul/li[2]", "Contact List link not found in the page");
		selenium.click("//div[@id='main-wrapper']/div[1]/div/div[1]/div/ul/li[2]/a/cufon[2]/canvas");
		
		Helper.log("button contact List clicked");
		//selenium.waitForPageToLoad(TIME_OUT);
		
		Helper.waitForElement(selenium, "//th[@name='EmailAddress']", "Concat List Not Loaded");
		
		
		
		if (!selenium.isElementPresent("//td[@class='email']")){
			Helper.log("There are no guests to delete in Guests list " + selenium.getLocation());
			return ("There are no guests to delete in Guests list");
		}
		

		//select all the guests
		selenium.click("//div[2]/div/div[3]/input");
			
		
		Thread.sleep(small);

		selenium.click("//div[@class='button-grey btn-delete left']"); //IPV test

		Thread.sleep(small);
		
		
		//wait for delete confirmation window and verify 
		Helper.log("wait for delete window and verify on page " + selenium.getLocation());
		Helper.waitForElement(selenium, "//div[@id='dialog-popup']", "Delete windows not shown");
		

		//wait for delete confirmation TEXT	
		Helper.log("wait for delete confirmation TEXT on page " + selenium.getLocation());
		
		//Helper.waitForText(selenium, "//div[@class='bg-right-btn']", "Accept"); 
		Helper.waitForElement(selenium, "//div[@class='bg-right-btn']", "Accept button not shown");

		//click  delete button to confirm
		Helper.log("click  delete button to confirm on page " + selenium.getLocation());
		//selenium.click("//div[@class='bg-right-btn']");
		selenium.click("//div[@id='sharing-deleteguests']/div/div/form/div/div/div");
		
		
		Helper.waitForElement(selenium, "//div[@id='ctrl_grid_16_tableContainer_outer']", "Contact list page not shown");
		
		selenium.refresh();
		selenium.waitForPageToLoad(TIME_OUT);

		//assert that the "online files" is empty   
		SeleneseTestCase.assertEquals("0 shared items in total.", selenium.getText("//span[@class='right_info_text']"));

		Helper.log("Contact list deleted in contact list in " + selenium.getLocation());

		return "ok";
		
	}

	/**
	 * 
	 * Create a new folder in OnlineFiles, if a folder already exist a message with the error will be returned
	 * 
	 * @param selenium
	 * @param folderName
	 * @return message: "ok" or "error message"
	 * @throws InterruptedException 
	 */
	public static String createFolder(Selenium selenium, String folderName) throws Exception{
		Helper.log("execute createFolder: " + folderName);

		String message = null;		

		selenium.windowFocus();

		Helper.log("link=Create folder");
		
		Helper.waitForElement(selenium, "//div[@id='ctrl_grid_16_browser_container']/div[2]/div[1]/div[1]/div/div", "Link Create folder not present or active");

		selenium.click("//div[@id='ctrl_grid_16_browser_container']/div[2]/div[1]/div[1]/div/div");

		Helper.waitForElement(selenium, "//*[@class='new_folder_input']", "No imput field find");

		//write the name of the folder
		Helper.log("write the name of the folder: " + folderName);
		selenium.type("//input[@class='new_folder_input']", folderName);

		Thread.sleep(small);

		Helper.log("press enter: " + folderName);

		//save the new album		
		// Work OK in FF 3.5.
		//String imageLocator = "//input[@class='new_folder_input']";
		//String imageLocator = "//div[@id='page']";
		
		//selenium.focus(imageLocator);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_ENTER));

		 //selenium.keyDown(imageLocator, "\\13");
		 //selenium.keyPressNative("\\13");
		 
		Thread.sleep(1000);

		Helper.log("check for error message");

		for (int second = 0;; second++) {
			if (second >= 4) break;
			try { 
				if (selenium.isVisible("//div[@id='error']")){

					message = selenium.getText("//*[@class='errormsg']");

					if (message.length() != 0){

						Helper.log("error message is : " + message);
						selenium.click("//div[@id='error']/div/div/div[3]/div/div");
						return message;
					}
				}
			} catch (Exception e) {}
			Thread.sleep(1000);
		}

		Helper.log("No error message, verify the folder is created");
		stc.verifyTrue(selenium.isElementPresent("link="+folderName));
		message = "ok";
		return message;
	}


	/**
	 * 
	 * Delete a folder in OnlineFiles
	 * 
	 * @param selenium
	 * @param folderName
	 * @return null
	 */
	public static void deleteFolder(Selenium selenium, String folderName) throws Exception {

		Helper.log("execute deleteFolder: " + folderName);

		if (!selenium.isElementPresent("//tr[@id[contains(.,'file_')]]")){
			Helper.log("There are no files or folders to delete in OnlineFiles " + folderName);
			//SeleneseTestCase.fail("There are no files or folders to delete in OnlineFiles");
		}else{			
			//select the folder�s checkBox
			selectFolder(selenium,folderName);
	
			Thread.sleep(small);
	
	
			Helper.log("Click delete button for : " + folderName);		
	
			//Click delete button
			selenium.click("//div[@class='button-grey btn-delete left']");
	
			Thread.sleep(small);
			
			//wait for the delete window
			
			if(selenium.isVisible("//div[@id='confirm-generic']")){
				Helper.log("confirm a folder or file deletion");
				//click the delete button to confirm
				selenium.click("//div[@id='confirm-generic']/div/div/div[4]/div/div");
				Helper.log("deletion confirmation button pressed");
				Helper.waitForElement(selenium, "//div[@id='section-files']", "Online Files page not appear in " + selenium.getLocation());			
			}else{
				Helper.log("Delete window not appears");
				SeleneseTestCase.fail("Delete window not appears in OnlineFiles");
			}
	
			//assert the folder do not exist anymore     
			stc.verifyFalse(selenium.isTextPresent(folderName));
			Helper.log(folderName + " Deleted from OnlineFiles");
		}
	}


	/**
	 * 
	 * Create a new Album
	 * 
	 * @param selenium
	 * @param albumName
	 * @return String
	 */
	public static String createAlbum(Selenium selenium, String albumName) throws Exception {
		String message = null;
		
		//click albums link
		selenium.click("//div[@id='main-subheader']/div[1]/div[1]/ul/li[3]/a/cufon/canvas");
		selenium.waitForPageToLoad("30000");

		//click create lightbox
		selenium.click("//div[@id='main-wrapper']/div[2]/div/div[1]/div[1]/div[1]/div/div");
		Helper.waitForElement(selenium, "//div[@id='dialog-popup']", "Creaet new collection");
		
		// type the name of the album
		//selenium.type(Helper.getIDFieldName(selenium, "create-newLightBoxName"), albumName);
		selenium.type("//input[@id='create-newLightBoxName']", albumName);
		
		
		//click the add album button
		selenium.click("//div[@class='button-blue btn-create right key-control']");

		Thread.sleep(small);
		
		if (selenium.isTextPresent("Error")){
			message = selenium.getText("//*[@class='errormsg']");
			
			Helper.log(message);
			selenium.click("//div[@id='error']/div/div/div[3]/div/div");
			return message;
		}
		
		//si no hay mensaje de error luego de 4 segundos el pop-up desaparece asi
		//que esperare 6 segundos
		Thread.sleep(6000);		
		
		if(!selenium.isElementPresent("//input[@name='"+albumName+"']")){
			
			Assert.fail("Album "+albumName+" not present in Albums");
		}
		
		message = "createAlbumOk";
		Helper.log(message);
		
		return message;
	}

	public static String deleteAlbum(Selenium selenium, String albumName) throws Exception {

		Helper.log("execute deleteAlbum: " + albumName);

		String message;

		//click albums link
		selenium.click("//div[@id='main-subheader']/div[1]/div[1]/ul/li[3]/a/cufon/canvas");
		
		selenium.waitForPageToLoad("30000");

		Thread.sleep(small);

		try {

			//click the album name
			selenium.click("//input[@name='"+albumName+"']");
			Thread.sleep(small);

			//click delete link
			selenium.click("//div[@id='main-wrapper']/div[2]/div/div[1]/div[1]/div[4]/div/div");

		} catch (SeleniumException e){
			message = albumName + " non present in Albums list";
			Helper.log(albumName + " non present in Albums list");
			//return message;

			throw new ElementNotFoundException(message) ;

		}

		//wait for delete album confirmation window
		Helper.waitForElement(selenium, "//div[@id='dialog-popup']", "delete album confirmation window not shown");
		
		//verify the message Are you sure you want to delete <albumName>? is present
		Assert.assertTrue(selenium.isTextPresent("Are you sure you want to delete these?"));
		
		//click the delete album button
		selenium.click("//div[@class='button-blue btn-delete right btndelete key-control']");
		
		//Wait 6 seconds until deletion pop-up dissapears 
		Thread.sleep(6000);
		
		//wait "delete windows" not present
		Helper.waitForElementNoPresent(selenium, "//input[@name='"+albumName+"']", "Delete album windows is still present");
		
		//verify album name is not anymore in the page
		stc.verifyFalse(selenium.isElementPresent("//input[@name='"+albumName+"']"));
		message = "deleteAlbumOk";
		Helper.log(message);

		return message;
	}

	public static void selectAlbum(Selenium selenium, String albumName) throws Exception {
		
		Helper.log("execute selectAlbum: " + albumName);

		String message;

		//click albums link
		selenium.click("//div[@id='main-subheader']/div[1]/div[1]/ul/li[3]/a/cufon/canvas");
		selenium.waitForPageToLoad("30000");

		Thread.sleep(small);

		try {

			//click the album name
			selenium.click("//input[@name='"+albumName+"']");
			Thread.sleep(small);

		} catch (SeleniumException e){
			message = albumName + " non present in Albums list";
			Helper.log(albumName + " non present in Albums list");
			//return message;

			throw new ElementNotFoundException(message) ;

		}
		
		//verify album name is in the page
		stc.verifyTrue(selenium.isElementPresent("//input[@name='"+albumName+"']"));
			
	}

	public static void openAlbum(Selenium selenium, String albumName) throws Exception {
		
		Helper.log("execute openAlbum: " + albumName);

		String message;

		//click albums link
		selenium.click("//div[@id='main-subheader']/div[1]/div[1]/ul/li[3]/a/cufon/canvas");
		selenium.waitForPageToLoad("30000");

		Thread.sleep(small);

		try {

			//click the album name
			selenium.click("//img[@alt='"+albumName+"']");
			Thread.sleep(small);

		} catch (SeleniumException e){
			message = albumName + " non present in Albums list";
			Helper.log(albumName + " non present in Albums list");
			//return message;

			throw new ElementNotFoundException(message) ;

		}
		
		selenium.waitForPageToLoad("30000");
		
		//verify album name is in the page
		
		
		stc.verifyTrue(selenium.getText("//h1[@id='albumTitle']/cufon/canvas").equals(albumName));
		//stc.verifyTrue(selenium.isElementPresent("//input[@name='"+albumName+"']"));
			
	}	
	
	public static boolean isLinkActive(Selenium selenium, String buttonClass, String title){

		boolean result = false;

		/*if (selenium.isElementPresent("css=a."+link+"[href=\"\"]")){
			System.out.println(link+ " link active");
			result = true;
		}else if (selenium.isElementPresent("css=a."+link+"[href=\"\"]") == false){
			System.out.println(link+" link not active");
			result = false;
		}
		return result;*/

		if (selenium.isVisible("//div[@class='"+buttonClass+"' and @title='"+title+"']") == true){
			System.out.println(title+ " link active");
			result = true;
		}else if (selenium.isVisible("//div[@class='"+buttonClass+" grey-disabled' and @title='"+title+"']") == true){
			System.out.println(title+" link not active");
			result = false;
		}
		return result;
	}

	public static boolean isDivVisible(Selenium selenium, String buttonClass, String title){

		boolean result = false;

		/*if (selenium.isElementPresent("css=a."+link+"[href=\"\"]")){
			System.out.println(link+ " link active");
			result = true;
		}else if (selenium.isElementPresent("css=a."+link+"[href=\"\"]") == false){
			System.out.println(link+" link not active");
			result = false;
		}
		return result;*/

		if (selenium.isVisible("//div[@class='"+buttonClass+"' and @title='"+title+"']") == true){
			System.out.println(title+ " link active");
			result = true;
		}else{
			System.out.println(title+" link not active");
			result = false;
		}
		return result;
	}
	
	public static void onlineFilesAddToNewAlbum(Selenium selenium,String fileName,String albumName ) throws Exception{

		//select  file in online files page
		Claireandbruce.selectFile(selenium, fileName);

		//click new album link
		selenium.click("//div[@class='button-grey btn-more-options left']");

		//click add to album
		selenium.click("//li[@class='btn-add-col']");

		//wait for new album name field
		Helper.waitForElement(selenium, "//input[@id='lightbox-add-new-col']", "Create new collection radio button not shown in online files->options->add to album " + selenium.getLocation());

		//click Create new collection radio button
		selenium.click("//input[@id='lightbox-add-new-col']");

		// type the name of the album
		selenium.type("//input[@id='add-newLightBoxName']", albumName);

		//click in accept button
		selenium.click("//div[@class='bg-right-btn btnaddcollection']");	
		
		Thread.sleep(6000);
		
		//click albums link
		selenium.click("//div[@id='main-subheader']/div[1]/div[1]/ul/li[3]/a/cufon/canvas");
		selenium.waitForPageToLoad("30000");
		
		//verify the album is created
		stc.verifyTrue(selenium.isElementPresent("//input[@name='"+albumName+"']"));

	}

	public static void onlineFilesCopyFile (Selenium selenium, String fileName, String folderName) throws Exception {

		Claireandbruce.selectFile(selenium, fileName);

		//click  move link
		selenium.click("link=copy");

		Helper.waitForElement(selenium, "//div[@id='file-copy']/div/div/h2/cufon[2]/canvas", "Move file windows do to appers");

		Helper.waitForElement(selenium, "//a[text()='"+folderName+"']", "Folder not present");

		//click on the destination folder
		selenium.click("//a[text()='"+folderName+"']");

		Thread.sleep(2000);
		//click the copy botton
		selenium.click("//div[@id='file-copy']/div/div/div[5]/div/div");
		
		Thread.sleep(5000);
		
		Helper.waitForElement(selenium, "xpath=//a[@class='fileBrowserMenuLink']", "On line files windows do to appers");

		//Assert.assertTrue((selenium.isElementPresent("link="+fileName)));
		
		Assert.assertTrue(selenium.isElementPresent("//a[@title='"+fileName+"']"));
		
		Thread.sleep(3000); //IPV cambios pq se cuelga haciendolo bien
		
		//selenium.click("link="+folderName);
		selenium.click("//a[@title='"+folderName+"']");
		
		Thread.sleep(6000);
		
		//Helper.waitForElement(selenium,"link=back to \"Online Files\"","Folder page unloaded");
		
		Helper.waitForElement(selenium,"//a[@title='Online Files']","Folder page unloaded");

		Assert.assertTrue(selenium.isElementPresent("//a[@title='"+fileName+"']"));


	}

	public static void onlineFilesMoveFile (Selenium selenium, String fileName, String folderName) throws Exception {

		Claireandbruce.selectFile(selenium, fileName);

		//click  move link
		selenium.click("link=move");

		Helper.waitForElement(selenium, "//form[@id='form-file-move']/div/h2/cufon[1]/canvas", "Move file windows do to appers");
		
		Helper.waitForElement(selenium, "//a[text()='"+folderName+"']", "Folder name to load");
		//click on the destination folder
		selenium.click("//a[text()='"+folderName+"']");

		//click the copy botton
		selenium.click("//form[@id='form-file-move']/div/div[5]/div/div");
		
		Thread.sleep(3000); //IPV cambios pq se cuelga haciendolo bien
		
		Helper.waitForElement(selenium, "xpath=//a[@class='fileBrowserMenuLink']", "On line files windows do to appers");
		
		
		Assert.assertFalse((selenium.isElementPresent("link="+fileName)));
		
		selenium.click("link="+folderName);
		
		Helper.waitForElement(selenium, "link="+fileName, "Link " +fileName+ " not present");
		Assert.assertTrue("Link " +fileName+ " not present", selenium.isElementPresent("link="+fileName));

	}

	public static void OnlineFilesPlayVideo(Selenium selenium, String[] arrayOfStrings ) throws Exception {

		Helper.log("execute OnlineFilesPlayVideo");


		//select files
		for (int i=0; i<arrayOfStrings.length; i++){

			Claireandbruce.selectFile(selenium, arrayOfStrings[i]);	

		}

		Assert.assertTrue(Claireandbruce.isLinkActive(selenium, "button-grey btn-delete left", "Click here to move selected files to recycle bin."));
		Assert.assertTrue(Claireandbruce.isLinkActive(selenium, "button-grey btn-share-file left", "Click here to share selected files."));
		Assert.assertTrue(Claireandbruce.isLinkActive(selenium, "button-grey btn-play-file left", "Click here to play selected files."));	
		Assert.assertTrue(Claireandbruce.isLinkActive(selenium, "button-grey btn-download-file left", "Click here to download selected files."));	

		//Play them
		selenium.click("//div[@class='button-grey btn-play-file left']");


		//wait for the media player
		//Helper.waitForElement(selenium, "//div[@class='MediaPlayer']", "MediaPlayer windows not present");
		Helper.waitForElement(selenium, "//div[@class='collection-panel-body']", "MediaPlayer windows not present");

		//assert video is present 
		//Assert.assertTrue(selenium.isTextPresent("Video"));
		Thread.sleep(30000);

		for (int i=0; i<arrayOfStrings.length; i++){


			try {

				//check the link exists
				//selenium.getText("link="+arrayOfStrings[i]);
				//selenium.isElementPresent("//div[@class='Clips']/a[@title='"+arrayOfStrings[i]+"']");

				selenium.isElementPresent("//img[@alt='"+arrayOfStrings[i]+"']");
				
				Thread.sleep(10000);
			
				//Helper.log("//div[@class='Clips']/a[@title='"+arrayOfStrings[i]+"'] + found");
				Helper.log("//img[@alt='"+arrayOfStrings[i]+"'] + found");

			}	catch (SeleniumException e ){
				throw new ElementNotFoundException("Video Link "+arrayOfStrings[i]+"not present in Video player");
			}

		}

		//click boton cerrar
		//selenium.click("//img[@alt='Close']");
		selenium.click("//div[@class='close right']");


		//de-select files
		for (int i=0; i<arrayOfStrings.length; i++){

			Claireandbruce.selectFile(selenium, arrayOfStrings[i]);	

		}		
		
	}
		
	public static void OnlineFilesPlayMedia(Selenium selenium, String[] arrayOfVideo, String[] arrayOfPhoto, String[] arrayOfMusic ) throws Exception {

		Helper.log("execute OnlineFilesPlayMedia");


		//select Video files
		for (int i=0; i<arrayOfVideo.length; i++){

			Claireandbruce.selectFile(selenium, arrayOfVideo[i]);	

		}
		
		//select Photo files
		for (int i=0; i<arrayOfPhoto.length; i++){

			Claireandbruce.selectFile(selenium, arrayOfPhoto[i]);	

		}
		
		String lastPlayed = "";
		//select Audio files
		for (int i=0; i<arrayOfMusic .length; i++){

			Claireandbruce.selectFile(selenium, arrayOfMusic [i]);	
			lastPlayed = arrayOfMusic [i];
		}
		
		Assert.assertTrue(Claireandbruce.isLinkActive(selenium, "button-grey btn-delete left", "Click here to move selected files to recycle bin."));
		Assert.assertTrue(Claireandbruce.isLinkActive(selenium, "button-grey btn-share-file left", "Click here to share selected files."));
		Assert.assertTrue(Claireandbruce.isLinkActive(selenium, "button-grey btn-play-file left", "Click here to play selected files."));	
		Assert.assertTrue(Claireandbruce.isLinkActive(selenium, "button-grey btn-download-file left", "Click here to download selected files."));	

		//Play them
		selenium.click("//div[@class='button-grey btn-play-file left']");

		//wait for the media player
		Helper.waitForElement(selenium, "//div[@class='collection-panel-body']", "MediaPlayer windows not present");
		
		Thread.sleep(30000);
		
		//click boton cerrar
		selenium.click("//div[@class='close right']");
		
		
		//click select all checkBox
		Helper.log("click select all checkBox on page " + selenium.getLocation() + " to unselect the previous selected files");
		selenium.click("//input[@class='left selectAllChk']");
		selenium.click("//input[@class='left selectAllChk']");
		
		Thread.sleep(small);		
	}
			
	public static String setUserName(Selenium selenium,String firstName,String lastName ) throws Exception{
		String message = null;

		Helper.log("execute setUserName" + firstName + " " + lastName );
		
		selenium.click("//div[@id='main-subheader']/div[1]/div[1]/ul/li[7]/a/cufon/canvas");
		selenium.waitForPageToLoad(TIME_OUT);
		
		//type name and surname
		selenium.type("Name", firstName);
		selenium.type("Surname", lastName);
		
		//save the info
		selenium.click("//div[@id='conf-userinfo']/div/div[1]/div[1]/div/div");
		
		Thread.sleep(medium);
		
		Assert.assertTrue("Name not updated", selenium.isTextPresent(firstName+" "+lastName+"!"));
		
		message = "setUserNameOk";
		Helper.log(message);
		
		return message;

	}

public static String guestLogin(Selenium selenium,String userEmail,String password,String account) throws Exception {
	String message = null;
	
	selenium.open("Application/GuestLogin.aspx?Account=" + account + "&Email=" + userEmail);
	Helper.waitForElement(selenium, "//*[@id='form1']", "Guest Login form not appear in "+ selenium.getLocation());
	
	
	selenium.type("EmailTextBox", userEmail);
	selenium.type("PasswordTextBox", password);
	selenium.type("AccountNameTextBox", account);
	selenium.click("//span[@class='ddButtonContent']");
	
	search:
	for (int second = 0;; second++) {
		if (second >= 20) break;
		try { 
			if (selenium.isElementPresent("//*[@id='InvalidLabel']")){
				message = selenium.getText("//*[@id='InvalidLabel']");
				break search;
			}
			else if(selenium.isElementPresent("//*[@id='ctl00_Header1_LogOutHL']")){

					message = "guestLoginOk";
					break search;
				}
			

		} catch (Exception e) {}
		Thread.sleep(small);
	}
		
	if(message == null){
			Helper.log("Guest Login Error " + selenium.getLocation());
			Assert.fail("Guest Login Error " + selenium.getLocation());
		}
	
	Helper.log(message);
	return message;
}

public static String guestSetPassword (Selenium selenium, String password,String newPassword, String newPasswordConfirm) throws Exception{
	String message = null;
		
	
	
	selenium.click("ctl00_Header1_SettingsHL");
	selenium.waitForPageToLoad(TIME_OUT);
	
	selenium.click("//a[@class='PasswordSetting']");
	Helper.waitForElement(selenium, "//*[@id='FirstInnerTabMiddle']/h1", "Change password windows do no appear in guestSetPassword");
	
	//*[@id[contains(.,'ConfirmPasswordTextBox')]]
	
	selenium.type("//*[@id[contains(.,'OldPasswordTextBox')]]", password);
	selenium.type("//*[@id[contains(.,'NewPasswordTextBox')]]", newPassword);
	selenium.type("//*[@id[contains(.,'ConfirmPasswordTextBox')]]", newPasswordConfirm);
	
	//save the changes
	selenium.click("//span[@class='icon16 ok16']");
	
	
	if(selenium.isElementPresent("//*[@id='PopupError']")){
		
		message = selenium.getText("//*[@id='PopupError']");
		Helper.log(message);
		return message;
	}
	
	message ="guestSetPasswordOk";
	return message;
	
}

public static void editGuest(Selenium selenium, String email) throws Exception {
	
	
	
	//wait and click Guest list link
	Helper.waitForElement(selenium, "ctl00_Header1_LoginViewSharing_AddressBookHL", "uest List link not found in the page");
	selenium.click("ctl00_Header1_LoginViewSharing_AddressBookHL");
	
	selenium.waitForPageToLoad(TIME_OUT);
	
	selenium.click("//a[@href='mailto:"+email+"']/../img[@class='EditButton']");
	/*
	Tb.isLinkActive(selenium, "Edit");
	*/
}

public static boolean isFileInRecycleBin(Selenium selenium,String fileName) throws Exception{
	
	Helper.log("Executing isFileInRecycleBin");
	
	//goto the recycle bin
	try { Claireandbruce.gotoRecycleBin(selenium);} catch (Exception e) {Helper.log(" --> Recycle Bin page does not load");}
	
	 if (selenium.isElementPresent("//a[@title='"+fileName+"']")){
		 Helper.log("File "+fileName+" found in recycle bin");
		 return true; 
	 } else{
		 Helper.log("File "+fileName+" not found in recycle bin");
		 return false;
	 }
}

public static boolean isFileInOnlineFiles(Selenium selenium,String fileName) throws Exception{
	
	Helper.log("Executing isFileInOnlineFiles");
	
	//goto the home page
	gotoHomePage(selenium);	
	
	 if (selenium.isElementPresent("//a[@title='"+fileName+"']")){
		 Helper.log("File "+fileName+" found in online files");
		 return true; 
	 } else{
		 Helper.log("File "+fileName+" not found in online files");
		 return false;
	 }
}

public static String deleteAllRecycleBin(Selenium selenium) throws Exception{
	Helper.log("Executing deleteAllRecycleBin");

	//IPV: funcion retocada para "goto the recycle bin" que falla algunas veces y otras no. clica, da error y para. Con try-catch clica y da error pero no para.
	try {Claireandbruce.gotoRecycleBin(selenium);} catch (Exception e) {Helper.log(" --> The RecycleBin page does not load");}
	
	Helper.waitForElement(selenium, "//th[@name='Name']", "The file list do not appear");		
	
	//click Empty items in Recycle Bin
	selenium.click("//div[@id='ctrl_grid_18_browser_container']/div[2]/div[2]/div[3]/div/div");

	/*
	if (!selenium.isElementPresent("//div[@id='confirm-generic']/div/div/div[4]/div/div']")){

		Helper.log("Empty Recycle Bin confirmation windows do not appear");
		return ("Empty Recycle Bin confirmation windows do not appear");
	}
	*/
	Thread.sleep(6000);
	
	if(selenium.isElementPresent("//div[@class='confirmation-phrase']")){
		Assert.assertTrue("Empty Recycle Bin description is wrong", selenium.getText("//div[@class='confirmation-phrase']").equals("Are you sure you want to delete it?"));
		//Click in accept to confirm deletion
		selenium.click("//div[@id='confirm-generic']/div/div/div[4]/div/div");
	}else{
		Helper.log("There are no files or folders to delete in Recycle Bin " + selenium.getLocation());
	}
/*	Helper.waitForElementNoPresent(selenium, "//*[@id='FirstInnerTabMiddle']/h1", "Empty Recycle Bin windows is still appear");
	
	Helper.waitForElement(selenium, "//*[@id='ctl00_BodyPlaceHolder_DirectoryContents_DirectoryContentsGrid:Content']", "The recycle bin page is not present");
	
	Assert.assertTrue(selenium.isTextPresent("no results"));
*/	
	return "deleteAllRecycleBinOk";

}

public static void gotoRecycleBin(Selenium selenium) throws Exception {
	
	Claireandbruce.gotoHomePage(selenium);
	
	try {selenium.click("//a[@class='recyclebinMenuLink']");} catch (Exception e) {Helper.log(" --> Clica pasando por excepcion");}
	//Helper.waitForElement(selenium, "//div[@id='recyclebin_container']", "Recycle Bin page do not appear");
	Helper.waitForElement(selenium, "//a[@title='Recycle bin']", "Recycle Bin page do not appear");
}

public static boolean albumsIsLinkActive(Selenium selenium,String link) {
	boolean result = false;
	
	if (selenium.isElementPresent("//*[@id='ctl00_BodyPlaceHolder_LoginViewReadWrite_GrabBagActions_ActionList']/dfn[@class='SelectedItemActions ']/*/a[contains(.,'"+link+"')]") == false){
		System.out.println(link+ " link active");
		result = true;

	}else if (selenium.isElementPresent("//*[@id='ctl00_BodyPlaceHolder_LoginViewReadWrite_GrabBagActions_ActionList']/dfn[@class='SelectedItemActions ']/*/a[contains(.,'"+link+"')]") == true){
		System.out.println(link+" link not active");
		result = false;

	}
	return result;
	
}

public static void deleteRecycleBinFile(Selenium selenium, String fileName) throws Exception {

	Helper.log("execute deleteRecycleBinFile on page " + selenium.getLocation());
	
	gotoRecycleBin(selenium);
	
	
	if (selenium.isTextPresent("no results")){

		SeleneseTestCase.fail("There are no files or folders to delete in RecycleBin");
	}


	//select the file to delete
	Helper.log("select the file to delete on page " + selenium.getLocation());
	Claireandbruce.selectFile(selenium, fileName);

	//wait for the delete link to be active
	Helper.waitForElement(selenium, "//div[@class='button_item button-grey btn-delete left']", "Delete link not present in "+ selenium.getLocation());
	
	//click delete link
	Helper.log("click delete link on page " + selenium.getLocation());
	selenium.click("//div[@class='button_item button-grey btn-delete left']");

	Thread.sleep(small);

	
	if(selenium.isElementPresent("//div[@class='confirmation-phrase']")){
		Assert.assertTrue("Empty Recycle Bin description is wrong", selenium.getText("//div[@class='confirmation-phrase']").equals("Are you sure you want to delete it?"));
		//Click in accept to confirm deletion
		selenium.click("//div[@id='confirm-generic']/div/div/div[4]/div/div");
	}else{
		Helper.log("There are no files or folders to delete in Recycle Bin " + selenium.getLocation());
	}

	//assert the file do not exist anymore     
	stc.verifyFalse(Claireandbruce.isFileInRecycleBin(selenium, fileName));

}

public static void restoreRecycleBinFile(Selenium selenium, String fileName) throws Exception{
	
	Helper.log("execute restoreRecycleBinFile on page " + selenium.getLocation());

	gotoRecycleBin(selenium);
	
	try {
		selectFile(selenium, fileName);
		Helper.log("click restore button");
		//selenium.click("//div[@class='button_item button-blue btn-recover left']");
		selenium.click("//div[@id='ctrl_grid_18_browser_container']/div[2]/div[2]/div[1]/div/div");
		
		Helper.waitForElementNoVisible(selenium, "//a[@title='"+fileName+"']", "File or folder is still in recycle bin, it should be in online Files");
		
	}catch(Exception e){
		throw new ElementNotFoundException(e.toString());
	}
	
}

public static String onlineFilesShare(Selenium selenium,String fileName, String toUser) throws Exception{
	String message = null;
	
	Helper.log("Executing onlineFilesShare");
	Claireandbruce.gotoHomePage(selenium);

	//select the file to share
	Claireandbruce.selectFile(selenium, fileName);
	
	selenium.click("//div[@class='button-grey btn-share-file left']");
	Helper.log("click on link=share");
	
	//Helper.waitForElement(selenium, "//div[@id='dialog-popup']", "The popup Share items do to appear");
	
	Helper.waitForElement(selenium, "//input[@id='file-sharing-newmail']", "The Email input field do to appear");
	
	selenium.type("file-sharing-newmail", toUser);
	Helper.log("Insert the users email: " +toUser);

	
	//click check box expiration date
	//selenium.click("//*[@id[contains(.,'SetExpirationControl1_ExpirationCheckBox')]]");
	//Helper.log("click check box expiration date");

	//insert date
	//selenium.type("//*[@id[contains(.,'SetExpirationControl1_DateTextBox')]]", date);
	//Helper.log("insert date " +date);
	
	//click Add to list
	selenium.click("//form[@id='form-file-sharing']/div/div[3]/div[4]/div/div");
	Helper.log("click Add to list button");
	
	//click on Accept button
	selenium.click("//form[@id='form-file-sharing']/div/div[10]/div/div");
	
	Helper.log("click Accept button");
	
	Thread.sleep(small);
	
	
	if(selenium.isElementPresent("//label[@class='error']")){
		message = selenium.getText("//form[@id='form-file-sharing']/div/div[3]/div[1]/label");
		Helper.log(message);
		selenium.click("//form[@id='form-file-sharing']/div/div[11]/div/div");
		//form[@id='form-file-sharing']/div/div[11]/div/div
	}else{
		//Helper.waitForElement(selenium, "//span[@title='"+email+"']", "Email "+email+" not present in the guest list page!");
		message = "onlineFilesShareOk";
	}
	
	Thread.sleep(5000);
	
	//message = "onlineFilesShareOk";
	Helper.log(message);
	return message;
}
}












