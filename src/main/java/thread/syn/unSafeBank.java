package thread.syn;

import lombok.Data;

public class unSafeBank {
    public static void main(String[] args) {
        Account niuniuba = new Account("我的账户",1000);
        Drawing d = new Drawing(niuniuba,500);

        new Thread(d,"妞妞").start();
        new Thread(d,"妞妞妈").start();
        new Thread(d,"妞妞爸").start();
    }

}
@Data
class Account{
    private String name;
    private int money;

    Account(String name, int money) {
        this.name = name;
        this.money = money;
    }
}

class Drawing implements Runnable{
    Account account;
    int drawingMoney;

    public Drawing(Account account,int drawingMoney){
        this.account = account;
        this.drawingMoney = drawingMoney;

    }
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (account) {
            if (account.getMoney() >= drawingMoney) {
                account.setMoney(account.getMoney() - drawingMoney);
                System.out.println(Thread.currentThread().getName() + "取到了" + drawingMoney);
            }

            if (account.getMoney() <= 0) {
                System.out.println("钱已经取完了，快去挣钱吧！");
            }
        }
    }
}