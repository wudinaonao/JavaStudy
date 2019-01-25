package DesignMode.FactoryMode;

/**
 * @program: study
 * @description: 超级工厂
 * @author: Wen lyuzhao
 * @create: 2019-01-24 19:33
 **/
interface Phone{
    /**
     定义一个手机接口，说明手机要实现的功能
     */
    void call();
    void sms();
    void internet();
}

/**
 *  各个手机实现类
 */
class IPhone implements Phone{
    @Override
    public void call() {
        System.out.println("iPhone 能打电话");
    }

    @Override
    public void sms() {
        System.out.println("iPhone 能发短信");
    }

    @Override
    public void internet() {
        System.out.println("iPhone 能上网");
    }
}
class HuaweiPhone implements Phone{
    @Override
    public void call() {
        System.out.println("华为能打电话");
    }

    @Override
    public void sms() {
        System.out.println("华为能发短信");
    }

    @Override
    public void internet() {
        System.out.println("华为能上网");
    }
}
class XiaomiPhone implements Phone{
    @Override
    public void call() {
        System.out.println("小米能打电话");
    }

    @Override
    public void sms() {
        System.out.println("小米能发短信");
    }

    @Override
    public void internet() {
        System.out.println("小米能上网");
    }
}

/**
 *  抽象工厂（静态工厂不需要）
 */
public abstract class AbstractFactory {
    abstract Phone product(String phoneName);
}

/**
 *  实现一个具体的手机工厂
 */
class FactoryPhone{

    public static Phone product(String phoneName) {
        if ("苹果".equals(phoneName)){
            return new IPhone();
        }
        if ("华为".equals(phoneName)){
            return new HuaweiPhone();
        }
        if ("小米".equals(phoneName)){
            return new XiaomiPhone();
        }
        return null;
    }
}

