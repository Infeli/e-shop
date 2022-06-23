package com.engeto.lekce11;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws IOException {

        Reader reader = Resources.getResourceAsReader("MyBatisConfig.xml");
        SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(reader);

        try(SqlSession session = sqlFactory.openSession()){
            ItemMapper itemMapper = session.getMapper(ItemMapper.class);

            // Load by Item
            System.out.println("------Load by Item--------");
            System.out.println(itemMapper.loadByItemId(2));
            System.out.println();

            // Delete where stock is 0
            System.out.println("------Delete where stock is 0--------");
            itemMapper.deleteAllOutOfStockItems();
            System.out.println();

            // Load all where stock is > 0
            System.out.println("------Load all available items--------");
            for(Item listOfItems : itemMapper.loadAllAvailableItems()){
                System.out.println(listOfItems);
            }
            System.out.println();



            // Save item
            System.out.println("------Save item--------");
            //session.commit();
            System.out.println();

            // price change
            System.out.println("------Price change--------");
           // itemMapper.updatePrice(1, BigDecimal.valueOf(12.0));


        }

    }
}
