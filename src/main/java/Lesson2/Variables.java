package Lesson2;

public class Variables {
    static int globalVar = 100; // Статична змінна

    public String generateOutput() {
        int localVar = 50; // Локальна змінна
        double pi = 3.14; // Дробове число
        char letter = 'A'; // Символ
        boolean isTrue = true; // Логічне значення

        // Формуємо рядок із результатами
        return "Local: " + localVar + "\n" +
                "Global: " + globalVar + "\n" +
                "Pi: " + pi + "\n" +
                "Letter: " + letter + "\n" +
                "Is True: " + isTrue + "\n";
    }

    // Метод main для демонстрації
    public static void main(String[] args) {
        Variables vars = new Variables();
        System.out.print(vars.generateOutput());
    }



    //конструктор перезавантаження

    private int number;
    private String text;

    // Конструктор без параметрів
    public Variables() {
        this.number = 0;
        this.text = "Default";
    }

    // Конструктор з одним параметром
    public Variables(int number) {
        this.number = number;
        this.text = "Default";
    }
    // Конструктор з двома параметрами
    public Variables(int number, String text) {
        this.number = number;
        this.text = text;
    }
    //виклик іншого конструктора
    public class MyClass {
        private int number;
        private String text;

        // Конструктор з двома параметрами
        public MyClass(int number, String text) {
            this.number = number;
            this.text = text;
        }

        // Конструктор з одним параметром, який викликає інший конструктор
        public MyClass(int number) {
            this(number, "Default"); // Викликає конструктор з двома параметрами
        }
    }

}
