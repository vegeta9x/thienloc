package com.thienloc.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thienloc.enums.CategoryType;
import com.thienloc.enums.Flag;
import com.thienloc.form.HomeForm;
import com.thienloc.form.ProductForm;
import com.thienloc.mapper.CategoryMapper;
import com.thienloc.model.Category;
import com.thienloc.model.CategoryExample;
import com.thienloc.model.Product;
import com.thienloc.utils.RemoveVietnameseTones;

@Transactional
@Repository
public class CategoryBean {
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryBean.class);
	
	@Autowired
	CategoryMapper categoryMapper;
	
	private ProductBean	productBean;
	public CategoryBean(@NonNull ProductBean productBean) {  
        this.productBean = productBean;  
    }
	
	public Category findCategoryByCategoryId(Long categoryId) {
		CategoryExample example = new CategoryExample();
		example.createCriteria()
			.andCategoryIdEqualTo(categoryId)
			.andDeletedFlagEqualTo(Flag.OFF.getCode());
		
		List<Category> categoryList = categoryMapper.selectByExample(example);
		
		return categoryList.size() > 0 ? categoryList.get(0) : null;
	}
	
	public List<Category> findCategoryAllMain() {
		CategoryExample example = new CategoryExample();
		example.createCriteria()
			.andCategoryTypeEqualTo(CategoryType.MAIN.getCode())
			.andDeletedFlagEqualTo(Flag.OFF.getCode());
		example.setOrderByClause("sort ASC");
		
		List<Category> categoryList = categoryMapper.selectByExample(example);
		
		return categoryList;
	}
	
	public List<Category> findCategorySubByCategoryParentId(Long categoryParentId) {
		CategoryExample example = new CategoryExample();
		example.createCriteria()
			.andCategoryTypeEqualTo(CategoryType.SUB.getCode())
			.andCategoryParentIdEqualTo(categoryParentId)
			.andDeletedFlagEqualTo(Flag.OFF.getCode());
		example.setOrderByClause("sort ASC");
		
		List<Category> categoryList = categoryMapper.selectByExample(example);
		
		return categoryList;
	}
	
	public List<Category> findCategorySubByCategoryParentIdAndDisplay(Long categoryParentId, Integer display) {
		CategoryExample example = new CategoryExample();
		example.createCriteria()
			.andCategoryTypeEqualTo(CategoryType.SUB.getCode())
			.andCategoryParentIdEqualTo(categoryParentId)
			.andDisplayEqualTo(display)
			.andDeletedFlagEqualTo(Flag.OFF.getCode());
		example.setOrderByClause("sort ASC");
		
		List<Category> categoryList = categoryMapper.selectByExample(example);
		
		return categoryList;
	}
	
	public List<Category> findAllCategory() {
		CategoryExample example = new CategoryExample();
		example.createCriteria()
			.andDeletedFlagEqualTo(Flag.OFF.getCode());
		example.setOrderByClause("sort ASC");
		
		List<Category> categoryList = categoryMapper.selectByExample(example);
		
		List<Category> result =	new ArrayList<>();
		
		for (Category category : categoryList) {
			if(category.getCategoryType() == 1) {
				result.add(category);
				for (Category category2 : categoryList) {
					if((category2.getCategoryType() == 2) && (category.getCategoryId() == category2.getCategoryParentId()))
						result.add(category2);
				}
			}
		}
		
		return result;
	}

	public void editCagegory(Category categoryForm) {
		Date date = new Date();
		
		Category category = findCategoryByCategoryId(categoryForm.getCategoryId());
		
		category.setCategoryName(categoryForm.getCategoryName());
		category.setCategoryCode(RemoveVietnameseTones.removeAccent(categoryForm.getCategoryName()));
		category.setSort(categoryForm.getSort());
		if(categoryForm.getCategoryType().equals(CategoryType.SUB.getCode())) {
			category.setDisplay(categoryForm.getDisplay());
		}
		category.setUpdatedDate(date);
		
		categoryMapper.updateByPrimaryKey(category);
		
	}

	public void deleteCategoryById(Category category) throws IOException {
		Date date = new Date();
		
		if(category != null) {
			category.setDeletedFlag(Flag.ON.getCode());
			category.setDeletedDate(date);
			category.setUpdatedDate(date);
			
			categoryMapper.updateByPrimaryKey(category);
			
			if(category.getCategoryType().equals(CategoryType.MAIN.getCode())) {
				List<Category> listSub = findCategorySubByCategoryParentId(category.getCategoryId());
				for (Category categorySub : listSub) {
					categorySub.setDeletedFlag(Flag.ON.getCode());
					categorySub.setDeletedDate(date);
					categorySub.setUpdatedDate(date);
					
					categoryMapper.updateByPrimaryKey(categorySub);
					
					List<Product> products = productBean.findProductByCategory(categorySub.getCategoryId());
					for (Product product : products) {
						productBean.deleteProduct(product);
					}
				}
				
			} else {
				List<Product> products = productBean.findProductByCategory(category.getCategoryId());
				for (Product product : products) {
					productBean.deleteProduct(product);
				}
				
			}
		}
	}
	
	public void newCagegory(Category categoryForm) throws IOException {
		Date date = new Date();
		
		Category category = new Category();
		
		category.setCategoryType(categoryForm.getCategoryType());
		if(categoryForm.getCategoryType().equals(CategoryType.SUB.getCode())) {
			category.setCategoryParentId(categoryForm.getCategoryParentId());
			category.setDisplay(categoryForm.getDisplay());
		}
			
		category.setCategoryName(categoryForm.getCategoryName());
		category.setCategoryCode(RemoveVietnameseTones.removeAccent(categoryForm.getCategoryName()));
		category.setSort(categoryForm.getSort());
		category.setCreatedDate(date);
		category.setUpdatedDate(date);
		category.setDeletedFlag(Flag.OFF.getCode());
		
		categoryMapper.insert(category);
		
	}
	
	public List<HomeForm> homeForm() {
		List<Category> categories = findCategoryAllMain();
		List<HomeForm> result = new ArrayList<>();
		int i = 0;
		for (Category category : categories) {
			if(i == 2)
				break;
			HomeForm homeForm = new HomeForm();
			homeForm.setCategoryMain(category);
			
			List<Category> categoriesSub = findCategorySubByCategoryParentIdAndDisplay(category.getCategoryId(), Flag.ON.getCode());
			homeForm.setCategorySubList(categoriesSub);
			
			List<ProductForm> productForms = new ArrayList<>();
			for (Category categorySub : categoriesSub) {
				productForms.addAll(productBean.findProductByCategory(categorySub, null, null, Flag.ON.getCode(), Flag.ON.getCode()));
			}
			homeForm.setProductList(productForms);
			
			result.add(homeForm);
			i++;
		}
		
		return result;
	}
}
