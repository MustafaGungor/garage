package com.vodafone.garage.model;

import java.util.List;

public class GarageResponse {
    private List<String> output;
    private String message;

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
