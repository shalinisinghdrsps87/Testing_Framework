package step_definitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import cucumber.api.java.Before;
//import cucumber.api.java.Before;
import utils.SeleniumDriver;

public class BeforeActions {

	@Before
	public void setUp() throws IOException {

			SeleniumDriver.setUpDriver();

 	
		
	}
}
