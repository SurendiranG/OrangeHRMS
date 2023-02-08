package reusable;

import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BrowserInvocation {

   public static WebDriver driver;
   public static Properties prop;

    public static WebDriver browserCall() throws IOException {

     String path =   System.getProperty("user.dir");
        FileInputStream fileInputStream = new FileInputStream(new File(path + "/src/main/resources/Utilities/Configuration.Properties"));
       prop = new Properties();
      prop.load(fileInputStream);
        switch (prop.getProperty("browser").toLowerCase()){

            case "chrome" :
                System.setProperty("webdriver.chrome.driver",path + "/src/main/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "edge" :
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Enter the correct browser name");

        }

        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        return driver;


    }
}