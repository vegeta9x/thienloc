package com.thienloc.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

public class Upload {
	
	public static void doUpload(MultipartFile fileData, String pathName, String name) throws IOException {
		
        String path  = ResourceUtils.getURL(pathName).getPath();
        File uploadRootDir = new File(path);
        
		// Tạo thư mục, nếu nó không tồn tại.
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		System.out.println("Client File Name = " + name);

		if (fileData.getSize() > 0) {
			try {
				File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(fileData.getBytes());
				stream.close();
				System.out.println("Upload success file: " + serverFile);
			} catch (Exception e) {
				System.out.println("Error Write file: " + name);
			}
		}
	}
	
	public static void deleteFile(String pathName, String name) throws FileNotFoundException {
		String path  = ResourceUtils.getURL(pathName).getPath();
        File uploadRootDir = new File(path);
        
		try {
			File deleteFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);

			if (deleteFile.delete()) {
                System.out.println(name + " is deleted!");
            } else {
                System.out.println("Sorry, unable to delete the file.");
            }
		} catch (Exception e) {
			System.out.println("Error Write file: " + name);
		}
	}
}
