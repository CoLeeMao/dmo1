package thread;

public class MyThread extends Thread {
    public MyThread(String string) {
        super(string);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(getName()+i);
        }
    }
}
