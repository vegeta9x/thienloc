package com.thienloc.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thienloc.enums.OrderStatus;
import com.thienloc.form.CheckoutForm;
import com.thienloc.form.OrderDetailsForm;
import com.thienloc.mapper.OrderDetailsMapper;
import com.thienloc.mapper.OrdersMapper;
import com.thienloc.model.Orders;
import com.thienloc.model.OrdersExample;
import com.thienloc.model.Product;
import com.thienloc.model.OrderDetails;
import com.thienloc.model.OrderDetailsExample;

@Transactional
@Repository
public class OrderBean {
	@Autowired
	OrdersMapper ordersMapper;
	
	@Autowired
	OrderDetailsMapper orderDetailsMapper;
	
	@Autowired
	private ProductBean productBean;
	
	public boolean checkExist(String orderId) {
		if(ordersMapper.selectByPrimaryKey(orderId) != null)
			return true;
		return false;
	}
	
	public Orders findOrdersByOrderId(String orderId) {
		return ordersMapper.selectByPrimaryKey(orderId);
	}
	
	public List<Orders> findAll() {
		OrdersExample example = new OrdersExample();
		example.setOrderByClause("order_date desc");
		return ordersMapper.selectByExample(example);
	}
	
	public Orders saveOrder(CheckoutForm checkoutForm, List<Long> productIdList, List<Integer> quantityList, List<Long> priceList) {
		Date date = new Date();
		Orders order = new Orders();
		
		DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");
		
		order.setOrderId(dateFormat.format(date));
		order.setTotalPrice(checkoutForm.getTotalPrice());
		order.setTotalProduct(checkoutForm.getTotalProduct());
		order.setCustomerName(checkoutForm.getCustommerName());
		order.setCustomerAddress1(checkoutForm.getCustomerAddress_1());
		order.setCustomerAddress2(checkoutForm.getCustomerAddress_2());
		order.setCustomerPhone(checkoutForm.getCustomerPhone());
		order.setCustomerEmail(checkoutForm.getCustomerEmail());
		order.setNote(checkoutForm.getNote());
		order.setMethodPay(checkoutForm.getMethodPay());
		order.setOrderDate(date);
		order.setStatus(OrderStatus.CONFIRM.getCode());
		order.setUpdatedDate(date);
		
		ordersMapper.insert(order);
		
		Long count = 1L;
		for (int i = 0; i < productIdList.size(); i++) {
			OrderDetails orderDetails = new OrderDetails();
			
			orderDetails.setOrderId(order.getOrderId());
			orderDetails.setOrderDetailId(count);
			orderDetails.setProductId(productIdList.get(i));
			orderDetails.setPrice(priceList.get(i));
			orderDetails.setQuantity(quantityList.get(i));
			count++;
			
			orderDetailsMapper.insert(orderDetails);
		}
		
		return order;
	}

	public Long countOrderByStatus(int code) {
		OrdersExample example = new OrdersExample();
		example.createCriteria()
			.andStatusEqualTo(code);
		
		return ordersMapper.countByExample(example);
	}
	

	public void updateStatus(Orders orders) {
		Date date = new Date();
		Orders newOrders = findOrdersByOrderId(orders.getOrderId());
		
		if((orders.getStatus() == OrderStatus.TRANSPORT.getCode()) && (newOrders.getStatus() == OrderStatus.CONFIRMED.getCode())) {
			List<OrderDetails> orderDetails = findOrderDetailsByOrderId(orders.getOrderId());
			for (OrderDetails orderDetail : orderDetails) {
				Product product = productBean.findProductById(orderDetail.getProductId());
				product.setQuantity(product.getQuantity() - orderDetail.getQuantity());
				product.setUpdatedDate(date);
				
				productBean.updateProduct(product);
			}
		}
		
		if((orders.getStatus() == OrderStatus.CANCEL.getCode()) && (newOrders.getStatus() == OrderStatus.TRANSPORT.getCode())) {
			List<OrderDetails> orderDetails = findOrderDetailsByOrderId(orders.getOrderId());
			for (OrderDetails orderDetail : orderDetails) {
				Product product = productBean.findProductById(orderDetail.getProductId());
				product.setQuantity(product.getQuantity() + orderDetail.getQuantity());
				product.setUpdatedDate(date);
				
				productBean.updateProduct(product);
			}
		}
		
		newOrders.setStatus(orders.getStatus());
		newOrders.setUpdatedDate(date);
		
		ordersMapper.updateByPrimaryKey(newOrders);
	}
	
	//------------//
	
	public List<OrderDetails> findOrderDetailsByOrderId(String orderId) {
		OrderDetailsExample example = new OrderDetailsExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		
		return orderDetailsMapper.selectByExample(example);
	}
	
	public List<OrderDetailsForm> findOrderDetailsFormByOrderId(String orderId) {
		List<OrderDetailsForm> orderDetailsForms = new ArrayList<>();
		
		OrderDetailsExample example = new OrderDetailsExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		example.setOrderByClause("order_detail_id asc");
		
		List<OrderDetails> orderDetails = orderDetailsMapper.selectByExample(example);
		for (OrderDetails orderDetail : orderDetails) {
			OrderDetailsForm orderDetailsForm = new OrderDetailsForm();
			orderDetailsForm.setProduct(productBean.findProductById(orderDetail.getProductId()));
			orderDetailsForm.setPrice(orderDetail.getPrice());
			orderDetailsForm.setQuantity(orderDetail.getQuantity());
			
			orderDetailsForms.add(orderDetailsForm);
		}
		
		return orderDetailsForms;
	}

	public Long countRevenue() {
		Long revenue = 0L;
		
		OrdersExample example = new OrdersExample();
		example.createCriteria().andStatusEqualTo(OrderStatus.SUCCESS.getCode());
		List<Orders> orders = ordersMapper.selectByExample(example);
		for (Orders order : orders) {
			revenue += order.getTotalPrice();
		}
		
		return revenue;
	}
	
}
