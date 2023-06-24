package net.dmytro.homework32.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "net.dmytro.homework32")
@PropertySource("dataBase.properties")
public class AppConfig {



    @Bean
    public DataSource getDataSource(@Value("${spring.datasource.url}")String url,
                                    @Value("${spring.datasource.username}")String user,
                                    @Value("${spring.datasource.password}")String pass){

        HikariConfig config = new HikariConfig();
        config.setUsername(user);
        config.setJdbcUrl(url);
        config.setPassword(pass);
        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
