
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CommonDriver {

    private static WebDriver driver = null;


    public static WebDriver startDriver() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
       
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void stopDriver(){
        driver.quit();
        driver = null;
    }


    }

