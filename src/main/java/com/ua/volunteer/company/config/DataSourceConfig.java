package com.ua.volunteer.company.config;

import com.ua.volunteer.company.constant.DatabaseSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DatabaseSettings.DRIVER.getValue());
        dataSource.setUrl(DatabaseSettings.URL.getValue());
        dataSource.setUsername(DatabaseSettings.USER.getValue());
        dataSource.setPassword(DatabaseSettings.PASSWORD.getValue());
        return dataSource;
    }
}
