package org.amy.trainingtng;

/**
 * Created by amy on 10/30/2015.
 */
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import utility.ExcelUtils;

public class TestDDNG {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod()throws Exception{
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://store.demoqa.com/");
    }

    @Test(dataProvider = "Authentication")
    public void Registration_data(String userName, String passWord)throws Exception{
        //click the login icon
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();

        // enter user name
        driver.findElement(By.id("log")).sendKeys(userName);
        System.out.println(userName);

        // enter user password
        driver.findElement(By.id("pwd")).sendKeys(passWord);
        System.out.println(passWord);

        //wait for a couple of second
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //login the the system
        driver.findElement(By.id("login")).click();

        //wait for a couple of second
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //log out
        driver.findElement(By.xpath(".//*[@id='meta']/ul/li[2]/a")).click();

        //wait for a couple of second and see the log out page
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }

    @DataProvider
    public Object[][]Authentication()throws Exception{
        Object[][] testObjArray = ExcelUtils.getTableArray("C://traingtng//src//test//java//testData//TestData.xlsx","Sheet1");
        return (testObjArray);
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
