package mameie.kfzService.controller;

import mameie.kfzService.db.KfzOptimzerDataBase;
import mameie.kfzService.request.LoginForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class KfzServerUserController {

    private final KfzOptimzerDataBase dataBase;
    public KfzServerUserController(KfzOptimzerDataBase dataBase){
        this.dataBase=dataBase;
    }

   @PostMapping("/request")
    public ResponseEntity postController(@RequestBody LoginForm loginForm){
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity postLogin(@RequestBody LoginForm loginForm){

        return ResponseEntity.ok(HttpStatus.OK);
    }

   @GetMapping("/date" )
    public String getDate(){
        return "asdasdasd";
   }
   @GetMapping("/t")
    public LoginForm getT(){
       LoginForm loginForm = new LoginForm();
       loginForm.setUser("Markus");
        return loginForm;
   }

}
