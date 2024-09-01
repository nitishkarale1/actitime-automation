package com.actitimeautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass
{
    public WebDriver driver;

    public void launchBrowser(String browserName)
    {
        switch (browserName)
        {
            case "chrome" : driver=new ChromeDriver();
            break;

            case "firefox" : driver=new FirefoxDriver();
            break;

            case "edge" : driver=new EdgeDriver();
        }
    }

    public void initializeBrowser(String BrowserName) throws IOException
    {
        if(BrowserName.equals("chrome"))
        {
            driver=new ChromeDriver();
        }

        else if (BrowserName.equals("edge"))
        {
            driver=new EdgeDriver();
        }

        else if(BrowserName.equals("firefox"))
        {
            driver=new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get("https://online.actitime.com/nk18/login.do");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
