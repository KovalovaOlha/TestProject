package LessoN1;

public class AudioBook implements Book {
    private String title;
    private String author;
    private double durationHours;
    private boolean playing;

    public AudioBook(String title, String author, double durationHours) {
        this.title = title;
        this.author = author;
        this.durationHours = durationHours;
        this.playing = false;
    }

    @Override
    public void displayInfo() {
        System.out.println("🎧 AudioBook: " + title + " by " + author + ", duration: " + durationHours + " hours.");
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
        return 0; // Аудіокнига не має сторінок, можна повернути 0 або -1
    }

    @Override
    public void open() {
        playing = true;
        System.out.println("▶️ Playing audiobook: " + title);
    }

    @Override
    public void close() {
        playing = false;
        System.out.println("⏸️ Stopped audiobook: " + title);
    }

    @Override
    public boolean isDownloaded() {
        return true; // Припустимо, що аудіокнига вже доступна онлайн
    }
}


