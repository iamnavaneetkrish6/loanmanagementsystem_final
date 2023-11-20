package com.hexaware.loanmanagementsystem.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.loanmanagementsystem.dto.CustomerDetailsDTO;
import com.hexaware.loanmanagementsystem.entity.CustomerDetails;
import com.hexaware.loanmanagementsystem.service.ICustomerDetailsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/customer-details/")
public class CustomerDetailsRestController {

	@Autowired
	ICustomerDetailsService customerDetailsService;

	@PostMapping(value = "/addcustomer-detail", consumes = "application/json", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public CustomerDetails createCustomerAccountDetails(@RequestBody @Valid CustomerDetailsDTO customerDetailsDto) {

		return customerDetailsService.customerRegisteration(customerDetailsDto);
	}

	@PutMapping(value = "/updatecustomer-detail", consumes = "application/json", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public CustomerDetails updateCustomerAccountDetails(@RequestBody @Valid CustomerDetailsDTO customerDetailsDto) {

		return customerDetailsService.updateCustomerDetails(customerDetailsDto);
	}

	@DeleteMapping(value = "/deletecustomer-detail/{ID}", consumes = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public ResponseEntity<String> deleteCustomerAcountDetails(@PathVariable long ID) {
		customerDetailsService.deleteCustomer(ID);

		return new ResponseEntity<>("Customer details deleted sucessfully", HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/getbycustomer-detailid/{id}", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public CustomerDetails getcustomerAccountDetailsByCustomerId(@PathVariable int id) {

		return customerDetailsService.getCustomerDetailsById(id);
	}

	@GetMapping(value = "/getAllcustomer-detail", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public List<CustomerDetails> getAllAdmin() {

		return customerDetailsService.getAllCustomerDetails();
	}

}
