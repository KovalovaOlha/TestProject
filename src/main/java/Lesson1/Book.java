package Lesson1;
//модифікатор доступу + слово abstract + слово class + назва базового класу
public abstract class Book {
    //private: Поля та методи, позначені як private, доступні лише всередині класу.
    //Поля класу
    //Це поля класу, які містять:
    //title – назву книги.
    //author – автора.
    public String title;
    public String author;
    //Цей конструктор:
    //Ініціалізує поля title і author у абстрактному класі BookStore.
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Абстрактний метод, який буде реалізовувати кожен підклас
    public abstract void displayInfo();

    // Перевантаження методу displayInfo з додатковим параметром
    public abstract void displayInfo(int year);  // Абстрактний метод з параметром
}
