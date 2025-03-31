package lesson4;

public class BookStore {
    private String title;
    private String author;
    private BookGenre genre;

    public BookStore(String title, String author, BookGenre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookGenre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre.getDisplayName() +
                '}';
    }
}

