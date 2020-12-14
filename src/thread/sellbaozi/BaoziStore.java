package thread.sellbaozi;

public class BaoziStore extends Thread{

    private Baozi baozi;

    public BaoziStore(String name, Baozi baozi) {
        super(name);
        this.baozi = baozi;
    }

    @Override
    public void run() {
        int count=0;
        while (true){
            synchronized (baozi){
                if (baozi.isFlag()){
                    try {
                        baozi.wait();
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (count%2==0){
                    baozi.setPi("薄皮");
                    baozi.setXian("白菜香菇");
                }else {
                    baozi.setPi("厚皮");
                    baozi.setXian("五香牛肉");
                }

                System.out.println("包子店正在生产 "+baozi.toString()+"包子");

                count++;
                baozi.setFlag(true);
                System.out.println("包子生产完成");
                System.out.println();
                baozi.notify();
            }
        }
    }
}
