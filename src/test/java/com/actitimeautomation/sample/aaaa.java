package com.actitimeautomation.sample;

import com.actitimeautomation.pages.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class aaaa extends BaseClass
{
    static WebDriver driver;
    public aaaa()
    {
        launchBrowser("chrome");
        driver = super.driver;
    }

    public static void main(String[] args) throws InterruptedException
    {
        new Demo3();
        driver.manage().window().maximize();
        driver.get("https://online.actitime.com/nk18/login.do");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("username")).sendKeys("nitish1810");
        driver.findElement(By.name("pwd")).sendKeys("nkhonor8pro");
        driver.findElement(By.xpath("//div[starts-with(text(),'Login')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Users' and @class='label']")).click();
    }
}
