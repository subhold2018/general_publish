package com.lumendata.model;

import lombok.Builder;
import lombok.Data;

@Data
public class PayloadMapper {
    private String payload;
    private String topicName;
}
