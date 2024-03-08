public class MyThreadClass extends Thread{
    public MyThreadClass() {
    }

    public MyThreadClass(ThreadGroup threadGroup2, String myThreadClass) {
        super(threadGroup2, myThreadClass);
    }

    @Override
    public void run() {
        System.out.println("My Thread codes");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
