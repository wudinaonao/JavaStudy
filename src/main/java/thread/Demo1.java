// package thread;
//
// /**
//  * @program: study
//  * @description: demo1
//  * @author: Wen lyuzhao
//  * @create: 2019-01-19 23:16
//  *
//  *      Thread 线程的初步使用
//  *
//  **/
// public class Demo1 {
//     public static void main(String[] args) {
//         MyThread m1 = new MyThread();
//         MyThread m2 = new MyThread();
//         m1.start();
//         m2.start();
//     }
// }
//
// class MyThread extends Thread{
//     @Override
//     public void run(){
//         for (int i = 0; i < 1000; i++) {
//             System.out.println(i);
//         }
//     }
// }