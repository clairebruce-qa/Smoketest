package basics;
import org.junit.Assert;
import org.junit.Test;
import lib.Claireandbruce;


public class TestOptionFiles extends ClaireandbruceTestCase {

	//Clase adaptada a R2	
	@Test
	public void testTB604() throws Exception  {		
		//TB-604:Move_File:Mover		
		Claireandbruce.login(selenium, username, password);		
		//clear OnlineFiles
		Claireandbruce.deleteAllOnlineFiles(selenium);		
		//create a folder
		Assert.assertEquals("ok", Claireandbruce.createFolder(selenium, "test1"));		
		//Upload a file
		Claireandbruce.uploadFile(selenium,"dns.txt");		
		Claireandbruce.onlineFilesMoveFile(selenium, "dns.txt", "test1");			
		Claireandbruce.logout(selenium);		
	}

	@Test
	public void testTB605() throws Exception  {	
		//TB-605:copy_File:Copiar		
		Claireandbruce.login(selenium, username, password);		
		//clear OnlineFiles
		Claireandbruce.deleteAllOnlineFiles(selenium);		
		//create a folder
		Assert.assertEquals("ok", Claireandbruce.createFolder(selenium, "test1"));		
		//Upload a file
		Claireandbruce.uploadFile(selenium,"dns.txt");		
		Claireandbruce.onlineFilesCopyFile(selenium, "dns.txt", "test1");			
		Claireandbruce.logout(selenium);	
	}

	@Test
	public void testTB606() throws Exception  {	
		//TB-606:Delete_File:Borrar		
		Claireandbruce.login(selenium, username, password);		
		//clear OnlineFiles
		Claireandbruce.deleteAllOnlineFiles(selenium);		
		//Upload a file
		Claireandbruce.uploadFile(selenium,"dns.txt");		
		//select and delete file
		Claireandbruce.deleteOnlineFile(selenium, "dns.txt");			
		Claireandbruce.logout(selenium);		
	}

	@Test
	public void testTB607() throws Exception  {	
		//TB-607:Edit_File:Editar		
		Claireandbruce.login(selenium, username, password);		
		//clear OnlineFiles
		Claireandbruce.deleteAllOnlineFiles(selenium);		
		//Upload a file
		Claireandbruce.uploadFile(selenium,"dns.txt");		
		Claireandbruce.editFileName(selenium, "dns.txt", "dnsrenamed.txt");		
		//select and delete file
		Claireandbruce.deleteOnlineFile(selenium, "dnsrenamed.txt");			
		Claireandbruce.logout(selenium);		
	}

	@Test
	public void testTB1222() throws Exception  {
		
		//TB-1222:play video files		
		Claireandbruce.login(selenium, username, password);		
		//clear OnlineFiles
		Claireandbruce.deleteAllOnlineFiles(selenium);		
		//Upload a video wmv
		Claireandbruce.uploadFile(selenium,"chris_46knots.wmv");		
		//Upload a video mpg
		Claireandbruce.uploadFile(selenium,"Spock.mpg");		
		//Upload a video 3gp
		Claireandbruce.uploadFile(selenium,"DontCallMeParis.3gp");		
		//number of video to play 
		String[] videos = new String[3];
		
		videos[0] = "chris_46knots.wmv";
		videos[1] = "Spock.mpg";
		videos[2] = "DontCallMeParis.3gp";
			
		Claireandbruce.OnlineFilesPlayVideo(selenium,videos);		
		//clear OnlineFiles
		Claireandbruce.deleteAllOnlineFiles(selenium);			
		Claireandbruce.logout(selenium);		
		}
}
