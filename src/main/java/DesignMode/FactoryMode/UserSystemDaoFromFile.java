package DesignMode.FactoryMode;

/**
 * @program: study
 * @description: 从文件获取用户名
 * @author: Wen lyuzhao
 * @create: 2019-01-24 18:24
 **/
public class UserSystemDaoFromFile implements IUserSystem{
    @Override
    public void findUserName() {
        System.out.println("从文件查找用户名");
    }

    @Override
    public void findUserNameAndPassword() {
        System.out.println("从文件查找用户名和密码");
    }

    @Override
    public void shwoAllUser() {
        System.out.println("从文件显示全部用户名");
    }
}
