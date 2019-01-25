// package thread;
//
// import sun.awt.windows.ThemeReader;
//
// /**
//  * @program: study
//  * @description: Runnable
//  * @author: Wen lyuzhao
//  * @create: 2019-01-20 17:40
//  *
//  *      Runnable used
//  *
//  *      Runnable 接口的实现类的线程通过Thread类启动
//  *      需要包实现类的对象传入Thread类的构造方法中, 然后通过Thread的start方法启动该Runnable实现类的进程
//  *
//  **/
// public class Demo3 {
//     public static void main(String[] args) {
//         MyRunnable myRunnable = new MyRunnable();
//         Thread thread0 = new Thread(myRunnable, "温吕钊");
//         Thread thread1 = new Thread(myRunnable, "白雪懿");
//         thread0.start();
//         thread1.start();
//     }
// }
//
// class MyRunnable implements Runnable{
//     @Override
//     public void run(){
//         for (int i = 0; i < 100; i++) {
//             try{
//                 Thread.sleep(500);
//             }catch (InterruptedException e){
//                 e.printStackTrace();
//             }
//             System.out.println(Thread.currentThread().getName() + "-->" + i);
//         }
//     }
// }
