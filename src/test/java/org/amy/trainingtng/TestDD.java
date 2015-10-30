package org.amy.trainingtng;

/**
 * This class is to test data driven approach
 * Created by amy on 10/29/2015.
 */
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDD {
    private static WebDriver driver;

    @DataProvider(name="Authentication")

    public static Object[][] credentials(){
        return new Object[][]{{"danielw", "esgaSM51Dtok"},{"danielw", "esgaSM51Dtok"}};
    }

    //call name
    @Test(dataProvider = "Authentication")

    public void test(String userName, String passWord){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://store.demoqa.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //click the login icon
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();

        // enter user name
        driver.findElement(By.id("log")).sendKeys(userName);

        // enter user password
        driver.findElement(By.id("pwd")).sendKeys(passWord);

        //wait for a couple of second
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //log out
        driver.findElement(By.xpath(".//*[@id='meta']/ul/li[2]/a")).click();

        //wait for a couple of second and see the log out page
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.quit();
    }

}
