package thread;

public class TestDaemonThread {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread godThread = new Thread(god);
        godThread.setDaemon(true);
        godThread.start();
        new Thread(you).start();

    }
}

class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("God 守护着你");
        }
    }
}
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你开心的活着"+i);
        }
        System.out.println("==============goodbye!world!======");
    }
}
