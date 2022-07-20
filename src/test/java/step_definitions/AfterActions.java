package step_definitions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import utils.SeleniumDriver;

public class AfterActions {
	
	  @After
	    public static void tearDown(Scenario scenario) {
	    	
	    	WebDriver driver=SeleniumDriver.getInstance();
	    	System.out.println(scenario.isFailed());
	    	 if (scenario.isFailed()) {
	             //byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	             //scenario.embed(screenshotBytes, "image/png");
	    		 	SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
	    			Date curDate = new Date();
	    			String strDate = sdf.format(curDate);
	    		 try {
	                   String screenshotName = scenario.getName().replaceAll(" ", "_")+strDate; 
	                   byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	                   File screenshot_with_scenario_name = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 	                          

	                   File destinationPath = new File(System.getProperty("user.dir")+"\\ExtentReport\\" + screenshotName + ".png");
	                  
	                   Files.copy(screenshot_with_scenario_name.toPath(), destinationPath.toPath()); 
	                
	                   scenario.embed(screenshot, "image/png");
	       
	               } catch (IOException somePlatformsDontSupportScreenshots) {
	                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
	           }  
	    		 
	         }
	    
	    SeleniumDriver.killDriver();
	    
	    }
}
