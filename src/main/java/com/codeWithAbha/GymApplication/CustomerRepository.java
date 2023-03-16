package com.codeWithAbha.GymApplication;


import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class CustomerRepository {
    public HashMap<Integer,Customer> map= new HashMap<>();

    public  String createCustomer(Customer customer){
        int key= customer.id;
        map.put(key,customer);
        return "customer added Successfully";
    }

    public  Customer getCustomerById(int id){
        if(map.containsKey(id))
            return map.get(id);
        else
            return null;
    }
    public  Customer getCustomerByName(String cust_name){
        for(Customer c: map.values()){
            if(c.name.equals(cust_name))
                return c;
        }
        return null;
    }

    public  Customer updateCustomer(Customer customer){
       Customer c=map.put(customer.id, customer);
       return c;
    }


}
