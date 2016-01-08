package acceptance_tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (glue = {"step_definitions"}, features = "src/test/resources/features/")
public class RunCukesTest {
}