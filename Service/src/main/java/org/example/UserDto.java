package org.example;

public class UserDto {

    private int id;
    private String name;
    private int count;

    public UserDto(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}