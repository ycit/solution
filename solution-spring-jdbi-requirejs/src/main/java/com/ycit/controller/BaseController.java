package com.ycit.controller;

import com.ycit.api.ApiResponse;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xlch on 2016/12/11.
 */
public class BaseController {

    public <T> ApiResponse<T> success(Integer total, List<T> results) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(200);
        response.setResults(results);
        response.setTotal(total);
        return response;
    }

    public <T> ApiResponse<T> error(Integer code, String message) {
        ApiResponse<T> response = new ApiResponse<T>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
}
