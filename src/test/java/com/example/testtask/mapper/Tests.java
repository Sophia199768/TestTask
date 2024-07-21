package com.example.testtask.mapper;

import com.example.testtask.entity.File;
import com.example.testtask.exceptions.FileNotFoundException;
import com.example.testtask.requestsAndResponses.GetFileResponse;
import com.example.testtask.service.FileRepository;
import com.example.testtask.service.Service;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class Tests {

    @Test
    public void mapperTest() {
        Mapper mapper = new Mapper();

        File newFile = new File("NewTitle", "NewFile", "NewDescription", new Date(1));
        newFile.setId(1L);

        GetFileResponse response = new GetFileResponse(1L, "NewTitle", "NewFile", "NewDescription", new Date(1));
        GetFileResponse fileResponse = mapper.toGetFileResponse(newFile);

        assertEquals(fileResponse, response);
    }

    @Test
    public void createNewFile() {
        FileRepository mockedFileRepo = mock(FileRepository.class);
        Mapper mapper = new Mapper();

        Service service = new Service(mockedFileRepo, mapper);
        File newFile = new File("NewTitle", "NewFile", "NewDescription", new Date(1));

        File newFileId = new File("NewTitle", "NewFile", "NewDescription", new Date(1));
        newFileId.setId(1L);

        when(mockedFileRepo.save(newFile)).thenReturn(newFileId);
        Long id = service.createFile(mapper.toNewFileRequest(newFile));
        verify(mockedFileRepo).save(newFile);

        assertEquals(id, newFileId.getId());
    }

    @Test
    public void findExistFile() {
        FileRepository mockedFileRepo = mock(FileRepository.class);
        Mapper mapper = new Mapper();

        Service service = new Service(mockedFileRepo, mapper);

        File newFileId = new File("NewTitle", "NewFile", "NewDescription", new Date(1));
        newFileId.setId(1L);

        GetFileResponse response = mapper.toGetFileResponse(newFileId);

        when(mockedFileRepo.findById(newFileId.getId())).thenReturn(Optional.of(newFileId));

        GetFileResponse myResponse = service.getFile(1L);
        verify(mockedFileRepo).findById(1L);
        assertEquals(myResponse, response);
    }

    @Test
    public void findNonExistFile() {
        FileRepository mockedFileRepo = mock(FileRepository.class);
        Mapper mapper = new Mapper();

        Service service = new Service(mockedFileRepo, mapper);
        when(mockedFileRepo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(FileNotFoundException.class, () -> service.getFile(1L));
        verify(mockedFileRepo).findById(1L);
    }

    @Test
    public void pageMapperTest() {
        PageRequestMapper mapper = new PageRequestMapper();

        File newFile = new File("NewTitle", "NewFile", "NewDescription", new Date(1));
        newFile.setId(1L);

        Sort sort = Sort.by(Sort.Direction.DESC, "creationDate").ascending();

        PageRequest response = PageRequest.of(1, 1, sort);
        PageRequest fileResponse = mapper.toPageRequest(1, 1, true);

        assertEquals(fileResponse, response);
    }
}