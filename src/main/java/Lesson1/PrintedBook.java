package Lesson1;

public class PrintedBook extends Book {
    public int pages;

    public PrintedBook(String title, String author, int pages) {
        super(title, author); // викликає конструктор батьківського класу
        this.pages = pages;
    }

    public void displayInfo() {
        System.out.println("📖 Printed Book: " + title + " by " + author + ", " + pages + " pages.");
    }

    public void displayInfo(int year) {
        System.out.println("📖 Printed Book: " + title + " by " + author + ", " + pages + " pages, published in: " + year);
    }

}
