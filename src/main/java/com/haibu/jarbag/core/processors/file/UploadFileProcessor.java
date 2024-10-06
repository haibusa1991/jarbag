package com.haibu.jarbag.core.processors.file;

import com.haibu.jarbag.api.operations.file.upload.UploadFile;
import com.haibu.jarbag.api.operations.file.upload.UploadFileInput;
import com.haibu.jarbag.api.operations.file.upload.UploadFileResult;
import com.haibu.jarbag.base.error.ApiError;
import com.haibu.jarbag.core.NotImplementedErrorSupplier;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UploadFileProcessor implements UploadFile {
    private final NotImplementedErrorSupplier notImplementedErrorSupplier;

    @Override
    public Either<ApiError, UploadFileResult> process(UploadFileInput input) {
        return Either.left(notImplementedErrorSupplier.supplyError());
    }
}
