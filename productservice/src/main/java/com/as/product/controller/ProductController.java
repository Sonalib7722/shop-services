package com.as.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.as.product.model.Products;
import com.as.product.repos.ProductRepository;

@RestController
@RequestMapping(value="/productapi")
@CrossOrigin
public class ProductController {
	@Autowired
	ProductRepository repository;
	
	@RequestMapping(value="/getproducts",method=RequestMethod.GET)
	public List<Products> getCertificationsList() {
		return repository.findAll();
	}

	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public Products saveCertifications(@RequestBody Products certifications) {
		return repository.save(certifications);
	}
	
	@RequestMapping(value="/getproductdetails/{productid}",method=RequestMethod.GET)
	public Products getCertificationdetails(@PathVariable String productid) {
		return repository.findById(productid).get();
	}
}
