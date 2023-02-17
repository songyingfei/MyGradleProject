package thread.syn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class unsafeList {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Thread A = new Thread(()->{
//                synchronized (test){
//                    System.out.println(Thread.currentThread().getName());
                    test.add(Thread.currentThread().getName());
//                }

            });
            A.start();
//            try {
//                A.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(test.size());
    }
}
