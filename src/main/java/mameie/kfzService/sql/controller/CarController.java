package mameie.kfzService.sql.controller;

import mameie.kfzService.sql.model.Car;
import mameie.kfzService.sql.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CarController {

    @Autowired
    private CarRepository repository;


    @PostMapping("/car/save")
    public String saveCar(@RequestBody Car car){
       try{
           for(Car dataBaseCar:repository.findAll()){
               if(dataBaseCar.getKennzeichen().equals(car.getKennzeichen())){
                   return "Car Allready exist!";
               }
           }
           repository.saveAndFlush(car);
           return "Success";
       }catch (Exception e){
           return e.getMessage();
       }
    }


}
