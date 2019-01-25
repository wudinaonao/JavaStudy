package thread;

import java.util.concurrent.*;

/**
 * @program: study
 * @description: Demo6
 * @author: Wen lyuzhao
 * @create: 2019-01-24 17:34
 **/
public class Demo6 {
    public static void main(String[] args) throws Exception{
        ExecutorService pool = Executors.newFixedThreadPool(3);

        MyCall myCall = new MyCall();

        Future<String> num1 = pool.submit(myCall);
        Future<String> num2 = pool.submit(myCall);
        Future<String> num3 = pool.submit(myCall);
        Future<String> num4 = pool.submit(myCall);

        System.out.println("num1 --> " + num1.get());
        System.out.println("num2 --> " + num2.get());
        System.out.println("num3 --> " + num3.get());
        System.out.println("num4 --> " + num4.get());

        pool.shutdown();

    }
}

class MyCall implements Callable<String>{

    int num = 100;
    int result = 0;

    @Override
    public String call() throws Exception {
        while (num>0){
            Thread.sleep(100);
            result += num;
            System.out.println(Thread.currentThread().getName() + " ---> 正在计算：" + num--);
        }
        return "值 --> " + String.valueOf(result);
    }
}
