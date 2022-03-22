package com.martynsmart;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/cucumber-report/cucumber.json"},
        features = "src/test/resources/SearchByOwner.feature"
)
public class RunCucumberAllTests {
}
