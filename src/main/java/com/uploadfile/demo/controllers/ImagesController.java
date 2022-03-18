package com.uploadfile.demo.controllers;

import com.uploadfile.demo.services.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "images")
public class ImagesController {


    @Autowired
    private FilesStorageService filesStorageService;


    /**
     * Gets file.
     *
     * @param filename the filename
     * @return the file
     */
    @GetMapping("/persons/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getPersonFile(@PathVariable String filename) {
        Resource file = filesStorageService.load(filename, "personnes");
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
