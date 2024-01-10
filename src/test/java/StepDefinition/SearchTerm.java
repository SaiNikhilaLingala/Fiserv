package StepDefinition;

import static org.testng.Assert.assertTrue;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SearchTerm {
	public WebDriver driver;
	@Given("User is on Search Engine {string} with browser {string}")
		public void user_is_on_search_engine(String searchEngine, String browser) {
			setupWebDriver(searchEngine,browser);
	        driver.get(getSearchEngineURL(searchEngine));
		}
		
		private void setupWebDriver(String searchEngine, String browser) {
	        switch (browser.toLowerCase()) {
	            case "chrome":
	                WebDriverManager.chromedriver().setup();
	                driver = new ChromeDriver();
	                break;
	            case "firefox":
	                WebDriverManager.firefoxdriver().setup();
	                driver = new FirefoxDriver();
	                break;
	            case "edge":
	                WebDriverManager.edgedriver().setup();
	                driver = new EdgeDriver();
	                break;
	            default:
	                throw new IllegalArgumentException("Unsupported browser: " + browser);
	        } 
	        }
	        
	        private String getSearchEngineURL(String searchEngine) {
	            switch (searchEngine.toLowerCase()) {
	                case "google":
	                    return "https://www.google.com";
	                case "bing":
	                    return "https://www.bing.com";
	                case "yahoo":
	                    return "https://www.yahoo.com";
	                default:
	                    throw new IllegalArgumentException("Unsupported search engine: " + searchEngine);
	            }
	            
	        }
		@When("User submit the search term {string}")
		public void user_submit_the_search_term(String searchTerm) {
			WebElement searchBox = driver.findElement(By.id("APjFqb"));
	        searchBox.sendKeys(searchTerm);
	        searchBox.submit();
		    
		}
		// Registering parameter type for 'expectedresult'
 	    @ParameterType(".*") // Regex pattern for any string
	    public String expectedresult(String value) {
	        return value;
 	    }

		@Then("first result should be {expectedresult}")
		public void first_result_should_be(String expectedText) {
			 WebElement firstResult = driver.findElement(By.cssSelector("h3.LC20lb.MBeuO.DKV0Md")); 
		        String actualText = firstResult.getText().toLowerCase();
		        String ExpectedText1 = expectedText.toLowerCase();
		        System.out.println(ExpectedText1);
		        System.out.println(actualText);
		        Assert.assertTrue(actualText.contains(ExpectedText1), "Expected text was not found within the actual text");
		        driver.quit();
		    }

	}
