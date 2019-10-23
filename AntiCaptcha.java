import TestCwiczenie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.chord;
import static org.testng.Assert.assertEquals;


public class AntiCaptcha {


    Logger log = LoggerFactory.getLogger(TestCwiczenie.class);


    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void testCwiczenie1() throws IOException, InterruptedException {
        driver.get("http://antycaptcha.amberteam.pl/");

        driver.findElement(By.xpath("//a[contains(text(),'Interact with an')]")).click();

        driver.findElement(By.id("showAlert")).click();

        Alert alert = driver.switchTo().alert();

        String alert_txt = alert.getText();

        Thread.sleep(3000);

        alert.accept();

        System.out.println(alert_txt);

        driver.findElement(By.id("alertText")).sendKeys(alert_txt);

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@id='solution']")).click();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {

        driver.quit();
    }


}
