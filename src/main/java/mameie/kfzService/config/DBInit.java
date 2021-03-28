package mameie.kfzService.config;

import mameie.kfzService.db.KfzOptimzerDataBase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBInit {

    @Bean
    public KfzOptimzerDataBase getDBService()throws Exception{
        KfzOptimzerDataBase kfzOptimzerDataBase = new KfzOptimzerDataBase();
        return kfzOptimzerDataBase;
    }

}
