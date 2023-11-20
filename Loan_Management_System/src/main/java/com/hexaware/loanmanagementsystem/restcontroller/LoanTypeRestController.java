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

import com.hexaware.loanmanagementsystem.dto.LoanTypeDTO;
import com.hexaware.loanmanagementsystem.entity.LoanType;
import com.hexaware.loanmanagementsystem.service.ILoanTypesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/loan-type/")
public class LoanTypeRestController {

	@Autowired
	private ILoanTypesService loanTypesService;
	
	@PostMapping(value = "/addloantype", consumes = "application/json", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public LoanType createCustomerAccountDetails(@RequestBody @Valid LoanTypeDTO loanTypeDto) {

		return loanTypesService.createLoanType(loanTypeDto);
	}

	@PutMapping(value = "/updateloantype", consumes = "application/json", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public LoanType updateCustomerAccountDetails(@RequestBody @Valid LoanTypeDTO loanTypeDto) {

		return loanTypesService.updateLoanType(loanTypeDto);
	}

	@DeleteMapping(value = "/deleteloantype/{ID}", consumes = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public ResponseEntity<String> deleteLoanType(@PathVariable long ID) {
		loanTypesService.deleteLoanTypeById(ID);

		return new ResponseEntity<>("Customer loan information deleted sucessfully", HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/getbyloantypeid/{id}", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public LoanType getcustomerAccountDetailsByCustomerId(@PathVariable int id) {

		return loanTypesService.getLoanTypeById(id);
	}

	@GetMapping(value = "/getAllloantype", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public List<LoanType> getAllAdmin() {

		return loanTypesService.getAllLoanType();
	}
}
