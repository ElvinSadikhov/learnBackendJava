package class_activity;


public class HelloWorld {

    private int num = 1;
    public int publicNum = 2;

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class Wrapper {
    static void doSmth() {
        HelloWorld obj = new HelloWorld();
        System.out.println(obj.publicNum);
    }

    public static void main(String[] args) {
        doSmth();
    }
}

