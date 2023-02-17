package thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

public class TestThread2 extends Thread{
    private String url;
    private String name;
    public TestThread2(String url,String name ){
        this.url = url;
        this.name = name;
    }
    public TestThread2(){

    }
    @Override
    public void run(){
        WebDownLoad webDownLoad = new WebDownLoad();
        webDownLoad.downloader(url,name);
    }

    public static void main(String[] args) {
        Thread thread = new TestThread2("https://msn-img-nos.yiyouliao.com/inforec-20230206-9e633eba66ba092e9527872ac2c72412.jpg?time=1675756784&signature=E436A1AECDDDC8BAD5DBFFDB067146A0","图片1.jpg");
        Thread thread1 = new TestThread2("https://msn-img-nos.yiyouliao.com/inforec-20230206-570ee924db4423fb686c1369b4889a04.jpg?time=1675756784&signature=A77BC33CE5F034EDC11ECD84DA26CF50","图片2.jpg");
        thread.start();
        thread1.start();

    }
}



class WebDownLoad{
    public void downloader(String url,String name){
        try{
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (Exception e){
            System.out.println("下载图片出错！"+e.getMessage());
        }
    }
}
