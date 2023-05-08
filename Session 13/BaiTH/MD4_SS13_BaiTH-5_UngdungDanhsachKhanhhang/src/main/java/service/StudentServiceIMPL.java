package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements IStudentService{
    public static List<User> studentList = new ArrayList<>();
    static {
        studentList.add(new User(1L,"Chinh ND","chinhnd2@rikkeisoft.com","Hai Duong"));
        studentList.add(new User(2L,"DungLV","dunglv@rikkeisoft.com","Phu Tho"));
        studentList.add(new User(3L,"Toan TV","toan@rikkeisoft.com","Quang Ninh"));
    }
    @Override
    public List<User> findAll() {
        return studentList;
    }

    @Override
    public User findById(Long id) {
        return studentList.get(Math.toIntExact(id));
    }

}
