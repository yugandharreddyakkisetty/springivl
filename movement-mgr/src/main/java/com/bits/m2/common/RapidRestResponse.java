package com.bits.m2.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RapidRestResponse<T> {
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private T response;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String errors;
}
