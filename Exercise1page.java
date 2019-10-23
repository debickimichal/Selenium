
import TestCwiczenie;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.testng.Assert.assertEquals;

public class Exercise1page {

    Logger log = LoggerFactory.getLogger(TestCwiczenie.class);

    private WebDriver driver;

    public Exercise1page(WebDriver driver){

        this.driver = driver;
    }


    public void openPage() {
        driver.get("http://antycaptcha.amberteam.pl/exercises/exercise1?seed=8b465d93-c134-495c-a1c3-e811d575b9ca");
        String url = driver.getCurrentUrl();
        log.info(url);
        String title = driver.getTitle();
        log.info(title);
        assertEquals(title, "AntyCaptcha");
    }

    public void checkIfSolution() {

        assertEquals(getSolutionTrail(), "OK. Good answer");
    }

    public String getSolutionTrail(){
        return driver.findElement(By.xpath("//code[@class='wrap']")).getText();
    }

    public void clickCheckSolution() {

        driver.findElement(By.id("solution")).click();
    }

    public void clickButton1() {

        driver.findElement(By.id("btnButton1")).click();
    };

    public void clickButton2() {

        driver.findElement(By.id("btnButton2")).click();
    }


}
