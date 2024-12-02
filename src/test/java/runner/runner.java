package runner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)

    @CucumberOptions(

          features = {"src/test/resources/testdesign"},
            glue= {"stepdefination"},
            tags ="@fitpeo01" ,
            dryRun = false,
            monochrome = true,
            plugin = {"pretty","html:src/main/resources/cucumber-reports/report1.html",
                    "json:src/main/resources/cucumber-reports/report2.json",
                     "junit:src/main/resources/cucumber-reports/report3.xml"  }



    )

    public class runner {
    }

