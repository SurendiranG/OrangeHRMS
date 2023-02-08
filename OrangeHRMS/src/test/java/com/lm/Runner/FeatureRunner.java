package com.lm.Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/resources/com.lm.featurefile"},
        glue = {"com/lm/stepdefinition"},
        monochrome = true,
        plugin = {"pretty", "html:test-output/report.html",
                "json:test-output/jsonReport.json",
                "junit:test-output/junitReport.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}



)


public class FeatureRunner {
}
