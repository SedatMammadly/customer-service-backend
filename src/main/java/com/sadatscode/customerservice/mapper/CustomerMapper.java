package com.sadatscode.customerservice.mapper;

import com.sadatscode.customerservice.dto.CustomerRequestDto;
import com.sadatscode.customerservice.dto.CustomerResponseDto;
import com.sadatscode.customerservice.model.Customer;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper {
   private final ModelMapper mapper = new ModelMapper();

    public CustomerResponseDto CustomerToCustomerResponseDto(Customer customer){
     return mapper.map(customer, CustomerResponseDto.class);
    }
    public List<CustomerResponseDto> toCustomerResponseDtoList(List<Customer> customers){
        return customers.stream().map(customer-> mapper.map(customer,CustomerResponseDto.class)).toList();
    }
    public Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerDto){
     return mapper.map(customerDto, Customer.class);
    }
    public void updateCustomerFromDto(CustomerRequestDto customerDto, Customer customer) {
        mapper.map(customerDto, customer);
    }
}
