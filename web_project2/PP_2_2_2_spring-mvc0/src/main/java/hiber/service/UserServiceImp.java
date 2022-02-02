package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {




   @Autowired
   private UserDao userDao;





   @Transactional
   @Override
   public void add(User user) {

      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   @Transactional
   public User getId(Long id) {
      return userDao.getId(id);
   }

   @Override
   @Transactional
   public void update(long id , String name) {
      userDao.update(id , name);
   }

   @Override
   @Transactional
   public void delete(long id) {
      userDao.delete(id);
   }


}
