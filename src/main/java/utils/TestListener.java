package utils;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
public class TestListener extends TestListenerAdapter {
	private static final Logger log= LoggerHelper.getLogger(SeleniumDriver.class);
	public void onTestFailure(ITestResult tr) {
		log.info("Test failed at : " + tr.getName());
	}

}
