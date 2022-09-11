package com.thienloc.mapper;

import com.thienloc.model.OrderDetail;
import com.thienloc.model.OrderDetailExample;
import com.thienloc.model.OrderDetailKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Tue Sep 06 08:45:18 ICT 2022
     */
    long countByExample(OrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Tue Sep 06 08:45:18 ICT 2022
     */
    int deleteByExample(OrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Tue Sep 06 08:45:18 ICT 2022
     */
    int deleteByPrimaryKey(OrderDetailKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Tue Sep 06 08:45:18 ICT 2022
     */
    int insert(OrderDetail row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Tue Sep 06 08:45:18 ICT 2022
     */
    int insertSelective(OrderDetail row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Tue Sep 06 08:45:18 ICT 2022
     */
    List<OrderDetail> selectByExample(OrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Tue Sep 06 08:45:18 ICT 2022
     */
    OrderDetail selectByPrimaryKey(OrderDetailKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Tue Sep 06 08:45:18 ICT 2022
     */
    int updateByExampleSelective(@Param("row") OrderDetail row, @Param("example") OrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Tue Sep 06 08:45:18 ICT 2022
     */
    int updateByExample(@Param("row") OrderDetail row, @Param("example") OrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Tue Sep 06 08:45:18 ICT 2022
     */
    int updateByPrimaryKeySelective(OrderDetail row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_detail
     *
     * @mbg.generated Tue Sep 06 08:45:18 ICT 2022
     */
    int updateByPrimaryKey(OrderDetail row);
}