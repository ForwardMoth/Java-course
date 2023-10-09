package src;

public class MyThread extends Thread{
    public void run(){
        while(true){
            System.out.println("Асинхронный привет!");
            try {
                sleep(5 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Асинхронный пока!");
            try {
                sleep(10 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
