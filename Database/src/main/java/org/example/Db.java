package org.example;

import java.util.HashMap;
import java.util.Optional;

public class Db {

    private HashMap<Integer, UserEntity> db;

    public void addUser(UserEntity user) {
        this.db.put(user.getId(), user);
    }

    public Optional <UserEntity> getUserById(Integer id) {
        return Optional.of(this.db.get(id));
    }

    public Db() {
        this.addUser(new UserEntity(1,"name",0));
    }
}
