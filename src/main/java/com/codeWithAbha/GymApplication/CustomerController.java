package com.codeWithAbha.GymApplication;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add-customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);

        return new ResponseEntity<>("customer added successfully", HttpStatus.CREATED);
    }


    @GetMapping("/get-student-by-id")
    public ResponseEntity<Customer> getCustomerByCustomerId(@RequestParam("id") Integer id){
        Customer c=customerService.getCustomerById(id);
        if(c!=null) {
            return new ResponseEntity<>(c, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-customer-by-name")
    public ResponseEntity<Customer> getCustomerByName(@RequestParam("name") String name){
        Customer c=customerService.getCustomerByName(name);

        if(c!=null) {
            return new ResponseEntity<>(c, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-customer-by-path/{id}")
    public ResponseEntity<Customer> getCustomerByPath(@RequestParam("id") Integer id){
        Customer c=customerService.getCustomerById(id);
        if(c!=null) {
            return new ResponseEntity<>(c, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-customer")
    public ResponseEntity<Customer> updateCustomer(@RequestParam Customer customer){
        Customer c=customerService.updateCustomer(customer);
        return new ResponseEntity<>(c,HttpStatus.OK);

    }

//    @DeleteMapping("delete-customer")
//    public ResponseEntity<String> deleteCustomer(@RequestParam("id") Integer id){
//
//        map.remove(id);
//        return new ResponseEntity<>("customer deleted successfully",HttpStatus.OK);
//    }
}
