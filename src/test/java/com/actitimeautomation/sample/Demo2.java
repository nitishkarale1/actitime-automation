package com.actitimeautomation.sample;

import com.actitimeautomation.pages.BaseClass;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Demo2 extends BaseClass
{
    static WebDriver driver;
    public Demo2()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        new Demo2();

        driver.manage().window().maximize();
        driver.get("https://online.actitime.com/nk18/login.do");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("username")).sendKeys("nitish1810");
        driver.findElement(By.name("pwd")).sendKeys("nkhonor8pro");
        driver.findElement(By.xpath("//div[starts-with(text(),'Login')]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Add New']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[starts-with(@class,'inputFieldWithPlaceholder')]")).sendKeys("AutoFlux");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='item createNewProject']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[starts-with(@class,'projectNameField')]")).sendKeys("DataSynch");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Create Project']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='item createNewTasks']")).click();
        Thread.sleep(2000);

//        //create first task
//        driver.findElement(By.xpath("(//input[@placeholder='Enter task name'])[4]")).sendKeys("Functional testing");
//        Thread.sleep(2000);
//        //create second task
//        driver.findElement(By.xpath("(//input[@placeholder='Enter task name'])[5]")).sendKeys("Integration testing");
//        Thread.sleep(2000);
//        //create third task
//        driver.findElement(By.xpath("(//input[@placeholder='Enter task name'])[6]")).sendKeys("Compatibility testing");
//        Thread.sleep(2000);
//        //create fourth task
//        driver.findElement(By.xpath("(//input[@placeholder='Enter task name'])[7]")).sendKeys("Regression testing");
//        Thread.sleep(2000);


//        List<WebElement> allTaskFields = driver.findElements(By.xpath("//table[@class='createTasksTable']//colgroup[@class='createTasksTableColgroup']//following-sibling::tbody//input[@placeholder='Enter task name']"));
//        FileInputStream fis = new FileInputStream("D:\\CyberSuccess\\test data\\Book1.xlsx");
//        Sheet sh = WorkbookFactory.create(fis).getSheet("Sheet2");
//        int lastRowIndex = sh.getLastRowNum();
//        int lastCellIndex = sh.getRow(0).getLastCellNum() - 1;
//        int taskFieldIndex = 0; // Track the task field index
//
//        for (int i = 0; i <= lastRowIndex; i++)
//        {
//            for (int j = 0; j <= lastCellIndex; j++)
//            {
//                if (taskFieldIndex < allTaskFields.size())
//                {
//                    WebElement taskField = allTaskFields.get(taskFieldIndex);
//                    taskField.sendKeys(sh.getRow(i).getCell(j).getStringCellValue());
//                    Thread.sleep(1500);
//                    taskFieldIndex++; // Move to the next task field for the next input
//                }
//            }
//        }

        List<WebElement> allTaskFields = driver.findElements(By.xpath("//table[@class='createTasksTable']//colgroup[@class='createTasksTableColgroup']//following-sibling::tbody//input[@placeholder='Enter task name']"));
        FileInputStream fis=new FileInputStream("D:\\CyberSuccess\\test data\\Book1.xlsx");
        Sheet sh= WorkbookFactory.create(fis).getSheet("Sheet2");
        int lastRowIndex=sh.getLastRowNum();
        int lastCellIndex=sh.getRow(0).getLastCellNum()-1;
        int taskFieldIndex = 0;
        for(int i=0; i<=lastRowIndex; i++)
        {
            for(int j=0; j<=lastCellIndex; j++)
            {
                if(taskFieldIndex < allTaskFields.size())
                {
                    WebElement taskField = allTaskFields.get(taskFieldIndex);
                    taskField.sendKeys(sh.getRow(i).getCell(j).getStringCellValue());
                    Thread.sleep(1500);
                    taskFieldIndex++;
                }
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Create Tasks']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("logoutLink")).click();
        Thread.sleep(1500);
        driver.quit();
    }
}
