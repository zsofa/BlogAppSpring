package com.example.BlogAppSpring.returnModel;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter @Setter
public class ReturnModel <T>{

    private boolean success;
    private HttpStatus httpStatus;

    private T object;
    private List<T> objectsList;

    public ReturnModel(boolean success, HttpStatus httpStatus) {
        this.success = true;
        this.httpStatus = httpStatus;
    }

    public ReturnModel(boolean success, HttpStatus httpStatus, T object) {
        this.success = success;
        this.httpStatus = httpStatus;
        this.object = object;
    }

    public ReturnModel(boolean success, HttpStatus httpStatus, List<T> objectsList) {
        this.success = success;
        this.httpStatus = httpStatus;
        this.objectsList = objectsList;
    }
}
