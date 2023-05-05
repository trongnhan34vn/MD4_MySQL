package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> selectAllUser ();
    void addUserTransaction (User user, int[] permission);
    void insertUpdateWithoutTransaction();
}
