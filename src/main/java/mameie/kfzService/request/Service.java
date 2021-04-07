package mameie.kfzService.request;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private List<Item> serviceList= new ArrayList<>();

    public void loadServiceList(){

    }

    public List<Item> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Item> serviceList) {
        this.serviceList = serviceList;
    }

    private class Item {
        private String name;
        private int intervall,kosten;
        public Item(String name, int intervall, int kosten) {
            this.name = name;
            this.intervall = intervall;
            this.kosten = kosten;
        }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public int getIntervall() {
           return intervall;
       }

       public void setIntervall(int intervall) {
           this.intervall = intervall;
       }

       public int getKosten() {
           return kosten;
       }

       public void setKosten(int kosten) {
           this.kosten = kosten;
       }
   }
}
