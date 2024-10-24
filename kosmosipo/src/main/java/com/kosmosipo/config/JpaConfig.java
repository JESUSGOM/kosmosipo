package com.kosmosipo.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {

	@Bean
	 public DataSource dataSource()
    {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://mysql-8001.dinaserver.com:3306/Espazio");
        dataSourceBuilder.username("Espazio");
        dataSourceBuilder.password("Este11@res");
        return dataSourceBuilder.build();
    }
}
