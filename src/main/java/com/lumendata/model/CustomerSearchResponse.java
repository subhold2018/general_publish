package com.lumendata.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CustomerSearchResponse {
    public String guid;
    public Map<String, List<Map<String, String>>> searchData;
}
