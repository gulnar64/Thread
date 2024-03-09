public class MyThreadClass1 extends Thread {

    private Printer1 printer1;
    private Printer2 printer2;

    public MyThreadClass1(Printer1 printer1, Printer2 printer2) {
        this.printer1 = printer1;
        this.printer2 = printer2;
    }

    public MyThreadClass1(ThreadGroup threadGroup2, String myThreadClass) {
        super(threadGroup2, myThreadClass);
    }

    @Override
    public void run() {
        synchronized (printer2) {
            System.out.println("thread 2 synchronized 1 ");
            synchronized (printer1) {
                System.out.println("thread 2 synchronized 2 ");
            }
        }
    }
}
