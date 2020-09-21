package model.services;

import model.entities.User;

import java.util.List;

public interface IUserService {
    boolean login(String username, String password);

    List<User> findAll();

    void save(User customer);

    User findById(int id);

    void update(int id, User customer);

    void remove(int id);
}
