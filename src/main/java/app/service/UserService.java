package app.service;

import app.model.User;

import java.util.List;


public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    void addUser(User user);

    void updateUser(Long id, User updatedUser);

    void deleteUser(Long id);
}
