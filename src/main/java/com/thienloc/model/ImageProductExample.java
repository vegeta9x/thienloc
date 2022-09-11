package com.thienloc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageProductExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public ImageProductExample() {
		oredCriteria = new ArrayList<>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andProductIdIsNull() {
			addCriterion("product_id is null");
			return (Criteria) this;
		}

		public Criteria andProductIdIsNotNull() {
			addCriterion("product_id is not null");
			return (Criteria) this;
		}

		public Criteria andProductIdEqualTo(Long value) {
			addCriterion("product_id =", value, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdNotEqualTo(Long value) {
			addCriterion("product_id <>", value, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdGreaterThan(Long value) {
			addCriterion("product_id >", value, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
			addCriterion("product_id >=", value, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdLessThan(Long value) {
			addCriterion("product_id <", value, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdLessThanOrEqualTo(Long value) {
			addCriterion("product_id <=", value, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdIn(List<Long> values) {
			addCriterion("product_id in", values, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdNotIn(List<Long> values) {
			addCriterion("product_id not in", values, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdBetween(Long value1, Long value2) {
			addCriterion("product_id between", value1, value2, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdNotBetween(Long value1, Long value2) {
			addCriterion("product_id not between", value1, value2, "productId");
			return (Criteria) this;
		}

		public Criteria andImageIdIsNull() {
			addCriterion("image_id is null");
			return (Criteria) this;
		}

		public Criteria andImageIdIsNotNull() {
			addCriterion("image_id is not null");
			return (Criteria) this;
		}

		public Criteria andImageIdEqualTo(Long value) {
			addCriterion("image_id =", value, "imageId");
			return (Criteria) this;
		}

		public Criteria andImageIdNotEqualTo(Long value) {
			addCriterion("image_id <>", value, "imageId");
			return (Criteria) this;
		}

		public Criteria andImageIdGreaterThan(Long value) {
			addCriterion("image_id >", value, "imageId");
			return (Criteria) this;
		}

		public Criteria andImageIdGreaterThanOrEqualTo(Long value) {
			addCriterion("image_id >=", value, "imageId");
			return (Criteria) this;
		}

		public Criteria andImageIdLessThan(Long value) {
			addCriterion("image_id <", value, "imageId");
			return (Criteria) this;
		}

		public Criteria andImageIdLessThanOrEqualTo(Long value) {
			addCriterion("image_id <=", value, "imageId");
			return (Criteria) this;
		}

		public Criteria andImageIdIn(List<Long> values) {
			addCriterion("image_id in", values, "imageId");
			return (Criteria) this;
		}

		public Criteria andImageIdNotIn(List<Long> values) {
			addCriterion("image_id not in", values, "imageId");
			return (Criteria) this;
		}

		public Criteria andImageIdBetween(Long value1, Long value2) {
			addCriterion("image_id between", value1, value2, "imageId");
			return (Criteria) this;
		}

		public Criteria andImageIdNotBetween(Long value1, Long value2) {
			addCriterion("image_id not between", value1, value2, "imageId");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andContentTypeIsNull() {
			addCriterion("content_type is null");
			return (Criteria) this;
		}

		public Criteria andContentTypeIsNotNull() {
			addCriterion("content_type is not null");
			return (Criteria) this;
		}

		public Criteria andContentTypeEqualTo(String value) {
			addCriterion("content_type =", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeNotEqualTo(String value) {
			addCriterion("content_type <>", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeGreaterThan(String value) {
			addCriterion("content_type >", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeGreaterThanOrEqualTo(String value) {
			addCriterion("content_type >=", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeLessThan(String value) {
			addCriterion("content_type <", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeLessThanOrEqualTo(String value) {
			addCriterion("content_type <=", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeLike(String value) {
			addCriterion("content_type like", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeNotLike(String value) {
			addCriterion("content_type not like", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeIn(List<String> values) {
			addCriterion("content_type in", values, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeNotIn(List<String> values) {
			addCriterion("content_type not in", values, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeBetween(String value1, String value2) {
			addCriterion("content_type between", value1, value2, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeNotBetween(String value1, String value2) {
			addCriterion("content_type not between", value1, value2, "contentType");
			return (Criteria) this;
		}

		public Criteria andSizeIsNull() {
			addCriterion("size is null");
			return (Criteria) this;
		}

		public Criteria andSizeIsNotNull() {
			addCriterion("size is not null");
			return (Criteria) this;
		}

		public Criteria andSizeEqualTo(Long value) {
			addCriterion("size =", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeNotEqualTo(Long value) {
			addCriterion("size <>", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeGreaterThan(Long value) {
			addCriterion("size >", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeGreaterThanOrEqualTo(Long value) {
			addCriterion("size >=", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeLessThan(Long value) {
			addCriterion("size <", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeLessThanOrEqualTo(Long value) {
			addCriterion("size <=", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeIn(List<Long> values) {
			addCriterion("size in", values, "size");
			return (Criteria) this;
		}

		public Criteria andSizeNotIn(List<Long> values) {
			addCriterion("size not in", values, "size");
			return (Criteria) this;
		}

		public Criteria andSizeBetween(Long value1, Long value2) {
			addCriterion("size between", value1, value2, "size");
			return (Criteria) this;
		}

		public Criteria andSizeNotBetween(Long value1, Long value2) {
			addCriterion("size not between", value1, value2, "size");
			return (Criteria) this;
		}

		public Criteria andCreatedDateIsNull() {
			addCriterion("created_date is null");
			return (Criteria) this;
		}

		public Criteria andCreatedDateIsNotNull() {
			addCriterion("created_date is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedDateEqualTo(Date value) {
			addCriterion("created_date =", value, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateNotEqualTo(Date value) {
			addCriterion("created_date <>", value, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateGreaterThan(Date value) {
			addCriterion("created_date >", value, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateGreaterThanOrEqualTo(Date value) {
			addCriterion("created_date >=", value, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateLessThan(Date value) {
			addCriterion("created_date <", value, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateLessThanOrEqualTo(Date value) {
			addCriterion("created_date <=", value, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateIn(List<Date> values) {
			addCriterion("created_date in", values, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateNotIn(List<Date> values) {
			addCriterion("created_date not in", values, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateBetween(Date value1, Date value2) {
			addCriterion("created_date between", value1, value2, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateNotBetween(Date value1, Date value2) {
			addCriterion("created_date not between", value1, value2, "createdDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateIsNull() {
			addCriterion("updated_date is null");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateIsNotNull() {
			addCriterion("updated_date is not null");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateEqualTo(Date value) {
			addCriterion("updated_date =", value, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateNotEqualTo(Date value) {
			addCriterion("updated_date <>", value, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateGreaterThan(Date value) {
			addCriterion("updated_date >", value, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateGreaterThanOrEqualTo(Date value) {
			addCriterion("updated_date >=", value, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateLessThan(Date value) {
			addCriterion("updated_date <", value, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateLessThanOrEqualTo(Date value) {
			addCriterion("updated_date <=", value, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateIn(List<Date> values) {
			addCriterion("updated_date in", values, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateNotIn(List<Date> values) {
			addCriterion("updated_date not in", values, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateBetween(Date value1, Date value2) {
			addCriterion("updated_date between", value1, value2, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateNotBetween(Date value1, Date value2) {
			addCriterion("updated_date not between", value1, value2, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andDeletedFlagIsNull() {
			addCriterion("deleted_flag is null");
			return (Criteria) this;
		}

		public Criteria andDeletedFlagIsNotNull() {
			addCriterion("deleted_flag is not null");
			return (Criteria) this;
		}

		public Criteria andDeletedFlagEqualTo(Integer value) {
			addCriterion("deleted_flag =", value, "deletedFlag");
			return (Criteria) this;
		}

		public Criteria andDeletedFlagNotEqualTo(Integer value) {
			addCriterion("deleted_flag <>", value, "deletedFlag");
			return (Criteria) this;
		}

		public Criteria andDeletedFlagGreaterThan(Integer value) {
			addCriterion("deleted_flag >", value, "deletedFlag");
			return (Criteria) this;
		}

		public Criteria andDeletedFlagGreaterThanOrEqualTo(Integer value) {
			addCriterion("deleted_flag >=", value, "deletedFlag");
			return (Criteria) this;
		}

		public Criteria andDeletedFlagLessThan(Integer value) {
			addCriterion("deleted_flag <", value, "deletedFlag");
			return (Criteria) this;
		}

		public Criteria andDeletedFlagLessThanOrEqualTo(Integer value) {
			addCriterion("deleted_flag <=", value, "deletedFlag");
			return (Criteria) this;
		}

		public Criteria andDeletedFlagIn(List<Integer> values) {
			addCriterion("deleted_flag in", values, "deletedFlag");
			return (Criteria) this;
		}

		public Criteria andDeletedFlagNotIn(List<Integer> values) {
			addCriterion("deleted_flag not in", values, "deletedFlag");
			return (Criteria) this;
		}

		public Criteria andDeletedFlagBetween(Integer value1, Integer value2) {
			addCriterion("deleted_flag between", value1, value2, "deletedFlag");
			return (Criteria) this;
		}

		public Criteria andDeletedFlagNotBetween(Integer value1, Integer value2) {
			addCriterion("deleted_flag not between", value1, value2, "deletedFlag");
			return (Criteria) this;
		}

		public Criteria andDeletedDateIsNull() {
			addCriterion("deleted_date is null");
			return (Criteria) this;
		}

		public Criteria andDeletedDateIsNotNull() {
			addCriterion("deleted_date is not null");
			return (Criteria) this;
		}

		public Criteria andDeletedDateEqualTo(Date value) {
			addCriterion("deleted_date =", value, "deletedDate");
			return (Criteria) this;
		}

		public Criteria andDeletedDateNotEqualTo(Date value) {
			addCriterion("deleted_date <>", value, "deletedDate");
			return (Criteria) this;
		}

		public Criteria andDeletedDateGreaterThan(Date value) {
			addCriterion("deleted_date >", value, "deletedDate");
			return (Criteria) this;
		}

		public Criteria andDeletedDateGreaterThanOrEqualTo(Date value) {
			addCriterion("deleted_date >=", value, "deletedDate");
			return (Criteria) this;
		}

		public Criteria andDeletedDateLessThan(Date value) {
			addCriterion("deleted_date <", value, "deletedDate");
			return (Criteria) this;
		}

		public Criteria andDeletedDateLessThanOrEqualTo(Date value) {
			addCriterion("deleted_date <=", value, "deletedDate");
			return (Criteria) this;
		}

		public Criteria andDeletedDateIn(List<Date> values) {
			addCriterion("deleted_date in", values, "deletedDate");
			return (Criteria) this;
		}

		public Criteria andDeletedDateNotIn(List<Date> values) {
			addCriterion("deleted_date not in", values, "deletedDate");
			return (Criteria) this;
		}

		public Criteria andDeletedDateBetween(Date value1, Date value2) {
			addCriterion("deleted_date between", value1, value2, "deletedDate");
			return (Criteria) this;
		}

		public Criteria andDeletedDateNotBetween(Date value1, Date value2) {
			addCriterion("deleted_date not between", value1, value2, "deletedDate");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table image_product
	 * @mbg.generated  Wed Aug 31 21:21:35 ICT 2022
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table image_product
     *
     * @mbg.generated do_not_delete_during_merge Sat Aug 27 10:03:58 ICT 2022
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}