package com.lambdaschool.bwafricanmarket.configs;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Value("h2")
    private String dbValue;

    @Value("${spring.data.source.url:}")
    private String dbURL;

    @Bean
    public DataSource dataSource(){
        if(dbValue.equalsIgnoreCase("POSTGRESQL")){
            HikariConfig config = new HikariConfig();
            config.setDriverClassName("org.postgresql.Driver");
            config.setJdbcUrl(dbURL);
            return new HikariDataSource(config);
        }
        else{
            String myURLString = "Jdbc:h2:mem:testdb";
            String myDriverClass = "org.h2.Driver";
            String mydbUser = "sa";
            String mydbPassword = "";

            return DataSourceBuilder.create()
                    .username(mydbUser)
                    .password(mydbPassword)
                    .url(myURLString)
                    .driverClassName(myDriverClass)
                    .build();

        }
    }
}
