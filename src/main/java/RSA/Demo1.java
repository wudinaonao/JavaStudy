package RSA;

/**
 * @program: study
 * @description: 尝试实现RSA算法
 * @author: Wen lyuzhao
 * @create: 2019-01-22 19:10
 **/
public class Demo1 {

    private static boolean isPrime(int n){
        if (n < 2){
            return false;
        }
        if (n == 2){
            return true;
        }
        if (n % 2 == 0){
            return false;
        }
        for (int i = 3; i < n; i+=2) {
            if (n % i ==0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // System.out.println(isPrime(771507));
        long p = 771509L;
        long q = 771473L;
        long eulerN = (p-1)*(q-1);
        long e = 771623L;

        System.out.println(eulerN);
    }
}
