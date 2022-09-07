package threads;

public class MultiThreading {

    int count=0;
    synchronized public void increment() {
        count++;
    }
    Thread firstThread=new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<1000;i++)
                increment();
        }
    });   Thread secondThread=new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<1000;i++)
                increment();
        }
    });  Thread thirdThread=new Thread(()->
    {
        for(int i=0;i<1000;i++){
            increment();
        }try{
        Thread.sleep(3000);
    }catch (InterruptedException e){
        e.printStackTrace();
    }
    });

    public static void main(String[] args) throws InterruptedException {
        MultiThreading multiThreading=new MultiThreading();
        multiThreading.firstThread.start();
        multiThreading.secondThread.start();
        multiThreading.thirdThread.start();
        multiThreading.firstThread.join();
        multiThreading.secondThread.join();
        multiThreading.thirdThread.join();
        System.out.println(multiThreading.count);
    }

}
