package reusable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextBoxHelper extends BrowserInvocation {

    public void enterTextValue(By locator,String textValue){
      driver.findElement(locator).sendKeys(textValue);

    }
    public String getTextValue(By locator){
      String textValue =  driver.findElement(locator).getText();
        return textValue;
    }
    public void clearTextValue(By locator){
        driver.findElement(locator).clear();
    }

}
