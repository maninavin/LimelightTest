package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
    private static WebElement element = null;
    
	private final static String searchBarId = "twotabsearchtextbox";
	private final static String refine_By_Plastic_btn_Id = "input[name=\"s-ref-checkbox-8080061011\"]";
	private final static String searchBar_Btn_Id = "input.nav-input";
	private final static String refine_By_Price_From_Text_Id = "low-price";
	private final static String refine_By_Price_To_Text_Id = "high-price";
	private final static String refine_By_Price_Submit_Id = "form>span>span>input.a-button-input";
	private final static String ipad_Air_2_Case_Filter_Test_Id = "#bcKwText > span";
	private final static String plastics_Filter_Test_Id = "#s-result-count > span > a:nth-child(6)";
	private final static String prices_Filter_Test_Id = "#s-result-count > span > a:nth-child(7)";

	public static WebElement searchBar_textBox(WebDriver driver) {

		element = driver.findElement(By.id(searchBarId));

		return element;

	}
    
    
	public static WebElement searchBar_Btn(WebDriver driver) {

		element = driver.findElement(By.cssSelector(searchBar_Btn_Id));

		return element;

	}
    
    
	public static WebElement refine_By_Plastic_btn(WebDriver driver) {

		element = driver.findElement(By.cssSelector(refine_By_Plastic_btn_Id));

		return element;

	}
    
 
	public static WebElement refine_By_Price_From_Text(WebDriver driver) throws InterruptedException {

		element = driver.findElement(By.id(refine_By_Price_From_Text_Id));

		return element;

	}
	
	
	public static WebElement refine_By_Price_To_Text(WebDriver driver) {

		element = driver.findElement(By.id(refine_By_Price_To_Text_Id));

		return element;

	}
    
	public static WebElement refine_By_Price_Submit(WebDriver driver) {

		element = driver.findElement(By.cssSelector(refine_By_Price_Submit_Id));
		return element;

	}    
    
    
    
    
    // Filters test elements
    
	public static WebElement ipad_Air_2_Case_Filter_Test(WebDriver driver) {

		element = driver.findElement(By.cssSelector(ipad_Air_2_Case_Filter_Test_Id));
		return element;

	}
    
    
	public static WebElement plastics_Filter_Test(WebDriver driver) {

		element = driver.findElement(By.cssSelector(plastics_Filter_Test_Id));
		return element;

	}
    

    
	public static WebElement prices_Filter_Test(WebDriver driver) {

		element = driver.findElement(By.cssSelector(prices_Filter_Test_Id));
		return element;

	}
}
