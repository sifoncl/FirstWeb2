package org.example;

public class UserEntity {

   private int id;
   private String name;
   private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public UserEntity() {
    }

    public UserEntity(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
}
