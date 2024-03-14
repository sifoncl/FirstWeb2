package org.example;

import java.util.Optional;

public class UserService {
    private final Db db = new Db();

    public Optional<UserDto> getUser(Integer id){
        return db.getUserById(id).map(u-> new UserDto(u.getId(), u.getName(), u.getCount()));
    }

}
