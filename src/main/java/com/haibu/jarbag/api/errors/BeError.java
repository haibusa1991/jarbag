package com.haibu.jarbag.api.errors;

import com.haibu.jarbag.base.error.ApiError;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Builder
@Getter
public class BeError implements ApiError {
    private final HttpStatus status;
    private final Errors errors;
    private final String reasonPhrase;

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public Errors getErrors() {
        return errors;
    }

    @Override
    public String getReasonPhrase() {
        return reasonPhrase;
    }
}
