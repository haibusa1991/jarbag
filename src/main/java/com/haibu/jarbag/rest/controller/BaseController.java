package com.haibu.jarbag.rest.controller;

import com.haibu.jarbag.base.error.ApiError;
import com.haibu.jarbag.rest.config.ExchangeAccessor;
import io.undertow.server.HttpServerExchange;
import io.vavr.control.Either;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {
    @Setter
    private ExchangeAccessor exchangeAccessor;

    public ResponseEntity<?> handle(Either<ApiError, ?> processorResult, HttpServletResponse response) {
        return processorResult.isLeft()
                ? this.handleError(processorResult, response)
                : new ResponseEntity<>(processorResult.get(), HttpStatus.OK);
    }

    public ResponseEntity<?> handle(Either<ApiError, ?> processorResult, HttpServletResponse response, HttpStatus status) {
        return processorResult.isLeft()
                ? this.handleError(processorResult, response)
                : new ResponseEntity<>(processorResult.get(), status);
    }

    private ResponseEntity<?> handleError(Either<ApiError, ?> processorResult, HttpServletResponse response) {
        ApiError error = processorResult.getLeft();
        HttpServerExchange exchange = this.exchangeAccessor.getExchange(response);

        exchange.setReasonPhrase(error.getReasonPhrase());

        return ResponseEntity
                .status(error.getStatus())
                .body(error.getErrors());
    }

}
