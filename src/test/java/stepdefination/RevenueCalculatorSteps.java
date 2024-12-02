package stepdefination;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import utility.BrowserBase;
import utility.PageObjectManager;
import utility.TestContext;

import java.io.IOException;

public class RevenueCalculatorSteps {

    TestContext context;

    public RevenueCalculatorSteps(TestContext context)
    {
       this.context = context;
    }

    @Given("From the homepage, navigate to the Revenue Calculator Page")
    public  void revenueLogin() throws InterruptedException {
        context.pageObjectManager.getRevenuePage().navigateRevenueCalculator();
    }


    @When("Scroll down the page until the revenue calculator slider is visible")

    public void scrollDownPage() throws InterruptedException {
     context.pageObjectManager.getRevenuePage().scrollingToSlider();
    }


    @And("Adjust the slider to set its value and bottom text field value should be updated")
    public void adjustsliderPosition() throws InterruptedException {
        context.pageObjectManager.getRevenuePage().setSliderPosition();
    }
    @And("select the checkboxes for CPT-99091, CPT-99453, CPT-99454, and CPT-99474")
    public void checkboxes() {
        context.pageObjectManager.getRevenuePage().selectCheckboxes();
    }
    @And("Take the screenshot")
    public void takeTheScreenshot() throws IOException {
        context.pageObjectManager.getRevenuePage().takeScreenshot();
    }

   @Then("Validate value  enter in textbox")
    public void validateValueEnterInTextbox() {
       Assert.assertEquals("817", context.pageObjectManager.getRevenuePage().getValidateValue());

   }
      @BeforeStep
    public void before()
      {
          System.out.println("test execution started");
      }
    @AfterStep
    public void after()
    {
        System.out.println("test execution completed");
    }

}



