package com.haibu.jarbag.rest.controller;

import com.haibu.jarbag.api.operations.hello.Greeting;
import com.haibu.jarbag.api.operations.hello.GreetingInput;
import com.haibu.jarbag.rest.config.ExchangeAccessor;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController extends BaseController {
    private final ExchangeAccessor exchangeAccessor;
    private final Greeting greeting;

    @PostConstruct
    public void init() {
        super.setExchangeAccessor(exchangeAccessor);
    }

    @GetMapping("/hello")
    public ResponseEntity<?> hello(HttpServletResponse response) {
        return handle(greeting.process(GreetingInput.builder().build()), response);
    }
}
