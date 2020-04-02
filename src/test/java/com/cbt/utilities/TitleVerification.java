package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {

        List<String>urls = Arrays.asList("http://practice.cybertekschool.com/", "http://practice.cybertekschool.com/dropdown",
                                         "http://practice.cybertekschool.com/login");
        WebDriver driver = BrowserFactory.getDriver("chrome");


        String expected = "Practice";
        String expectedUrl = "http://practice.cybertekschool.com";

        for (int i = 0; i < urls.size(); i++) {
            //driver.get(urls.get(i));
            driver.get(urls.get(i));
           String actual = driver.getTitle();
           StringUtility.verifyEquals(actual,expected);
           String actualUrl = driver.getCurrentUrl();

           if(actualUrl.startsWith("http://practice.cybertekschool.com")){
               System.out.println("URL PASS");
           }else {
               System.out.println("URL TEST FAIL");
           }

        }
        driver.quit();





//        for(String eachTitle : titles){
//            if(url.equals(eachTitle)){
//                System.out.println("TITLES ARE EQUAL!");
//            }else {
//                System.out.println("TITLES ARE NOT EQUAL!");
//            }
//
//        }




//         String webSites [] = url.split(" ");
//        for (int i = 0; i < webSites.length; i++) {
//            if (webSites[i].equals(webSites[i+1])){
//                System.out.println("ALL EQUAL!");
//            }
//        }
//        driver.get(urls.get(0));
//        String titleExpected0 = driver.getTitle();
//        driver.get(urls.get(1));
//        String titleExpected1 = driver.getTitle();
//        driver.get(urls.get(2));
//        String titleExpected2 = driver.getTitle();
//
//        if(titleExpected0.equals(titleExpected1)&& titleExpected0.equals(titleExpected2)){
//            System.out.println("Titles are the same");
//        }else {
//            System.out.println("Titles of websites are different");
//        }
//
//        driver.get(urls.get(0));
//        String url0 = driver.getCurrentUrl();
//        driver.get(urls.get(1));
//        String url1 = driver.getCurrentUrl();
//        driver.get(urls.get(2));
//        String url2 = driver.getCurrentUrl();











    }
}
