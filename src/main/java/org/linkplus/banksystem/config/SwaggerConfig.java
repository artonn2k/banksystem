package org.linkplus.banksystem.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    //http://localhost:8085/swagger-ui/index.html
    private Info apiInfo(){
        return new Info()
                .title("Bank System API")
                .description("API documentation for Bank System")
                .version("1.0.0")
                .license(apiLicense())
                .contact(apiContact());
    }

    private License apiLicense(){
        return new License()
                .name("LinkPlusIT")
                .url("https://linkplus-it.com/");
    }

    private Contact apiContact(){
        return new Contact()
                .name("Arton Bilalli")
                .email("arton.bilalli1@gmail.com")
                .url("https://www.linkedin.com/in/arton-bilalli-06bb4b225/");
    }

}
