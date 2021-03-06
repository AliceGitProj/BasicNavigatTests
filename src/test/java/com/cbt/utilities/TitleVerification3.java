package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://wayfair.com",
                "https://walmart.com", "https://www.luluandgeorgia.com/"
        ,"https://westelm.com/m/", "https://www.luluandgeorgia.com/");


        WebDriver driver = BrowserFactory.getDriver("chrome");

        for (int i = 0; i < urls.size(); i++) {

            driver.get(urls.get(i));

            if (driver.getTitle().contains(".com")) {

                String title2Compare = driver.getTitle().replace(" ", "").toLowerCase();
                String url2Compare = driver.getCurrentUrl().replace("https://www.", "").replace("/", "").toLowerCase();

                if (url2Compare.contains(title2Compare.substring(0, url2Compare.length()))) {
                    System.out.println("PASS!");
                } else {
                    System.out.println("FAIL!");
                }
                driver.quit();

            } else {

                String titleCompare = driver.getTitle().replace(" ", "").toLowerCase();
                String urlCompare = driver.getCurrentUrl().replace("https://www.", "").replace(".com/", "").toLowerCase();

                if (urlCompare.contains(titleCompare)) {
                    System.out.println("PASS!");
                } else {
                    System.out.println("FAIL!");
                }
                driver.quit();

            }
            driver = BrowserFactory.getDriver("chrome");
        }
        driver.quit();
    }

}
