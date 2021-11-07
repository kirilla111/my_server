package com.example.restservice.config;

import java.io.*;
import java.util.Properties;

public class MainConfig {
    private String video_files_path;
    private static final String CONFIG_PATH = "";
    private static final String CONFIG_FILE_NAME = "properties.conf";
    private static final String DEFAULT_FILLING = "#video_files_path = SOME_PATH/";

    public MainConfig() throws IOException {
        File f = new File(CONFIG_PATH + CONFIG_FILE_NAME);

        if (!f.exists()) {
            f.createNewFile();
            System.out.println("WRITING CONFIG FILE..");
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            writer.write(DEFAULT_FILLING);
            writer.close();
        }

        System.out.println("READING CONFIG..");
        Properties props = new Properties();
        props.load(new FileInputStream(f));

        video_files_path = props.getProperty("video_files_path", "");
        System.out.println("video_files_path: " + video_files_path);
    }

    public String getVideo_files_path() {
        return video_files_path;
    }
}
