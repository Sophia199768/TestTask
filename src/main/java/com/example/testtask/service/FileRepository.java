package com.example.testtask.service;

import com.example.testtask.entity.File;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {}
