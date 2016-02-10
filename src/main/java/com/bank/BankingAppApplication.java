package com.bank;

import com.bank.services.BankService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Import({
        SwaggerConfiguration.class,
        DataBaseConfiguration.class,
        WebConfiguration.class
})
@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories("com.bank.dao")
public class BankingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingAppApplication.class, args);
    }


    //Java based spring bean configuration
    @Bean()
    public BankService bankService() {
        BankService bankService = new BankService();
        return bankService;
    }


}
