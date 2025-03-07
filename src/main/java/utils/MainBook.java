package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class MainBook {
    public WebDriver driver;

    public MainBook(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickViaJSExecutor(WebElement el) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(el));
        executor.executeScript("arguments[0].scrollIntoView(true);", el);
        wait.until(ExpectedConditions.elementToBeClickable(el));
        executor.executeScript("arguments[0].click();", el);
    }

    public void scroll (WebElement el) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", el);
    }

    public void waitUntilElementClickable(WebElement el){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }
    public void waitAndClick(By el){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
    }

//    public Page Field(Field field) {
//        Field.click();
//        waitAndClick(By.xpath("//li[contains(@class,'item')]/span[text()='" + category.getTagName() + "']"));
//        return this;
//    }

//    public Page PageTest() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        test.click();
//        return this;
//    }


    public boolean isValidDate(String dateText) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        try {
            dateFormat.parse(dateText);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    //
//    public pageClass  clickaddButton() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Button123));
//        // Скролимо до елемента
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        // Використовуємо Actions для натискання
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).click().perform();
//        return this;
//    }

//    public List<String> getTestElements() {
//        return TestElements.stream()
//                .map(element -> element.getAttribute("href"))
//                .collect(Collectors.toList());
//    }

}
