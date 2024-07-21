package com.example.testtask.service;

import com.example.testtask.entity.File;
import com.example.testtask.exceptions.FileNotFoundException;
import com.example.testtask.requestsAndResponses.GetFileResponse;
import com.example.testtask.mapper.Mapper;
import com.example.testtask.requestsAndResponses.NewFileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Service {
    private final FileRepository fileRepository;
    private final Mapper mapper;

    public Long createFile(NewFileRequest newFileRequest) {
        File newFile = new File(newFileRequest.getTitle(), newFileRequest.getContent(), newFileRequest.getDescription(), newFileRequest.getCreationDate());
        return fileRepository.save(newFile).getId();
    }

    public GetFileResponse getFile(Long id) {
        Optional<File> file = fileRepository.findById(id);
        if (file.isEmpty()) throw new FileNotFoundException("File not found");
        return mapper.toGetFileResponse(file.get());
    }

    public List<GetFileResponse> findAll(PageRequest pageRequest) {
        return fileRepository.findAll(pageRequest).stream().map(mapper::toGetFileResponse).toList();
    }
}

