package service;

import model.User;

import java.util.List;

public interface IStudentService {
    List<User> findAll();
    User findById(Long id);
}
