package org.example;

import java.util.HashMap;
import java.util.Optional;

public class Db {

    static final String DEFAULT_PATH = "G:/Tom_Cat/db.json";

    private HashMap<Integer, UserEntity> db;

    private String path;

    public void addUser(UserEntity user) {
        this.db.put(user.getId(), user);
    }

    public Optional<UserEntity> getUserById(Integer id) {

        return Optional.ofNullable(this.db.get(id));
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public HashMap<Integer, UserEntity> getDb() {
        return db;
    }

    public void setDb(HashMap<Integer, UserEntity> db) {
        this.db = db;
    }

    public Db() {
        this.db= new HashMap<Integer,UserEntity>();
        this.path=Db.DEFAULT_PATH;
    }

}
