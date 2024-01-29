package service;

import dao.UserDAO;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.findById(id).orElse(null);
    }

    @Override
    public void addUser(User user) {
        userDAO.save(user);
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);

        if (existingUser != null) {
            // Обновляю данные пользователя
            existingUser.setName(updatedUser.getName());

            // Сохраняю обновленного пользователя в базу данных
            userDAO.save(existingUser);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }
}
