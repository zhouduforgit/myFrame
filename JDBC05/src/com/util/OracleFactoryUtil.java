package com.util;

import com.jdbc.JdbcFactory;

/**
 * Created by Administrator on 2020/8/26.
 */
public class OracleFactoryUtil {

    private static JdbcFactory factory ;
    static{
        factory = new JdbcFactory("oracle.properties") ;
    }

    public static JdbcFactory getFactory(){
        return factory ;
    }

}
