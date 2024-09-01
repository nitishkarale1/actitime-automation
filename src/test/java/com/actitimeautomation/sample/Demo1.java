package com.actitimeautomation.sample;

import com.actitimeautomation.pages.AddCustomer;
import com.actitimeautomation.pages.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo1 extends BaseClass
{
    static WebDriver driver;
    public Demo1()
    {
        launchBrowser("chrome");
        driver = super.driver;
    }

    public static void main(String[] args) throws InterruptedException {
        new Demo1();
        driver.manage().window().maximize();
        driver.get("https://online.actitime.com/nk18/login.do");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nitish1810", "nkhonor8pro");

        AddCustomer addCustomer = new AddCustomer(driver);
        addCustomer.clickOnTasksModeule();
        Thread.sleep(2000);
        addCustomer.clickOnAddNewButton();

        //click on New Tasks link
        driver.findElement(By.xpath("//div[@class='item createNewTasks']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[starts-with(@class,'customerSelector')]//div[@class='selectedItem']")).click();

        List<WebElement> allCustomerslist = driver.findElements(By.xpath("//tr[@class='selectCustomerRow']//div[@class='searchItemList']/div"));

        for(WebElement customer:allCustomerslist)
        {
            if(customer.getText().equals("- ALL ACTIVE CUSTOMERS -"))
            {
                customer.click();
                break;
            }
        }

        driver.findElement(By.xpath("//div[starts-with(@class,'projectSelector')]//div[@class='selectedItem']")).click();
        List<WebElement> allProjectslist = driver.findElements(By.xpath("//tr[@class='selectProjectRow projectSelectorRow']//div[@class='searchItemList']/div"));
        Thread.sleep(2000);
        for(WebElement project:allProjectslist)
        {
            if(project.getText().equals("Recruiting & HR"))
            {
                project.click();
                break;
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@type='text' and @placeholder='Enter task name'])[1]")).sendKeys("Salary Discussion");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Create Tasks']")).click();
    }
}