package com.haibu.jarbag.base.error;

import com.haibu.jarbag.api.errors.Errors;
import org.springframework.http.HttpStatus;

public interface ApiError {

    HttpStatus getStatus();

    Errors getErrors();

    String getReasonPhrase();
}