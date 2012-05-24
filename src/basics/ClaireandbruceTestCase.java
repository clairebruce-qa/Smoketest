package basics;
import java.util.Calendar;
import java.util.GregorianCalendar;

import lib.Helper;
import lib.RunProgram;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.*;
import testlink.api.java.client.TestLinkAPIClient;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

@RunWith(RCRunner.class)
public class ClaireandbruceTestCase{
     
	static String tc;

	public static String username = System.getProperty("my.username","stress_test_qa@claireandbruce.com"); 
	public static String password = System.getProperty("my.userpassword","123456");
	public static String  ClaireandbruceUrl	=	"http://pre-cb.newshore.es/";
	//static String  ClaireandbruceUrl	=	"http://int2-cb.newshore.es/";
	//static String  ClaireandbruceUrl	=	"http://www.claireandbruce.com/";
	public static String nombreProducto= System.getProperty("nombreProducto","");
	public static String totalParaPayPal = System.getProperty("totalParaPayPal","");
	
	
	/*	Selenium RC settings
	 	for firefox  *chrome
	 	for explorer *iexplore  *iehta
	 	for google chrome *googlechrome
	*/
	static String seleniumUrl =	"localhost";

	//static String seleniumBrowser = System.getProperty("my.browser","*googlechrome");
	static String seleniumBrowser = System.getProperty("my.browser","*chrome");
//	public static String seleniumBrowser = System.getProperty("my.browser","*iexplore");

	public static DefaultSelenium selenium = new DefaultSelenium(seleniumUrl, 4444, seleniumBrowser,ClaireandbruceUrl );
	
	@BeforeClass
    public static void init(){
		selenium.start();
		selenium.windowMaximize();
		selenium.windowFocus();
		selenium.setSpeed("500");
		selenium.setTimeout("40000");	 
	}
   
	@AfterClass
	public static void clean(){
		//IPV: para evitar fallos posteriores
		RunProgram.Exec("C:\\Usuarios\\NEWSHORE\\workspace\\testware\\pskill -t AutoIt3.exe"); //no se utiliza funcion porque no tiene control de excepciones
		//RunProgram.Exec("E:\\testABIL\\KillAutoIt3.bat"); //no se utiliza funcion porque no tiene control de excepciones
		selenium.stop();
	}
	
	@Before
	public void beforetest(){
		 // Get test method name
         System.out.println("**** Start test **** " + RCRunner.getTestName()+" ****\n");               
	}
	
	@After
	public void aftertest(){
		System.out.println("**** Test done ****"+ RCRunner.getTestName()+" ****\n");		
	}
    
    @AfterFailure
    public void captureScreenShotOnFailure(Throwable failure) throws Exception {
    	//get the today date
    	GregorianCalendar calendar = new GregorianCalendar();
    	String testmonth =  String.valueOf(calendar.get(Calendar.MONTH) + 1);
    	String testday = String.valueOf(calendar.get(Calendar.DATE));;
    		
    	if((calendar.get(Calendar.MONTH) + 1) < 10){
    		testmonth = "0" + testmonth;
    	}
    	
    	if(calendar.get(Calendar.DATE) < 10){
    		testday = "0" + testday;
    	}    	
    		
		String d = (calendar.get(Calendar.YEAR) + "_" + testmonth + "_"
		    + testday);
    	
    	// Get test method name
        String testMethodName = null;
        for (StackTraceElement stackTrace : failure.getStackTrace()) {
            if (stackTrace.getClassName().equals(this.getClass().getName())) {
                testMethodName = stackTrace.getMethodName();
                break;
            }
        }
        
        selenium.captureScreenshot("C:\\tmp\\TEST\\R2\\"+d+"\\" + this.getClass().getName() + "." + testMethodName + ".png");
        Thread.sleep(1000);
        
        //IPV: para evitar fallos posteriores
		//Helper.killProcess("Autoit3.exe");
		
        /*
        try {
            SimpleFTP ftp = new SimpleFTP();
            
            // Connect to an FTP server on port 21.
            ftp.connect("ftp.somewhere.net", 21, "username", "password");
            
            // Set binary mode.
            ftp.bin();
            
            // Change to a new working directory on the FTP server.
            
            ftp.cwd("/root/.hudson/jobs/"+"R2 ES Terabox Testing Smoke test IE 8 Win Vista"+"/builds");
            
            // Upload some files.
            ftp.stor(new File("webcam.jpg"));

            
            // You can also upload from an InputStream, e.g.
            //ftp.stor(new FileInputStream(new File("test.png")), "test.png");
            //ftp.stor(someSocket.getInputStream(), "blah.dat");
            
            // Quit from the FTP server.
            ftp.disconnect();
        }
        catch (IOException e) {
            // Jibble.
        }
        */
    }
}
