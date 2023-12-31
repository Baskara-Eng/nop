package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="./src/test/resource/features/Login.feature",
				glue={"stepDefinitions","AppHooks"},
				plugin={"pretty"}
		)
public class TestRunner {

}


