package com.haibu.jarbag.core.processors.file;

import com.haibu.jarbag.api.operations.file.download.DownloadFile;
import com.haibu.jarbag.api.operations.file.download.DownloadFileInput;
import com.haibu.jarbag.api.operations.file.download.DownloadFileResult;
import com.haibu.jarbag.base.error.ApiError;
import com.haibu.jarbag.core.NotImplementedErrorSupplier;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DownloadFileProcessor implements DownloadFile {
    private final NotImplementedErrorSupplier notImplementedErrorSupplier;

    @Override
    public Either<ApiError, DownloadFileResult> process(DownloadFileInput input) {
        return Either.left(notImplementedErrorSupplier.supplyError());
    }
}
