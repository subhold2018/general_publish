package com.lumendata.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumendata.model.Customer;
import com.lumendata.model.publish.ListOfSwiPersonPublishIOTopElmt;
import com.lumendata.provider.CustomerProvider;
import com.lumendata.transformation.CustomerTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    @Autowired
    CustomerProvider customerProvider;

    @Autowired
    CustomerTransformation customerTransformation;

    public void processMessage(String guid) {
        ObjectMapper objectMapper=new ObjectMapper();
        Customer customer =  customerProvider.findCustomerById(guid);
        ListOfSwiPersonPublishIOTopElmt listOfSwiPersonPublishIOTopElmt=
                customerTransformation.transform(customer);

    }
}
