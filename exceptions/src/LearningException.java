package src;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LearningException {
    public static String method() {
        try {
//            System.out.println(1/0);
            return "SomeString";
        } catch(Exception ex) {
            return "Catch message";
        } finally {
//            return "Finally message";
        }
//        return "method()";
    }

    private static void checkFinally() {
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Do it!");
        }
    }

    public static String twoExceptionsMethod2() {
        try {
            throw new NullPointerException();
        }catch (NullPointerException ex) {
            System.out.println(ex.getMessage()+ " catchBlock");;
        }
        finally {
            Exception ex2 = new Exception();
            return ex2.getMessage() + "finallyBlock";
        }
    }

    public static void ioExcAndFileNotFoundEx() {
        try {
            //TODO: some code
            String x = "abc";
            if (x.equals("abc")) {
                throw new IOException();
            } else {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(1111);
        } catch (IOException e) {
            e.getMessage();
            System.out.println(22222);
        }
    }


    public static void main(String[] args) {
//        System.out.println(method());
//        System.out.println(twoExceptionsMethod2());
        ioExcAndFileNotFoundEx();
    }
}
