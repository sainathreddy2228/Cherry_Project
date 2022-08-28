package spring.boot.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import spring.boot.entity.Customer;

@Transactional
public interface CustomerService {

	List<Customer> findAll();
	Customer findById(long id);
	void saveCustomer(Customer cust);
	void deleteCustomer(long id);
}
