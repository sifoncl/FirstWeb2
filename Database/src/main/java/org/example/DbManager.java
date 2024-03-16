package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;

public class DbManager {

    public static void saveDb(Db db) throws IOException {
        File file = new File(db.getPath());
        System.out.println("Создал ФАйл");
        System.out.println(file.getPath());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, db.getDb());
    }

    public static Db loadDb(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] jsonData = Files.readAllBytes(Path.of(path));
        Db database =new Db();
        database.setPath(path);
        database.setDb(objectMapper.readValue(jsonData, new TypeReference<HashMap<Integer,UserEntity>>(){
        }));
        return database;
    }

}
