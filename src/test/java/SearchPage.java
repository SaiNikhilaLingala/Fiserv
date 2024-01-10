

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String searchEngineURL) {
        driver.get(searchEngineURL);
    }

    public void search(String searchTerm) {
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
    }

    public String getFirstResultText() {
        WebElement firstResult = driver.findElement(By.cssSelector("h3.LC20lb.MBeuO.DKV0Md"));
        return firstResult.getText().toLowerCase();
    }
}

