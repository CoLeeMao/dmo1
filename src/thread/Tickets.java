package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tickets implements Runnable {
    private int ticket = 100;

//    Object lock = new Object();
//    @Override
//    public void run() {
//        while (true){
//            synchronized (lock){
//                if (ticket>0){
//                    try {
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName()+"正在卖"+ticket--);
//                }
//            }
//        }
//    }


//    @Override
//    public void run() {
//        while (true){
//            sellTickets();
//        }
//    }
//
//    public synchronized void sellTickets() {
//        if (ticket > 0) {
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "正在卖" + ticket--);
//        }
//    }

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在卖" + ticket--);
            }
            lock.unlock();
        }
    }
}
