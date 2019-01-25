package DesignMode.FactoryMode;

/**
 * @program: study
 * @description: 工厂模式
 * @author: Wen lyuzhao
 * @create: 2019-01-24 18:21
 **/

public class Factory{
    public static void main(String[] args) {
        String phoneName = "小米";
        Phone p1 = FactoryPhone.product(phoneName);
        if (p1 == null){
            return;
        }
        p1.call();
        p1.sms();
        p1.internet();
    }
}