package pageactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import page_locators.GoogleHomePageLocators;
import utils.LoggerHelper;
import utils.SeleniumDriver;


public class GoogleHomePageActions {
	 private static final Logger log= LoggerHelper.getLogger(SeleniumDriver.class);
	GoogleHomePageLocators homePageLocators = null;
	
	public GoogleHomePageActions() {
		this.homePageLocators = new GoogleHomePageLocators();
		PageFactory.initElements(SeleniumDriver.getInstance(), homePageLocators);
		log.info("Home Page elements initialized");
	}
	
	public void enterLocation(String location) {
		homePageLocators.searchLocation.sendKeys(location);
		log.info("Entered Location as : " + location);
	}
	
	public void clickSearchButton() {
		homePageLocators.searchButton.click();
		log.info("Clicked on Search Location Button");
	}
	public void clickDirectionButton() {
		homePageLocators.directionButton.click();
		log.info("Clicked on Direction Button");
	}
	
}
