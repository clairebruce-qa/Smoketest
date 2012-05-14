package basics;
import org.junit.Test;
import lib.Claireandbruce;


public class TestUploadFile extends ClaireandbruceTestCase {
	//Ha sido adaptada para R2
	
	@Test
	public void test631() throws Exception {
		   /*
		   	1. login to terabox web site
		   	2. In File Manager "archivos en linea" options click on  "Subir archivos"
		   	3. Click on "seleccionar archivos"
		   	4. Select video files with different formats
		   	5. Click on "subir
		    */
		
		Claireandbruce.login(selenium, username, password);		
		Claireandbruce.deleteAllOnlineFiles(selenium);		
		Claireandbruce.uploadFile(selenium,"chris_46knots.wmv");		
		Claireandbruce.logout(selenium);		
	}
	
	@Test
	public void test641() throws Exception {
		   /*
		   	1. login to terabox web site
   			2. In File Manager "archivos en linea" options click on "Subir archivos"
   			3. Click on "seleccionar archivos"
   			4. Select  images files with different formats
   			5. Click on "subir
		    */
		
		Claireandbruce.login(selenium, username, password);		
		Claireandbruce.deleteAllOnlineFiles(selenium);		
		Claireandbruce.uploadFile(selenium,"Desert.jpg");		
		Claireandbruce.logout(selenium);		
	}

	@Test
	public void test638() throws Exception {
		   /*
		    1. login to terabox web site
   			2. In File Manager "archivos en linea" options click on "Subir archivos"
   			3. Click on "seleccionar archivos"
   			4. Select audio files with different formats
   			5. Click on "subir
		    */
		
		Claireandbruce.login(selenium, username, password);		
		Claireandbruce.deleteAllOnlineFiles(selenium);		
		Claireandbruce.uploadFile(selenium,"sympho01.mp3");		
		Claireandbruce.logout(selenium);		
	}

	@Test
	public void test640() throws Exception {
		   	/*
		   	1. login to terabox web site
   			2. In File Manager "archivos en linea" options click on "Subir archivos"
   			3. Click on "seleccionar archivos"
   			4. Select word processing files with different formats
   			5. Click on "subir
		    */
		
		Claireandbruce.login(selenium, username, password);		
		Claireandbruce.deleteAllOnlineFiles(selenium);		
		Claireandbruce.uploadFile(selenium,"contact_terabox.docx");		
		Claireandbruce.logout(selenium);		
	}
	
	@Test
	public void test633() throws Exception {
	   	/*
	   	1.   login to terabox web site
			2. In File Manager "archivos en linea" options click on "Subir archivos"
			3. Click on "seleccionar archivos"
			4. Select zip files with different formats
			5. Click on "subir
	    */
	
	Claireandbruce.login(selenium, username, password);	
	Claireandbruce.deleteAllOnlineFiles(selenium);	
	Claireandbruce.uploadFile(selenium,"Spock.zip");	
	Claireandbruce.logout(selenium);	
	}	
}
