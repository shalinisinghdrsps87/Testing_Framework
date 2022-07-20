package pageactions;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page_locators.GoogleDirectionPageLocators;
import utils.ErrorCollector;
import utils.LoggerHelper;
import utils.PrintInTxtFile;
import utils.SeleniumDriver;

public class GoogleDirectionPageActions {
	 private static final Logger log= LoggerHelper.getLogger(SeleniumDriver.class);
	GoogleDirectionPageLocators directionPageLocators = null;
	public static SoftAssert softAssert = new SoftAssert();
	

	public GoogleDirectionPageActions() {
		this.directionPageLocators = new GoogleDirectionPageLocators();
		PageFactory.initElements(SeleniumDriver.getInstance(), directionPageLocators);
		log.info("Direction Page elements initialized");
	}
	
	public void clickCarButton() {
		directionPageLocators.clickOnCarButton.click();
		log.info("Clicked on Car Button");
	}
	
	public void enterStartLocation(String s) {
		directionPageLocators.startLocation.sendKeys(s);
		log.info("Enetered starting location as : " + s);
	}
	
	public void enterDestinationLocation(String s) {
		directionPageLocators.destinationLocation.sendKeys(s);
		log.info("Enetered destination location as : " + s);
	}
	public void clickOnDirectionSearchButton() {
		//directionPageLocators.startLocation.click();
		Actions move = new Actions(SeleniumDriver.getInstance());
		move.moveToElement(directionPageLocators.destinationLocation).perform();
		directionPageLocators.clickDirectionSearchButton.click();
		log.info("Clicked on Search Route Button");
	}
	
	public int getListofRoutes() {
		List<WebElement> list = directionPageLocators.listofRoutes.findElements(By.xpath("//div[starts-with(@id,'section-directions-trip')]"));
		return list.size();
		
		
		//Assert.fail("The suggested routes is less than two. Actual is "+ list.size());
	}
	
	public void printRoutesInTxt() throws IOException {
		
		List<WebElement> list = directionPageLocators.listofRoutes.findElements(By.xpath("//div[starts-with(@id,'section-directions-trip')]"));		
		String msg = "Total routes suggested by Google is " + list.size() + "\r\n" + "Please find below details of the routes." + "\r\n\r\n";
		int srNo=1;
		for (WebElement w : list) {
			String divId = w.getAttribute("id");
			String h1Text = w.findElement(By.xpath("//*[@id='"+divId+"']/div[1]/div[1]/div[2]/h1[1]")).getText();
			//System.out.println(h1Text);
			String travelTime = w.findElement(By.xpath("//*[@id='"+divId+"']/div[1]/div[1]/div[1]/div[1]/span[1]")).getText();
			String miles = w.findElement(By.xpath("//*[@id='"+divId+"']/div[1]/div[1]/div[1]/div[2]/div")).getText();
			msg = msg + "Route" + srNo + ") " + h1Text + " which takes around " + travelTime + " and the distance is " + miles + "\r\n";
			srNo++;
		}
		//System.out.println(msg);
		PrintInTxtFile.printDetails(msg);
	}
}
