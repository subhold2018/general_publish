package com.lumendata.provider;

import com.lumendata.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerProvider {

    public Customer findCustomerById(String guid){
        Customer customer=new Customer();
        return customer;
    }
}
