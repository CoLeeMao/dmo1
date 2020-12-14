package thread.sellbaozi;

public class Customer extends Thread {

    private Baozi baozi;

    public Customer(String name, Baozi baozi) {
        super(name);
        this.baozi = baozi;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (baozi) {
                if (!baozi.isFlag()) {
                    try {
                        baozi.wait();
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("顾客正在吃 " + baozi.toString() + "包子");
                System.out.println("包子吃完了");
                System.out.println();
                baozi.setFlag(false);
                baozi.notify();
            }
        }
    }
}
