public class MyThreadClass extends Thread {
    private Printer1 printer1;
    private Printer2 printer2;

    public MyThreadClass(Printer1 printer1, Printer2 printer2) {
        this.printer1 = printer1;
        this.printer2 = printer2;
    }

    public MyThreadClass(String myThreadClass) {
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
