package thread.locktest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockTest {
    public static void main(String[] args) {
        testLock a = new testLock();
        new Thread(a,"张三").start();
        new Thread(a,"李四").start();
        new Thread(a,"王五").start();
        new Thread(a,"张麻子").start();

    }

}
class testLock implements Runnable{
    Lock b = new ReentrantLock();
    int ticket = 100;
    @Override
    public void run() {

            while (true){
                try{
                    b.lock();
                if(ticket>0){
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+"拿到了第"+ticket--+"张票");
                }else{
                    return;
                }

                }catch (Exception e){

                }finally {
                    b.unlock();
                }
            }



    }
}