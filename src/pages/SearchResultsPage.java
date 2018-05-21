package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
	
	private static final String prices_id = "//div[@class=\"a-row a-spacing-mini\"]/div[@class=\"a-row a-spacing-none\"][1]/a/span[2]";
	private static final String names_id = ".a-size-base.s-inline.s-access-title.a-text-normal";
	private static final String reviews_id = "a[href*='#customerReviews']";
	private static final String score_id = "i.a-icon.a-icon-star>span";


	
    private static WebElement element = null;
    


	  
	public static List<WebElement> prices(WebDriver driver) {
		List<WebElement> prices = driver.findElements(By.xpath(prices_id));
		return prices;
	}
	  
	  
	public static List<WebElement> names(WebDriver driver) {
		List<WebElement> names = driver.findElements(By.cssSelector(names_id));
		return names;
	}
	  
	public static List<WebElement> reviews(WebDriver driver) {
		List<WebElement> reviews = driver.findElements(By.cssSelector(reviews_id));
		return reviews;
	}
	  
	public static List<WebElement> score(WebDriver driver) {
		List<WebElement> reviews = driver.findElements(By.cssSelector(score_id));
		return reviews;
	}

}
