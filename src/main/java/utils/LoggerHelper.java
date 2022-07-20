package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {
	
	private static boolean root = false;
	
	public static <T> Logger getLogger(Class<T> cls) {
		if(root) 
		{
		 return Logger.getLogger(cls);
		}
		else 
		{
			PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log4j.properties");
			root = true;
			return Logger.getLogger(cls);
		}
		
	}

}
