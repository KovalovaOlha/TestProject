package LessoN1;

//модифікатор доступу + словов class + назва класу+ слово імплемент для того щоб виокристати інтерфейс + назва інтерфейсу+ фігурні дужки
public class Ebook implements Book {

    //Поля класу
    //Це поля класу, які містять:
    //title – назву книги.
    //author – автора.
    //fileSizeMB – розмір файлу у мегабайтах.
    //Чому private?
    //Тут ми використовуємо Інкапсуляція: дані закриті для змін ззовні.
    //Доступ до них можна отримати лише через методи класу (гетери/сетери).
    private String title;
    private String author;
    private double fileSizeMB;
    private boolean downloaded;

    //Як створити конструктор?
    //public – модифікатор доступу (конструктор зазвичай публічний, щоб можна було створювати об'єкти).
    //ClassName – назва конструктора має збігатися з назвою класу.
    //параметри – вхідні значення, які передаються при створенні об'єкта.
    //this.поле = параметр; – зберігаємо отримані значення у змінних класу (this вказує, що це поле саме цього об'єкта).

    public Ebook(String title, String author, double fileSizeMB) {
        this.title = title;
        this.author = author;
        this.fileSizeMB = fileSizeMB;
        this.downloaded = false; // Початково книга не завантажена
    }
    //також можуть бути випадки коли потрібно викликати інший конструктор
    public Ebook(String title, String author) {
        this(title, author, 0.0); // Викликає основний конструктор
    }
    //Якщо створюємо new Ebook("Java Basics", "John Doe"),
    //він викличе this(title, author, 0.0)
    //і передасть управління основному конструктору.

    //@Override вказує, що цей метод перевизначає метод з інтерфейсу Book.
    //System.out.println(...) виводить інформацію про книгу.
    //як стоврити метод?
    //<модифікатор_доступу> <тип_повернення> <назва_методу>(<параметри>) {Тіло методу}
    //void (якщо метод не повертає значення).
    //int, String, boolean тощо, якщо метод повертає значення певного типу.

    @Override
    public void displayInfo() {
        System.out.println("📱 Ebook: " + title + " by " + author + ", size: " + fileSizeMB + " MB.");
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
        return 0; // Для eBook можна реалізувати інший спосіб підрахунку сторінок
    }

    @Override
    public void open() {
        System.out.println("📖 Opening ebook: " + title);
    }

    @Override
    public void close() {
        System.out.println("📕 Closing ebook: " + title);
    }

    //boolean — це тип даних у Java (і в багатьох інших мовах програмування)
    //який використовується для зберігання двох можливих значень: true (істина) або false (неправда).
    @Override
    public boolean isDownloaded() {
        return downloaded;
    }

    public void download() {
        this.downloaded = true;
        System.out.println("📥 Ebook downloaded: " + title);
    }
    //Підсумок
    //✅ Клас Ebook є підтипом Book (поліморфізм через інтерфейс).
    //✅ Метод displayInfo() перевизначений для конкретної поведінки електронної книги.
    //✅ Об'єкти Ebook можна використовувати як Book, що дозволяє працювати з різними книгами через один інтерфейс.

}