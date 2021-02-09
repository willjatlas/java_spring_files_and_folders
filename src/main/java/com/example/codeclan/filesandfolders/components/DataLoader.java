package com.example.codeclan.filesandfolders.components;

import com.example.codeclan.filesandfolders.models.File;
import com.example.codeclan.filesandfolders.models.Folder;
import com.example.codeclan.filesandfolders.models.User;
import com.example.codeclan.filesandfolders.repositories.FileRepository;
import com.example.codeclan.filesandfolders.repositories.FolderRepository;
import com.example.codeclan.filesandfolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){

        User user1 = new User("Neil Gaiman");
        User user2 = new User("Barry Folders");
        User user3 = new User("Larry Moulders");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Folder folder1 = new Folder("Neil's Stuff", user1);
        Folder folder2 = new Folder("Neil's Work Docs", user1);
        Folder folder3 = new Folder("Barry's Things", user2);
        Folder folder4 = new Folder("Larry's Junk", user3);

        folderRepository.save(folder1);
        folderRepository.save(folder2);
        folderRepository.save(folder3);
        folderRepository.save(folder4);

        File file1 = new File("New Book Idea", "DOCX", 175, folder2);
        File file2 = new File("CV", "DOCX", 2, folder1);
        File file3 = new File("Cover Letter1", "DOCX", 3, folder2);
        File file4 = new File("Food Plan", "PDF", 4, folder3);
        File file5 = new File("Pictures of Cats", ".psd", 600, folder4);

        fileRepository.save(file1);
        fileRepository.save(file2);
        fileRepository.save(file3);
        fileRepository.save(file4);
        fileRepository.save(file5);

    }


}
