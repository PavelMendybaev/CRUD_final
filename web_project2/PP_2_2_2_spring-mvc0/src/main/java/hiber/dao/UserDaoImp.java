package hiber.dao;

import hiber.model.User;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager em;

   @Override
   public void add(User user) {
      em.persist(user);
      System.out.println("Пользователь Сохранён");
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {

      return  em.createQuery("from User ").getResultList();
   }

   @Override
   public User getId(Long id) {
      return em.find(User.class , id);
   }

   @Override
   @Transactional
   public void update(long id , String name) {

      User user = new User();
      user.setId(id);
      user.setFirstName(name);
      em.merge(user);

   }

   @Override
   @Transactional
   public void delete(long id) {
      em.createQuery("delete from User where id = :id").setParameter("id" , id).executeUpdate();
   }


}
