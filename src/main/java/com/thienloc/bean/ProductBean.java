package com.thienloc.bean;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.thienloc.enums.CategoryType;
import com.thienloc.enums.Flag;
import com.thienloc.form.ImageProductForm;
import com.thienloc.form.ProductForm;
import com.thienloc.mapper.ImageProductMapper;
import com.thienloc.mapper.ProductMapper;
import com.thienloc.model.Category;
import com.thienloc.model.ImageProduct;
import com.thienloc.model.ImageProductExample;
import com.thienloc.model.ImageProductKey;
import com.thienloc.model.Product;
import com.thienloc.model.ProductExample;
import com.thienloc.utils.RemoveVietnameseTones;
import com.thienloc.utils.Upload;

@Transactional
@Repository
public class ProductBean {
	
	private static final String PATHNAME = "src/main/webapp/WEB-INF/images/category";
	
	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	ImageProductMapper imageProductMapper;
	
	private CategoryBean categoryBean;
    public ProductBean(@NonNull @Lazy CategoryBean categoryBean) {    
        this.categoryBean = categoryBean;  
    }
    
    public void updateProduct(Product product) {
    	productMapper.updateByPrimaryKey(product);
    }
	
	public Product findProductById(Long productId) {
		ProductExample example = new ProductExample();
		example.createCriteria().andProductIdEqualTo(productId)
			.andDeletedFlagEqualTo(Flag.OFF.getCode());
		
		List<Product> list = productMapper.selectByExample(example);
		
		return list.size() > 0 ? list.get(0) : null;
	}
	
	public ProductForm findProductFormById(Long productId) {
		
		return productMapper.selectByProductId(productId);
	}
	
	public List<ProductForm> findAllProduct(Integer promotionFlag, String orderBy, String sort, Integer displayFlag, Integer topViewFlag, String bandName) {
		
		List<ProductForm> result = productMapper.selectAll(promotionFlag, orderBy, sort, displayFlag, topViewFlag, bandName);
		
		return result;
	}
	
	public List<ProductForm> findProductBySearch(String orderBy, String sort, Integer displayFlag, String searchKey) {
		
		List<ProductForm> result = productMapper.selectBySearchKey(orderBy, sort, displayFlag, searchKey);
		
		return result;
	}
	
	public List<Product> findRelatedProduct(Long categorySubId, Long categoryMainId, Long productId) {
		ProductExample example = new ProductExample();
		example.createCriteria()
			.andCategoryIdEqualTo(categorySubId)
			.andProductIdNotEqualTo(productId)
			.andDisplayEqualTo(Flag.ON.getCode())
			.andDeletedFlagEqualTo(Flag.OFF.getCode());
		
		List<Product> result = productMapper.selectByExample(example);
		List<Long> productIdList = new ArrayList<>();
		for (Product item : result) {
			productIdList.add(item.getProductId());
		}
		
		if(productIdList.size() == 0)
			productIdList.add(0L);
		
		if(result.size() < 4) {
			List<Long> categorySubIdList = new ArrayList<>();
			List<Category> categories = categoryBean.findCategorySubByCategoryParentId(categoryMainId);
			for (Category categorie : categories) {
				categorySubIdList.add(categorie.getCategoryId());
			}
			
			ProductExample example1 = new ProductExample();
			example1.createCriteria()
				.andCategoryIdIn(categorySubIdList)
				.andProductIdNotEqualTo(productId)
				.andDisplayEqualTo(Flag.ON.getCode())
				.andProductIdNotIn(productIdList)
				.andDeletedFlagEqualTo(Flag.OFF.getCode());
			
			result.addAll(productMapper.selectByExample(example1));
		}
		
		return result.size() > 4 ? result.subList(0, 4) : result;
	}

	public List<ProductForm> findProductByCategory(Category category, String orderBy, String sort, Integer displayFlag, Integer limitFlag) {
		
		List<Long> categoryIdList = new ArrayList<>();
		List<ProductForm> result = new ArrayList<>();
		
		if(category.getCategoryType().equals(CategoryType.MAIN.getCode())) {
			 List<Category> categoryList = categoryBean.findCategorySubByCategoryParentId(category.getCategoryId());
			 for (Category item : categoryList) {
				 categoryIdList.add(item.getCategoryId());
			}
		} else {
			categoryIdList.add(category.getCategoryId());
		}
		
		if(categoryIdList.size() == 0)
			return null;
		
		result = productMapper.selectAllByCategoryId(categoryIdList, orderBy, sort, displayFlag, limitFlag);
		
		return result;
	}
	
	public List<Product> findProductByCategory(Long CategoryId) {
		
		ProductExample example = new ProductExample();
		example.createCriteria()
			.andCategoryIdEqualTo(CategoryId)
			.andDeletedFlagEqualTo(Flag.OFF.getCode());
		
		return productMapper.selectByExample(example);
	}

	public Product saveProduct(Product productForm) throws IOException {
		Date date = new Date();
		Product product = null;
        
        if(productForm.getProductId() != null) {
        	product = findProductById(productForm.getProductId());
        	
        	product.setProductName(productForm.getProductName());
        	product.setProductCode(RemoveVietnameseTones.removeAccent(productForm.getProductName()));
        	product.setCategoryId(productForm.getCategoryId());
        	product.setPrice(productForm.getPrice());
        	product.setPromotionFlag(productForm.getPromotionFlag());
        	if(productForm.getPromotionFlag().equals(Flag.ON.getCode()))
        		product.setPromotionPrice(productForm.getPromotionPrice());
        	else
        		product.setPromotionPrice(productForm.getPrice());
        	product.setBrand(productForm.getBrand());
        	product.setDescription(productForm.getDescription());
        	product.setDetail(productForm.getDetail());
        	product.setInfo(productForm.getInfo());
        	product.setQuantity(productForm.getQuantity());
        	product.setTopView(productForm.getTopView());
        	product.setDisplay(productForm.getDisplay());
        	product.setUpdatedDate(date);
        	
        	productMapper.updateByPrimaryKey(product);
        } else {
        	product = new Product();
        	
        	product.setProductName(productForm.getProductName());
        	product.setProductCode(RemoveVietnameseTones.removeAccent(productForm.getProductName()));
        	product.setCategoryId(productForm.getCategoryId());
        	product.setPrice(productForm.getPrice());
        	product.setPromotionFlag(productForm.getPromotionFlag());
        	if(productForm.getPromotionFlag().equals(Flag.ON.getCode()))
        		product.setPromotionPrice(productForm.getPromotionPrice());
        	else
        		product.setPromotionPrice(productForm.getPrice());
        	product.setBrand(productForm.getBrand());
        	product.setDescription(productForm.getDescription());
        	product.setDetail(productForm.getDetail());
        	product.setInfo(productForm.getInfo());
        	product.setQuantity(productForm.getQuantity());
        	product.setTopView(productForm.getTopView());
        	product.setDisplay(productForm.getDisplay());
        	product.setCreatedDate(date);
        	product.setUpdatedDate(date);
        	product.setDeletedFlag(Flag.OFF.getCode());
        	
        	productMapper.insert(product);
        }
        
        return product;
	}
	
	public ImageProduct findImageProductByImageId(Long productId, Long imageid) {
		ImageProductKey key = new ImageProductKey();
		key.setProductId(productId);
		key.setImageId(imageid);
		
		return imageProductMapper.selectByPrimaryKey(key);
	}
	
	public List<ImageProduct> findImageProduct(Long productId) {
		ImageProductExample example = new ImageProductExample();
		example.createCriteria().andProductIdEqualTo(productId)
			.andDeletedFlagEqualTo(Flag.OFF.getCode());
		
		return imageProductMapper.selectByExample(example);
	}
	
	public void saveImageProduct(ImageProductForm imageProductForm) throws IOException {
		Long count = Long.parseLong(String.valueOf(findImageProduct(imageProductForm.getProductId()).size()));
		Date date = new Date();
		
		Product product = findProductById(imageProductForm.getProductId());
		
		if(imageProductForm.getThumbnail().getSize() > 0) {
			
			if(product.getImageName() != null) {
				Upload.deleteFile(PATHNAME, product.getImageName());
			}
			
			product.setContentType(imageProductForm.getThumbnail().getContentType());
			product.setSize(imageProductForm.getThumbnail().getSize());
			product.setUpdatedDate(date);
			
			String name = "product-" + product.getProductId().toString()
					+ imageProductForm.getThumbnail().getContentType().replace("/", ".").substring(imageProductForm.getThumbnail().getContentType().indexOf("/"));
			
			Upload.doUpload(imageProductForm.getThumbnail(), PATHNAME, name);
			
			product.setImageName(name);
			productMapper.updateByPrimaryKey(product);
		}
		for (MultipartFile fileData : imageProductForm.getFileDatas()) {
			
			if(fileData.getSize() > 0) {
				ImageProduct imageProduct = new ImageProduct();
				count++;
				
				imageProduct.setProductId(imageProductForm.getProductId());
				imageProduct.setImageId(count);
				imageProduct.setContentType(fileData.getContentType());
				imageProduct.setSize(fileData.getSize());
				imageProduct.setCreatedDate(date);
				imageProduct.setUpdatedDate(date);
				imageProduct.setDeletedFlag(Flag.OFF.getCode());
				
				String name = "product-" 
						+ imageProduct.getProductId().toString() 
						+ "-" 
						+ imageProduct.getImageId().toString() 
						+ fileData.getContentType().replace("/", ".").substring(fileData.getContentType().indexOf("/"));
				
				Upload.doUpload(fileData, PATHNAME, name);
				
				imageProduct.setName(name);
				imageProductMapper.insert(imageProduct);
			}
		}
		
	}

	public void deleteImageProduct(ImageProduct imageProduct, Product product) throws FileNotFoundException {
		if(imageProduct != null) {
			ImageProductKey imageProductKey = new ImageProductKey();
			imageProductKey.setProductId(imageProduct.getProductId());
			imageProductKey.setImageId(imageProduct.getImageId());
			
			Upload.deleteFile(PATHNAME, imageProduct.getName());
			
			imageProductMapper.deleteByPrimaryKey(imageProductKey);
		}
	}
	
	public void deleteProduct(Product product) throws FileNotFoundException {
		if(product != null) {
			List<ImageProduct> imageProducts = findImageProduct(product.getProductId());
			Date date = new Date();
			
			for (ImageProduct imageProduct : imageProducts) {
				deleteImageProduct(imageProduct, product);
			}
			
			Upload.deleteFile(PATHNAME, product.getImageName());
			
			product.setImageName(null);
			product.setSize(null);
			product.setContentType(null);
			product.setDeletedFlag(Flag.ON.getCode());
			product.setDeletedDate(date);
			product.setUpdatedDate(date);
			
			productMapper.updateByPrimaryKey(product);
		}
	}

	public boolean checkQuantity(int quantityCheck) {
		ProductExample example = new ProductExample();
		example.createCriteria()
			.andDeletedFlagEqualTo(Flag.OFF.getCode())
			.andQuantityLessThanOrEqualTo(quantityCheck);
		
		return productMapper.countByExample(example) > 0 ? true : false;
	}
	
}
