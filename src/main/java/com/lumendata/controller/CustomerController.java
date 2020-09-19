package com.lumendata.controller;

import com.lumendata.model.publish.ListOfSwiPersonPublishIO;
import com.lumendata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/customer/{guid}/publish", produces = "application/json")
    public String publishMessage(@PathVariable("guid") String guid) {
         customerService.processMessage(guid);
         return guid;
    }
}
