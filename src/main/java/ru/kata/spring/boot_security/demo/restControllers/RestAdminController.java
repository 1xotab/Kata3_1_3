package ru.kata.spring.boot_security.demo.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.AdminService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestAdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public List<User> showAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("users/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return adminService.get(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        adminService.add(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        adminService.set(user);
        return user;
    }

    @DeleteMapping("users/{id}")
    public String deleteUser(@PathVariable Long id){
        adminService.delete(id);
        return "User with " + id + "was deleted";
    }
}
