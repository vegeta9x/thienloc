package com.thienloc.mapper;

import com.thienloc.model.OrderDetails;
import com.thienloc.model.OrderDetailsExample;
import com.thienloc.model.OrderDetailsKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDetailsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_details
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	long countByExample(OrderDetailsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_details
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	int deleteByExample(OrderDetailsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_details
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	int deleteByPrimaryKey(OrderDetailsKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_details
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	int insert(OrderDetails row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_details
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	int insertSelective(OrderDetails row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_details
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	List<OrderDetails> selectByExample(OrderDetailsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_details
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	OrderDetails selectByPrimaryKey(OrderDetailsKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_details
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	int updateByExampleSelective(@Param("row") OrderDetails row, @Param("example") OrderDetailsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_details
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	int updateByExample(@Param("row") OrderDetails row, @Param("example") OrderDetailsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_details
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	int updateByPrimaryKeySelective(OrderDetails row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_details
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	int updateByPrimaryKey(OrderDetails row);
}