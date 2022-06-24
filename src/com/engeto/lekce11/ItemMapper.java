package com.engeto.lekce11;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

public interface ItemMapper {

    @Select("SELECT * FROM Item WHERE id = #{id}")
    Item loadByItemId(Integer id);

    @Delete("DELETE FROM Item WHERE numberInStock = 0")
    void deleteAllOutOfStockItems();

    @Select("SELECT * FROM Item WHERE numberInStock > 0")
    List<Item> loadAllAvailableItems();


    void saveItem(Item item);


    @Update("UPDATE Item "
            +"SET price = #{newPrice} "
            +"WHERE id = #{id}")
    void updatePrice(Integer id, BigDecimal newPrice);

}
