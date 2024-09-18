package com.sadatscode.customerservice.controller;

import com.sadatscode.customerservice.dto.CustomerRequestDto;
import com.sadatscode.customerservice.dto.CustomerResponseDto;
import com.sadatscode.customerservice.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerServiceImpl service;

   @GetMapping
   public ResponseEntity<List<CustomerResponseDto>> getAllCustomers() {
       return ResponseEntity.ok(service.getAllCustomers());
   }

   @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Long id) {
       return ResponseEntity.ok(service.getCustomerById(id));
   }

   @PostMapping("/create")
   public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
       return ResponseEntity.ok(service.createCustomer(customerRequestDto));
   }

   @PutMapping("/{id}")
   public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequestDto customerRequestDto) {
       return  ResponseEntity.ok(service.updateCustomer(id,customerRequestDto));
   }

   @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable Long id) {
       service.deleteCustomerById(id);
   }
}
