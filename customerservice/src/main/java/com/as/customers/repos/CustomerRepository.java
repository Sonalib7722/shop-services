package com.as.customers.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.customers.model.Customers;

public interface CustomerRepository extends JpaRepository<Customers, String> {

}
