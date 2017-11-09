package com.example.test2.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by napat on 11/8/2017 AD.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {

    private GenericStatus status;
    private Object data;

    public GenericResponse(GenericStatus status, Object data) {
        this.status = status;
        this.data = data;
    }

    public GenericResponse(GenericStatus status) {
        this.status = status;
    }

    public GenericResponse() {
    }
}
