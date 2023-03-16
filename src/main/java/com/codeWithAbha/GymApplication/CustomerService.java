package com.codeWithAbha.GymApplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public String addCustomer(Customer customer){
       String res=customerRepository.createCustomer(customer);
       return res;
    }

    public Customer getCustomerById(int id){
       Customer c= customerRepository.getCustomerById(id);
        return c;
    }

    public Customer getCustomerByName(String name){
        Customer c=customerRepository.getCustomerByName(name);
        return c;
    }

    public Customer updateCustomer(Customer customer){
       Customer c= customerRepository.updateCustomer(customer);
       return c;
    }
}
