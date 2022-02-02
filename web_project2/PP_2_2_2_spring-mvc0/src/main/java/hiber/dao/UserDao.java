package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User getId(Long id);
   void update(long id , String name);
   void delete(long id );


}
