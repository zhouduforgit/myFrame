package service;

public class AtmService {
    //登录方法
    public String login(String name,String pass){
        if("zdd".equals(name) && "123".equals(pass)){
            return "登录成功";
        }
        return "用户名或密码错误";
    }
    //查询余额方法
    public float lookBalance(String name){
        if(name.equals("zdd")){
            return 123.3F;
        }
        return  0;
    }
}
