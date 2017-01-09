package com.ycit.controller;

import com.ycit.bean.ApiResponse;

import java.util.List;

/**
 * Created by xlch on 2017/1/8.
 */
public class BaseController {

    public <E> ApiResponse<E> success(int toal, List<E> results) {
        ApiResponse<E> apiResponse = new ApiResponse<E>();
        apiResponse.setTotal(toal);
        apiResponse.setCode(200);
        apiResponse.setResults(results);
        return apiResponse;
    }

    public <E> ApiResponse<E> error(int code, String message) {
        ApiResponse<E> apiResponse = new ApiResponse<E>();
        apiResponse.setCode(code);
        apiResponse.setMessage(message);
        return apiResponse;
    }

}
