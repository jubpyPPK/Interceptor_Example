package com.example.test2.common.domain;

/**
 * Created by napat on 11/8/2017 AD.
 */
public class ResponseModel {

    private Status status;
    private Object data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
