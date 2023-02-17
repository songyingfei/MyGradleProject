package thread;

public class TestThread4 implements Runnable{
    //火车票
    private int ticket = 10;
    @Override
    public void run() {
        while(true){
            if(ticket<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticket--+"张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 testThread4 = new TestThread4();
        new Thread(testThread4,"小明").start();
        new Thread(testThread4,"张三").start();
        new Thread(testThread4,"李四").start();
    }
}
