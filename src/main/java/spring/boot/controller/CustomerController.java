package spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.entity.Customer;
import spring.boot.service.CustomerService;

@RestController
@RequestMapping("/cust")
public class CustomerController {

	
	private CustomerService customerService;
	@Autowired
	public CustomerController(CustomerService service) {
		this.customerService = service;
	}

	@GetMapping("/customers")
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@GetMapping("customers/{custId}")
	public Customer getCustomer(@PathVariable long custId) {
		Customer customer = customerService.findById(custId);
		if (customer == null) {
			throw new RuntimeException("customer not found with this id :" + custId);
		}
		return customer;
	}

	@PostMapping("/customers")
	@Transactional
	public Customer addCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}

	@PutMapping("/customers")
	@Transactional
	public Customer updateCustomer(@RequestBody Customer cust) {
		customerService.saveCustomer(cust);
		return cust;
	}

	@DeleteMapping("/customers/{custId}")
	public String deleteCustomer(@PathVariable long custId) {
		Customer customer = customerService.findById(custId);
		if (customer == null) {
			throw new RuntimeException("Customer ID not found :" + custId);
		}
		customerService.deleteCustomer(custId);
		return "Deleted Customer id : " + custId;
	}
}
