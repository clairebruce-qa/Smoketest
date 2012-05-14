package basics;
import org.junit.Assert;
import org.junit.Test;
import lib.Claireandbruce;


public class TestFileManager extends ClaireandbruceTestCase {
	//Clase adaptada a R2

	@Test
	public void test502() throws Exception  {	
		//TB-502:File Manager:Duplicate Folder
		
		Claireandbruce.login(selenium, username, password);	
		Claireandbruce.deleteAllOnlineFiles(selenium);	
		Assert.assertEquals("ok", Claireandbruce.createFolder(selenium, "test"));	
		Assert.assertEquals("A folder with the same name already exists in this directory. " +
				"Please try another name.", Claireandbruce.createFolder(selenium, "test"));		
		Claireandbruce.logout(selenium);	
	}

	@Test
	public void test503() throws Exception  {	
		//TB-503:File Manager:New Folder SC	
		Claireandbruce.login(selenium, username, password);	
		Claireandbruce.deleteAllOnlineFiles(selenium);		
		Assert.assertEquals("ok", Claireandbruce.createFolder(selenium, "test"));		
		Claireandbruce.logout(selenium);	
	}
}
