package thread.syn;

public class unsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();
        new Thread(station,"妞妞").start();
        new Thread(station,"妞妞妈").start();
        new Thread(station,"妞妞爸").start();

    }
}

class BuyTicket implements Runnable{
  private int ticketNum = 10;
  boolean flag = true;
    @Override
    public void run() {
        while(flag){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            buy();
        }
    }

    private synchronized void buy() {
        if(ticketNum>0){
            System.out.println(Thread.currentThread().getName()+"买到了"+ticketNum--);
        }else{
            flag = false;
        }
    }
}