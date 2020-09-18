package com.lumendata.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResp {
    private String guid;
    private String sentTopic;
    private Map<String, String> nextFlow;
    private String sourceId;
    private String source;
    private List<String> mergeNodeIds;
}
