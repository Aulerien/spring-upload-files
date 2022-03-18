package com.uploadfile.demo.services.impl;
import com.uploadfile.demo.services.FilesStorageService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * The type Files storage service.
 */
@Service
public class FilesStorageServiceImpl implements FilesStorageService {

  private final Path root = Paths.get("uploads");

    /**
     *
     */
  @Override
  public void init() {
    try {
      if(!Files.exists(root)){
        Files.createDirectory(root);
      }
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize folder for upload!");
    }
  }



    /**
     *
     * @param filename
     * @return
     */
  @Override
  public Resource load(String filename, String subdirectory) {
    try {
        init();
        String path = "uploads/"+subdirectory;
        Path file = Paths.get(path).resolve(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }


   /**
     *
     * @param file
     * @param subdirectory
     * @return
     */
    public String save(MultipartFile file, String subdirectory) {
      try {
          init();
          String path = "uploads/"+ subdirectory;
          if(!Files.isDirectory(Paths.get(path))){ // if not existe create
              Files.createDirectory(Paths.get(path));
          }
          if(file != null && !file.isEmpty()) {
              String fileName = (new Date()).getTime() + "_" + file.getOriginalFilename();
              Files.copy(file.getInputStream(), Paths.get(path + "/" + fileName));
              return fileName;
          }
          return null;
      } catch (Exception e) {
          throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
      }
  }


    /**
     *
     * @param chemin the chemin
     * @throws IOException
     */
  public void delete(String chemin) throws IOException {
      init();
      if(Files.exists(Paths.get(chemin))){
          Files.delete(Paths.get(chemin));
      }
  }
}




