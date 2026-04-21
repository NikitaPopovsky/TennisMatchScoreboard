package ru.NikitaPopovskiy.config;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //после внедрения зависимостей, загнать в контекст
        ServletContextListener.super.contextInitialized(sce);
    }
}
