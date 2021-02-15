package com.dao;

import com.domain.Car;
import com.util.MysqlFactoryUtil;

import java.util.List;

/**
 * Created by Administrator on 2020/8/27.
 */
public class CarDao2 {

    public int save(Car car){
        String sql = "insert into t_car values(null,#{cname},#{color},#{price})";
        SqlSession session = MysqlFactoryUtil.getFactory().getSession() ;
        int count = session.insert(sql,car);
        return count ;
    }

    public int delete(int cno){
        String sql = "delete from t_car where cno = #{cno} " ;
        SqlSession session = MysqlFactoryUtil.getFactory().getSession() ;
        int count = session.delete(sql,cno) ;
        return count ;
    }

    public List<Car> findAll(String cname){
        String sql = "select * from t_car where cname = #{cname}" ;
        SqlSession session = MysqlFactoryUtil.getFactory().getSession() ;
        List<Car> cars = session.selectList(sql,cname,Car.class) ;
        return cars ;
    }

}
