package com.haibu.jarbag.core.processors;

import com.haibu.jarbag.api.operations.hello.Greeting;
import com.haibu.jarbag.api.operations.hello.GreetingInput;
import com.haibu.jarbag.api.operations.hello.GreetingResult;
import com.haibu.jarbag.base.error.ApiError;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

@Component
public class GreetingOperation implements Greeting {
    @Override
    public Either<ApiError, GreetingResult> process(GreetingInput input) {
        return Either.right(GreetingResult.builder().greeting("Hello, World!").build());
    }
}
