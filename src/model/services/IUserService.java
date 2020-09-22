package model.services;

import model.entities.User;

import java.util.List;

public interface IUserService {
    boolean login(String username, String password);
}
