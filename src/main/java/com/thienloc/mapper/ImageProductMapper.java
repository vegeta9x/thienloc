package com.thienloc.mapper;

import com.thienloc.form.ImageProductSelectForm;
import com.thienloc.model.ImageProduct;
import com.thienloc.model.ImageProductExample;
import com.thienloc.model.ImageProductKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ImageProductMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	long countByExample(ImageProductExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	int deleteByExample(ImageProductExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	int deleteByPrimaryKey(ImageProductKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	int insert(ImageProduct row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	int insertSelective(ImageProduct row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	List<ImageProduct> selectByExample(ImageProductExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	ImageProduct selectByPrimaryKey(ImageProductKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	int updateByExampleSelective(@Param("row") ImageProduct row, @Param("example") ImageProductExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	int updateByExample(@Param("row") ImageProduct row, @Param("example") ImageProductExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	int updateByPrimaryKeySelective(ImageProduct row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	int updateByPrimaryKey(ImageProduct row);

	List<ImageProductSelectForm> selectImageProductByProductId(@Param(value = "productId") Long productId);
	
	ImageProductSelectForm selectImageProductByImageId(@Param(value = "productId") Long productId, @Param(value = "imageId") Long imageId);
}