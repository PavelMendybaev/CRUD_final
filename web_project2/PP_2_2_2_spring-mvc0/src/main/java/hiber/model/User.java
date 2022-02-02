package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long id;

   @Column(name = "name")
   public String firstName;


   public User() {}
   
   public User(String firstName) {
      this.firstName = firstName;

   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }


   @Override
   public String toString(){
      return "name = "+ firstName;
   }



}
