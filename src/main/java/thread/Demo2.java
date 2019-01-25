// package thread;
//
// /**
//  * @program: study
//  * @description: demo2
//  * @author: Wen lyuzhao
//  * @create: 2019-01-19 23:26.
//  *
//  *      setPrioprity 设置线程优先级
//  *      线程运行具有随机性
//  *
//  **/
// public class Demo2 {
//     public static void main(String[] args) {
//         MyThread m0 = new MyThread("关羽");
//         MyThread m1 = new MyThread("张飞");
//         m0.setPriority(Thread.MAX_PRIORITY);
//         m1.setPriority(Thread.MIN_PRIORITY);
//         m0.start();
//         m1.start();
//         // for (int i = 0; i < 200; i++) {
//         //     System.out.println("主线程 -->" + i);
//         // }
//         // System.out.println("主线程执行完毕");
//
//     }
//     private static void text(){
//         Thread t = Thread.currentThread();
//         System.out.println(t.getName());
//     }
// }
//
// class MyThread extends Thread{
//     @Override
//     public void run() {
//         for (int i = 0; i < 200; i++) {
//             System.out.println(getName() + "-->" + i);
//         }
//     }
//     public MyThread(){
//
//     }
//     public MyThread(String name){
//         super(name);
//     }
// }
