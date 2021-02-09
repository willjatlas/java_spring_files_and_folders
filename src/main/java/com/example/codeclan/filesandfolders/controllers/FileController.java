package com.example.codeclan.filesandfolders.controllers;

import com.example.codeclan.filesandfolders.models.File;
import com.example.codeclan.filesandfolders.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;

    @GetMapping("/files")
    public ResponseEntity<List<File>> getFileIndex(){
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<Optional<File>> getFileById(@PathVariable Long id){
        return new ResponseEntity<>(fileRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/files")
    public ResponseEntity<File> createFile(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }

}
