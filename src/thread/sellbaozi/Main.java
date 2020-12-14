package thread.sellbaozi;

public class Main {
    public static void main(String[] args) {
        Baozi baozi = new Baozi();
        new BaoziStore("包子铺",baozi).start();
        new Customer("顾客",baozi).start();
    }
}
