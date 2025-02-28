package Lesson1;

public class AudioBook extends Book {
    public double durationHours;

    public AudioBook(String title, String author, double durationHours) {
        super(title, author); // викликає конструктор батьківського класу
        this.durationHours = durationHours;
    }

    public void displayInfo() {
        System.out.println("🎧 AudioBook: " + title + " by " + author + ", " + durationHours + " hours.");
    }

    // Перевантаження методу displayInfo з параметром року
    //void (якщо метод не повертає значення).
    public void displayInfo(int year) {
        System.out.println("🎧 AudioBook: " + title + " by " + author + ", duration: " + durationHours + " hours, released in: " + year);
    }

    // Методи для зміни тривалості аудіокниги
    public void setDurationHours(double durationHours) {
        this.durationHours = durationHours;
    }

    public double getDurationHours() {
        return this.durationHours;
    }

    // Методи для зміни назви та автора
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Перевірка, чи тривалість аудіокниги перевищує ліміт
    public boolean isDurationExceeds(double limit) {
        return this.durationHours > limit;
    }
}
