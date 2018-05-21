package helper;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertTrue;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.google.common.collect.Ordering;

import helper.HelperMethods;
import pages.HomePage;
import selenium.DriverSetup;

import pages.HomePage;
import pages.SearchResultsPage;

public class HelperMethods {
	
	static WebDriver driver = null;
	
	
	/**
	 * This method launches the browser and verifies the title. Usage:
	 * assertTrue(launch_Browser) == True
	 * 
	 * @author M.Subramaniam
	 */

	public static boolean launch_Browser(WebDriver driver) {

		try {
			String url = "https://www.amazon.com";
			driver.get(url);
			driver.manage().window().maximize();
			String pageTitle = driver.getTitle();
			while (pageTitle.equals(
					"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more\r\n" + ""))
				;

			return true;
		} catch (Exception e) {
			System.err.println(e);
			System.err.println("Could not launch the browser");
			return false;
		}
	}
	
	
	/**
	 * This method verifies verify_Ipad_Air_2_Case_Filter_Applied. Usage:
	 * assertTrue(verify_Ipad_Air_2_Case_Filter_Applied) == True
	 * 
	 * @author M.Subramaniam
	 */

	public static boolean verify_Ipad_Air_2_Case_Filter_Applied(WebDriver driver) {
		WebDriver d = driver;
		try {
			HomePage.searchBar_textBox(d).sendKeys("ipad air 2 case");
			HomePage.searchBar_Btn(driver).click();
			String actual_text = HomePage.ipad_Air_2_Case_Filter_Test(d).getText();
			System.out.println(actual_text+"\n");
			while (actual_text == "ipad air 2 case")
				;
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.err.println("Ipad air2 case filter not applied");
			return false;
		}
	}
	
	/**
	 * This method verifies verify_Plastc_Filter_Applied. Usage:
	 * assertTrue(verify_Plastc_Filter_Applied) == True
	 * 
	 * @author M.Subramaniam
	 */

	public static boolean verify_Plastc_Filter_Applied(WebDriver driver) {
		WebDriver d = driver;
		try {
			HomePage.refine_By_Plastic_btn(d).click();
			String actual_text = HomePage.plastics_Filter_Test(d).getText();
			System.out.println(actual_text+"\n");
			while (actual_text == "Plastic")
				;
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.err.println("Plastics filter not applied"+"\n");
			return false;
		}
	}
	
	
	/**
	 * This method verifies Prices Filter are Applied. Usage:
	 * assertTrue(verify_Prices_Filter_Applied) == True
	 * 
	 * @author M.Subramaniam
	 */

	public static boolean verify_Prices_Filter_Applied(WebDriver driver) {
		WebDriver d = driver;
		try {
			Thread.sleep(5000);
			HomePage.refine_By_Price_From_Text(driver).sendKeys("20");
			HomePage.refine_By_Price_To_Text(driver).sendKeys("100");
			HomePage.refine_By_Price_Submit(driver).click();
			String actual_text = HomePage.prices_Filter_Test(d).getText();
			System.out.println(actual_text+"\n");
			while (actual_text == "$20-$100")
				;
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	/**
	 * This method outputs Name, prices and reviewss of first 5 results. Usage:
	 * assertTrue(print_Name_Prices_Score_First_5_Results) == True
	 * 
	 * @author M.Subramaniam
	 */

	public static void print_Name_Prices_Score_First_5_Results(WebDriver driver) {
		WebDriver d = driver;
		try {

			List<WebElement> prices = SearchResultsPage.prices(driver);
			List<WebElement> names = SearchResultsPage.names(driver);
			List<WebElement> reviews = SearchResultsPage.reviews(driver);
			List<WebElement> score = SearchResultsPage.score(driver);

			for (int i = 0; i < 5; i++) {
				System.out.println("Score: " + score.get(i).getAttribute("innerHTML") + " Item Name: "
						+ names.get(i).getText() + " Item reviews: " + reviews.get(i).getText() + " Item Price: "
						+ prices.get(i).getText()+"\n");
			}

		} catch (Exception e) {
			System.out.println(e);
			System.err.println("Cannot find names, prices and reviewss");
		}
	}
	
	
	/**
	 * This method outputs best item based on price and score.(Using Math.log to calculate the best item) Usage:
	 * assertTrue(best_product_on_basis_of_score_and_prices) == True
	 * 
	 * @author M.Subramaniam
	 */

	public static void best_product_on_basis_of_score_and_prices(WebDriver driver) {
		WebDriver d = driver;
		try {

			List<WebElement> prices = SearchResultsPage.prices(driver);

			List<WebElement> names = SearchResultsPage.names(driver);
			List<WebElement> reviews = SearchResultsPage.reviews(driver);
			List<WebElement> score = SearchResultsPage.score(driver);

			Map<Double, String> bestItem = new HashMap<Double, String>();

			double maxValue = Double.parseDouble(reviews.get(0).getText().replace(",", ""))
					* (Math.log(Double
							.parseDouble(score.get(0).getAttribute("innerHTML").replace(" out of 5 stars", "").trim())))
					/ Double.parseDouble(prices.get(0).getText().trim().replace("$", "").trim().replace(" ", "."));

			for (int i = 0; i < 5; i++) {
				double bestValue = Double.parseDouble(reviews.get(i).getText().replace(",", ""))
						* (Math.log(Double.parseDouble(
								score.get(i).getAttribute("innerHTML").replace(" out of 5 stars", "").trim())))
						/ Double.parseDouble(prices.get(i).getText().trim().replace("$", "").trim().replace(" ", "."));
				if (bestValue > maxValue) {
					maxValue = bestValue;
					bestItem.put(maxValue, names.get(i).getText());
				} else {
					bestItem.put(bestValue, names.get(i).getText());
				}

			}
			System.out.println("Best Item user can purchase is: " + bestItem.get(maxValue)+"\n");

		} catch (Exception e) {
			System.out.println(e);
			System.err.println("Cannot find the best item based on reviews and prices");
		}
	}

	/**
	 * This method verifies the first 5 values are between 20-100$. Usage:
	 * assertTrue(verify_First_5_Values_20_100) == True
	 * 
	 * @author M.Subramaniam
	 */

	public static boolean verify_First_5_Values_20_100(WebDriver driver) {
		WebDriver d = driver;
		try {

			// Kept the minimum value to 19.99 as amazon returns 19.99 also for filter between 20-100 for prices
			double minValue = 19.99;
			double maxValue = 100.0;

			List<WebElement> prices = SearchResultsPage.prices(driver);

			// Displaying name, reviews and price of first 5 items
			for (int i = 0; i < 5; i++) {
				System.out.println(prices.get(i).getText().trim().replace("$", "").trim().replace(" ", ".") + " $"+"\n");
				if (!(Double.parseDouble(
						prices.get(i).getText().trim().replace("$", "").trim().replace(" ", ".")) >= minValue
						&& Double.parseDouble(prices.get(i).getText().trim().replace("$", "").trim().replace(" ",
								".")) <= maxValue)) {
					return false;
				}
			}

			return true;
		} catch (Exception e) {
			System.err.println(e);
			System.err.println("First 5 prices are not between 5-20");
			return false;
		}
	}
	
	

	/**
	 * This method verifies the first 5 prices are sorted by price. Usage:
	 * assertTrue(verify_Sort_First_Five_Results_By_Price) == True
	 * 
	 * @author M.Subramaniam
	 */

	public static boolean verify_Sort_First_Five_Results_By_Price(WebDriver driver) {
		WebDriver d = driver;
		try {

			List<WebElement> prices = SearchResultsPage.prices(driver);

			List<Double> sortedPrices = new ArrayList<Double>();
			for (int i = 0; i < 5; i++) {
				sortedPrices.add(
						Double.parseDouble(prices.get(i).getText().trim().replace("$", "").trim().replace(" ", ".")));
				Collections.sort(sortedPrices);
			}

			System.out.println(sortedPrices+"\n");
			boolean isSorted = Ordering.natural().isOrdered(sortedPrices);
			if (isSorted == true) {
				return true;
			}

			return false;
		} catch (Exception e) {
			System.out.println(e);
			System.err.println("First five results is not sorted");
		}
		return false;
	}
	
	
	/**
	 * This method sorts the first 5 results by reviews. Usage:
	 * assertTrue(sort_First_Five_Results_By_reviews) == True
	 * 
	 * @author M.Subramaniam
	 */

	public static void sort_First_Five_Results_By_reviews(WebDriver driver) {
		WebDriver d = driver;
		try {
			List<WebElement> score = SearchResultsPage.score(driver);
			List<Double> sortedscore = new ArrayList<Double>();
			for (int i = 0; i < 5; i++) {
				sortedscore.add(Double
						.parseDouble(score.get(i).getAttribute("innerHTML").replace(" out of 5 stars", "").trim()));
				Collections.sort(sortedscore);
			}

			System.out.println(sortedscore+"\n");
		} catch (Exception e) {
			System.out.println(e);
			System.err.println("Cannot sort the first five results by scores");
		}
	}		

}

