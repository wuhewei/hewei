package cn.superwei;

/**
 * @author hewei
 * @date 2019/5/7
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();
        T1 t1 = new T1("t1", lock1, lock2);
        T2 t2 = new T2("t2", lock1, lock2);
        t1.start();
        t2.start();
    }
    private static class T1 extends Thread {
        Object lock1;
        Object lock2;
        private T1(String name, Object lock1, Object lock2) {
            super(name);
            this.lock1 = lock1;
            this.lock2 = lock2;
        }
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("lock1");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("lock2");
                }
            }
            System.out.println("the T1 is starting...");
        }
    }
    private static class T2 extends Thread {
        Object lock1;
        Object lock2;
        private T2(String name, Object lock1, Object lock2) {
            super(name);
            this.lock1 = lock1;
            this.lock2 = lock2;
        }
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("lock2");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("lock1");
                }
            }
            System.out.println("the T2 is starting...");
        }
    }

}
