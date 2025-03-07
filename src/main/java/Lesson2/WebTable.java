package Lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MainBook;

import java.util.List;

public class WebTable extends MainBook {
    WebDriver driver;
    //конструктор
    public WebTable(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M16 132h41')]")
    WebElement elements;

    public WebTable clickElements() {
        elements.click();
        return this;
    }

    @FindBy(xpath = " //div[@class='element-list collapse show']//li[@id='item-3']")
    WebElement clickWebTable;

    public WebTable clickWebTable() {
        clickWebTable.click();
        return this;
    }

    @FindBy(xpath = " //div[contains(text(),\"First Name\")]")
    private List<WebElement> firstNames;

    @FindBy(xpath = " //div[contains(text(),'Last Name')]")
    private List<WebElement> lastNames;

    @FindBy(xpath = " //*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]")
    private List<WebElement> firstNames1;

    public boolean isTableNotEmpty() {
        return !firstNames.isEmpty();
    }



    //For
    //Ініціалізація змінної i: Цикл for починається з ініціалізації змінної i = 0, що є стандартним підходом для індексації елементів у списках, оскільки індексація в Java починається з нуля.
    //Умова продовження циклу: Умовою продовження циклу є перевірка i < firstNames.size(). Це означає, що цикл буде виконуватись, поки i не досягне кількості елементів у списку firstNames. Це дозволяє циклу пройти через всі елементи в списку.
    //Ітерація: Після кожної ітерації значення i збільшується на 1 (i++). Таким чином, цикл проходить через кожен індекс елемента.
    //Виконання коду: Для кожного елемента списку firstNames і lastNames виконується команда System.out.println, яка виводить значення імені та прізвища на кожному кроці циклу.
    public void printTableData() {
        for (int i = 0; i < firstNames.size(); i++) {
            System.out.println("Row " + (i + 1) + ": " +
                    firstNames.get(i).getText() + " " +
                    lastNames.get(i).getText());
        }
    }

//while
    //Ініціалізація змінної i: Як і в циклі for, ініціалізуємо змінну i = 0, оскільки індексація елементів списку починається з нуля.
//Умова продовження циклу: Умова i < firstNames.size() аналогічна умові у циклі for і забезпечує, що цикл буде виконуватись до тих пір, поки i не перевищить кількість елементів у списку.
//Ітерація: Після виконання блоку коду в середині циклу значення i збільшується на 1 (i++), що є необхідним для того, щоб пройти через всі елементи списку.
//Виконання коду: Так само, як і в циклі for,  виводимо дані за допомогою System.out.println.
    public void printTableData2() {
        int i = 0;
        while (i < firstNames.size()) {
            System.out.println("Row " + (i + 1) + ": " +
                    firstNames.get(i).getText() + " " +
                    lastNames.get(i).getText());
            i++;
        }
    }
    //do while
    //Ініціалізація змінної i: Як і в інших циклах, змінна i ініціалізується значенням 0.
    //Умова продовження циклу: Важливе відміну циклу do-while від звичайного while — умова перевіряється після виконання блоку коду. Тобто, цей цикл гарантовано виконається хоча б один раз, навіть якщо умова на початку не виконується. Цей цикл корисний, коли потрібно спочатку виконати дію, а вже потім перевірити умову для подальшого виконання.
    //Ітерація: Після виконання блоку коду значення i збільшується на 1 (i++).
    //Виконання коду: Як і в попередніх циклах,  виводимо значення імен та прізвищ.

    public void printTableData3() {
        int i = 0;
        do {
            System.out.println("Row " + (i + 1) + ": " +
                    firstNames.get(i).getText() + " " +
                    lastNames.get(i).getText());
            i++;
        } while (i < firstNames.size());
    }
    // Вкладений цикл для перевірки або обробки кількох даних
    //Вкладений цикл: У цьому випадку  маємо два цикли: зовнішній цикл перебирає елементи списку firstNames, а внутрішній цикл перебирає елементи списку lastNames. Таким чином, кожен елемент з firstNames комбінується з усіма елементами з lastNames, і для кожної пари виводиться результат.
    //Необхідність такого циклу: Вкладений цикл використовується, коли треба виконати операції для кожної комбінації елементів з двох різних списків. Це може бути корисно, наприклад, для генерації комбінацій або для обробки елементів з двох таблиць або списків одночасно.
    public void printTableData4() {
        for (int i = 0; i < firstNames.size(); i++) {
            for (int j = 0; j < lastNames.size(); j++) {
                System.out.println("Row " + (i + 1) + ": " +
                        firstNames.get(i).getText() + " " +
                        lastNames.get(j).getText());
            }
        }
    }
    // Використовуємо отримання даних у таблиці
    //Цикл for-each: Цикл for-each проходить через кожен елемент у колекції (у нашому випадку, через список firstNames1). Отримуємо кожен елемент списку по черзі та працюємо з ним.
    //Використання індексу: Оскільки  використовуємо цикл for-each, щоб отримати відповідний елемент із списку lastNames1,  використовуємо змінну i для індексації елемента в списку lastNames1.
    //Призначення циклу: Цей цикл дозволяє працювати з елементами списку без явного використання індексу, що робить код більш компактним і зручним для читання, але зберігає можливість доступу до елементів через індекс за допомогою змінної i.
    public void printTableData5() {
        int i = 1;
        for (WebElement firstName : firstNames1) {
            WebElement lastName = firstNames1.get(i - 1);
            System.out.println("Row " + i + ": " +
                    firstName.getText() + " " + lastName.getText());
            i++;
        }
    }


}