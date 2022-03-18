package com.uploadfile.demo.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

/**
 * The interface Files storage service.
 */
public interface FilesStorageService {
    /**
     * Init.
     */
    void init();


    /**
     * Load resource.
     *
     * @param filename     the filename
     * @param subdirectory the subdirectory
     * @return the resource
     */
    Resource load(String filename, String subdirectory);

    /**
     * Save string.
     *
     * @param file   the file
     * @param chemin the chemin
     * @return the string
     */
    String save(MultipartFile file, String chemin);

    /**
     * Delete.
     *
     * @param chemin the chemin
     * @throws IOException the io exception
     */
    void delete(String chemin) throws IOException;
}



