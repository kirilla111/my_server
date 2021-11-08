package com.example.restservice;

import com.example.restservice.config.MainConfig;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import templates.FileInfo;
import templates.FileInfoRequest;

import java.io.File;
import java.io.IOException;

@CrossOrigin(origins = "http://localhost:8091/", maxAge = 3600)
@RestController
public class Controller {

    private final MainConfig config;
    private File[] files;

    public Controller() throws IOException {
        config = new MainConfig();
    }

    @GetMapping("/files")
    public FileInfoRequest getFiles() {
        FileInfoRequest request = new FileInfoRequest();
        try {
            final File folder = new File(config.getVideo_files_path());
            this.files = folder.listFiles();

            if (files == null) return request;
            request.setArrayLength(files.length);

            for (final File fileEntry : files) {
                if (fileEntry.isFile())
                    request.add(new FileInfo(fileEntry.getName(), fileEntry.getPath(), FileInfoRequest.TYPES.File));
                else
                    request.add(new FileInfo(fileEntry.getName(), fileEntry.getPath(), FileInfoRequest.TYPES.Directory));
            }

            return request;
        } catch (Exception e) {
            e.printStackTrace();
            request.setFail(true);
            return request;
        }

    }
}