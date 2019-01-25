package DesignMode.FactoryMode;

/**
 * @program: study
 * @description: 登陆
 * @author: Wen lyuzhao
 * @create: 2019-01-24 18:25
 **/
public class Login {
    IUserSystem userDao = new UserSystemDaoFromFile();

    private void login(){
        userDao.findUserName();
    }
    public static void main(String[] args) {
        new Login().userDao.findUserName();
    }
}
