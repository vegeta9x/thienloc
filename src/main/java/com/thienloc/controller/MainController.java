package com.thienloc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thienloc.bean.AccountBean;
import com.thienloc.bean.BlogBean;
import com.thienloc.bean.CategoryBean;
import com.thienloc.bean.ImagesBannerBean;
import com.thienloc.bean.OrderBean;
import com.thienloc.bean.ProductBean;
import com.thienloc.enums.CategoryType;
import com.thienloc.enums.Flag;
import com.thienloc.enums.ImagesBannerType;
import com.thienloc.enums.TopView;
import com.thienloc.form.CheckoutForm;
import com.thienloc.form.HomeForm;
import com.thienloc.form.OrderDetail;
import com.thienloc.form.ProductForm;
import com.thienloc.model.Blog;
import com.thienloc.model.Category;
import com.thienloc.model.Orders;
import com.thienloc.model.Product;
import com.thienloc.utils.EncryptDecrypt;
import com.thienloc.utils.Validator;

@Controller
@Transactional
public class MainController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
	private static final List<String> QUERYSTRING = Stream.of("order_by", "sort_by").collect(Collectors.toList());
	private static final List<String> SORTBYLIST = Stream.of("asc", "desc").collect(Collectors.toList());
	private static final List<String> ORDERBYLIST = Stream.of("price", "date").collect(Collectors.toList());
	
	@Autowired
	AccountBean accountBean;
	
	@Autowired
	OrderBean orderBean;
	
	@Autowired
	ProductBean productBean;
	
	@Autowired
	BlogBean blogBean;
	
	@Autowired
	CategoryBean categoryBean;
	
	@Autowired
	ImagesBannerBean bannerBean;
	
	@RequestMapping("/403")
	public String accessDenied(Model model, HttpSession session) {
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		return "/403";
	}
	
	@RequestMapping("/404")
	public String notFound(Model model, HttpSession session) {
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		return "/404";
	}
	
	@RequestMapping(value = {"/", "/index"})
	public String home(Model model, HttpSession session) {
		List<ProductForm> productSaleList = productBean.findAllProduct(Flag.ON.getCode() ,null, null, Flag.ON.getCode(), null, null);
		List<ProductForm> productTopSaleList = productBean.findAllProduct(Flag.OFF.getCode() ,null, null, Flag.ON.getCode(), TopView.TOP_SALE.getCode(), null);
		List<ProductForm> productTopSearchList = productBean.findAllProduct(Flag.OFF.getCode() ,null, null, Flag.ON.getCode(), TopView.TOP_SEARCH.getCode(), null);
		List<ProductForm> productTopNewList = productBean.findAllProduct(Flag.OFF.getCode() ,null, null, Flag.ON.getCode(), TopView.TOP_NEW.getCode(), null);
		List<HomeForm> featuredProduct = categoryBean.homeForm();
		
		session.setAttribute("categoryList", categoryBean.findAllCategory());
		
		model.addAttribute("featuredProduct_1", featuredProduct.size() > 0 ? featuredProduct.get(0) : null);
		model.addAttribute("featuredProduct_2", featuredProduct.size() > 1 ? featuredProduct.get(1) : null);
		
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		model.addAttribute("productSaleList", productSaleList.size() > 8 ? productSaleList.subList(0, 8) : productSaleList);
		model.addAttribute("productTopSaleList_1", productTopSaleList.size() > 3 ? productTopSaleList.subList(0, 3) : productTopSaleList);
		model.addAttribute("productTopSaleList_2", productTopSaleList.size() > 3 ? productTopSaleList.subList(3, productTopSaleList.size()) : null);
		model.addAttribute("productTopSearchList_1", productTopSearchList.size() > 3 ? productTopSearchList.subList(0, 3) : productTopSearchList);
		model.addAttribute("productTopSearchList_2", productTopSearchList.size() > 3 ? productTopSearchList.subList(3, productTopSearchList.size()) : null);
		model.addAttribute("productTopNewList_1", productTopNewList.size() > 3 ? productTopNewList.subList(0, 3) : productTopNewList);
		model.addAttribute("productTopNewList_2", productTopNewList.size() > 3 ? productTopNewList.subList(3, productTopNewList.size()) : null);
		model.addAttribute("viewBlogList", blogBean.findAllViewBlog().size() > 3 ? blogBean.findAllViewBlog().subList(0, 3) : blogBean.findAllViewBlog());
		
		model.addAttribute("banner", bannerBean.findImagesBannerByType(ImagesBannerType.BANNER.getCode()).getImageName());
		model.addAttribute("bannerSub1", bannerBean.findImagesBannerByType(ImagesBannerType.BANNER_SUB_1.getCode()).getImageName());
		model.addAttribute("bannerSub2", bannerBean.findImagesBannerByType(ImagesBannerType.BANNER_SUB_2.getCode()).getImageName());
		
		return "index";
	}
	
	@RequestMapping(value = {"/contact"})
	public String contact(Model model, HttpSession session) {
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		return "contact";
	}
	
	@RequestMapping(value = {"/guide"})
	public String shoppingGuide(Model model, HttpSession session) {
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		model.addAttribute("avatar", bannerBean.findImagesBannerByType(ImagesBannerType.AVATAR.getCode()).getImageName());
		
		return "shopping-guide";
	}
	
	@RequestMapping("/blog")
	public String blog(Model model, HttpSession session) {
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		model.addAttribute("viewBlogList", blogBean.findAllViewBlog());
		return "blog";
	}
	
	@GetMapping(value = "/blog-details/{titleConvert_blogId}")
	public String blogDetail(Model model, HttpSession session, @PathVariable String titleConvert_blogId) {
		
		String blogId = titleConvert_blogId.substring(titleConvert_blogId.lastIndexOf("-") + 1);
		String titleConvert = titleConvert_blogId.substring(0, titleConvert_blogId.lastIndexOf("-"));
		
		Blog blog =  blogBean.findBlogByBlogId(Long.parseLong(blogId));
		if(blog == null || !blog.getTitleCode().equals(titleConvert))
			return "redirect:/404";
		
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		model.addAttribute("blogDetails", blog);
		model.addAttribute("newBlogs", blogBean.findBlogLimit(blog.getBlogId(), 4));
		
		model.addAttribute("avatar", bannerBean.findImagesBannerByType(ImagesBannerType.AVATAR.getCode()).getImageName());
		
		return "blog-details";
	}
	
	@GetMapping(value = "/product-details/{productCode_productId}")
	public String productDetail(Model model, HttpSession session, @PathVariable String productCode_productId) {
		
		String productId = productCode_productId.substring(productCode_productId.lastIndexOf("-") + 1);
		String productCode = productCode_productId.substring(0, productCode_productId.lastIndexOf("-"));
		
		Product product =  productBean.findProductById(Long.parseLong(productId));
		Category category = categoryBean.findCategoryByCategoryId(product.getCategoryId());
		
		if(product == null || !product.getProductCode().equals(productCode))
			return "redirect:/404";
		
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		model.addAttribute("category", category);
		model.addAttribute("categoryParent", categoryBean.findCategoryByCategoryId(category.getCategoryParentId()));
		model.addAttribute("product", product);
		model.addAttribute("imageProductList", productBean.findImageProduct(product.getProductId()));
		model.addAttribute("relatedProductList", productBean.findRelatedProduct(category.getCategoryId(), category.getCategoryParentId(), product.getProductId()));
		
		return "product-details";
	}
	
	@RequestMapping(value = "/category/{categoryCode}", method = RequestMethod.GET)
	public String categoryPage(Model model, 
								HttpServletRequest request, 
								HttpSession session, 
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
				return "redirect:/404";
		} else {
			orderBy = null;
			sortBy = null;
		}
		
		String categoryId = categoryCodePath.substring(categoryCodePath.lastIndexOf("-") + 1);
		String categoryCode = categoryCodePath.substring(0, categoryCodePath.lastIndexOf("-"));
		
		Category category = categoryBean.findCategoryByCategoryId(Long.parseLong(categoryId));
		if(category == null || !category.getCategoryCode().equals(categoryCode))
			return "redirect:/404";
		
		model.addAttribute("category", category);
		model.addAttribute("categoryMain", category.getCategoryType() == CategoryType.MAIN.getCode() ? category : categoryBean.findCategoryByCategoryId(category.getCategoryParentId()));
		model.addAttribute("productList", productBean.findProductByCategory(category, orderBy, sortBy, Flag.ON.getCode(), Flag.OFF.getCode()));
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		
		return "category";
	}
	
	@RequestMapping(value = "/sale", method = RequestMethod.GET)
	public String salePage(Model model, 
								HttpServletRequest request, 
								HttpSession session, 
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
				return "redirect:/404";
		} else {
			orderBy = null;
			sortBy = null;
		}
		
		model.addAttribute("productList", productBean.findAllProduct(Flag.ON.getCode() ,orderBy, sortBy, Flag.ON.getCode(), null, null));
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		
		return "sale";
	}
	
	@RequestMapping(value = "/brand/{brandName}", method = RequestMethod.GET)
	public String brandPage(Model model, 
								HttpServletRequest request, 
								HttpSession session, 
								@PathVariable("brandName") String brandName, 
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
				return "redirect:/404";
		} else {
			orderBy = null;
			sortBy = null;
		}
		
		List<ProductForm> productForms = productBean.findAllProduct(Flag.OFF.getCode() ,orderBy, sortBy, Flag.ON.getCode(), null, brandName);
		
		if(productForms == null)
			return "redirect:/404";
		
		model.addAttribute("brandName", brandName);
		model.addAttribute("productList", productForms);
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		
		return "brand";
	}
	
	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public String search(Model model, 
				@RequestParam(value = "key", required = true, defaultValue = "") String key, 
				HttpServletRequest request, 
				HttpSession session, 
				@RequestParam(value = "order_by", required = false, defaultValue = "") String orderBy, 
				@RequestParam(value = "sort_by", required = false, defaultValue = "") String sortBy) {
		
		String url = request.getQueryString();
		url = url.toLowerCase();
		
		if(url.contains("order_by") && url.contains("sort_by")) {
			url = url.substring(url.indexOf("&") + 1, url.length());
			
			String s1 = url.substring(0, url.indexOf("="));
			orderBy = url.substring(s1.length() + 1, url.indexOf("&"));
			String s3 = url.substring(s1.length() + orderBy.length() + 2, url.lastIndexOf("="));
			sortBy = url.substring(url.lastIndexOf("=") +1, url.length());
			
			if(!Validator.checkEmpty(QUERYSTRING, s1) ||
					!Validator.checkEmpty(ORDERBYLIST, orderBy) ||
					!Validator.checkEmpty(QUERYSTRING, s3) ||
					!Validator.checkEmpty(SORTBYLIST, sortBy))
				return "redirect:/404";
		} else {
			orderBy = null;
			sortBy = null;
		}
		
		
		List<ProductForm> productForms = productBean.findProductBySearch(orderBy, sortBy, Flag.ON.getCode(), key);
		
		model.addAttribute("key", key);
		model.addAttribute("productList", productForms);
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		
		return "search";
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String shoppingCart(Model model, HttpSession session) {
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		
		return "shopping-cart";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkOut(Model model) {
		CheckoutForm checkoutForm = new CheckoutForm();
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

		model.addAttribute("checkoutForm", checkoutForm);
		model.addAttribute("orderDetails", orderDetails);
		
		return "checkout";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkout(HttpServletRequest request, Model model, 
			@RequestParam(value = "productId") List<Long> productIdList, 
			@RequestParam(value = "quantity") List<Integer> quantityList, 
			@RequestParam(value = "price") List<Long> priceList, 
			@ModelAttribute("checkoutForm") CheckoutForm checkoutForm) throws IOException {
		
		Orders orders = orderBean.saveOrder(checkoutForm, productIdList, quantityList, priceList);
		String encodedOrderId = EncryptDecrypt.encrypt(orders.getOrderId());
		
		return "redirect:/checkout/thankyou?id=" + encodedOrderId;
	}
	
	@RequestMapping(value = "/checkout/thankyou", method = RequestMethod.GET)
	public String thankYou(@RequestParam(value = "id", required = true, defaultValue = "") String encodedOrderId) {
		
		String decodedOrderId = EncryptDecrypt.decrypt(encodedOrderId);
		
		if(!orderBean.checkExist(decodedOrderId)) {
			return "redirect:/404";
		}
		
		return "checkout-success";
	}

}
