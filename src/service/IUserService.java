package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> showAllUser();

    User adminLogin(String username, String password);

    User userLogin(String username, String password);

    void add(User newUser);

    void update(User newUser);

     void updatePW(User newUser);

    void removeUser(Long idUser);

    boolean existById(Long id);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByUsername(String userName);

    public User findById(Long id);

}
