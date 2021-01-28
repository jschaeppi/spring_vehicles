package com.astontech.hr;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/*import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;*/

@SpringBootApplication
public class Application {
    
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;
    
    @Value("${spring.datasource.username}")
    private String dataSourceUser;
    
    @Value("${spring.datasource.password}")
    private String dataSourcePass;
    
    @Value("${spring.datasource.driver-class-name}")
    private String dataSourceDriverClassName;
    
    @Bean
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        //ds.setDataSource(dataSourceDriverClassName);
        ds.setUrl(dataSourceUrl);
        ds.setUsername(dataSourceUser);
        ds.setPassword(dataSourcePass);
        
        return ds;
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
/*    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any()).build();
    }*/
    
}
