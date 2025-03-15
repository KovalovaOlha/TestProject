package Lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.MainBook;

import java.util.*;

public class Collections extends MainBook {
    WebDriver driver;
    //конструктор
    public Collections(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M16 132h41')]")
    WebElement elements;

    public Collections elements() {
        elements.click();
        return this;
    }

    //List //ArrayList
    // Метод для кліку по всіх елементах
    public Collections clickCheckBox1() {
        List<WebElement> buttons = new ArrayList<>();

        // Додавання елементів до List за допомогою пошуку по XPath
        buttons.add(driver.findElement(By.xpath("//*[@id=\"item-0\"]")));
        buttons.add(driver.findElement(By.xpath("//*[@id=\"item-1\"]")));
        buttons.add(driver.findElement(By.xpath("//*[@id=\"item-2\"]")));

        // Перебір всіх кнопок і клік по кожній
        for (WebElement button : buttons) {
            button.click();
        }
        if (buttons.size() > 0) {
            System.out.println("Кількість кнопок: " + buttons.size()); // Виводить кількість кнопок у списку
        } else {
            System.out.println("Немає кнопок для натискання.");
        }

        return this; // Повертає об'єкт
    }

    @FindBy(xpath = "//h5[normalize-space()='Widgets']")
    WebElement Widgets;

    public Collections clickWidgets() {
        Widgets.click();
        return this;
    }

    @FindBy(xpath = "//span[normalize-space()='Select Menu']")
    WebElement SelectMenu;

    public Collections SelectMenu() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickViaJSExecutor(SelectMenu);
        return this;
    }

    @FindBy(xpath = "//*[@id=\"oldSelectMenu\"]\n")
    WebElement oldSelectMenu;

    public Collections oldSelectMenu() {
        oldSelectMenu.click();
        return this;
    }

    // Новий метод для роботи з LinkedList і випадаючим меню
    public Collections workWithOldSelectMenu() {
        // Створюємо LinkedList для зберігання опцій
        LinkedList<String> expectedOptions = new LinkedList<>();
        //add() – це стандартний метод інтерфейсу Set у Java.
        expectedOptions.add("Red");
        expectedOptions.add("Blue");
        expectedOptions.add("Green");
        expectedOptions.add("Yellow");
        expectedOptions.add("Purple");
        expectedOptions.add("Black");
        expectedOptions.add("White");
        expectedOptions.add("Voilet");
        expectedOptions.add("Indigo");
        expectedOptions.add("Magenta");
        expectedOptions.add("Aqua");

        // Використовуємо Selenium Select для роботи з <select>
        Select select = new Select(oldSelectMenu);

        // Отримуємо всі опції з випадаючого меню
        List<WebElement> actualOptionsElements = select.getOptions();
        LinkedList<String> actualOptions = new LinkedList<>();
        for (WebElement option : actualOptionsElements) {
            actualOptions.add(option.getText());
        }

        // Перевіряємо, чи збігаються очікувані опції з фактичними
        System.out.println("Очікувані опції: " + expectedOptions);
        System.out.println("Фактичні опції: " + actualOptions);

        if (expectedOptions.equals(actualOptions)) {
            System.out.println("Список опцій збігається!");
        } else {
            System.out.println("Список опцій НЕ збігається!");
        }

        // Приклад: вибір певного значення ("Blue")
        select.selectByVisibleText("Blue");
        System.out.println("Вибрано значення: " + select.getFirstSelectedOption().getText());

        return this;
    }


    // Метод для роботи з Set і випадаючим меню
    public Collections workWithOldSelectMenu2() {
        // Створюємо Set для зберігання очікуваних опцій (без дублів)
        //Створює множину (Set<String>) очікуваних значень випадаючого списку
        Set<String> expectedOptions = new HashSet<>();
        expectedOptions.add("Red");
        expectedOptions.add("Blue");
        expectedOptions.add("Green");
        expectedOptions.add("Yellow");
        expectedOptions.add("Purple");
        expectedOptions.add("Black");
        expectedOptions.add("White");
        expectedOptions.add("Voilet");
        expectedOptions.add("Indigo");
        expectedOptions.add("Magenta");
        expectedOptions.add("Aqua");

        // Використовуємо Selenium Select для роботи з <select>
        Select select = new Select(oldSelectMenu);
        //Select — це клас Selenium, який працює з елементами <select>.
        //select.getOptions() отримує всі опції випадаючого списку.
        //Кожен елемент WebElement перетворюється на String (getText()) і додається в множину actualOptions.
        // Отримуємо всі опції з випадаючого меню
        List<WebElement> actualOptionsElements = select.getOptions();
        Set<String> actualOptions = new HashSet<>();
        for (WebElement option : actualOptionsElements) {
            actualOptions.add(option.getText()); // Додаємо текст опції в Set
        }

        // Перевіряємо, чи збігаються очікувані опції з фактичними
        System.out.println("Очікувані опції: " + expectedOptions);
        System.out.println("Фактичні опції: " + actualOptions);

        if (expectedOptions.equals(actualOptions)) {
            System.out.println("Список опцій збігається!");
        } else {
            System.out.println("Список опцій НЕ збігається!");
        }

        // Приклад: вибір певного значення ("Green")
        //selectByVisibleText("Green") вибирає значення "Green" у списку.
        //getFirstSelectedOption().getText() перевіряє, що було вибрано правильне значення.
        select.selectByVisibleText("Green");
        System.out.println("Вибрано значення: " + select.getFirstSelectedOption().getText());

        return this;
    }

    public Collections workWithOldSelectMenu3() {
        Map<String, Integer> expectedOptions = new HashMap<>();
        //Тут зберігаються очікувані варіанти випадаючого списку разом з їхніми індексами.
        //put — це стандартний метод інтерфейсу Map у Java.
        expectedOptions.put("Red", 0);
        expectedOptions.put("Blue", 1);
        expectedOptions.put("Green", 2);
        expectedOptions.put("Yellow", 3);
        expectedOptions.put("Purple", 4);
        expectedOptions.put("Black", 5);
        expectedOptions.put("White", 6);
        expectedOptions.put("Voilet", 7);
        expectedOptions.put("Indigo", 8);
        expectedOptions.put("Magenta", 9);
        expectedOptions.put("Aqua", 10);
        Select select = new Select(oldSelectMenu);

        // Отримуємо всі опції з випадаючого меню
        List<WebElement> actualOptionsElements = select.getOptions();
//Select — це клас Selenium для роботи з елементами <select>.
//Викликається getOptions(), щоб отримати всі можливі опції списку.
        // Створюємо Map
        Map<String, Integer> actualOptions = new HashMap<>();
        for (int i = 0; i < actualOptionsElements.size(); i++) {
            String optionText = actualOptionsElements.get(i).getText();
            actualOptions.put(optionText, i);  // додаємо опцію як ключ і її індекс як значення
        }

        // Перевіряємо, чи всі очікувані опції є
        //Код проходить по кожному елементу actualOptionsElements, отримує текст опції (optionText) і додає її у actualOptions з відповідним індексом.
        boolean isMatch = true;
        for (Map.Entry<String, Integer> entry : expectedOptions.entrySet()) {
            if (!actualOptions.containsKey(entry.getKey())) {
                System.out.println("Опція " + entry.getKey() + " не знайдена!");
                isMatch = false;
            } else if (!actualOptions.get(entry.getKey()).equals(entry.getValue())) {
                System.out.println("Опція " + entry.getKey() + " має невірний індекс! Очікувано: "
                        + entry.getValue() + ", але отримано: " + actualOptions.get(entry.getKey()));
                isMatch = false;
            }
        }
        //Перебирає expectedOptions і перевіряє, чи всі очікувані значення є в actualOptions.
        //Якщо якихось опцій не вистачає — виводить повідомлення та встановлює isMatch = false.
        if (isMatch) {
            System.out.println("Список опцій збігається!");
        } else {
            System.out.println("Список опцій НЕ збігається!");
        }

        // Приклад: вибір певного значення ("Blue")
        select.selectByVisibleText("Blue");
        System.out.println("Вибрано значення: " + select.getFirstSelectedOption().getText());


        return this;
    }

    //Як видалити елемент із List під час ітерації?
    public static void removeElement(List<String> list, String elementToRemove) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(elementToRemove)) {
                iterator.remove(); // Безпечне видалення
            }
        } }
    //Як перетворити List у Set?
    //Set<String> set = new HashSet<>(list);

    //Set методи
    //add(E e) – додає елемент до множини (якщо його ще немає).
    //remove(Object o) – видаляє елемент o, якщо він є.
    //clear() – очищає множину, видаляючи всі елементи.
    //contains(Object o) – перевіряє, чи є елемент у множині.
    //isEmpty() – перевіряє, чи множина порожня.
    //toArray() – повертає масив, що містить всі елементи множини.
    //toArray(T[] a) – повертає масив зазначеного типу.

//Map методи
    //Додавання та оновлення значень
    //put(K key, V value) → Додає новий ключ або оновлює значення для наявного.
    //putAll(Map<? extends K, ? extends V> map) → Додає всі пари ключ → значення з іншої мапи.
    //putIfAbsent(K key, V value) → Додає пару, тільки якщо ключа ще немає.

    //get(K key) → Повертає значення за ключем або null, якщо такого немає.
    //getOrDefault(K key, V defaultValue) → Повертає значення, якщо ключ існує, інакше повертає defaultValue.
    //remove(K key) → Видаляє пару за ключем.
    //remove(K key, V value) → Видаляє тільки якщо значення відповідає переданому.
    //clear() → Видаляє всі елементи.

    //size() → Повертає кількість пар ключ → значення.
    //isEmpty() → Перевіряє, чи мапа порожня.
}
