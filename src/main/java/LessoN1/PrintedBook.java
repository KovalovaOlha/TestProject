package LessoN1;

public class PrintedBook implements Book {
    private String title;
    private String author;
    private int pages;
    private boolean open; // Стан книги (відкрита/закрита)

    public PrintedBook(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.open = false;
    }

    @Override
    public void displayInfo() {
        System.out.println("📖 Printed Book: " + title + " by " + author + ", " + pages + " pages.");
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public int getPageCount() {
        return pages;
    }

    @Override
    public void open() {
        open = true;
        System.out.println("📖 Opening printed book: " + title);
    }

    @Override
    public void close() {
        open = false;
        System.out.println("📕 Closing printed book: " + title);
    }

    @Override
    public boolean isDownloaded() {
        return false; // Друковану книгу не можна завантажити
    }
}

