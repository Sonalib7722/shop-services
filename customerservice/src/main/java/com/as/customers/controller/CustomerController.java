package com.as.customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.as.customers.model.Customers;
import com.as.customers.repos.CustomerRepository;


@RestController
@RequestMapping(value="/customerapi")
public class CustomerController {

	@Autowired
	CustomerRepository repository;
	
	@RequestMapping(value="/getcustomers",method=RequestMethod.GET)
	public List<Customers> getCustomerList() {
		return repository.findAll();
	}

	@RequestMapping(value="/addcustomer",method=RequestMethod.POST)
	public Customers addCustomers(@RequestBody Customers certifications) {
		return repository.save(certifications);
	}
	
	@RequestMapping(value="/getcustomerdetails/{customerid}",method=RequestMethod.GET)
	public Customers getCustomerdetails(@PathVariable String customerid) {
		return repository.findById(customerid).get();
	}
}
