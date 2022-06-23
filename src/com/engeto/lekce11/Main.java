package com.engeto.lekce11;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws IOException {

        Reader reader = Resources.getResourceAsReader("MyBatisConfig.xml");
        SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(reader);


    }
}
