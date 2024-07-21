package com.example.testtask.requestsAndResponses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class GetFileResponse {
    private Long id;
    private String title;
    private String content;
    private String description;
    private Date creationDate;
}
