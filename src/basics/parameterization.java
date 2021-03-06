package basics;
import com.thoughtworks.selenium.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.*;

import java.util.regex.Pattern;
//require for the collection class
import java.util.*;

@RunWith(value=Parameterized.class)
public class parameterization {

	private static DefaultSelenium selenium;
	private long expected;
	private int value;
	
	@BeforeClass
	public static void init() /* throws Exception */ {
	selenium = new DefaultSelenium("localhost", 4444, "*chrome","http://google.com");
	selenium.start();
	selenium.windowMaximize();
	selenium.windowFocus();
	}
	
	@Parameters
	public static Collection data() {
	 return Arrays.asList( new Object[][] {
	                      { 1, 0 },   // expected, value
	                      { 1, 1 },
	                      { 2, 2 },
	                      { 24, 4 },
	                      { 5041, 7 },//wrong expected
	                      });
	}
	
	public parameterization(long expected, int value) {
	 this.expected = expected;
	 this.value = value;
	}
	@Test
	public void first() throws Exception  {
	
		selenium.open("/");
		selenium.type("q", value+"!=");
		selenium.click("btnG");
		selenium.waitForPageToLoad("30000");
		
		String text = selenium.getText("//*[@id='topstuff']/table[1]/tbody/tr[1]/td[3]/h2/b");
		//to remove whitespaces
		text= text.replace(" ","");
		// will verify the text
		assertEquals(value+"!="+expected,text);	
	}
}
