package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.App;
import utils.ProjectData;

import java.time.Duration;


public class TestBase {

    protected WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/home/olgakovaliova/download.cache/selenium/chromedriver/linux64/123.0.6312.105/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(ProjectData.appUrl);
        App.driver = driver;
    }


    @AfterMethod(alwaysRun=true)
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
