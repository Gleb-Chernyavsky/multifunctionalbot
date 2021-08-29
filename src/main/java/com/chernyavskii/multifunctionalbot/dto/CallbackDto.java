package com.chernyavskii.multifunctionalbot.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class CallbackDto {
    private String type;
    @JsonProperty(value = "object")
    private Map<String, Map<String, Object>> operationData;
    @JsonProperty(value = "group_id")
    private Long groupId;
    private String secret;
    @JsonProperty(value = "event_id")
    private String eventId;

    public CallbackDto(String type, Map<String, Map<String, Object>> operationData, Long groupId, String secret, String eventId) {
        this.type = type;
        this.operationData = operationData;
        this.groupId = groupId;
        this.secret = secret;
        this.eventId = eventId;
    }

    public CallbackDto() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Map<String, Object>> getOperationData() {
        return operationData;
    }

    public void setOperationData(Map<String, Map<String, Object>> operationData) {
        this.operationData = operationData;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

}
