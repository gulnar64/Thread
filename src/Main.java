import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 20, 6, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));

        for (int i = 1; i <= 5; i++)
            scheduledExecutorService.schedule(new MyThreadClass("Thread " + i), 2, TimeUnit.SECONDS);

        System.out.println("Thread running");
        scheduledExecutorService.shutdown();
        scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS);
        scheduledExecutorService.submit(new MyThreadClass("Thread " + 11));
//        Printer2 printer2 = new Printer2();
//        Printer1 printer1 = new Printer1();
//        Thread thread1 = new MyThreadClass(printer1, printer2);
//        Thread thread2 = new MyThreadClass1(printer1, printer2);
//        thread1.start();
//        thread2.start();


//        Transfer transfer = new Transfer(1000);
//        Thread thread = new Thread(() -> {
//            try {
//                transfer.withdraw(1500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        Thread thread2 = new Thread(() -> {
//            transfer.deposit(1000);
//        });

//        Runnable runnable = () -> {
//            try {
//                Thread.currentThread().setName("Runnable 1");
//                System.out.println("Runnable start");
//                for (int i = 1; i <= 5; i++)
//                    System.out.println(Thread.currentThread().getName() + ": " + i);
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        };

//        Thread thread1 = new Thread(runnable);
//        thread1.start();
//        thread.start();
//        thread2.start();


//        Thread thread = new MyThreadClass();
//        thread.setPriority(8);
//        Thread thread1 = new MyThreadClass1();
//        System.out.println("NEW: " + thread.getState());
//        System.out.println(new Date());
//        thread.start();
//        thread1.start();
//        thread1.join();
//        System.out.println(new Date());
//        //  thread1.join();
//       // thread.join();
//        System.out.println("RUN: " + thread.getState());
//        System.out.println("thread1: " + thread1.getState());
//        System.out.println("TIMED_WAITING: " + thread.getState());
//        Thread.sleep(2000);
//        System.out.println("TERM: " + thread.getState());
    }

    private static void threadGroup() {
        ThreadGroup threadGroup1 = new ThreadGroup("group 1");
        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1, "group 2");

        Thread.currentThread().setPriority(8);
        Thread thread = new MyThreadClass("My Thread Class");

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
        System.out.println("Priority: " + threads[0].getPriority());
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