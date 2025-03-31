package Factory;

public class ScienceBook implements Book {
    @Override
    public void read() {
        System.out.println("Reading a Science Book");
    }
}
