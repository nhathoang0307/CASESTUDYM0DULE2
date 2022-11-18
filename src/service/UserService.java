package service;

import model.Product;
import model.Role;
import model.User;
import utils.CSVUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    final String PATH = "G:\\Module2\\case_module2\\daTa\\users.csv";
    private static UserService userService;

    public UserService() {
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public List<User> showAllUser() {
        List<User> users = new ArrayList<>();
        List<String> lines = CSVUtils.read(PATH);
        for (String l : lines) {
            users.add(User.parseUser(l));
        }
        return users;
    }

    public User adminLogin(String username, String password) {
        List<User> users = showAllUser();
        for (User user : users) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password) &&
                    user.getRole().equals(Role.ADMIN)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User userLogin(String username, String password) {
        List<User> users = showAllUser();
        for (User user : users) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password) &&
                    user.getRole().equals(Role.USER)) {
                return user;
            }
        }
        return null;
    }

    public Long getIdUser(String name) {
        List<User> users = showAllUser();
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user.getId();
            }
        }
        return null;

    }

    public Long getIdForOrder(String name) {
        List<User> users = showAllUser();
        for (User user : users) {
            if (user.getUsername().equals(name) &&
                    user.getPassword().equals(name) &&
                    user.getRole().equals(Role.USER)) {
                return user.getId();
            }
        }
        return null;
    }

    @Override
    public void add(User newUser) {
        newUser.setCreatedAt(Instant.now());
        List<User> users = new ArrayList<>();
        users.add(newUser);
        CSVUtils.write(PATH, users);
    }

    @Override
    public void update(User newUser) {
        List<User> users = showAllUser();
        for (User user : users) {
            if (user.getId().equals(newUser.getId())) {
                String fullName = newUser.getFullName();
                if (fullName != null && !fullName.isEmpty())
                    user.setFullName(fullName);
                String phone = newUser.getMobile();
                if (phone != null && !phone.isEmpty())
                    user.setMobile(newUser.getMobile());
                String address = newUser.getAddress();
                if (address != null && !address.isEmpty())
                    user.setAddress(newUser.getAddress());
                user.setUpdatedAt(Instant.now());
                CSVUtils.writeUpdate(PATH, users);
                break;
            }
        }

    }

    @Override
    public void updatePW(User newUser) {
        List<User> users = showAllUser();
        for (User user : users) {
            if (user.getUsername().equals(newUser.getUsername())) {
                    user.setPassword(newUser.getPassword());
                CSVUtils.writeUpdate(PATH, users);
                break;
            }
        }
    }



    @Override
    public void removeUser(Long idUser) {
        List<User> users = showAllUser();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(idUser)) {
                users.remove(i);
                break;
            }
        }
        CSVUtils.writeUpdate(PATH, users);

    }


    @Override
    public boolean existsByEmail(String email) {
        List<User> users = showAllUser();
        for (User user : users) {
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    public boolean existsByPhone(String phone) {
        List<User> users = showAllUser();
        for (User user : users) {
            if (user.getMobile().equals(phone))
                return true;
        }
        return false;
    }

    @Override
    public boolean existsByUsername(String userName) {
        List<User> users = showAllUser();
        for (User user : users) {
            if (user.getUsername().equals(userName))
                return true;
        }
        return false;
    }

    public User findById(Long id) {
        List<User> users = showAllUser();
        for (User user : users) {
            if (user.getId().equals(id))
                return user;
        }
        return null;
    }

    @Override
    public boolean existById(Long id) {
        if (findById(id) != null) {
            return true;
        } else {
            return false;
        }
    }

}
