package com.thienloc.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thienloc.bean.BlogBean;
import com.thienloc.bean.CategoryBean;
import com.thienloc.bean.ImagesBannerBean;
import com.thienloc.bean.OrderBean;
import com.thienloc.bean.ProductBean;
import com.thienloc.enums.Flag;
import com.thienloc.enums.OrderStatus;
import com.thienloc.form.BlogForm;
import com.thienloc.form.ImageProductForm;
import com.thienloc.form.ImagesBannerForm;
import com.thienloc.form.ProductForm;
import com.thienloc.model.Blog;
import com.thienloc.model.Category;
import com.thienloc.model.ImageProduct;
import com.thienloc.model.Orders;
import com.thienloc.model.Product;
import com.thienloc.utils.Validator;

@Controller
@Transactional
public class AdminController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	CategoryBean categoryBean;
	
	@Autowired
	OrderBean orderBean;
	
	@Autowired
	ProductBean productBean;
	
	@Autowired
	BlogBean blogBean;
	
	@Autowired
	ImagesBannerBean imagesBannerBean;
	
	private static final List<String> QUERYSTRING = Stream.of("order_by", "sort_by").collect(Collectors.toList());
	private static final List<String> SORTBYLIST = Stream.of("asc", "desc").collect(Collectors.toList());
	private static final List<String> ORDERBYLIST = Stream.of("price", "date", "quantity").collect(Collectors.toList());
	
	@RequestMapping("/admin/404")
	public String notFound() {
		return "/admin/404";
	}
	
	@RequestMapping(value = { "/admin/login" }, method = RequestMethod.GET)
	public String login(Model model) {
		return "admin/login";
	}
	
	@RequestMapping("/admin/thienloc")
	public String adminPage(Model model) {
		model.addAttribute("productFlag", productBean.checkQuantity(5));
		model.addAttribute("orderFlag", orderBean.countOrderByStatus(OrderStatus.CONFIRM.getCode()) > 0 ? true : false);
		
		return "admin/index";
	}
	
	//-------------------//
	
	@RequestMapping(value = "/admin/blogList", method = RequestMethod.GET)
	public String blogList(Model model) {
		model.addAttribute("blogList", blogBean.findAllBlog());
		
		return "admin/blogList";
	}
	
	@RequestMapping(value = { "/admin/blog" }, method = RequestMethod.GET)
	public String blog(Model model, @RequestParam(value = "blogId", required = false, defaultValue = "") Long blogId) {
		
		BlogForm blogForm = null;
		if (blogId != null ) {
			Blog blog = blogBean.findBlogByBlogId(blogId);
			if (blog != null)
				blogForm = new BlogForm(blog);
			else
				return "redirect:/admin/404";
		}
		if (blogForm == null || blogId == null) {
			blogForm = new BlogForm();
		}
		model.addAttribute("blogForm", blogForm);
		
		return "admin/blog";
	}
	
	@RequestMapping(value = "/admin/blog", method = RequestMethod.POST)
	public String saveBlog(HttpServletRequest request, Model model, @ModelAttribute("blogForm") BlogForm blogForm) throws IOException {
		blogBean.saveBlog(blogForm);

		return "redirect:/admin/blogList";
	}
	
	@RequestMapping(value = { "/admin/deleteBlog" }, method = RequestMethod.GET)
	public String deleteBlog(Model model, @RequestParam(value = "blogId", required = false, defaultValue = "") Long blogId) throws FileNotFoundException {
		Blog blog = blogBean.findBlogByBlogId(blogId);
		if(blog == null)
			return "redirect:/admin/404";
		
		blogBean.deleteBlogById(blog);
		
		return "redirect:/admin/blogList";
	}
	
	//-------------------//
	
	@RequestMapping(value = "/admin/categoryList", method = RequestMethod.GET)
	public String categoryList(Model model) {
		model.addAttribute("categoryList", categoryBean.findAllCategory());
		
		return "admin/categoryList";
	}
	
	@RequestMapping(value = "/admin/category", method = RequestMethod.GET)
	public String editCategory(Model model, @RequestParam(value = "categoryId", required = false, defaultValue = "") Long categoryId) {
		Category category = categoryBean.findCategoryByCategoryId(categoryId);
		if(category == null)
			return "redirect:/admin/404";
		
		model.addAttribute("categoryForm", category);
		
		return "admin/category";
	}
	
	@RequestMapping(value = "/admin/editCategory", method = RequestMethod.POST)
	public String editCagegory(Model model, @ModelAttribute("categoryForm") Category categoryForm) throws IOException {
		categoryBean.editCagegory(categoryForm);
		
		return "redirect:/admin/categoryList";
	}
	
	@RequestMapping(value = { "/admin/deleteCategory" }, method = RequestMethod.GET)
	public String deleteCategory(Model model, @RequestParam(value = "categoryId", required = false, defaultValue = "") Long categoryId) throws IOException {
		Category category = categoryBean.findCategoryByCategoryId(categoryId);
		if(category == null)
			return "redirect:/admin/404";
		
		categoryBean.deleteCategoryById(category);
		
		return "redirect:/admin/categoryList";
	}
	
	@RequestMapping(value = "/admin/newCategory", method = RequestMethod.GET)
	public String newCategory(Model model) {
		model.addAttribute("categoryMainList", categoryBean.findCategoryAllMain());
		model.addAttribute("categoryForm", new Category());
		
		return "admin/newCategory";
	}
	
	@RequestMapping(value = "/admin/newCategory", method = RequestMethod.POST)
	public String newCagegory(Model model, @ModelAttribute("categoryForm") Category categoryForm) throws IOException {
		categoryBean.newCagegory(categoryForm);
		
		return "redirect:/admin/categoryList";
	}
	
	
	//-------------------//
	
	@RequestMapping(value = "/admin/productList", method = RequestMethod.GET)
	public String productList(Model model, 
							HttpServletRequest request, 
							@RequestParam(value = "order_by", required = false, defaultValue = "") String orderBy, 
							@RequestParam(value = "sort_by", required = false, defaultValue = "") String sortBy) {
		
		String url = request.getQueryString();
		
		if(url != null) {
			url = url.toLowerCase();
			String s1 = url.substring(0, url.indexOf("="));
			orderBy = url.substring(s1.length() + 1, url.indexOf("&"));
			String s3 = url.substring(s1.length() + orderBy.length() + 2, url.lastIndexOf("="));
			sortBy = url.substring(url.lastIndexOf("=") +1, url.length());
			
			if(!Validator.checkEmpty(QUERYSTRING, s1) ||
					!Validator.checkEmpty(ORDERBYLIST, orderBy) ||
					!Validator.checkEmpty(QUERYSTRING, s3) ||
					!Validator.checkEmpty(SORTBYLIST, sortBy))
				return "redirect:/admin/404";
			
		} else {
			orderBy = "productId";
			sortBy = "asc";
		}
		
		model.addAttribute("productList", productBean.findAllProduct(Flag.OFF.getCode() ,orderBy, sortBy, Flag.OFF.getCode(), null, null));
		model.addAttribute("categoryList", categoryBean.findAllCategory());
		
		return "admin/productList";
	}
	

	@RequestMapping(value = "/admin/productList/{categoryCode}", method = RequestMethod.GET)
	public String productListByCategoryCode(Model model, 
											HttpServletRequest request, 
											@PathVariable("categoryCode") String categoryCodePath, 
											@RequestParam(value = "order_by", required = false, defaultValue = "") String orderBy, 
											@RequestParam(value = "sort_by", required = false, defaultValue = "") String sortBy) {
		
		String url = request.getQueryString();

		if(url != null) {
			url = url.toLowerCase();
			String s1 = url.substring(0, url.indexOf("="));
			orderBy = url.substring(s1.length() + 1, url.indexOf("&"));
			String s3 = url.substring(s1.length() + orderBy.length() + 2, url.lastIndexOf("="));
			sortBy = url.substring(url.lastIndexOf("=") +1, url.length());
			
			if(!Validator.checkEmpty(QUERYSTRING, s1) ||
					!Validator.checkEmpty(ORDERBYLIST, orderBy) ||
					!Validator.checkEmpty(QUERYSTRING, s3) ||
					!Validator.checkEmpty(SORTBYLIST, sortBy))
				return "redirect:/admin/404";
		} else {
			orderBy = "productId";
			sortBy = "asc";
		}
		
		String categoryId = categoryCodePath.substring(categoryCodePath.lastIndexOf("-") + 1);
		String categoryCode = categoryCodePath.substring(0, categoryCodePath.lastIndexOf("-"));
		
		Category category = categoryBean.findCategoryByCategoryId(Long.parseLong(categoryId));
		if(category == null || !category.getCategoryCode().equals(categoryCode))
			return "redirect:/admin/404";
		
		List<ProductForm> productForms = productBean.findProductByCategory(category, orderBy, sortBy, Flag.OFF.getCode(), Flag.OFF.getCode());
		model.addAttribute("productList", productForms == null ? null : productForms);
		model.addAttribute("categoryList", categoryBean.findAllCategory());
		
		return "admin/productList";
	}
	
	@RequestMapping(value = "/admin/product", method = RequestMethod.GET)
	public String product(Model model, @RequestParam(value = "productId", required = false, defaultValue = "") Long productId) {
		Product product = null;
		if (productId != null ) {
			product = productBean.findProductById(productId);
			if (product == null)
				return "redirect:/admin/404";
		}
		else
			product = new Product();
		
		model.addAttribute("productForm", product);
		
		model.addAttribute("categoryList", categoryBean.findAllCategory());
		
		return "admin/product";
	}
	
	@RequestMapping(value = "/admin/product", method = RequestMethod.POST)
	public String product(Model model, 
						HttpServletRequest request, 
						@ModelAttribute("productForm") Product productForm) throws IOException {
		
		Product product = productBean.saveProduct(productForm);
		
		return "redirect:/admin/product?productId=" + product.getProductId();
	}
	
	@RequestMapping(value = "/admin/imageProduct", method = RequestMethod.GET)
	public String imageProduct(Model model, 
						@RequestParam(value = "productId", required = true, defaultValue = "") Long productId) {
		
		Product product = productBean.findProductById(productId);
		if (product == null)
			return "redirect:/admin/404";
		
		model.addAttribute("product", product);
		model.addAttribute("imageProductList", productBean.findImageProduct(productId));
		model.addAttribute("imageProductForm", new ImageProductForm(productId, product.getCategoryId()));
		
		return "admin/imageProduct";
	}
	
	@RequestMapping(value = "/admin/imageProduct", method = RequestMethod.POST)
	public String imageProduct(Model model, @ModelAttribute("imageProductForm") ImageProductForm imageProductForm) throws IOException {
		productBean.saveImageProduct(imageProductForm);
		
		return "redirect:/admin/imageProduct?productId=" + imageProductForm.getProductId();
	}
	
	@RequestMapping(value = { "/admin/deleteImageProduct" }, method = RequestMethod.GET)
	public String deleteImageProduct(Model model, 
							@RequestParam(value = "productId", required = false, defaultValue = "") Long productId, 
							@RequestParam(value = "imageId", required = false, defaultValue = "") Long imageId) throws FileNotFoundException {
		
		Product product = productBean.findProductById(productId);
		ImageProduct imageProduct = productBean.findImageProductByImageId(productId, imageId);
		if(imageProduct == null)
			return "redirect:/admin/404";
		
		productBean.deleteImageProduct(imageProduct, product);
		
		return "redirect:/admin/imageProduct?productId=" + productId;
	}
	
	@RequestMapping(value = { "/admin/deleteProduct" }, method = RequestMethod.GET)
	public String deleteProduct(Model model, 
						@RequestParam(value = "productId", required = false, defaultValue = "") Long productId) throws FileNotFoundException {
		Product product = productBean.findProductById(productId);
		if(product == null)
			return "redirect:/admin/404";
		
		productBean.deleteProduct(product);
		
		return "redirect:/admin/productList";
	}
	
	//-------------------//
	
	@RequestMapping(value = "/admin/orderList", method = RequestMethod.GET)
	public String orderList(Model model) {
		model.addAttribute("orderList", orderBean.findAll());
		
		model.addAttribute("confirm", orderBean.countOrderByStatus(OrderStatus.CONFIRM.getCode()));
		model.addAttribute("confirmed", orderBean.countOrderByStatus(OrderStatus.CONFIRMED.getCode()));
		model.addAttribute("transport", orderBean.countOrderByStatus(OrderStatus.TRANSPORT.getCode()));
		model.addAttribute("success", orderBean.countOrderByStatus(OrderStatus.SUCCESS.getCode()));
		model.addAttribute("cancel", orderBean.countOrderByStatus(OrderStatus.CANCEL.getCode()));
		
		model.addAttribute("revenue", orderBean.countRevenue());
		
		return "admin/orderList";
	}
	
	@RequestMapping(value = "/admin/orderDetail", method = RequestMethod.GET)
	public String orderDetail(Model model,
					@RequestParam(value = "orderId", required = true, defaultValue = "") String orderId) {
		Orders orders = orderBean.findOrdersByOrderId(orderId);
		if(orders == null) {
			return "redirect:/admin/404";
		}
		
		model.addAttribute("orders", orders);
		model.addAttribute("orderDetailsForms", orderBean.findOrderDetailsFormByOrderId(orderId));
		
		return "admin/orderDetail";
	}
	
	@RequestMapping(value = "/admin/orderDetail", method = RequestMethod.POST)
	public String orderDetail(Model model, @ModelAttribute("orders") Orders orders) throws IOException {
		orderBean.updateStatus(orders);
		
		return "redirect:/admin/orderDetail?orderId=" + orders.getOrderId();
	}
	
	//-------------------//
	
	@RequestMapping(value = "/admin/imagesBanner", method = RequestMethod.GET)
	public String imagesBanner(Model model) {
		model.addAttribute("ImagesBannerList", imagesBannerBean.findAllImagesBanner());
		model.addAttribute("ImagesBannerForm", new ImagesBannerForm());
		
		return "admin/imagesBanner";
	}
	
	@RequestMapping(value = "/admin/imagesBanner", method = RequestMethod.POST)
	public String imagesBanner(Model model, @ModelAttribute("ImagesBannerForm") ImagesBannerForm imagesBannerForm) throws IOException {
		imagesBannerBean.saveData(imagesBannerForm);
		
		return "redirect:/admin/imagesBanner";
	}
	
}
