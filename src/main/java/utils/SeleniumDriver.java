package utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDriver {
	
	private static WebDriver driver;
	private static SeleniumDriver seleniumDriver;
    //private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;
    private static final Logger log= LoggerHelper.getLogger(SeleniumDriver.class);
	
	private SeleniumDriver() throws IOException {
		String browser = PropertyFileUtil.getProperty("browser");
		log.info("The browser to test on is : " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\exe\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\exe\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
        driver.manage().window().maximize();
        //waitDriver = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit 	.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        String window=driver.getWindowHandle();
        System.out.println("Window ->"+window);
        log.info("Driver setup done");
	}
	public static void openPage(String url) {
	    	System.out.println(url);
	    	System.out.println(driver);
	        driver.get(url);
	        log.info("Opened website : "+ url);
	}
	 
	public static void setUpDriver() throws IOException{ 
		if(seleniumDriver == null) {
			seleniumDriver = new SeleniumDriver();
			
		}
	}
	
	public static WebDriver getInstance() {
		return driver;
	}
	
	public static void killDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        seleniumDriver = null;
        log.info("Killed driver instances");
    }
	public static void waitForPageToLoad()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
