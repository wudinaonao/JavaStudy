package thread.Pool;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.*;
import java.util.concurrent.*;

/**
 * @program: study
 * @description: 线程池练习
 * @author: Wen lyuzhao
 * @create: 2019-01-24 22:00
 **/
public class ThreadPool {
    public static void main1(String[] args) {
        // ExecutorService pool = Executors.newFixedThreadPool(3);
        // pool.submit(new Myrun());
        // pool.submit(new Myrun());
        // pool.submit(new Myrun());
        // pool.shutdown();

        // ThreadPoolExecutor
        // ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
        //         .setNameFormat("threadTest-pool-ID:%d").build();
        // //
        // // //Common Thread Pool
        // ExecutorService pool = new ThreadPoolExecutor(20, 200,
        //         0L, TimeUnit.MILLISECONDS,
        //         new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        //
        // // pool.submit(new Myrun());
        // // pool.submit(new Myrun());
        // pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        // pool.shutdown();//gracefully shutdown

        /// 带返回值的并发
        //  设置并发数

        int threadCount = 128;
        // ThreadPoolExecutor
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("threadTest-pool-ID:%d")
                .build();
        ExecutorService pool = new ThreadPoolExecutor(threadCount, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        List<Future<String>> list = new ArrayList<Future<String>>();
        for (int i = 0; i < threadCount; i++) {
            Callable c = new TaskQueue();
            // 执行任务并获取Future对象
            Future<String> f = pool.submit(c);
            list.add(f);
        }
        // 获取所有并发任务的运行结果
        for (Future<String> f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            // System.out.println(">>>" + f.get().toString());

            String element = null;
            try {
                element = f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(element);
        }

        pool.shutdown();
    }

    public static void main(String[] args) {
        int threadCount = 10;

        // 创建一个 ThreadFactory 对象
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("Naonao-pool-ID:%d")
                .build();
        // 使用 ThreadPoolExecutor 创建线程池
        ExecutorService pool = new ThreadPoolExecutor(
                threadCount,
                200,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(1024),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        // 创建一个列表对象储存线程返回值
        List<Future<String>> futures = new ArrayList<>();
        // 提交任务到线程池并加入列表
        for (int i = 0; i < 100; i++) {
            Future<String> submit = pool.submit(new TaskQueue());
            futures.add(submit);
            System.out.println("提交任务 --- " + i);
        }
        // 创建迭代器从列表里取结果
        Iterator<Future<String>> iterator = futures.iterator();
        String winner = null;
        while (iterator.hasNext()){
            Future<String> future = iterator.next();
            try {
                winner = future.get();
                if (winner != null){
                    System.out.println(winner);
                    pool.shutdownNow();
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("摸完鱼了.");
        // 关闭线程池
        pool.shutdown();
    }
}

class Myrun implements Runnable{
    int num = 500;

    @Override
    public void run() {
        while (num>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " = = = " + "current is " + num--);
        }
    }
}

/**
 *  模拟多线程执行业务逻辑
 *
 *  getRandomValue 模拟一个执行方法
 */
class SimulationThreadTask{

    private static Random random = new Random();

    public static String getRandomValue(){
        int sleepTime = random.nextInt(10000);
        // try {
        //     Thread.sleep(sleepTime);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // return Thread.currentThread().getName() + " --- 宝宝睡了: " + sleepTime + " ms";
        // System.out.println(Thread.currentThread().getName() + " --- 正在摸鱼中......");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {

        }
        System.out.println(Thread.currentThread().getName() + " --- 摸鱼用了 " + sleepTime + " ms");
        int value = random.nextInt(2000);
        if (value > 1900){
            return Thread.currentThread().getName() + " --- 中奖啦!";
        }
        return null;
    }
}

/**
 *  实现Callable接口
 */
class TaskQueue implements Callable<String>{
    @Override
    public String call() throws Exception {
        return SimulationThreadTask.getRandomValue();
    }
}