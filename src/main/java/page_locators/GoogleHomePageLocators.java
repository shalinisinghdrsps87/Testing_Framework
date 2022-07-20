package page_locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePageLocators {
	
	@FindBy(xpath="//*[@id='searchboxinput']")
	public WebElement searchLocation;
	

	@FindBy(xpath="//*[@id='searchbox-searchbutton']")
	public WebElement searchButton;
	
	@FindBy(xpath="//*[@id='QA0Szd']/div/div/div[1]/div[2]/div/div[1]/div/div/div[4]/div[1]/button/span")
	public WebElement directionButton;

}
