package mameie.kfzService.controller;

import mameie.kfzService.db.method.KfzOptimzerDataBase;
import mameie.kfzService.db.table.UserTable;
import mameie.kfzService.request.UserLogin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "*")
public class UserIdentifkatorController {

    private final KfzOptimzerDataBase dataBase;
    private  UserTable userTable;
    public UserIdentifkatorController(KfzOptimzerDataBase dataBase, UserTable userTable){
        this.userTable=userTable;
        this.dataBase=dataBase;
    }

    @GetMapping("/date")
    public void geDate(){
        if(userTable.load()){
            if(userTable.checkLogin("93markus.meier@googlemail.com","abc12345")){
                System.out.println("Loggin Succesfull");
            }else{
                System.err.println("Loggin denied");
            }
        }

    }
    @PostMapping("/userIdentifaktion")
    public ResponseEntity postController(@RequestBody UserLogin userLogin){
        if(userTable.load()){
            if(userTable.checkLogin(userLogin.getEmail(),userLogin.getPassword())){
                System.out.println("Loggin Succesfull");
                return ResponseEntity.ok(HttpStatus.OK);
            }else{
                return ResponseEntity.ok(HttpStatus.NOT_FOUND);
            }
        }else{
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        }
    }

}
