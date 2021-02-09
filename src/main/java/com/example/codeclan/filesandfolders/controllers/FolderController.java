package com.example.codeclan.filesandfolders.controllers;

import com.example.codeclan.filesandfolders.models.Folder;
import com.example.codeclan.filesandfolders.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping("/folders")
    public ResponseEntity<List<Folder>> getFolderIndex(){
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/folders/{id}")
    public ResponseEntity<Optional<Folder>> getFolderById(@PathVariable Long id){
        return new ResponseEntity<>(folderRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/folders")
    public ResponseEntity<Folder> createFoler(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

}
