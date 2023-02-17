package thread;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.concurrent.*;

public class ThreadTestCallable implements Callable<Boolean> {

    private String url;
    private String name;
    public ThreadTestCallable(String url,String name ){
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownLoad webDownLoad = new WebDownLoad();
        webDownLoad.downloader(url,name);
        return true;
    }

    @SneakyThrows
    public static void main(String[] args) {
        ThreadTestCallable callable = new ThreadTestCallable("https://msn-img-nos.yiyouliao.com/inforec-20230206-9e633eba66ba092e9527872ac2c72412.jpg?time=1675756784&signature=E436A1AECDDDC8BAD5DBFFDB067146A0","call图片1.jpg");
        ThreadTestCallable callable2 = new ThreadTestCallable("https://msn-img-nos.yiyouliao.com/inforec-20230206-570ee924db4423fb686c1369b4889a04.jpg?time=1675756784&signature=A77BC33CE5F034EDC11ECD84DA26CF50","call图片2.jpg");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Boolean> future = executorService.submit(callable);
        Future<Boolean> future2 = executorService.submit(callable2);
        boolean a = future.get();
        boolean b = future2.get();
        System.out.println(a);
        System.out.println(b);
        executorService.shutdown();

    }
}

class WebDownLoad1{
    public void downloader(String url,String name){
        try{
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (Exception e){
            System.out.println("下载图片出错！"+e.getMessage());
        }
    }
}