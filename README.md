# Cucumber-for-java-maven
This repo is based on my work when reading the 'Cucumber for Java Book'.

I created a Maven project for the work I'd done after page 49 of the book.

# Mvn clean test + RunCukesTest class
Before there was a RunCukesTest class, when I executed mvn clean test, no tests were run.

Of course Maven looks for a class ending in Test. There is then some Cucumber magic in the RunCukesTest class that tells
Cucumber where to look for feature files.

# Maven Cucumber Reporting plugin
The step-by-step implementation of this was not in the 'Cucumber for Java Book' but I just did it anyway:

To implement the plugin, add in the following in the pom.xml:

        <dependency>
            <groupId>net.masterthought</groupId>
            <artifactId>cucumber-reporting</artifactId>
            <version>${masterthought.cucumber.dependency.version}</version>
        </dependency>
        
...and then also this:

            <plugin>
                <groupId>net.masterthought</groupId>
                <artifactId>maven-cucumber-reporting</artifactId>
                <version>${masterthought.cucumber.plugin.version}</version>
                <executions>
                    <execution>
                        <id>execution</id>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <projectName>cucumber-for-java-maven</projectName>
                            <outputDirectory>${project.build.directory}/cucumber-html-reports</outputDirectory>
                            <cucumberOutput>${project.build.directory}/cucumber-reports</cucumberOutput>
                            <skippedFails>true</skippedFails>
                            <!--if a step is skipped in a FF, it will show as a failure on the HTML report-->
                            <undefinedFails>true</undefinedFails>
                            <!--if a step is undefined in a FF, it will show as a failure on the HTML report-->
                            <enableFlashCharts>true</enableFlashCharts>
                            <!--this gives nicer flash charts in the HTML report-->
                        </configuration>
                    </execution>
                </executions>
            </plugin>

###Few things to note about it...

From the github repo (https://github.com/damianszczepanik/cucumber-reporting):

>"This project allows you to publish the results of a cucumber run as pretty html reports. In order for this to work
>you must generate a cucumber json report. The project converts the json report into an overview html linking to
>separate feature file htmls with stats and results."

So basically, I need to include the JSON in the cucumber options (within RunCukesTest.java) in order to generate the 
HTML reports.

The HTML reports can't be generated without the JSON.

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"cucumber_book"}, features = "src/test/resources/features/", plugin = {"pretty",
        "html:target/cucumber-reports", "json:target/cucumber-reports/cucumber.json"})
public class RunCukesTest {
}

###Why do all the tests open a browser?

Some of the features require a browser for execution, but others do not (e.g. tic_tac_toe.feature).

So why are there loads of open browsers?

The reason for this is because I have added in an @After hook in WebDriverHooks.java. This takes a screenshot of the
scenario, passed or failed. So when the tic_tac_toe.feature runs, the final thing cucumber does is run the after hook
which opens a browser and takes a screenshot...this screenshot then gets embedded within the scenario.

If I only want to take a screenshot of failing tests, I could implement something like this:

@After("@browser")
public void tearDown(Scenario scenario) {
    if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
    }
    driver.close();
}
