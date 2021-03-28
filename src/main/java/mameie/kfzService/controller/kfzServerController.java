package mameie.kfzService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class kfzServerController {

    @GetMapping("/date")
    public String getDate(){
        return "date";
    }

}
