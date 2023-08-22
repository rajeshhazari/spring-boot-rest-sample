package com.htsvsystems.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data @AllArgsConstructor @NoArgsConstructor
public class AppError {
    private String message;
    private String statusCode;
    private Timestamp timeStamp;

}
