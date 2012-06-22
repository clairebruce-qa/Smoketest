package lib;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import lib.ElementNotFoundException;
 

import com.thoughtworks.selenium.*;

public class Helper {
	
	/**
	   * 
	   * Kill autoid elements
	   * 
	   * @param proceso proceso a matar
	   */
	public static void killProcess(String proceso) throws Exception{
		
		Helper.log("Killing the element "+proceso);
		//RunProgram.Exec("D:\\testABIL\\psexec.exe -d -high -u TESTABIL.LOCAL\\selenium -p 1111 D:\\testABIL\\pskill -t " + proceso);
		RunProgram.Exec("C:\\Usuarios\\NEWSHORE\\workspace\\testware\\pskill -t " + proceso);
		Thread.sleep(2000);
		
	}
	
	//timeout in seconds
	private final static int timeout = 15;
	
	public static void waitElement(String element, String path) throws Exception{
		System.out.print(element);
		System.out.print(path.toString());
		for (int second = 0;; second++) {
			if (second >= 60) SeleneseTestCase.fail("timeout");
			try { if (element.equals(path)) break; } catch (Exception e) {}
			Thread.sleep(2000);
		}
	}

	
	/**
	   * 
	   * Wait for an element
	   * 
	   * @param selenium
	   * @param element string
	   * @param error message string if fails
	   * @return null
	   */
	public static void waitForElement(Selenium selenium, String element, String error ) throws Exception{
		
		Helper.log("Esperando por el elemento " + element + " en la ubicación " + selenium.getLocation());
		for (int second = 0;; second++) {
			if (second >= 20) { SeleneseTestCase.fail(error);};
			try { if (selenium.isElementPresent(element)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}
	
	
	public static void waitForElementNoPresent(Selenium selenium, String element, String error ) throws Exception{
		
		Helper.log("Executing waitForElementNoPresent: " + element + " in " + selenium.getLocation());
		for (int second = 0;; second++) {
			if (second >= 20) { SeleneseTestCase.fail(error);};
			try { if  (selenium.isElementPresent(element) == false) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}
	
	public static void waitForElementNoVisible(Selenium selenium, String element, String error ) throws Exception{
		
		Helper.log("Executing waitForElementNoVisible: " + element + " in " + selenium.getLocation());
		for (int second = 0;; second++) {
			if (second >= 20) { SeleneseTestCase.fail(error);};
			try { if  (selenium.isVisible(element) == false) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}
	
	public static void clickAndVerify(Selenium selenium, String link, String check, String path ) throws Exception{
		
		Helper.log("Clic en el link: " + selenium.getText(link) + " y verificación con el texto: " + check );
		Thread.sleep(3000);
		
		waitForElement(selenium,link,"link "+ link + "not found");
		selenium.click(link);
		Thread.sleep(3000);
		
		//System.out.print(link+" path "+path+"\n");
		
		for (int second = 0;; second++) {
			if (second >= 60) SeleneseTestCase.fail("El texto "+check+" no fue encontrado en el xpath "+path);
			try { if (check.equals(selenium.getText(path))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}		
	}


	/**
	   * 
	   * extrae toda la información HTML de la página actual (HTML source)
	   * y analiza "parser" la información a traves de la regexp introducida
	   * 
	   * @param selenium
	   * @param textPresent tipo regexp, expresión regular a comparar
	   * @param pageLinks tipo String[], donde se guarda los Links extraidos
	   * @return tipo string[]
	   */
	  public static final String[] getLinks(Selenium selenium, String textPresent, String[] pageLinks) throws Exception{
		  	
		  	
		  	String htmlSource = selenium.getHtmlSource();
		  	
		  	Pattern LinksElementPattern = Pattern.compile(textPresent);
			
		  	Matcher ElementMatcher = LinksElementPattern.matcher(htmlSource);
		  	
		  	
		  	
		  	int l=0;
			while (ElementMatcher.find()) {
			  pageLinks[l] = ElementMatcher.group();	
		      System.out.println(ElementMatcher.group());
		      l++;
			}
			return pageLinks;
		  }
	  

	  /**
	   * 
	   * 
	   * 
	   * \\@param inputStr tipo string, texto introducido a ser comparado con la regexp
	   * \\@param regEx tipo regexp, expresión regular introducida a ser comparado con el texto
	   * \\@return tipo string[] Array, se guarda las coincidencias entre ambos parametros 
	   */
	  public static final String[] parse (String inputStr, String regEx) {
		    Pattern p = Pattern.compile(regEx);
		    Matcher m = p.matcher(inputStr);

		    if (m.find()) {
		      int Count=m.groupCount();
		      String[] res=new String[Count];

		      for (int i=0; i<Count; i++) {res[i]=m.group(i+1);}
		      return res;
		    }

		    else return null;
		  }

	  public static String getIDFieldName(Selenium selenium,String fieldName) throws ElementNotFoundException {
		
			Helper.log("getIDFieldName of " + fieldName);
		  	
			try {
				
			
			// return the field name + the id		  
			String[] field = new String[1];
			Helper.getLinks(selenium, "id=[^%]{1,9}"+fieldName, field);		
			
			
			
			String field2 = "";
			String fieldId = "";
			
			//remove " from the string
			char c = '"';
			 for (int i = 0; i < field[0].length(); i ++) {
			     if (field[0].charAt(i) != c) field2 += field[0].charAt(i);
			     }

			fieldId = field2.substring(3,field2.length());
			 
			Helper.log("return " + fieldId);
			return fieldId;
			
			} catch (Exception e ){
				throw new ElementNotFoundException("fieldName: " + fieldName + " not present");
			}
			
	  }
	  
	  public static void log(String message){
		  
		  System.out.println(message);
		  
	  }
	  
	  public static void waitForText(Selenium selenium,String locator, String text) throws InterruptedException, ElementNotFoundException {
	        for (int second = 0;; second++) {
	            if (second >= timeout) throw new ElementNotFoundException("El Texto '" + text + "' en el elemento '"+ locator +"' no está presente.");
	            try {
	                if (text.trim().equals(selenium.getText(locator).trim())) break;
	            } catch (Exception e) {}
	            Thread.sleep(1000);
	        }
	    }

}

