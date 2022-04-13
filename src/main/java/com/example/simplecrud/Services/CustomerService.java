package com.example.simplecrud.Services;

import com.example.simplecrud.Entity.CustomerEntity;
import com.example.simplecrud.Repositories.CustomerEntityRepository;
import com.example.simplecrud.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerEntityRepository customerEntityRepository;

    public Customer customerService(Customer customer){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(0L);
        customerEntity.setName(customer.getName());
        customerEntity.setMobileNumber(customer.getMobileNumber());
        customerEntity.setAge(customer.getAge());
        customerEntity.setEmail(customer.getEmail());
        CustomerEntity customerEntityResult = customerEntityRepository.save(customerEntity);

        Customer customer1 = new Customer();
        customer1.setId(customerEntityResult.getId());
        customer1.setMobileNumber(customerEntityResult.getMobileNumber());
        customer1.setName(customerEntityResult.getName());
        customer1.setAge(customerEntityResult.getAge());
        customer1.setEmail(customerEntityResult.getEmail());

        return customer1;
    }
    public List<Customer> CustomerGet(){
        List<CustomerEntity> customerEntityList = customerEntityRepository.findAll();
        ArrayList<Customer> customersList = new ArrayList<>();
        customerEntityList.forEach(customerEntity -> {
            Customer customer = new Customer();
            customer.setId(customerEntity.getId());
            customer.setMobileNumber(customerEntity.getMobileNumber());
            customer.setName(customerEntity.getName());
            customer.setAge(customerEntity.getAge());
            customer.setEmail(customerEntity.getEmail());
            customersList.add(customer);
        });
        return customersList;
    }
    public  Customer CustomerGetId(Long id){
        CustomerEntity customerEntity = customerEntityRepository.getById(id);

                Customer customer = new Customer();
                customer.setId(id);
                customer.setMobileNumber(customerEntity.getMobileNumber());
                customer.setName(customerEntity.getName());
                customer.setAge(customerEntity.getAge());
                customer.setEmail(customerEntity.getEmail());
            return customer;
    }
   public Customer customerUpdate(Customer customer,Long id){
       CustomerEntity customerEntity = new CustomerEntity();
       customerEntity.setId(id);
       customerEntity.setName(customer.getName());
       customerEntity.setMobileNumber(customer.getMobileNumber());
       customerEntity.setAge(customer.getAge());
       customerEntity.setEmail(customer.getEmail());
       CustomerEntity customerEntityResult = customerEntityRepository.save(customerEntity);

       Customer customer1 = new Customer();
       customer1.setId(customerEntityResult.getId());
       customer1.setMobileNumber(customerEntityResult.getMobileNumber());
       customer1.setName(customerEntityResult.getName());
       customer1.setAge(customerEntityResult.getAge());
       customer1.setEmail(customerEntityResult.getEmail());

       return customer1;
   }
   public void customerDeleteId(Long id) {
            customerEntityRepository.deleteById(id);
   }
   public void customerDeleteAll(){
        customerEntityRepository.deleteAll();
   }
}