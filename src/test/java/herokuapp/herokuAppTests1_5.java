package herokuapp;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class herokuAppTests1_5 {
   private WebDriver driver;
    private By regFormBy = By.linkText("Registration Form");
    private By DOBBy = By.xpath("//input[@placeholder='MM/DD/YYYY']");
    private By fisrtNameBy= By.name("firstname");
    private By lastNameBy = By.name("lastname");
    public By regForm = By.linkText("Registration Form");
    public By firstName= By.name("firstname");
    private By lastName = By.name("lastname");
    private By userName= By.xpath("//*[@name='username']");
    private By password= By.xpath("//*[@name='password']");
    private By phoneNumber= By.xpath("//*[@name='phone']");
    private By genderMale=By.cssSelector("input[value='male']");
    private By birthDay=By.cssSelector("input[name='birthday']");
    private By javaLan=By.xpath("//*[@value='java']");
    private By signUpBtn=By.id("wooden_spoon");
    private By email=By.xpath("//*[@name='email']");
    private By chooseFileBtn =By.id("file-upload");
    private By UploadBtn = By.id("file-submit");
    private By AutoCompl = By.linkText("Autocomplete");
    private By CountryBy = By.name("myCountry");
    private By StatusCodesBy=By.linkText("Status Codes");

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
    public void testCase1(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(regFormBy).click();
        driver.findElement(DOBBy).sendKeys("wrong_dob");

        String expected = "The date of birth is not valid";
        String actual = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']")).getText();

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testCase2(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(regFormBy).click();

        List<WebElement> JavaLan = driver.findElements(By.xpath("//label[@class='form-check-label']"));
        for (WebElement each :JavaLan) {
            Assert.assertTrue(each.isDisplayed());
            System.out.println(each.getText());
        }

    }

    @Test
    public void testCase3(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(regFormBy).click();
        driver.findElement(fisrtNameBy).sendKeys("a");
        String expectedMes="first name must be more than 2 and less than 64 characters long";
        String actualMes=driver.findElement(By.xpath("//*[@id='registrationForm']/div[1]/div/small[2]")).getText();
        Assert.assertEquals(actualMes,expectedMes);
    }

    @Test
    public void testCase4(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(regFormBy).click();
        driver.findElement(lastNameBy).sendKeys("a");
        String actual= driver.findElement(By.xpath("//small[@class='help-block' and contains(text(),'The last name must be')]")).getText();
        String expected= "The last name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testCase5(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(regForm).click();
        driver.findElement(firstName).sendKeys("John");
        BrowserUtils.wait(3);
        driver.findElement(lastName).sendKeys("Smith");
        driver.findElement(userName).sendKeys("HelloJ");
        driver.findElement(email).sendKeys("hi@gmail.com");
        driver.findElement(password).sendKeys("hello123");
        driver.findElement(phoneNumber).sendKeys("555-555-6666");
        BrowserUtils.wait(3);
        driver.findElement(genderMale).click();
        BrowserUtils.wait(3);
        driver.findElement(birthDay).sendKeys("01/01/2001");
        Select selectDepart= new Select(driver.findElement(By.name("department")));
        BrowserUtils.wait(3);
        selectDepart.selectByVisibleText("Department of Engineering");
        Select selectJobTitle= new Select(driver.findElement(By.name("job_title")));
        selectJobTitle.selectByVisibleText("SDET");
        BrowserUtils.wait(3);
        driver.findElement(javaLan).click();
        driver.findElement(signUpBtn).click();

        String expected="You've successfully completed registration!";
        String actual = driver.findElement(By.xpath("//p")).getText();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testCase6(){

        driver.get("https://www.tempmailaddress.com/");
        String email = driver.findElement(By.className("animace")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("John Smith");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();
        String expected= "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(actual,expected);
        driver.get("https://www.tempmailaddress.com/");
        BrowserUtils.wait(5);
        String actualEmail = driver.findElement(By.xpath("//tbody/tr/td[text()='do-not-reply@practice.cybertekschool.com']")).getText().replace(" ","");
        driver.findElement(By.xpath("//tbody/tr/td[text()='do-not-reply@practice.cybertekschool.com']")).click();
        String expectedEmail = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualEmail, expectedEmail);
        String expectedMessage = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualMessage = driver.findElement(By.id("predmet")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);

        driver.quit();

    }

    @Test
    public void testCase7(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("File Upload")).click();
        Actions action = new Actions(driver);
        String pathForFile = "C:\\Users\\Nikolai\\Desktop\\UploadTest.txt";
        WebElement chooseFile = driver.findElement(chooseFileBtn);
        chooseFile.sendKeys(pathForFile);
        driver.findElement(UploadBtn).click();

        String expectedMessage = "File Uploaded!";
        String actualMessage = driver.findElement(By.xpath("//div//h3")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        String expectedFile = "UploadTest.txt";
        String actualFile = driver.findElement(By.xpath("//div[@class='panel text-center']")).getText();
        Assert.assertEquals(actualFile, expectedFile);

    }

    @Test
    public void testCase8(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(AutoCompl).click();
        WebElement countryInput = driver.findElement(CountryBy);
        countryInput.sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        String expectedMessage ="You selected: United States of America";
        Assert.assertEquals(driver.findElement(By.id("result")).getText().trim(),expectedMessage);
    }

    @DataProvider
    public Object[][] TestData(){
        Object[][]data = new Object[4][2];

        data[0][0]= "200";
        data[0][1]= "This page returned a 200 status code";

        data[1][0]= "301";
        data[1][1]= "This page returned a 301 status code";

        data[2][0]= "404";
        data[2][1]= "This page returned a 404 status code";

        data[3][0]= "404";
        data[3][1]= "This page returned a 404 status code";

        return  data;

    }

    @Test(dataProvider = "TestData")
    public void testCases9_12(String number, String message){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(StatusCodesBy).click();
        driver.findElement(By.linkText(number)).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText().contains(message));

    }


}
