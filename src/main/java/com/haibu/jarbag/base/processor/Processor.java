package com.haibu.jarbag.base.processor;


import com.haibu.jarbag.base.error.ApiError;
import io.vavr.control.Either;

public interface Processor<R extends ProcessorResult, I extends ProcessorInput> {

    Either<ApiError, R> process(I input);
}