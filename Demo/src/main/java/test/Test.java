package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public static void hello() {
        System.out.println("hello");
    }
}
 class MyApplication {
    public static void main(String[] args) {
        Test test=null;
        test.hello();


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        thread.start();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("sss");
            }
        });
    }
}
