package mameie.kfzService.controller;

import mameie.kfzService.db.KfzOptimzerDataBase;
import mameie.kfzService.request.UserLogin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserIdentifkatorController {

    private final KfzOptimzerDataBase dataBase;
    public UserIdentifkatorController(KfzOptimzerDataBase dataBase){
        this.dataBase=dataBase;
    }

    @PostMapping("/userIdentifaktion")
    public ResponseEntity postController(@RequestBody UserLogin userLogin){
        System.err.println(userLogin.getEmail());
        System.err.println(userLogin.getPassword());
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
