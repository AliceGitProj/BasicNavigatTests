package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args) throws Exception {
        Chrome();
        //Firefox();
        //Edge();
    }


    public static void Chrome() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://google.com");
        String googleT = "Google";
        //String googleT= driver.getTitle();
        driver.get("https://etsy.com");
        String etsyExp = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        System.out.println(driver.getTitle());
        driver.navigate().back();
        StringUtility.verifyEquals(driver.getTitle(),googleT);
        driver.navigate().forward();
        StringUtility.verifyEquals(driver.getTitle(),etsyExp);

        driver.quit();
    }

    public static void Firefox() throws Exception{
        WebDriver driver = BrowserFactory.getDriver("firefox");

        driver.get("https://google.com");
        String googleT = "Google";
        driver.get("https://etsy.com");
        String etsyExp = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        System.out.println(driver.getTitle());
        driver.navigate().back();
        StringUtility.verifyEquals(driver.getTitle(),googleT);
        driver.navigate().forward();
        StringUtility.verifyEquals(driver.getTitle(),etsyExp);

        driver.quit();

    }

    public static void Edge() {
        WebDriver driver = BrowserFactory.getDriver("edge");
        driver.get("https://google.com");
        String googleT = "Google";
        driver.get("https://etsy.com");
        String etsyExp = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        System.out.println(driver.getTitle());
        driver.navigate().back();
        StringUtility.verifyEquals(driver.getTitle(),googleT);
        driver.navigate().forward();
        StringUtility.verifyEquals(driver.getTitle(),etsyExp);

        driver.quit();

    }
}
