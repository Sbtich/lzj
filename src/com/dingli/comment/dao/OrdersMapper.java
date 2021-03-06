package com.dingli.comment.dao;

import com.dingli.comment.bean.Orders;
import com.dingli.comment.bean.OrdersDto;
import com.dingli.comment.bean.OrdersExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersMapper {
	
	List<OrdersDto> selectByPhone(String phone);
	
	List<OrdersDto> orders();
	
	List<OrdersDto> orderList(String username);
	
	int addOrders(OrdersDto oDto);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Wed Aug 15 09:21:42 GMT+08:00 2018
     */
    int countByExample(OrdersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Wed Aug 15 09:21:42 GMT+08:00 2018
     */
    int deleteByExample(OrdersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Wed Aug 15 09:21:42 GMT+08:00 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Wed Aug 15 09:21:42 GMT+08:00 2018
     */
    int insert(Orders record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Wed Aug 15 09:21:42 GMT+08:00 2018
     */
    int insertSelective(Orders record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Wed Aug 15 09:21:42 GMT+08:00 2018
     */
    List<Orders> selectByExample(OrdersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Wed Aug 15 09:21:42 GMT+08:00 2018
     */
    Orders selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Wed Aug 15 09:21:42 GMT+08:00 2018
     */
    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Wed Aug 15 09:21:42 GMT+08:00 2018
     */
    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Wed Aug 15 09:21:42 GMT+08:00 2018
     */
    int updateByPrimaryKeySelective(Orders record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Wed Aug 15 09:21:42 GMT+08:00 2018
     */
    int updateByPrimaryKey(Orders record);
}