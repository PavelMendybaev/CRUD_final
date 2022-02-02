package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      User user1 = new User("test_user");
      userService.add(user1);

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }
//
//      System.out.println(userService.getCar(1 , "model2"));
//
      context.close();

      System.out.println("Успешно");
   }

   public void saveUser(User user){
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);
      userService.add(user);
   }

   public List<User> listUser(){
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);
      return userService.listUsers();
   }
   public User getId(Long id){
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);
      User user = userService.getId(id);


      return user;
   }
   @Transactional
   public void update(long id , String name){
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);
      userService.update(id , name);

   }
   @Transactional
   public void delete(long id ){
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);
      userService.delete(id);

   }



}
