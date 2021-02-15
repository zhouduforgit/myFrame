package com.dao;

import com.domain.Car;
import com.jdbc.JdbcFactory;
import com.jdbc.JdbcUtil;
import com.jdbc.RowMapper;
import com.jdbc.SqlSession;
import com.util.MysqlFactoryUtil;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/8/24.
 */
public class CarDao {

    public void save(Car car){
        String sql = "insert into t_car(cname,color,price) values(?,?,?)" ;

        try {
            //使用jdbc实现java程序与数据库交互，将sql命令传递给数据库
            //1 引入mysql驱动jar文件
            //2 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //3 创建连接池
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc05?characterEncoding=utf8&serverTimezone=UTC",
                    "root",
                    "123") ;
            //4 创建预处理对象
            PreparedStatement stmt = conn.prepareStatement(sql) ;
            stmt.setString(1,car.getCname());
            stmt.setString(2,car.getColor());
            stmt.setInt(3,car.getPrice());
            //5 执行sql
            stmt.executeUpdate() ;
            //5.5 将查询结果组成集合对象  (orm)
            //6 各种关闭
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void save2(Car car){
        String sql = "insert into t_car(cname,color,price) values(?,?,?)" ;
        //使用jdbc将sql传递给数据库
        //原来自己写jdbc
        //现在使用jdbc模板
        /*
        JdbcUpdateTemplate t = new JdbcUpdateTemplate(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/jdbc05?characterEncoding=utf8&serverTimezone=UTC",
                "root",
                "123"
        ) ;

        t.executeJdbc(sql,new Object[]{car.getCname(),car.getColor(),car.getPrice()}) ;
        */
    }

    public void save3(Car car){
        String sql = "insert into t_car(cname,color,price) values(?,?,?)" ;
        //使用jdbc将sql传递给数据库
        //原来自己写jdbc
        //现在使用jdbcUtil工具
        JdbcUtil util = new JdbcUtil(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/jdbc05?characterEncoding=utf8&serverTimezone=UTC",
                "root",
                "123"
        ) ;
        util.update(sql,car.getCname(),car.getColor(),car.getPrice());
    }

    public void save4(Car car){
        String sql = "insert into t_car(cname,color,price) values(?,?,?)" ;
        //使用jdbc将sql传递给数据库
        //原来自己写jdbc
        //现在使用jdbcUtil工具
       JdbcFactory factory = new JdbcFactory();
       JdbcUtil util = factory.getUtil() ;
       util.insert(sql,car.getCname(),car.getColor(),car.getPrice()) ;
    }

    public void save5(Car car){
        String sql = "insert into t_car(cname,color,price) values(#{cname},#{color},#{price})" ;
        //使用jdbc将sql传递给数据库
        //原来自己写jdbc
        //现在使用jdbcUtil工具
        JdbcFactory factory = new JdbcFactory();
        SqlSession session = factory.getSession() ;
        session.insert(sql,car);
    }



    public void findAll(){
        String sql = "select cno,Cname,Color,PRICE from t_car" ;

        /*
        JdbcQueryTemplate t = new JdbcQueryTemplate(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/jdbc05?characterEncoding=utf8&serverTimezone=UTC",
                "root",
                "123"
        );
        */

        JdbcUtil util = new JdbcUtil(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/jdbc05?characterEncoding=utf8&serverTimezone=UTC",
                "root",
                "123"
        );
        List<Car> cars = util.selectList(sql,Car.class) ;

        for(Car car:cars){
            System.out.println(car);
        }
    }

    public void findAll2(){
        String sql = "select cno,Cname,Color,PRICE from t_car" ;

       //JdbcFactory factory = new JdbcFactory();
       JdbcUtil util = MysqlFactoryUtil.getFactory().getUtil() ;
       List<Car> cars = util.selectList(sql,Car.class) ;

        for(Car car:cars){
            System.out.println(car);
        }
    }

    public void findAll3(){
        String sql = "select cno,Cname,Color,PRICE from t_car where cno = #{cno}" ;

        JdbcFactory factory = new JdbcFactory();
        SqlSession session = factory.getSession() ;
        List<Car> cars = session.selectList(sql,1,Car.class);

        for(Car car:cars){
            System.out.println(car);
        }
    }

    public void findCount(){
        String sql = "select count(*) from t_car" ;
        JdbcUtil util = new JdbcUtil(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/jdbc05?characterEncoding=utf8&serverTimezone=UTC",
                "root",
                "123"
        );
        List<Integer> list = util.selectList(sql,Integer.class) ;
        System.out.println(list);
    }

}

class CarMapper implements RowMapper<Car> {
    @Override
    public Car mapping(Map<String,Object> rs) throws Exception{
        Integer cno = (Integer) rs.get("cno");
        String cname = (String) rs.get("cname");
        String color = (String) rs.get("color");
        Integer price = (Integer) rs.get("price");
        return new Car(cno,cname,color,price);
    }
}
