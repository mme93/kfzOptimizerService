package mameie.kfzService.controller;

import mameie.kfzService.db.method.KfzOptimzerDataBase;
import mameie.kfzService.db.table.UserTable;
import mameie.kfzService.request.LoginToken;
import mameie.kfzService.request.UserLogin;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

@RestController
@CrossOrigin(origins = "*")
public class UserIdentifkatorController {

    private final KfzOptimzerDataBase dataBase;
    private  UserTable userTable;
    private List<LoginToken> tokenList= new ArrayList<>();
    public UserIdentifkatorController(KfzOptimzerDataBase dataBase, UserTable userTable){
        this.userTable=userTable;
        this.dataBase=dataBase;
    }

    @PostMapping("/userIdentifaktion")
    public Object getTest(@RequestBody UserLogin userLogin){
        LoginToken token = new LoginToken(null,false);

        if(userTable.load()){
            if(userTable.checkLogin(userLogin.getEmail(),userLogin.getPassword())){
                System.out.println("Loggin Succesfull");
                token.setLogin(true);

                Supplier<String> tokenSupplier = () -> {
                    StringBuilder stringBuilderToken = new StringBuilder();
                    long currentTimeInMilisecond = Instant.now().toEpochMilli();
                    return stringBuilderToken.append(currentTimeInMilisecond).append("-")
                            .append(UUID.randomUUID().toString()).toString();
                };
                token.setToken(tokenSupplier.get());
                token.setEmail(userLogin.getEmail());
                this.tokenList.add(token);
                return token;
            }else{
                System.err.println("Loggin denied");
                return token;
            }
        }
        return token;
    }



}
