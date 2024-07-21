package com.example.testtask.controller;

import com.example.testtask.requestsAndResponses.GetFileResponse;
import com.example.testtask.requestsAndResponses.NewFileRequest;
import com.example.testtask.mapper.PageRequestMapper;
import com.example.testtask.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class Controller {

    private final Service service;
    private final PageRequestMapper pageMapper;

    @GetMapping("/{id}")
    public GetFileResponse getFile(@PathVariable Long id) {
        return service.getFile(id);
    }

    @PostMapping("/create")
    public Long createFile(@RequestBody NewFileRequest newFileRequest) {
        return service.createFile(newFileRequest);
    }

    @GetMapping("/")
    public List<GetFileResponse> getAllFiles(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(required = false, defaultValue = "false") Boolean ascending)
    {
        return service.findAll(pageMapper.toPageRequest(page, pageSize, ascending));
    }
}
