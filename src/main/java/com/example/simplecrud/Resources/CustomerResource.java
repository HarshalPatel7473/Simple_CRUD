package com.example.simplecrud.Resources;

import com.example.simplecrud.Services.CustomerService;
import com.example.simplecrud.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Api/")
public class CustomerResource {
    @Autowired
    CustomerService customerService;
    @PostMapping("customer")
    public ResponseEntity<Customer> Customer(@RequestBody Customer customer){
        System.out.println("Customer:"+ customer);
        Customer customerResourceResult1 = customerService.customerService(customer);

        return ResponseEntity.ok().body(customerResourceResult1);
    }
    @GetMapping("customer")
    public ResponseEntity<List<Customer>> Customer(){
        List<Customer> customer = customerService.CustomerGet();
        return ResponseEntity.ok().body(customer);
    }
   @GetMapping("customer/{id}")
    public ResponseEntity<Customer> CustomerId(@PathVariable Long id){
        Customer customer = customerService.CustomerGetId(id);
        return ResponseEntity.ok().body(customer);
    }
  @PutMapping("customer/{id}")
  public ResponseEntity<Customer> CustomerUpdate(@RequestBody Customer customer,
                                                 @PathVariable("id") Long id){
      System.out.println("Customer:"+ customer);
      System.out.println("id:"+ id);
      Customer customerResourceResult1 = customerService.customerUpdate(customer,id);

      return ResponseEntity.ok().body(customerResourceResult1);
  }
    @DeleteMapping("customer/{id}")
    public void customerDeleteId( @PathVariable("id") Long id){
        customerService.customerDeleteId(id);
  }
    @DeleteMapping("customer")
    public void customerDeleteId(){
        customerService.customerDeleteAll();
    }
}