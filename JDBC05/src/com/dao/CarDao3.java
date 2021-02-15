package com.dao;

import com.domain.Car;
import com.jdbc.annocations.Delete;
import com.jdbc.annocations.Insert;
import com.jdbc.annocations.Select;

import java.util.List;

/**
 * Created by Administrator on 2020/8/27.
 */
@SuppressWarnings("all")
public interface CarDao3 {

    @Insert("insert into t_car values(null,#{cname},#{color},#{price})")
    public int save(Car car) ;

    @Delete("delete from t_car where cno = #{cno}")
    public int delete(int cno);

    @Select("select * from t_car")
    public List<Car> findAll();

    @Select("select * from t_car where cno = #{cno}")
    public Car findById(int cno) ;

}
