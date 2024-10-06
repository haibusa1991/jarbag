package com.haibu.jarbag.rest.handler;

import com.haibu.jarbag.api.operations.file.download.DownloadFileResult;
import com.haibu.jarbag.base.error.ApiError;
import io.vavr.control.Either;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResponseHandler {
    private final ExchangeAccessor exchangeAccessor;

    public ResponseEntity<?> handle(Either<ApiError, ?> processorResult, HttpServletResponse response) {
        return handle(processorResult, response, HttpStatus.OK);
    }

    public ResponseEntity<?> handle(Either<ApiError, ?> processorResult, HttpServletResponse response, HttpStatus status) {
        if (processorResult.isLeft()) {
            return this.handleError(processorResult, response);
        }

        if (processorResult.get() instanceof DownloadFileResult result) {

            ContentDisposition attachment = ContentDisposition
                    .attachment()
                    .filename(result.getFilename())
                    .build();

            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, attachment.toString());

            return new ResponseEntity<>(result.getContent(), HttpStatus.OK);
        }

        return new ResponseEntity<>(processorResult.get(), status);
    }

    private ResponseEntity<?> handleError(Either<ApiError, ?> processorResult, HttpServletResponse response) {
        ApiError error = processorResult.getLeft();

        exchangeAccessor
                .getExchange(response)
                .setReasonPhrase(error.getReasonPhrase());

        if (response.getContentType() == null) {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        }

        return ResponseEntity
                .status(error.getStatus())
                .body(error.getErrors());
    }
}
