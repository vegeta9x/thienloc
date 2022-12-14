package com.thienloc.mapper;

import com.thienloc.model.Accounts;
import com.thienloc.model.AccountsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table accounts
	 * @mbg.generated  Fri Sep 16 09:52:07 ICT 2022
	 */
	long countByExample(AccountsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table accounts
	 * @mbg.generated  Fri Sep 16 09:52:07 ICT 2022
	 */
	int deleteByExample(AccountsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table accounts
	 * @mbg.generated  Fri Sep 16 09:52:07 ICT 2022
	 */
	int deleteByPrimaryKey(String userName);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table accounts
	 * @mbg.generated  Fri Sep 16 09:52:07 ICT 2022
	 */
	int insert(Accounts row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table accounts
	 * @mbg.generated  Fri Sep 16 09:52:07 ICT 2022
	 */
	int insertSelective(Accounts row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table accounts
	 * @mbg.generated  Fri Sep 16 09:52:07 ICT 2022
	 */
	List<Accounts> selectByExample(AccountsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table accounts
	 * @mbg.generated  Fri Sep 16 09:52:07 ICT 2022
	 */
	Accounts selectByPrimaryKey(String userName);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table accounts
	 * @mbg.generated  Fri Sep 16 09:52:07 ICT 2022
	 */
	int updateByExampleSelective(@Param("row") Accounts row, @Param("example") AccountsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table accounts
	 * @mbg.generated  Fri Sep 16 09:52:07 ICT 2022
	 */
	int updateByExample(@Param("row") Accounts row, @Param("example") AccountsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table accounts
	 * @mbg.generated  Fri Sep 16 09:52:07 ICT 2022
	 */
	int updateByPrimaryKeySelective(Accounts row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table accounts
	 * @mbg.generated  Fri Sep 16 09:52:07 ICT 2022
	 */
	int updateByPrimaryKey(Accounts row);
}