package ru.NikitaPopovskiy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.NikitaPopovskiy.entity.Player;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class PlayerHibernateDao implements PlayerDao{
    private final SessionFactory sessionFactory;

    public PlayerHibernateDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Player save(Player player) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(player);

            session.getTransaction().commit();
            return player;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Player> getByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            //session.get()
            //нужно писать sql
        }

        return Optional.empty();
    }
}
