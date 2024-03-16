package org.example;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Optional;

public class UserService {

    static final UserEntity testUser1 = new UserEntity(1, "name 1", 10);
    static final UserEntity testUser2 = new UserEntity(2, "name 2", 20);
    static final UserEntity testUser3 = new UserEntity(3, "name 3", 30);
    private Db db = dbInit(Db.DEFAULT_PATH);

    private static UserService instance;

    public Db getDb() {
        return db;
    }

    private UserService() {
    }

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public Optional<UserDto> getUser(Integer id) {
        return db.getUserById(id).map(u -> new UserDto(u.getId(), u.getName(), u.getCount()));
    }


    static Db dbInit(String path) {
        try {
            Db db = new Db();
            db = DbManager.loadDb(path);
            System.out.println(LocalTime.now().toString() + " Нашел бд, загрузил");
            return db;

        } catch (IOException e) {
            System.out.println(LocalTime.now().toString() + " НЕ НАШЕЛ БД ПО ПУТИ ИНИЦИАЛИЗАЦИИ," +
                    " создаю пустую бд, с тестовыми юзерами");
            Db db = new Db();
            db.addUser(testUser1);
            db.addUser(testUser2);
            db.addUser(testUser3);
            try {
                DbManager.saveDb(db);
            } catch (IOException b) {
                System.out.println(LocalTime.now().toString() + " Не удалось сохранить бд");
            }
            return db;
        }
    }
    public void addUser(String name, int id){
        UserEntity user = new UserEntity(id, name, 0);
        this.db.addUser(user);
    }

    public void increseCountByOne(int id){
       instance.db.getUserById(id).get().setCount(instance.getUser(id).get().getCount()+1);
    }

}
