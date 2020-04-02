package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String name) {

        if (name.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().version("79.0").setup();
            WebDriver driver = new ChromeDriver();
            return driver;
        } else if (name.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            return driver;

        } else if (name.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            return driver;

        } else if (name.equalsIgnoreCase("safari")) {
            return null;

        }else {
            return null;

        }

    }
}
