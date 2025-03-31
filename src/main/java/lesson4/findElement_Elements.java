package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MainBook;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class findElement_Elements extends MainBook {
    WebDriver driver;
    //конструктор implicitlyWait
    public findElement_Elements(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Додаємо очікування
    }

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M16 132h41')]")
    WebElement elements;

    public findElement_Elements elements() {
        elements.click();
        return this;
    }
    @FindBy(xpath = "//span[normalize-space()='Buttons']")
    WebElement buttons;

    public findElement_Elements button() {
        buttons.click();
        return this;
    }
    public findElement_Elements buttons1() {
        WebElement submitButton = driver.findElement(By.xpath("(//button[normalize-space()='Click Me'])[1]"));
        submitButton.click();
        return this;
    }

    public findElement_Elements buttons() {
    List<WebElement> allButtons = new ArrayList<>();
    allButtons.addAll(driver.findElements(By.xpath("(//button[normalize-space()='Right Click Me'])[1]")));
    allButtons.addAll(driver.findElements(By.xpath("(//button[normalize-space()='Click Me'])[1]")));

    for (WebElement button : allButtons) {
        System.out.println("Кнопка: " + button.getText());
    }
        return this;
    }
//explicitlyWait
    public findElement_Elements buttonClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttons));
        buttons.click();
        return this;
    }

}
