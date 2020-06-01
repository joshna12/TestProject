package cucumber.Options;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features/wishlist.feature",
        glue = {"steps"},
        plugin ={"pretty", "html:target/cucumber-html-report", "json:target/jsonReports/cucumber-report.json"},
        tags = {"@Test1"}
        )
public class TestRunner {
}