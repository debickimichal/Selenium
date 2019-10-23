import commons.CommonDriver;
import pageObject.Exercise1page;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



public class TestCwiczenie {

        Logger log = LoggerFactory.getLogger(TestCwiczenie.class);

        private WebDriver driver;

        private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod(alwaysRun = true)
        public void setUp() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
           driver = CommonDriver.startDriver();
    }


        @Test
        public void test1() throws IOException, InterruptedException {
        Exercise1page page = new Exercise1page(driver);

            page.openPage();

            
           File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           FileUtils.copyFile(f, new File("/tmp/s.png"));

            page.clickButton2();
            Thread.sleep(3000);

            page.clickButton1();
            Thread.sleep(3000);

            page.clickButton1();
            Thread.sleep(3000);

            page.clickCheckSolution();
            Thread.sleep(3000);

            page.checkIfSolution();
        }



    @AfterMethod(alwaysRun = true)
        public void tearDown()
        {
        CommonDriver.stopDriver();
        }

    }

