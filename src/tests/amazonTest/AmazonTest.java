	/**
	 * This test case validates prices for first 5 items and sorting of the 5 items by price.
	 * Functionality: Validating top 5 items and its sorting.
	 * 
	 * @author M.Subramaniam
	 */


package tests.amazonTest;

import static org.testng.Assert.assertTrue;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;

import helper.HelperMethods;
import pages.HomePage;
import selenium.DriverSetup;


public class AmazonTest extends DriverSetup {
	
	WebDriver driver = DriverSetup.setupDriver(DriverSetup.Browser.Chrome, "chromedriver.exe");


	@Parameters()
	@Test(description = "Test case to validate prices for first 5 items and sorting of the 5 itmes by price.")
	public void groupSetup() throws Exception {

		System.out.println("Launch the Amazon URL" + "\n");
		assertTrue(HelperMethods.launch_Browser(driver), "Unable to launch the browser");

		System.out.println("Verify Ipad air 2 case filter is applied" + "\n");
		assertTrue(HelperMethods.verify_Ipad_Air_2_Case_Filter_Applied(driver), "Ipad air 2 case filter not applied");

		System.out.println("Verify plastics filter is applied" + "\n");
		assertTrue(HelperMethods.verify_Plastc_Filter_Applied(driver), "plastics filter is not applied");

		System.out.println("Verify prices filter is applied" + "\n");
		assertTrue(HelperMethods.verify_Prices_Filter_Applied(driver), "Prices filter is not applied");

		System.out.println("Print the Name, Price and Score/Rating of first 5 results" + "\n");
		HelperMethods.print_Name_Prices_Score_First_5_Results(driver);

		System.out.println("Verify the first 5 values are between 20-100" + "\n");
		assertTrue(HelperMethods.verify_First_5_Values_20_100(driver), "First 5 prices are not between 20-100");

		System.out.println("Verify first 5 results are sorted by price" + "\n");
		assertTrue(HelperMethods.verify_Sort_First_Five_Results_By_Price(driver),
				"First 5 prices are not sorted by price");

		System.out.println("Verify Sort of first 5 results by reviews" + "\n");
		HelperMethods.sort_First_Five_Results_By_reviews(driver);

		System.out.println("Based on Score and Cost the item a user should purchase" + "\n");
		HelperMethods.best_product_on_basis_of_score_and_prices(driver);

	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDownTest() {
		driver.close();
	}
}
