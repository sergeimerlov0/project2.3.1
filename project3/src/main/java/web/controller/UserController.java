package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import web.dao.UserDao;
import web.model.User;
import java.util.List;

@Controller
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        model.addAttribute("users", userDao.listUser());
        return "users";
    }

    @GetMapping("/create")
    public String createUserForm(User user){
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user){
        userDao.add(user);
        return "redirect:/users";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userDao.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userDao.get(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user){
        userDao.update(user);
        return "redirect:/users";
    }
}
