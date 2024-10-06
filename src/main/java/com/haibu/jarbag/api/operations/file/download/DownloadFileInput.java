package com.haibu.jarbag.api.operations.file.download;

import com.haibu.jarbag.base.processor.ProcessorInput;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class DownloadFileInput implements ProcessorInput {

    private String uri;

}
