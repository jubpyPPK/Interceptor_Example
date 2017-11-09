package com.example.test2.common.domain;

import lombok.Data;

/**
 * Created by napat on 11/7/2017 AD.
 */
@Data
public class GenericStatus {

    private String code;
    private String message;

    public GenericStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public GenericStatus() {
    }
}
