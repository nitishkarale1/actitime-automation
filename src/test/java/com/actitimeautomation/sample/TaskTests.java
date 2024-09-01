package com.actitimeautomation.sample;

import com.actitimeautomation.pages.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TaskTests extends BaseClass
{
    static WebDriver driver;
    public  TaskTests()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }
    public static void main(String[] args) throws InterruptedException
    {
        TaskTests test=new TaskTests();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Launch website
        driver.get("https://online.actitime.com/nitishkarale/login.do");

        //Create object of LoginPage class
        LoginPage loginPage=new LoginPage(driver);

        //Perform login operation
        loginPage.login("nitish18", "nkhonor8pro");

        //wait for 5 seconds
        Thread.sleep(5000);

        //Click on Tasks module
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();

        //wait for 5 seconds
        Thread.sleep(5000);

        //Locate and verify select all checkbox is displayed or not
        boolean selectAllCheckbox=driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]")).isDisplayed();

        if(selectAllCheckbox)
        {
            //Click on select all checkbox
            driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]")).click();

            //wait for 5 seconds
            Thread.sleep(5000);

            //Verify select all checkbox is selected or not
            boolean selectedCheckbox=driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]")).isSelected();
            System.out.println(selectedCheckbox);
            if(selectedCheckbox)
            {
                System.out.println("All checkboxes are selected.");
            }
            else
            {
                System.out.println("Unable to select all checkboxes.");
            }
        }

        else
        {
            System.out.println("Unable to display select all checkbox hence unable to perform further operations.");
        }
    }
}
