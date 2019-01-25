package thread;

/**
 * @program: study
 * @description: 线程同步
 * @author: Wen lyuzhao
 * @create: 2019-01-20 19:41
 *
 *      同步：
 *              多个线程同一时间只能有一个执行
 *
 *      异步：
 *              多个线程同一时间一起执行
 *
 *      同步方法：
 *              1.  synchronized (锁对象) {
 *                      被同步的代码
 *                  }
 *                  锁对象必须保证，如果多个线程想要同步，必须保证多个线程使用同一个锁对象
 *                  Runnable 接口实现的类中this可以充当锁对象
 *                  Thread子类this无法充当锁对象
 *
 *              2.
 *              3. Lock 锁
 **/
public class Demo4 {
    public static void main(String[] args) {
        // SellTicketsThread sellTicketsThread1 = new SellTicketsThread("窗口1");
        // SellTicketsThread sellTicketsThread2 = new SellTicketsThread("窗口2");
        // SellTicketsThread sellTicketsThread3 = new SellTicketsThread("窗口3");
        // sellTicketsThread1.start();
        // sellTicketsThread2.start();
        // sellTicketsThread3.start();
        SellTicketsThread sellTicketsThread = new SellTicketsThread();
        Thread t1 = new Thread(sellTicketsThread, "窗口1");
        Thread t2 = new Thread(sellTicketsThread, "窗口2");
        Thread t3 = new Thread(sellTicketsThread, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

// class SellTicketsThread extends Thread{
//     public static int ticket = 100;
//     private SellTicketsThread(){
//
//     }
//     public SellTicketsThread(String name){
//         super(name);
//     }
//     @Override
//     public void run(){
//         while (true){
//             try{
//                 Thread.sleep(500);
//             }catch (InterruptedException e){
//                 e.printStackTrace();
//             }
//
//             if (ticket>0){
//                 System.out.println(getName() + " ---> 正在售卖：" + (ticket--) + " 张票");
//             }else{
//                 System.out.println(getName() + " ---> 已经停止售票。");
//                 break;
//             }
//         }
//     }
// }

class SellTicketsThread implements Runnable{

    private static Integer ticket = 10;

    @Override
    synchronized public void run(){
        while (true){
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            // synchronized 关键字给一个对象加锁
            // synchronized (ticket){
            //     if (ticket>0){
            //         System.out.println(Thread.currentThread().getName() + " ---> 正在售卖：" + (ticket--) + " 张票");
            //     }else{
            //         System.out.println(Thread.currentThread().getName() + " ---> 已经停止售票。");
            //         break;
            //     }
            // }
            if (ticket>0){
                System.out.println(Thread.currentThread().getName() + " ---> 正在售卖：" + (ticket--) + " 张票");
            }else{
                System.out.println(Thread.currentThread().getName() + " ---> 已经停止售票。");
                break;
            }
        }
    }
}
