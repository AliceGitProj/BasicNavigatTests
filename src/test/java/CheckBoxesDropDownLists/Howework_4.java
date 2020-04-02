package CheckBoxesDropDownLists;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Howework_4 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void Days_Test(){

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        List <WebElement> checkboxes= driver.findElements(By.className("gwt-CheckBox"));
        //links.get(new Random().nextInt(links.size())).click();

        for (WebElement each : checkboxes){
            checkboxes.get(new Random().nextInt(checkboxes.size())).click();
            BrowserUtils.wait(2);
            System.out.println(each.getText());
        }



    }
}
