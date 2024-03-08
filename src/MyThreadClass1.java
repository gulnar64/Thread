public class MyThreadClass1 extends Thread{
    public MyThreadClass1() {
    }

    public MyThreadClass1(ThreadGroup threadGroup2, String myThreadClass) {
        super(threadGroup2, myThreadClass);
    }

    @Override
    public void run() {
        System.out.println("My Thread codes");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
