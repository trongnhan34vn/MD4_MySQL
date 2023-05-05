package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(int id);
    void save(User user);
    void remove(int id);
}
