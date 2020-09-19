package com.lumendata.repository;

import com.lumendata.model.CustomerSearchResponse;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

@Repository
public interface CustomerRepository extends org.springframework.data.repository.Repository<CustomerSearchResponse, Long> {
    @Query(value = "CALL curation.customer.search($0)")
    Stream<LinkedHashMap> searchCustomer(Map<String, String> customer);
}
