package thread;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    @Test
    public void test1() throws InterruptedException {
        System.out.println("这里是main线程");
        MyThread xiaosong = new MyThread("小宋");
        xiaosong.start();
        Thread.sleep(3000);
        for (int i = 0; i < 20; i++) {
            System.out.println("2B" + i);
        }
    }

    @Test
    public void test2() throws InterruptedException {
        Thread song = new Thread(new MyRunnable(), "song");
        Thread ming = new Thread(new MyRunnable(), "ming");
        song.start();
        ming.start();
        Thread.sleep(3000);
        for (int i = 0; i < 100; i++) {
            System.out.println("zi" + i);
        }
    }

    @Test
    public void test3() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ssssssssssss");
            }
        }).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("zzzzzzzzzzz");

        }
    }

    @Test
    public void test4() throws InterruptedException {
        Tickets tickets = new Tickets();
        Thread c1 = new Thread(tickets, "窗口1");
        Thread c2 = new Thread(tickets, "窗口2");
        Thread c3 = new Thread(tickets, "窗口3");

        c1.start();
        c2.start();
        c3.start();

        Thread.sleep(10000);
    }

    @Test
    public void test5() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(11000);
    }


    public static Object obj = new Object();

    @Test
    public void test6() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        System.out.println(Thread.currentThread().getName()
                                + "===获取到锁对象，调用wait方法，进入waitting状态，释放锁对象");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()
                                + "=== 从waiting状 态醒来，获取到锁对象，继续执行了");
                    }
                }
            }
        },"等待线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "‐‐‐‐‐ 等待3秒钟");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + "‐‐‐‐‐ 获取到锁对 象,调用notify方法，释放锁对象");
                    obj.notify();
                }
            }
        },"唤醒线程").start();

        Thread.sleep(10000);
    }

    @Test
    public void threadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread.sleep(10000);
    }
}
