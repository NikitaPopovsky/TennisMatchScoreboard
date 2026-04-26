package ru.NikitaPopovskiy.config;

import org.hibernate.SessionFactory;
import ru.NikitaPopovskiy.dao.PlayerHibernateDao;
import org.hibernate.cfg.Configuration;
import ru.NikitaPopovskiy.entity.Match;
import ru.NikitaPopovskiy.entity.Player;

public class ApplicationContext {
    private PlayerHibernateDao playerHibernateDao;
    private SessionFactory sessionFactory;

    public ApplicationContext(PlayerHibernateDao playerHibernateDao, SessionFactory sessionFactory) {
        this.sessionFactory = getSessionFactory();
        this.playerHibernateDao = new PlayerHibernateDao(sessionFactory);


    }

    private SessionFactory getSessionFactory() {
        Configuration conf = new Configuration();

        conf.addAnnotatedClass(Player.class);
        conf.addAnnotatedClass(Match.class);

        conf.setProperty("hibernate.connection.driver_class", ConfigLoader.get("DB_DRIVER_CLASS"));
        conf.setProperty("hibernate.connection.url", ConfigLoader.get("DB_URL"));
        conf.setProperty("hibernate.dialect", ConfigLoader.get("DB_DIALECT"));
        conf.setProperty("hibernate.connection.username", ConfigLoader.get("DB_USERNAME"));
        conf.setProperty("hibernate.connection.password", ConfigLoader.get("DB_PASSWORD"));
        conf.setProperty("hbm2ddl.auto", ConfigLoader.get("HIBERNATE.HBM2DDL.AUTO"));
        conf.setProperty("hibernate.show_sql", ConfigLoader.get("HIBERNATE.SHOW_SQL"));

        return conf.buildSessionFactory();
    }


}
