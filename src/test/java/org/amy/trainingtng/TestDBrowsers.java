package org.amy.trainingtng;

/**
 * Created by amy on 11/10/2015.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import java.io.File;

public class TestDBrowsers {
    public WebDriver driver;

    @Parameters("browser")

    @BeforeClass

    //Passing Browser parameter from testNG xml
    public void beforeTest(String browser){
        //if the browser is Firefox, then do this
        if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("ie")){
            File file = new File("C:/SeleniumPR/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
            driver = new InternetExplorerDriver();
        }
    }
}
