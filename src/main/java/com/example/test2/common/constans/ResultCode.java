package com.example.test2.common.constans;

import com.example.test2.common.domain.GenericResponse;
import com.example.test2.common.domain.GenericStatus;

/**
 * Created by napat on 11/9/2017 AD.
 */
public enum ResultCode {

    SUCCESS(new GenericStatus("0","Success")),
    FAIL(new GenericStatus("5001","System Error")),
    NUMBER(new GenericStatus("1001","Invalid Number"));

    private GenericStatus genericStatus;

    ResultCode(GenericStatus genericStatus) {
        this.genericStatus = genericStatus;
    }

    public GenericStatus get(){
        return genericStatus;
    }
}
