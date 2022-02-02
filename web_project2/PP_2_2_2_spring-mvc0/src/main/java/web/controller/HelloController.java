package web.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import hiber.MainApp;
import hiber.model.User;
import hiber.service.UserService;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@Controller

public class HelloController {




	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String Enter(ModelMap model) {
		MainApp mainApp = new MainApp();

		List<User> users = mainApp.listUser();

		model.addAttribute("users", users);

		return "index";
	}





	@RequestMapping(value = "/" , method = RequestMethod.POST)
	public String PostEnter(@RequestParam("username") String username , ModelMap model ) {

		MainApp mainApp = new MainApp();

		mainApp.saveUser(new User(username));


		List<User> users = mainApp.listUser();

		model.addAttribute("users", users);



		return "index";
	}

	@GetMapping("{id}")
	public String showUser(@PathVariable("id") Long id , ModelMap model){

		MainApp mainApp = new MainApp();

		User user = mainApp.getId(id);
		model.addAttribute("user" , user);

		return "user";
	}

	@RequestMapping(value = "{id}" , method = RequestMethod.POST)
	public String getUser(@PathVariable("id") Long id ,@RequestParam("new_username") String new_name , ModelMap model){



		MainApp mainApp = new MainApp();

		User user = mainApp.getId(id);
		user.setFirstName(new_name);
		model.addAttribute("user" , user);
		mainApp.update(id , new_name);

		return "user";



	}

	@RequestMapping(value = "delete/{id}" , method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Long id , ModelMap model){

		MainApp mainApp = new MainApp();
		mainApp.delete(id);




		return "deleted";



	}



}