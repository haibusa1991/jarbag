package com.haibu.jarbag.api.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class Errors {

    List<String> errors;
}
