import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThreadClass();
        thread.setPriority(8);
        Thread thread1 = new MyThreadClass1();
        System.out.println("NEW: " + thread.getState());
        System.out.println(new Date());
        thread.start();
        thread1.start();
        thread1.join();
        System.out.println(new Date());
        //  thread1.join();
       // thread.join();
        System.out.println("RUN: " + thread.getState());
        System.out.println("thread1: " + thread1.getState());
        System.out.println("TIMED_WAITING: " + thread.getState());
        Thread.sleep(2000);
        System.out.println("TERM: " + thread.getState());
    }

    private static void threadGroup() { ThreadGroup threadGroup1 = new ThreadGroup("group 1");
        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1, "group 2");

        Thread.currentThread().setPriority(8);
        Thread thread = new MyThreadClass(threadGroup2, "My Thread Class");

        Thread thread1 = new Thread(threadGroup1, "Thread with override") {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Main Thread codes");
            }
        };

        Thread thread2 = new Thread(new MyRunnableClass());
        thread.start();
        thread1.start();
        thread2.start();
        threadGroup2.list();
        System.out.println("threadGroup2.activeCount: " + threadGroup2.activeCount());
        threadGroup1.list();
        System.out.println("threadGroup1.activeCount: " + threadGroup1.activeCount());
        System.out.println(threadGroup1.parentOf(threadGroup2));
        System.out.println(thread.getName());
        System.out.println("thread1: " + thread1.getName());
        thread.setName(" My first thread");
        System.out.println(thread.getName());
        System.out.println(" ********************");
        Thread[] threads = new Thread[threadGroup1.activeCount()];
        int size = threadGroup1.enumerate(threads);
        System.out.println("Priority: " +  threads[0].getPriority());
        threads[0].setPriority(7);
        System.out.println("main: " + Thread.currentThread().getName());
        System.out.println("main: " + Thread.currentThread().getPriority());
        for (int i = 0; i < size; i++) {
            System.out.println("Priority " + i + ": " + threads[i].getName());
            System.out.println("Priority " + i + ": " + threads[i].getPriority());
        }
        System.out.println("threadGroup1 getParent " + threadGroup1.getParent());
        System.out.println("threadGroup2 getParent " + threadGroup2.getParent());
        System.out.println("activeGroupCount " + threadGroup2.activeGroupCount());
        //Thread.sleep(10000);
        //threadGroup1.interrupt();
    }
}