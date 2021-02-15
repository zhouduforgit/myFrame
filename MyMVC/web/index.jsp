
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
   <%-- 请求的时候要三个信息
    .do请求---所有的servlet请求
    请求的类名是AtmController 还是  ShoppingController
    方法名
    比如  xxx.do--->xxx可以表示方法名业可以表示类名
    AtmController.do?method=login--%>
  </head>
  <body>
  <a href="AtmController.do?method=login&name=zd&pass=666">测试一，一个登录atm界面请求</a><br>
  <a href="AtmController.do?method=query&name=zdd&pass=123">测试二，登录以后查询余额请求</a><br>

  <a href="ShoppingController.do?method=kind&name=java&pass=111">测试三，查询购物系统的商品种类</a><br>
  <a href="ShoppingController.do?method=good&name=zhou&pass=567">测试四，查询每个种类的具体商品</a><br>
  </body>
</html>
