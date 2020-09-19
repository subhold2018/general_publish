package com.lumendata.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumendata.model.*;
import com.lumendata.model.publish.ListOfSwiPersonPublishIO;
import com.lumendata.model.publish.ListOfSwiPersonPublishIOTopElmt;
import com.lumendata.provider.CustomerProvider;
import com.lumendata.repository.CustomerRepository;
import com.lumendata.transformation.CustomerTransformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Stream;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@Component
@Slf4j
public class CustomerService {

    @Autowired
    CustomerProvider customerProvider;

    @Autowired
    CustomerTransformation customerTransformation;

    @Autowired
    CustomerRepository customerRepository;

    public void processMessage(String guid) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        Map<String,String> guidMap=new HashMap<>();
        guidMap.put("guid",guid);
        try {
            Stream<LinkedHashMap> respStream = customerRepository.searchCustomer(guidMap);
            LinkedHashMap hashMap = respStream.findFirst().get();
            CustomerSearchResponse customerSearchResponse = objectMapper.convertValue(
                    hashMap, CustomerSearchResponse.class);
            Customer customer=new Customer();
            if(null!=customerSearchResponse.getSearchData().get("primaryData")){
                customerSearchResponse.getSearchData().get("primaryData").forEach(mapData->{
                    PrimaryData primaryData=objectMapper.convertValue(mapData,PrimaryData.class);
                    customer.setPrimaryData(primaryData);
                });
            }
            if(null!=customerSearchResponse.getSearchData().get("sourceData")){
                customerSearchResponse.getSearchData().get("sourceData").forEach(mapData->{
                    Source source=objectMapper.convertValue(mapData, Source.class);
                    customer.setSource(source);
                });
            }
            if(null!=customerSearchResponse.getSearchData().get("emailData")){
                List<Email> emails=new ArrayList<>();
                customerSearchResponse.getSearchData().get("emailData").forEach(mapData->{
                    Email email=objectMapper.convertValue(mapData, Email.class);
                    emails.add(email);
                });
                customer.setEmails(emails);
            }
            if(null!=customerSearchResponse.getSearchData().get("nameData")){
                List<Name> names=new ArrayList<>();
                customerSearchResponse.getSearchData().get("nameData").forEach(mapData->{
                    Name name=objectMapper.convertValue(mapData, Name.class);
                    names.add(name);
                });
                customer.setNames(names);
            }
            if(null!=customerSearchResponse.getSearchData().get("phoneData")){
                List<Phone> phones=new ArrayList<>();
                customerSearchResponse.getSearchData().get("phoneData").forEach(mapData->{
                    Phone phone=objectMapper.convertValue(mapData, Phone.class);
                    phones.add(phone);
                });
                customer.setPhones(phones);
            }
            if(null!=customerSearchResponse.getSearchData().get("addressData")){
                List<Address> addresses=new ArrayList<>();
                customerSearchResponse.getSearchData().get("addressData").forEach(mapData->{
                    Address address=objectMapper.convertValue(mapData, Address.class);
                    addresses.add(address);
                });
                customer.setAddresses(addresses);
            }
            if(null!=customerSearchResponse.getSearchData().get("affiliationData")){
                List<Affiliation> affiliations=new ArrayList<>();
                customerSearchResponse.getSearchData().get("affiliationData").forEach(mapData->{
                    Affiliation affiliation=objectMapper.convertValue(mapData, Affiliation.class);
                    affiliations.add(affiliation);
                });
                customer.setAffiliations(affiliations);
            }
            if(null!=customerSearchResponse.getSearchData().get("identificationData")){
                List<Identification> identifications=new ArrayList<>();
                customerSearchResponse.getSearchData().get("identificationData").forEach(mapData->{
                    Identification identification=objectMapper.convertValue(mapData, Identification.class);
                    identifications.add(identification);
                });
                customer.setIdentifications(identifications);
            }
            ListOfSwiPersonPublishIO listOfSwiPersonPublishIO= customerTransformation.transform(customer);

        }catch (Exception exception){
            log.error("Error while searching customer-data with guid={}",guid);
        }
    }

}
