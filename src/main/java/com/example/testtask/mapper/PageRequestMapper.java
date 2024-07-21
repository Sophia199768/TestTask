package com.example.testtask.mapper;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class PageRequestMapper {
    public PageRequest toPageRequest(Integer page, Integer size, Boolean ascending) {
        Sort sort = Sort.by(Sort.Direction.DESC, "creationDate");
        if (ascending) {
            sort = sort.ascending();
        }
        return PageRequest.of(page, size, sort);
    }
}
