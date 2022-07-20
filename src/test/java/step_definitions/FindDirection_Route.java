package step_definitions;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageactions.GoogleDirectionPageActions;
import pageactions.GoogleHomePageActions;
import utils.ErrorCollector;
import utils.LoggerHelper;
import utils.PropertyFileUtil;
import utils.SeleniumDriver;

public class FindDirection_Route {
	
	GoogleHomePageActions homePageAction = new GoogleHomePageActions();
	GoogleDirectionPageActions directionPageAction= new GoogleDirectionPageActions();
	public static SoftAssert softAssert = new SoftAssert();
	
	private static final Logger log= LoggerHelper.getLogger(FindDirection_Route.class);
	
	
	@Given("^I am on the Home page of Google Map website$")
	public void i_am_on_the_home_page_of_google_map_website() throws IOException {
		String WebURL = PropertyFileUtil.getProperty("WebURL");
		log.info("The Website Url given in property file is : " + WebURL);
	    SeleniumDriver.openPage(WebURL);
	}

	@When("^I search location$")
	public void i_search_location() throws IOException {
		String locationInput = PropertyFileUtil.getProperty("SearchLocation");
		log.info("The Search Location given in property file is : " + locationInput);	
		homePageAction.enterLocation(locationInput);
		
	}

	@And("^I click on Search button$")
	public void i_click_on_link() {
		homePageAction.clickSearchButton();
		
	}

	@Then("^I should get correct co-ordinates$")
	public void i_should_get_correct_co_ordinates_as() throws IOException {
		SeleniumDriver.waitForPageToLoad();
		String url = SeleniumDriver.getInstance().getCurrentUrl();
		log.info(url);
		String[] strArr = (url.split("@",2)[1]).split(",",3);
		String coordinates = PropertyFileUtil.getProperty("coordinates");
		log.info("The coordinates given in property file is : " + coordinates);
		//log.info(strArr[0]+","+strArr[1]);
		try {
			softAssert.assertEquals(strArr[0]+","+strArr[1], coordinates);
			
		}
		catch(Exception t) {
			
			ErrorCollector.addVerificationFailure(t);
			log.info("The coordinates mismatched: Expected - "+coordinates+" | Actual is - " + strArr[0]+","+strArr[1]);
		}
		
	}
	
	@And("^I click on Direction button$")
	public void i_click_on_button() {
		homePageAction.clickDirectionButton();
	}


	@And("^I click on icon$")
	public void i_click_on_icon(List<String> list) {
		String icon=list.get(1);
		if (icon.equals("Car")) {
			directionPageAction.clickCarButton();
		}	    
	}

	@And("^I enter starting point$")
	public void i_enter_starting_point_as() throws IOException {
		String startLoc = PropertyFileUtil.getProperty("StartLocation");
		log.info("The Start Location given in property file is : " + startLoc);
		directionPageAction.enterStartLocation(startLoc);
	}
	@And("^I enter destination location$")
	public void i_enter_destination_location() throws IOException{
		String destLoc = PropertyFileUtil.getProperty("DestinationLocation");
		log.info("The Start Location given in property file is : " + destLoc);
		directionPageAction.enterDestinationLocation(destLoc);
	}
	@And("^I click on DirectionSearch button$")
	public void i_click_on_directionsearch_button() {
		directionPageAction.clickOnDirectionSearchButton();
	}

	@Then("^I should see list of routes$")
	public void i_should_see_list_of_routes() {
		int totalRoutes = directionPageAction.getListofRoutes(); 
		
		try {
			softAssert.assertTrue(totalRoutes>1);
			
		}
		catch(Throwable t)
		{
			ErrorCollector.addVerificationFailure(t);
			//softAssert.assertAll("The number of suggested routes is less than 2 : Expected - Greater than 2 | Actual is - " + totalRoutes);
			log.info("The number of suggested routes is less than 2 : Expected - Greater than 2 | Actual is - " + totalRoutes);
		}

	}

	@And("Print the route details in a .txt file")
	public void print_the_route_details_in_a_txt_file() throws IOException {
		directionPageAction.printRoutesInTxt();
		softAssert.assertAll();
		
	}
}
