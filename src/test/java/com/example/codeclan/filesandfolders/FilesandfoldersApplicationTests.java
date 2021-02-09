package com.example.codeclan.filesandfolders;

import com.example.codeclan.filesandfolders.models.File;
import com.example.codeclan.filesandfolders.models.Folder;
import com.example.codeclan.filesandfolders.models.User;
import com.example.codeclan.filesandfolders.repositories.FileRepository;
import com.example.codeclan.filesandfolders.repositories.FolderRepository;
import com.example.codeclan.filesandfolders.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilesandfoldersApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	FileRepository fileRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canAddFilesFoldersAndUsers(){

		User user = new User("Neil Gaiman");
		userRepository.save(user);

		Folder folder = new Folder("Neil's Stuff" ,user);
		folderRepository.save(folder);

		File file = new File("Norse Mythology", "pdf", 232, folder);
		fileRepository.save(file);

	}

}
