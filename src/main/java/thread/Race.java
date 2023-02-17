package thread;

public class Race implements Runnable{
    private String winner;
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if(Thread.currentThread().getName().equals("兔子")){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");
            if(gameOver(i)){
                break;
            }
        }
    }
    private boolean gameOver(int steps){
        if(winner!=null){
            System.out.println("胜利者是====》"+winner);
            return true;
        }
        if(steps>=100){
            winner = Thread.currentThread().getName();
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "乌龟").start();
        new Thread(race, "兔子").start();
    }
}
