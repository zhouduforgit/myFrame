package com.test;

import com.dao.CarDao;
import com.domain.Car;

public class TestMain {
    public static void main(String[] args) {
        Car car=new Car(null,"bwm766","green",376000);
        CarDao cdao=new CarDao();
         //cdao.save3(car);
        //cdao.findAll();
        //cdao.findCount();
        //cdao.save4(car);
        cdao.findAll2();
    }
}
