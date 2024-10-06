package com.haibu.jarbag.rest.controllers;

import com.haibu.jarbag.api.operations.file.download.DownloadFile;
import com.haibu.jarbag.api.operations.file.download.DownloadFileInput;
import com.haibu.jarbag.api.operations.file.upload.UploadFile;
import com.haibu.jarbag.api.operations.file.upload.UploadFileInput;
import com.haibu.jarbag.rest.handler.ResponseHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.haibu.jarbag.api.config.RestApiRoutes.REPOSITORY;

@Controller
@RequiredArgsConstructor
public class File {
    private final ResponseHandler responseHandler;
    private final DownloadFile downloadFile;
    private final UploadFile uploadFile;


    @GetMapping(path = REPOSITORY, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public ResponseEntity<?> downloadFile(HttpServletRequest request, HttpServletResponse response) {
        DownloadFileInput input = DownloadFileInput
                .builder()
                .uri(request.getRequestURI())
                .build();

        return responseHandler.handle(downloadFile.process(input), response);
    }

    @PutMapping(value = REPOSITORY)
    public ResponseEntity<?> uploadFile(@RequestBody byte[] content, HttpServletRequest request, HttpServletResponse response) {

        UploadFileInput input = UploadFileInput
                .builder()
                .uri(request.getRequestURI())
                .content(content)
                .build();

        return responseHandler.handle(uploadFile.process(input), response);
    }
}
