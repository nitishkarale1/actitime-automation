package com.actitimeautomation.sample;

import com.actitimeautomation.pages.LoginPage;
import com.actitimeautomation.pages.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest
{
    public static void main(String[] args) throws Exception {

        WebDriver driver=new ChromeDriver();
        driver.get("https://online.actitime.com/nitishkarale/login.do");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("nitish18","nkhonor8pro");

        System.out.println("Actitime Logged in Successful...!");

        Thread.sleep(5000);

        LogoutPage logoutPage=new LogoutPage(driver);
        logoutPage.logoutPage();

        System.out.println("Actitime Logged out Successful...!");

        Thread.sleep(2000);
        driver.close();


//        WebDriver driver=new FirefoxDriver();
//        driver.get("https://online.actitime.com/nitishkarale/login.do");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.manage().window().maximize();
////        WebElement username =driver.findElement(By.id("username"));
////        username.sendKeys("nitish18");
//        driver.findElement(By.id("username")).sendKeys("nitish18");
//        driver.findElement(By.name("pwd")).sendKeys("nkhonor8pro");
//        driver.findElement(By.xpath("//div[starts-with(text(),'Login')]")).click();
//
//        Thread.sleep(8000);
//        //Logout application
//        driver.findElement(By.id("logoutLink")).click();
//
//       //Scenario2: verify login feature error message with Invalid username & valid password
//        driver.findElement(By.id("username")).sendKeys("abc123");
//        driver.findElement(By.name("pwd")).sendKeys("nkhonor8pro");
//        driver.findElement(By.xpath("//div[starts-with(text(),'Login')]")).click();
//
//        Thread.sleep(5000);
//
//        //get error message
//        String errorMsg1=driver.findElement(By.xpath("//span[starts-with(text(),'Username or Password')]")).getText();
//        System.out.println(errorMsg1);
//
//        //verify error messgae
//        if(errorMsg1.equals("Username or Password is invalid. Please try again."))
//        {
//            System.out.println("Succefully verified error message.");
//        }
//        else
//        {
//            throw new Exception("Actual and Expected error message did not matched");
//        }
//
//        //Scenario3: verify login feature error message with blank username & valid password
//        driver.findElement(By.name("pwd")).sendKeys("nkhonor8pro");
//        driver.findElement(By.xpath("//div[starts-with(text(),'Login')]")).click();
//
//        //verify error messgae
//        if(driver.findElement(By.xpath("//span[starts-with(text(),'Username or Password')]")).isDisplayed())
//        {
//            String errorMsg2=driver.findElement(By.xpath("//span[starts-with(text(),'Username or Password')]")).getText();
//            //verify error message
//            if(errorMsg2.equals("Username or Password is invalid. Please try again."))
//            {
//                System.out.println("Successfully verified error message.");
//            }
//            else
//            {
//                throw new Exception("Actual and Expected error message did not matched.");
//            }
//        }
//        else
//        {
//            throw new Exception("Error message did not Displayed on webpage.");
//        }
//
//        Thread.sleep(2000);
//        driver.close();

    }
}
