package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExService {
    int count = 0;

//    public static void increment (){
//        count++;
//    }

    static Object syn=new Object();

    public static void main(String[] args) throws InterruptedException {
        ExService exService = new ExService();
        ExecutorService ex = Executors.newFixedThreadPool(4);
        ex.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (syn) {

                    exService.count++;
                }
            }
        });
        ex.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    synchronized (syn) {

                        exService.count++;
                    }
                }
            }
        });
        ex.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (syn) {

                    exService.count++;
                }
            }
        });
        ex.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (syn) {

                    exService.count++;
                }
            }
        });
        ex.submit(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    synchronized (syn){
                        exService.count++;
                    }
                }
            }
        });
        ex.shutdown();
        System.out.println(exService.count);
    }
}

