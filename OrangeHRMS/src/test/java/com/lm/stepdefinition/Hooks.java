package com.lm.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import reusable.BrowserInvocation;

public class Hooks extends BrowserInvocation {

  @Before
    public void preCondition(){
     String path = System.getProperty("user.dir") + "/src/test/resources/log4j.properties";
    PropertyConfigurator.configure(path);
  }
  @AfterStep
    public void captureScreenShot(Scenario sc){
   byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
   sc.attach(screenShot,"image/png",null);

  }

  @After
   public void postCondition(){
    driver.close();
  }


}
