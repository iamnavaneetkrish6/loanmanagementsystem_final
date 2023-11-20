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

import com.hexaware.loanmanagementsystem.dto.CustomerLoanInformationDTO;
import com.hexaware.loanmanagementsystem.entity.CustomerLoanInformation;
import com.hexaware.loanmanagementsystem.service.ICustomerLoanInformationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/customer-loan-information/")
public class CustomerLoanInformationRestController {

	@Autowired
	private ICustomerLoanInformationService customerLoanInformationService;
	
	@PostMapping(value = "/addcustomerloaninformation", consumes = "application/json", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public CustomerLoanInformation createCustomerAccountDetails(@RequestBody @Valid CustomerLoanInformationDTO customerLoanInformationDto) {

		return customerLoanInformationService.createCustomerLoanInformation(customerLoanInformationDto);
	}

	@PutMapping(value = "/updatecustomerloaninformation", consumes = "application/json", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public CustomerLoanInformation updateCustomerAccountDetails(@RequestBody @Valid CustomerLoanInformationDTO customerLoanInformationDto) {

		return customerLoanInformationService.updateCustomerLoanInformation(customerLoanInformationDto);
	}

	@DeleteMapping(value = "/deletecustomerloaninformation/{ID}", consumes = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public ResponseEntity<String> deleteCustomerLoanInformationById(@PathVariable long ID) {
		customerLoanInformationService.deleteCustomerLoanInformation(ID);

		return new ResponseEntity<>("Customer loan information deleted sucessfully", HttpStatus.ACCEPTED);	}

	@GetMapping(value = "/getbycustomerloaninformationid/{loanNumber}", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public CustomerLoanInformation getCustomerLoanInformationByLoanNumber(@PathVariable long loanNumber) {

		return customerLoanInformationService.getCustomerLoanInformationById(loanNumber);
	}

	@GetMapping(value = "/getAllcustomerloaninformation", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public List<CustomerLoanInformation> getAllAdmin() {

		return customerLoanInformationService.getAllCustomerLoanInformation();
	}
	
	
}
