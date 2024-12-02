package pageobjects;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class RevenueCalculatorPage {

    WebDriver driver;

    public RevenueCalculatorPage(WebDriver webDriver)
    {
        this.driver = webDriver;

    }

    public void navigateRevenueCalculator() throws InterruptedException {


        WebElement revnue_calc = driver.findElement(By.xpath("//div[contains(text(),'Revenue Calculator')]"));
       JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",revnue_calc);
        Thread.sleep(5000);
    }

    public void scrollingToSlider() {

        WebElement slider_visible = driver.findElement(By.xpath("//div[@class='MuiBox-root css-79elbk']/h4[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", slider_visible);
        js.executeScript("return window.pageYOffset");
    }

    public void setSliderPosition() throws InterruptedException {


        WebElement slider_position = driver.findElement(By.xpath("//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh']"));
        Actions act = new Actions(driver);
        act.dragAndDropBy(slider_position, 93, 0).build().perform();
        Thread.sleep( 2000);
    }

    public void selectCheckboxes()
    {
        WebElement checkbox_99091 = driver.findElement(By.xpath("//span[text() = '57']"));
        checkbox_99091.click();
        WebElement checkbox_99453 = driver.findElement(By.xpath("//span[text() = '19.19']"));
        checkbox_99453.click();
        WebElement checkbox_99454 = driver.findElement(By.xpath("//span[text() = '63']"));
        checkbox_99454.click();
        WebElement checkbox_99474 = driver.findElement(By.xpath("//span[text() = '15']"));
        checkbox_99474.click();

    }

    public void takeScreenshot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File trg = new File(".//src/main/resources/screenshot//screenshot1.png");
        FileUtils.copyFile(src,trg);
    }

    public String getValidateValue()
    {

        WebElement tot_RecurringReimbursement = driver.findElement(By.xpath("//div[@class='MuiBox-root css-19zjbfs']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", tot_RecurringReimbursement);
        js.executeScript("return window.pageYOffset");

        WebElement textBox_value = driver.findElement(By.xpath("//div[@class = 'MuiFormControl-root MuiTextField-root css-1s5tg4z']/div/input"));
        String val = textBox_value.getAttribute("value");
        return val;
    }


}
