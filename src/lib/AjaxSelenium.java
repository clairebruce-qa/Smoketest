package lib;

import com.thoughtworks.selenium.DefaultSelenium;

public class AjaxSelenium extends DefaultSelenium {

	//timeout in seconds
	private final int timeout = 15;	
	
	public AjaxSelenium(String serverHost, int serverPort, String browserStartCommand,
			String browserURL) {
		super(serverHost, serverPort, browserStartCommand, browserURL);		
	}
	
	 public void safeClick(String locator) throws ElementNotFoundException, InterruptedException {
	        this.waitForElement(locator);
	        this.click(locator);
	 }

	 public void safeOpen(String pageUrl) throws InterruptedException, ElementNotFoundException {
		 this.open(pageUrl);
	     this.waitForPageToLoad("3000");
	     this.waitForElement("//div[@id='javascript-loaded']");
	 }

	 public String safeGetText(String locator) throws ElementNotFoundException, InterruptedException {
		 this.waitForElement(locator);
	     return this.getText(locator);
	 }

	 public String safeGetValue(String locator) throws ElementNotFoundException, InterruptedException {
		 this.waitForElement(locator);
	     return this.getValue(locator);
	 }

	 public void safeType(String locator, String text) throws ElementNotFoundException, InterruptedException {
		 this.waitForElement(locator);
	     this.type(locator,text != null ? text : "");
	}

	 public void waitForElement(String locator) throws ElementNotFoundException, InterruptedException {
		 for (int second = 0; ; second++) {
			 if (second >= timeout) throw new ElementNotFoundException("Element not present: " + locator);
	         	try {
	                if (this.isElementPresent(locator)) break;
	            } catch (Exception e) {
	            }
	            Thread.sleep(1000);
		 }
	 }
	 
	 public void waitForText(String locator, String text) throws InterruptedException, ElementNotFoundException {
		 for (int second = 0;; second++) {
			 if (second >= timeout) throw new ElementNotFoundException("Text '" + text + "' in element '"+ locator +"' not present.");
	         	try {
	         		if (text.trim().equals(this.getText(locator).trim())) break;
	            } catch (Exception e) {}
	            Thread.sleep(1000);
		 }
	 }
	 
	 public void waitForValue(String locator, String text) throws ElementNotFoundException, InterruptedException {
		 for (int second = 0;; second++) {
			 if (second >= timeout) throw new ElementNotFoundException("Text '" + text + "' in element '"+ locator +"' not present.");
	         	try {
	         		if (text.trim().equals(this.getValue(locator).trim())) break;
	            } catch (Exception e) {}
	            Thread.sleep(1000);
		 }
	 }
}