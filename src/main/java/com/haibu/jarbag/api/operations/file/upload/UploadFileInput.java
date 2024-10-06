package com.haibu.jarbag.api.operations.file.upload;

import com.haibu.jarbag.base.processor.ProcessorInput;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class UploadFileInput implements ProcessorInput {

    private byte[] content;

    private String uri;

}
