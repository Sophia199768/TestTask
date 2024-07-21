package com.example.testtask.mapper;

import com.example.testtask.entity.File;
import com.example.testtask.requestsAndResponses.GetFileResponse;
import com.example.testtask.requestsAndResponses.NewFileRequest;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public GetFileResponse toGetFileResponse(File file) {
        return new GetFileResponse(file.getId(), file.getTitle(), file.getContent(), file.getDescription(), file.getCreationDate());
    }


    public NewFileRequest toNewFileRequest(File file) {
        return new NewFileRequest(file.getTitle(), file.getContent(), file.getDescription(), file.getCreationDate());
    }
}
