package mameie.kfzService.sql.controller;

import mameie.kfzService.sql.model.User;
import mameie.kfzService.sql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private UserRepository repository;



    @PutMapping
    private String updateUser(@RequestBody long id){
        if(!repository.existsById(id)){
            return "Error: No User with ID found!";
        }
        try{
            repository.save(repository.findById(id));
            return "User with id: "+id+" Succesfull update!";
        }catch (Exception e){
            return  e.getMessage();
        }
    }

    @DeleteMapping("/user/delete")
    public String deleteUser(@RequestBody long id){
        if(!repository.existsById(id)){
            return "Error: No User with ID found!";
        }
        try{
            repository.delete(repository.findById(id));
            return "User with id: "+id+" Successfull delted!";
        }catch (Exception e){
            return  e.getMessage();
        }
    }
    @GetMapping("/user/load")
    public User getUser(@RequestBody long id) {
        System.err.println(id);
        return repository.findById(id);
    }

    @GetMapping("/user/loadList")
    public List<User> getUser() {
        List<User>userList= new ArrayList<>();
        for(User user:repository.findAll()){
            userList.add(user);
        }
        return userList;
    }

    @PostMapping("/user/save")
    public String saveUser(@RequestBody User user) throws Exception {
        try {
            repository.saveAndFlush(user);
            return "Success to save new User";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
