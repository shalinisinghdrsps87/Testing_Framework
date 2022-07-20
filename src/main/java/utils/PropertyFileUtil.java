package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {
	
	public static String getProperty(String s) throws IOException{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Property.properties");
		
		try {
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(s);
		}
		catch(FileNotFoundException e){
			return "chrome";
		}
	}		
}
