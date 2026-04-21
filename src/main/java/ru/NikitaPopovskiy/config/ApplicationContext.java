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

        conf.setProperty("", ${driver})
    }


}
