package com.actitimeautomation.sample;

import com.actitimeautomation.pages.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Demo3 extends BaseClass
{
    static WebDriver driver;
    public Demo3()
    {
        launchBrowser("chrome");
        driver = super.driver;
    }

    public static void main(String[] args) throws InterruptedException {
        new Demo3();
        driver.manage().window().maximize();
        driver.get("https://online.actitime.com/nk18/login.do");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("username")).sendKeys("nitish1810");
        driver.findElement(By.name("pwd")).sendKeys("nkhonor8pro");
        driver.findElement(By.xpath("//div[starts-with(text(),'Login')]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Users' and @class='label']")).click();

        driver.findElement(By.xpath("(//div[contains(@class,'_groupItem department') and text()=\"  Departments\"])[1]")).click();

        driver.findElement(By.id("groupManagementLightBox_newGroupInput")).sendKeys("Quality Assurance");
        Thread.sleep(3000);
        driver.findElement(By.id("groupManagementLightBox_addGroupButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='groupManagementLightBox_closeLightbox']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='New User']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("createUserPanel_firstNameField")).sendKeys("Smith");
        Thread.sleep(3000);
        driver.findElement(By.id("createUserPanel_middleNameField")).sendKeys("MK");
        Thread.sleep(3000);
        driver.findElement(By.id("createUserPanel_lastNameField")).sendKeys("Morris");
        Thread.sleep(3000);
        driver.findElement(By.id("createUserPanel_emailField")).sendKeys("smith@kmail.com");
        Thread.sleep(3000);
        Actions act = new Actions(driver);
        act.click(driver.findElement(By.xpath("//div[text()='-- department not assigned --' and @class='title']"))).perform();
        List<WebElement>allDepartmentDropdownElements=driver.findElements(By.xpath("//div[@class='itemsContainer']/div[@class='item']"));
        for(WebElement element:allDepartmentDropdownElements)
        {
            if(element.getText().equals("Quality Assurance"))
            {
                element.click();
                break;
            }
        }
        Thread.sleep(3000);
        act.scrollToElement(driver.findElement(By.xpath("//span[text()='Onsite (default)']")));
        Thread.sleep(3000);
        act.click(driver.findElement(By.xpath("//span[text()='Onsite (default)']"))).perform();

        List<WebElement> allLocationDropdownElements=driver.findElements(By.xpath("//div[@id=':r5:']/div/div"));
        for(WebElement element1:allLocationDropdownElements)
        {
            if(element1.getText().equals("Business Trip"))
            {
                System.out.println(element1.getText());
                element1.click();
                break;
            }
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//span[text()='Close'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//td[@class='logoutCell preventPanelsHiding']//a[@id='logoutLink']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
