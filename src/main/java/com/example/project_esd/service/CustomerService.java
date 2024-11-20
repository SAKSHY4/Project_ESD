package com.example.project_esd.service;

import com.example.project_esd.dto.CustomerRequest;
import com.example.project_esd.dto.CustomerResponse;
import com.example.project_esd.dto.LoginRequest;
import com.example.project_esd.entity.Customer;
import com.example.project_esd.exception.CustomerNotFoundException;
import com.example.project_esd.helper.EncryptionService;
import com.example.project_esd.helper.JWTHelper;
import com.example.project_esd.mapper.CustomerMapper;
import com.example.project_esd.repo.CustomerRepo;
import com.example.project_esd.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Optional;

import static java.lang.String.format;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;
    public String createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toCustomer(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        customerRepo.save(customer);
        return "Customer Created Successfully";
    }

    public Customer getCustomer(String email) {
        return customerRepo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
                ));
    }

    public CustomerResponse retrieveCustomer(String email) {
        Customer customer = getCustomer(email);
        return CustomerMapper.toCustomerResponse(customer);
    }
    public String login(LoginRequest request) {
        Customer customer = getCustomer(request.email());
        System.out.println(request.password());
        System.out.println(customer.getEmail());
        if(!encryptionService.validates(request.password(), customer.getPassword())) {

            return "Wrong Password or Email";
        }
        String token = jwtHelper.generateToken(customer.getEmail());
        System.out.println(token);
        return token;
    }

}
