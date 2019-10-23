
import commons.CommonDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ActionChain {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)

    public void setUp() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        driver = CommonDriver.startDriver();
    }

    @Test
    public void testActionChain() throws IOException, InterruptedException {
        driver.get("https://h5p.org/drag-and-drop#example=68888");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.id("h5p-iframe-69782"));
        driver.switchTo().frame(driver.findElement(By.id("h5p-iframe-69782")));

        Actions builder = new Actions(driver);

        builder.dragAndDrop(driver.findElement(By.xpath("//div[8]//img[1]")), driver.findElement(By.xpath("//div[34]//div[1]")))
               .keyUp(Keys.CONTROL);

        Thread.sleep(4000);
        builder.perform();

        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f, new File("/tmp/scr.png"));

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
