package Lesson3;

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
    private static volatile TestBase instance;
    protected WebDriver driver;

    // Приватний конструктор для Singleton
    private TestBase() {
        // Запобігає створенню екземплярів через рефлексію
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    // Метод для отримання єдиного екземпляру
    public static TestBase getInstance() {
        if (instance == null) {
            synchronized (TestBase.class) {
                if (instance == null) {
                    instance = new TestBase();
                }
            }
        }
        return instance;
    }

    // Метод для тестування - дозволяє скинути instance
    public static void resetInstance() {
        instance = null;
    }

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
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
            driver = null; // Додано для очищення стану
        }
    }

    // Додатковий getter для driver (за потреби)
    public WebDriver getDriver() {
        return driver;
    }
}
