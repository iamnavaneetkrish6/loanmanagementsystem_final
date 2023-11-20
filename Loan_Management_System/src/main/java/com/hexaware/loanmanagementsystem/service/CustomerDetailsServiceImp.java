package com.hexaware.loanmanagementsystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.loanmanagementsystem.dto.CustomerDetailsDTO;
import com.hexaware.loanmanagementsystem.entity.CustomerDetails;
import com.hexaware.loanmanagementsystem.exception.CustomerAccountDetailsNotFoundException;
import com.hexaware.loanmanagementsystem.exception.CustomerDetailsNotFoundException;
import com.hexaware.loanmanagementsystem.repository.CustomerDetailsRepository;

@Service
public class CustomerDetailsServiceImp implements ICustomerDetailsService {

	@Autowired
	CustomerDetailsRepository customerDetailsRepository;

	Logger logger = LoggerFactory.getLogger(CustomerDetailsServiceImp.class);
	
	@Override
	public CustomerDetails customerRegisteration(CustomerDetailsDTO customer) {

		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setCustomerName(customer.getCustomerName());
		customerDetails.setCustomerUsername(customer.getCustomerUsername());
		customerDetails.setCustomerPassword(customer.getCustomerPassword());
		customerDetails.setCustomerAddress(customer.getCustomerAddress());
		customerDetails.setCustomerState(customer.getCustomerState());
		customerDetails.setCustomerState(customer.getCustomerState());
		customerDetails.setCustomerCountry(customer.getCustomerCountry());
		customerDetails.setCustomerEmailId(customer.getCustomerEmailId());

		return customerDetailsRepository.save(customerDetails);
	}

	@Override
	public CustomerDetails updateCustomerDetails(CustomerDetailsDTO customer) {
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setCustomerId(customer.getCustomerId());
		customerDetails.setCustomerName(customer.getCustomerName());
		customerDetails.setCustomerUsername(customer.getCustomerUsername());
		customerDetails.setCustomerPassword(customer.getCustomerPassword());
		customerDetails.setCustomerAddress(customer.getCustomerAddress());
		customerDetails.setCustomerState(customer.getCustomerState());
		customerDetails.setCustomerState(customer.getCustomerState());
		customerDetails.setCustomerCountry(customer.getCustomerCountry());
		customerDetails.setCustomerEmailId(customer.getCustomerEmailId());

		return customerDetailsRepository.save(customerDetails);
	}

	@Override
	public void deleteCustomer(long customerId) {

		customerDetailsRepository.deleteById(customerId);

	}

	@Override
	public CustomerDetails getCustomerDetailsById(long customerId) {

		return customerDetailsRepository.findById(customerId)
				.orElseThrow(()->new CustomerAccountDetailsNotFoundException(HttpStatus.NOT_FOUND, "No Customer  details linked with customer Id " + customerId + " found"));
	}

	@Override
	public List<CustomerDetails> getAllCustomerDetails() {

		List<CustomerDetails> customerDetails = customerDetailsRepository.findAll();
		
		if( customerDetails.isEmpty()) {
			throw new CustomerDetailsNotFoundException(HttpStatus.NOT_FOUND, "Customerdetails not found ");
		}
		
		return customerDetails;
	}

}
