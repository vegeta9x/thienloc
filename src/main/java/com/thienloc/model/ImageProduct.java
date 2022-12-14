package com.thienloc.model;

import java.util.Date;

public class ImageProduct extends ImageProductKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column image_product.name
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column image_product.content_type
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	private String contentType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column image_product.size
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	private Long size;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column image_product.created_date
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	private Date createdDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column image_product.updated_date
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	private Date updatedDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column image_product.deleted_flag
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	private Integer deletedFlag;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column image_product.deleted_date
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	private Date deletedDate;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column image_product.name
	 * @return  the value of image_product.name
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column image_product.name
	 * @param name  the value for image_product.name
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column image_product.content_type
	 * @return  the value of image_product.content_type
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column image_product.content_type
	 * @param contentType  the value for image_product.content_type
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column image_product.size
	 * @return  the value of image_product.size
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column image_product.size
	 * @param size  the value for image_product.size
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public void setSize(Long size) {
		this.size = size;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column image_product.created_date
	 * @return  the value of image_product.created_date
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column image_product.created_date
	 * @param createdDate  the value for image_product.created_date
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column image_product.updated_date
	 * @return  the value of image_product.updated_date
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column image_product.updated_date
	 * @param updatedDate  the value for image_product.updated_date
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column image_product.deleted_flag
	 * @return  the value of image_product.deleted_flag
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public Integer getDeletedFlag() {
		return deletedFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column image_product.deleted_flag
	 * @param deletedFlag  the value for image_product.deleted_flag
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public void setDeletedFlag(Integer deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column image_product.deleted_date
	 * @return  the value of image_product.deleted_date
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public Date getDeletedDate() {
		return deletedDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column image_product.deleted_date
	 * @param deletedDate  the value for image_product.deleted_date
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}
}