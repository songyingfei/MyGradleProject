package proxy;

public class StaticProxy {
     public static void main(String[] args) {
        You man = new You("XXX");
        WeddingCompany weddingCompany = new WeddingCompany(man);
        weddingCompany.marry();
    }
}
class You implements Marry{
    private String name;

    public  You(String targetName ){
        this.name = targetName;
    }
    @Override
    public void marry() {
        System.out.println(this.name+"要结婚啦，好开心！");
    }



}
class WeddingCompany implements Marry{
    private You target;
    public  WeddingCompany(You man ){
        this.target = man;
    }

    @Override
    public void marry() {
        System.out.println("布置婚礼现场");
        this.target.marry();
        System.out.println("收拾婚礼现场");
    }
}

interface Marry{
    public void marry();
}