package controller;

import service.AtmService;
import javax.servlet.http.HttpServletRequest;

public class AtmController {
    public String login(String name, String pass){
        System.out.println("请求到达登录控制层,这是atm的登录方法");
        //获取参数
        // String name=request.getParameter("name");
        //String pass=request.getParameter("pass");
        //System.out.println(name+"---===="+pass);
        //调取业务层
        AtmService service=new AtmService();
        String vv=service.login(name,pass);
        //System.out.println(vv);
        //转发
        return "welcome.jsp";
    }
    public String query(HttpServletRequest request){
        System.out.println("请求到达查询控制层，这是atm查询余额方法");
//        String name=request.getParameter("name");
//        AtmService service=new AtmService();
//        float balance=service.lookBalance(name);
//        System.out.println("余额是"+balance);
        return "welcome.jsp";
    }
}
