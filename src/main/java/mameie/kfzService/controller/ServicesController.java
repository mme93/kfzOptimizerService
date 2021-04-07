package mameie.kfzService.controller;

import mameie.kfzService.db.method.KfzOptimzerDataBase;
import mameie.kfzService.db.table.ServiceTable;
import mameie.kfzService.db.table.UserTable;
import mameie.kfzService.request.LoginToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ServicesController {


    private ServiceTable serviceTable;

    public ServicesController(ServiceTable serviceTable){
        this.serviceTable=serviceTable;
    }
    @GetMapping("/service")
    public void getServiceListe(){
        if(this.serviceTable.load()){
            this.serviceTable.getServiceList();
        }
    }
}
