package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageobjects.RevenueCalculatorPage;

public class PageObjectManager {

    WebDriver driver;

    public PageObjectManager(WebDriver webDriver) {
        this.driver = webDriver;
    }
public RevenueCalculatorPage getRevenuePage() {
    RevenueCalculatorPage revenueCalculatorPage = new RevenueCalculatorPage(driver);

    return revenueCalculatorPage;
}


}
