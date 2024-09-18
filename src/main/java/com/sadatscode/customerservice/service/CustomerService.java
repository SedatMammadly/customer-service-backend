package com.sadatscode.customerservice.service;

import com.sadatscode.customerservice.dto.CustomerRequestDto;
import com.sadatscode.customerservice.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDto> getAllCustomers();
    CustomerResponseDto getCustomerById(Long id);
    CustomerResponseDto createCustomer(CustomerRequestDto customerDto);
    CustomerResponseDto updateCustomer(Long id, CustomerRequestDto customerDto);
    void deleteCustomerById(Long id);
}
