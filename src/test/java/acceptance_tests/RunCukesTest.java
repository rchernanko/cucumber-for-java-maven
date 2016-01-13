package acceptance_tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (glue = {"step_definitions"}, features = "src/test/resources/features/")
public class RunCukesTest {
}

/*

RUNNING SCENARIOS / FEATURES AS PER THEIR TAGS

1)

If I wanted to run all scenarios that have a @richard tag EVERY time when I enter mvn clean test, I could add the below
tags section to my Cucumber Options:

@CucumberOptions (glue = {"step_definitions"}, features = "src/test/resources/features/", tags = {"@richard"})

2)

Of course, if I don't have a tags section in my cucumber options, then I can also specify specific tags to run on the
command line:

mvn clean test -Dcucumber.options="--tags @richard --tags @hello"

3)

If I want to run all scenarios in the features directory specified in the cucumber options, I simply don't add a
tags section to the cucumber options above. Then, if I run mvn clean test, every feature within the feature directory
will be run

 */
