package com.as.orders.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.as.orders.dto.Customers;
import com.as.orders.dto.Products;
import com.as.orders.model.Orders;
import com.as.orders.repos.OrderRepository;

@RestController
@RequestMapping(value = "/ordersapi")
public class OrderController {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${productservice.url}")
	private String productServiceUrl;
	
	@Value("${customerservice.url}")
	private String customerServiceUrl;
	
	@RequestMapping(value = "/placeorder",method=RequestMethod.POST)
	public Orders placeOrder(@RequestBody Orders orders) {
		System.out.println("productServiceUrl--->"+productServiceUrl);
		System.out.println("customerServiceUrl--->"+customerServiceUrl);
		Products products=restTemplate.getForObject(productServiceUrl+orders.getProductid(), Products.class);
		orders.setCost(products.getPrice());
		orders.setSupplierid(products.getSupplierid());
		Customers customers=restTemplate.getForObject(customerServiceUrl+orders.getCustomerid(), Customers.class);
		orders.setCustmobilenumber(customers.getMobilenumber());
		//StringBuffer finalAddress=new StringBuffer();
		//finalAddress=finalAddress.append(customers.getAddressline1()).append(customers.getAddressline2()).append(customers.getCity()).append(customers.getState()).append(customers.getZipcode());
		orders.setDeliverylocation("finalAddress");
		orders.setEmail(customers.getEmail());
		return repository.save(orders);
		
	}
	
	@RequestMapping(value = "/getorderlist",method=RequestMethod.GET)
	public List<Orders> getOrders() {
		return repository.findAll();
		
	}
}
