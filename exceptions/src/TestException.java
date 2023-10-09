package src;

public class TestException  {

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            try {
                System.out.println(i);
                new MyException();
            } catch (Throwable e) {
                System.out.println("e = " + e);
                if (e.getCause() instanceof MyException) {
                    MyException ex = (MyException) e.getCause();
                    System.out.println("e instanceof " + MyException.class.getName() + ", s = " + ex.get());
                }
            }
        }
    }
}

class MyException extends RuntimeException {
    private String s;

    static {
        System.out.println("Static block");
        init();
    }

    public MyException() {
        System.out.println("Constructor");
        s = "Hello";
    }

    private static void init() {
        System.out.println("Init function");
        throw new MyException();
    }

    public String get() {
        return s;
    }
}
