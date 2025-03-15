package utils;

import Lesson2.WebTable;
import Lesson3.Collections;
import org.openqa.selenium.WebDriver;

public class App {

    public static WebDriver driver;
    public static WebTable WebTable (){
        return new WebTable(driver);
    }
    public static Collections Collections (){
        return new Collections(driver);
    }

}
