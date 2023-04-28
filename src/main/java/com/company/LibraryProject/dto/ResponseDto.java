package com.company.LibraryProject.dto;

import ch.qos.logback.classic.spi.LoggingEventVO;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ResponseDto<T> {
    private boolean success;

    private String message;
    /*
     * 0   - it is ok
     *-1  - not found
     *-2  - validation error
     * -3 - database error
     * */

    private int code;

    private T data;

    private List<ErrorDto> errors;

}
