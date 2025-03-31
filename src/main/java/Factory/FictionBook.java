package Factory;

public class FictionBook implements Book {
    @Override
    public void read() {
        System.out.println("Reading a Fiction Book");
    }
}
