package com.haibu.jarbag.api.operations.hello;

import com.haibu.jarbag.base.processor.ProcessorResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class GreetingResult implements ProcessorResult {

    private String greeting;

}
