package ru.NikitaPopovskiy.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.NikitaPopovskiy.entity.MatchEntity;
import ru.NikitaPopovskiy.entity.PlayerEntity;

@Configuration
@ComponentScan (basePackages = "ru.NikitaPopovskiy")
public class AppConfig {
    @Bean
    public SessionFactory sessionFactory () {
        org.hibernate.cfg.Configuration conf = new org.hibernate.cfg.Configuration();
        conf.addAnnotatedClass(PlayerEntity.class);
        conf.addAnnotatedClass(MatchEntity.class);
        conf.setProperty("hibernate.connection.driver_class", ConfigLoader.get("DB_DRIVER_CLASS"));
        conf.setProperty("hibernate.connection.url", ConfigLoader.get("DB_URL"));
        conf.setProperty("hibernate.dialect", ConfigLoader.get("DB_DIALECT"));
        conf.setProperty("hibernate.connection.username", ConfigLoader.get("DB_USERNAME"));
        conf.setProperty("hibernate.connection.password", ConfigLoader.get("DB_PASSWORD"));
        conf.setProperty("hibernate.hbm2ddl.auto", ConfigLoader.get("HIBERNATE.HBM2DDL.AUTO"));
        conf.setProperty("hibernate.show_sql", ConfigLoader.get("HIBERNATE.SHOW_SQL"));
        return conf.buildSessionFactory();
    }
}
