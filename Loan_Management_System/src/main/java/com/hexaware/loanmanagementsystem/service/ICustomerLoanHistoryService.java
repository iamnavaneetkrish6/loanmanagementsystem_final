package com.hexaware.loanmanagementsystem.service;

import java.util.List;

import com.hexaware.loanmanagementsystem.entity.CustomerLoanInformation;

public interface ICustomerLoanHistoryService{

	public List<CustomerLoanInformation> getCustomerLoanHistoryByCusmtomerName(String customerName);

}
