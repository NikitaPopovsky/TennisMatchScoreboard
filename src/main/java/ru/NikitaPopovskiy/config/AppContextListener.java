package ru.NikitaPopovskiy.config;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext context = new ApplicationContext();
        sce.getServletContext().setAttribute("appContext", context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ApplicationContext context = (ApplicationContext) sce.getServletContext().getAttribute("appContext");
        if (context != null) {
            context.close();
        }
    }
}
