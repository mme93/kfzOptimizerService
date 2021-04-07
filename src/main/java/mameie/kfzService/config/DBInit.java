package mameie.kfzService.config;

import mameie.kfzService.db.method.KfzOptimzerDataBase;
import mameie.kfzService.db.table.ServiceTable;
import mameie.kfzService.db.table.UserTable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBInit {

    @Bean
    public KfzOptimzerDataBase getDBService()throws Exception{
        KfzOptimzerDataBase kfzOptimzerDataBase = new KfzOptimzerDataBase();
        return kfzOptimzerDataBase;
    }

    @Bean
    public UserTable getUserTableService()throws Exception{
        UserTable UserTable = new UserTable();
        return UserTable;
    }
    @Bean
    public ServiceTable getServiceTableService()throws Exception{
        ServiceTable serviceTable = new ServiceTable();
        return serviceTable;
    }


}
