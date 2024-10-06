package com.haibu.jarbag.api.operations.file.download;

import com.haibu.jarbag.base.processor.ProcessorResult;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class DownloadFileResult implements ProcessorResult {

    private Byte[] content;
    private String filename;
}
