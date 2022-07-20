package page_locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleDirectionPageLocators {
	
	@FindBy(how=How.XPATH,using="//*[@id='omnibox-directions']/div/div[2]/div/div/div/div[2]/button")
	public WebElement clickOnCarButton;
	
	@FindBy(how=How.XPATH,using="//*[@id='sb_ifc51']/input")
	public WebElement startLocation;
	
	@FindBy(how=How.XPATH,using="//*[@id='sb_ifc52']/input")
	public WebElement destinationLocation;
	
	@FindBy(how=How.XPATH,using="//*[@id='directions-searchbox-1']/button[1]")
	public WebElement clickDirectionSearchButton;
	
	@FindBy(how=How.XPATH,using="//*[@id='QA0Szd']/div/div/div[1]/div[2]/div/div[1]/div/div/div[4]")
	//@FindBy(how=How.XPATH,using="//div[@class='MespJc']")
	public WebElement listofRoutes;
}
