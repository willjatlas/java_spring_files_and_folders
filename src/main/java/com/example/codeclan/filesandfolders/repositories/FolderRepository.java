package com.example.codeclan.filesandfolders.repositories;

import com.example.codeclan.filesandfolders.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
}
