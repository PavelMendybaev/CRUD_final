package web.controller;


import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class HelloController {


	AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(AppConfig.class);
	UserService userService = context.getBean(UserService.class);

	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String Enter(ModelMap model) {
		List<User> users = userService.listUsers();
		model.addAttribute("users", users);
		return "index";
	}


	@RequestMapping(value = "/" , method = RequestMethod.POST)
	public String PostEnter(@RequestParam("username") String username , ModelMap model ) {
		userService.add(new User(username));
		List<User> users = userService.listUsers();
		model.addAttribute("users", users);
		return "index";
	}


	@GetMapping("{id}")
	public String showUser(@PathVariable("id") Long id , ModelMap model){

		User user = userService.getId(id);
		model.addAttribute("user" , user);
		return "user";
	}

	@RequestMapping(value = "{id}" , method = RequestMethod.POST)
	public String getUser(@PathVariable("id") Long id ,@RequestParam("new_username") String new_name , ModelMap model){

		User user = userService.getId(id);
		user.setFirstName(new_name);
		model.addAttribute("user" , user);
		userService.update(id , new_name);

		return "user";

	}

	@RequestMapping(value = "delete/{id}" , method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Long id , ModelMap model){

		userService.delete(id);

		return "deleted";
	}



}