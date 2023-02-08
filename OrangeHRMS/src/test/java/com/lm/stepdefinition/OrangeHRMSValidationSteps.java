package com.lm.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import reusable.BrowserInvocation;
import reusable.TextBoxHelper;

import java.io.IOException;

public class OrangeHRMSValidationSteps extends BrowserInvocation{
    private WebDriver driuer;
    private TextBoxHelper textBoxHelper;
    private BrowserInvocation browserInvocation;
    public OrangeHRMSValidationSteps(){
         browserInvocation = new BrowserInvocation();
         textBoxHelper = new TextBoxHelper();

    }
    @Given("User navigates to the URL")
    public void navigatesToURl() throws IOException {
         driuer = BrowserInvocation.browserCall();

    }
    @When("User enters the valid Username and Password")
    public void entersUsernamePassword(){
         textBoxHelper.enterTextValue(By.xpath("//input[@name='username']"),browserInvocation.prop.getProperty("Username"));
         textBoxHelper.enterTextValue(By.xpath("//input[@name='password']"),browserInvocation.prop.getProperty("Password"));
    }
    @And("User clicks the Login Button")
    public void clicksLogin(){
         driuer.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
    }
    @Then("User should verify logged in successfully")
    public void veridyLoggedIn(){
        String expectedResult = "Dashboard";
        String actualResult = textBoxHelper.getTextValue(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
        Assert.assertEquals(expectedResult,actualResult);
    }





















}
