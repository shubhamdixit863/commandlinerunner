package com.commandlinerunner.commandlinerunner.models;

import java.util.List;

public class Response {

    private String message;


    private List<String> data;

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
