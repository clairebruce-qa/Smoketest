package basics;
import java.util.Properties;  
import java.io.*;  

public class ReadValues{  
	private static final String PROP_FILE="myConfig.properties";  

	public static void main(String[] args) {

		try{  
			InputStream is = ReadValues.class.getResourceAsStream(PROP_FILE);  
			Properties prop = new Properties();  
			prop.load(is);  
			String directory = prop.getProperty("Directory");  
			String numberOfFiles = prop.getProperty("NumberOfFiles");  
			String  URL = prop.getProperty("URL");  
			is.close();  
					
			/* code to use values read from the file*/  
			System.out.println(directory);
			System.out.println(URL);
			
		}catch(Exception e){  
			System.out.println("Failed to read from " + PROP_FILE + " file.");  
		}  
	}
}  

