package com.haibu.jarbag.core;

import com.haibu.jarbag.api.errors.BeError;
import com.haibu.jarbag.api.errors.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotImplementedErrorSupplier {
    private final String ERROR_MESSAGE = "Custom not implemented message";
    private final String REASON_PHRASE = "Custom not implemented reason phrase";

    public BeError supplyError() {

        return BeError
                .builder()
                .errors(Errors.builder().errors(List.of(ERROR_MESSAGE)).build())
                .reasonPhrase(REASON_PHRASE)
                .status(HttpStatus.NOT_IMPLEMENTED)
                .build();
    }
}
