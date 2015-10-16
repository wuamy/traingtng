package org.amy.trainingtng;

/**
 * For trainging of Testng
 * 10/16/2015
 */
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNG {
    public WebDriver driver;

    @Test
    public void main(){
        //click the login icon
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();

        // enter user name
        driver.findElement(By.id("log")).sendKeys("");

        // enter user password
        driver.findElement(By.id("pwd")).sendKeys("");

        //wait for a couple of second
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //log out
        driver.findElement(By.xpath(".//*[@id='meta']/ul/li[2]/a")).click();

        //wait for a couple of second and see the log out page
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }

    @BeforeMethod

    public void beforeMethod(){
        //create a new instance of of the firefox driver
        driver = new FirefoxDriver();

        //wait for 10 sec
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //launch the website
        driver.get("http://store.demoqa.com/");
    }

    @AfterMethod
    public void afterMethod(){
        //close the driver
        driver.quit();
    }


}
