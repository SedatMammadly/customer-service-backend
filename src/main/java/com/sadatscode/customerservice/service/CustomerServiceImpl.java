package com.sadatscode.customerservice.service;

import com.sadatscode.customerservice.dto.CustomerRequestDto;
import com.sadatscode.customerservice.dto.CustomerResponseDto;
import com.sadatscode.customerservice.mapper.CustomerMapper;
import com.sadatscode.customerservice.model.Customer;
import com.sadatscode.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers = repository.findAll();
        return mapper.toCustomerResponseDtoList(customers);
    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) {
        Customer customer = repository.findById(id).orElse(null);
        if(customer == null) {
            return null;
        }
        return mapper.CustomerToCustomerResponseDto(customer);
    }

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto customerDto) {
       Customer customer = mapper.CustomerRequestDtoToCustomer(customerDto);
       Customer saveCustomer= repository.save(customer);
       return mapper.CustomerToCustomerResponseDto(saveCustomer);
    }


    @Override
    public CustomerResponseDto updateCustomer(Long id, CustomerRequestDto customerRequestDto) {
        Customer customer = repository.findById(id).orElseThrow(()-> new NullPointerException("customer not found"));
         mapper.updateCustomerFromDto(customerRequestDto,customer);
         repository.save(customer);
        return mapper.CustomerToCustomerResponseDto(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
     repository.deleteById(id);
    }
}
