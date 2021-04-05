package mameie.kfzService.controller;

import mameie.kfzService.db.method.KfzOptimzerDataBase;
import mameie.kfzService.db.table.UserTable;
import mameie.kfzService.request.UserLogin;
import mameie.kfzService.request.UserLoginAnswer;
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

    @PostMapping("/userIdentifaktion")
    public Object geDate(@RequestBody UserLogin userLogin){
        UserLoginAnswer result = new UserLoginAnswer(userLogin.getEmail(),userLogin.getPassword(),false);

        if(userTable.load()){
            if(userTable.checkLogin(userLogin.getEmail(),userLogin.getPassword())){
                System.out.println("Loggin Succesfull");
                result.setLogin(true);
                return result;
            }else{
                System.err.println("Loggin denied");
                return result;
            }
        }

    return result;
    }


}
