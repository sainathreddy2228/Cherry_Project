package spring.boot.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.entity.Customer;
import spring.boot.repository.CustomerJpaRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	CustomerJpaRepository customerRepository;
    
	//  constructor injection
	@Autowired
	public CustomerServiceImpl(CustomerJpaRepository custRepo) {
		this.customerRepository = custRepo;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(long id) {
		Customer customer = null;
		Optional<Customer> optionalCust = customerRepository.findById(id);
		if (optionalCust.isPresent()) {
			customer = optionalCust.get();
		} else {
			throw new RuntimeException("Did not find Customer id :" + id);
		}
		return customer;
	}

	@Override
	public void saveCustomer(Customer cust) {
		customerRepository.save(cust);

	}

	@Override
	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}
}
