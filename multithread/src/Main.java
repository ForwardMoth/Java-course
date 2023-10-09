package src;

public class Main {
    public static void main(String[] args) {
        MyThread mythread = new MyThread();
        mythread.start();

        while(true) {
            System.out.println("Работает основная программа");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
