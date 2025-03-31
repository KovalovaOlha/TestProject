package Lesson1;

public class Ebook extends Book {

    public double fileSizeMB;

//Підклас PrintedBook викликає конструктор super(title, author) абстрактного класу BookStore, щоб ініціалізувати поля title та author.
//Це дозволяє уникнути дублювання коду для ініціалізації спільних полів у кожному підкласі.
    public Ebook(String title, String author, double fileSizeMB) {
        //super використовується для виклику конструктора або методу батьківського класу в підкласі.
        super(title, author);
        this.fileSizeMB = fileSizeMB;
    }
    //Метод displayInfo():
    // Оскільки кожен підклас має свою власну реалізацію методу displayInfo(),перевіряємо чи правильно виводиться інформація для конкретного підкласу.
    @Override
    public void displayInfo() {
        System.out.println("📱 Ebook: " + title + " by " + author + ", size: " + fileSizeMB + " MB.");
    }

    @Override
    public void displayInfo(int year) {
        System.out.println("📱 Ebook: " + title + " by " + author + ", size: " + fileSizeMB + " MB, published in: " + year);
    }
}
