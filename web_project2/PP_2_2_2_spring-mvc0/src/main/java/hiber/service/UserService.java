package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getId(Long id);
    void update(long user , String name);
    void delete(long id );
}
