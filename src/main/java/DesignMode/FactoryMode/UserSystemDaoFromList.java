package DesignMode.FactoryMode;

/**
 * @program: study
 * @description: 从集合获取用户名
 * @author: Wen lyuzhao
 * @create: 2019-01-24 18:23
 **/
public class UserSystemDaoFromList implements IUserSystem {
    @Override
    public void findUserName() {
        System.out.println("从集合查找用户名");
    }

    @Override
    public void findUserNameAndPassword() {
        System.out.println("从集合查找用户名和密码");
    }

    @Override
    public void shwoAllUser() {
        System.out.println("从集合显示全部用户名");
    }
}
