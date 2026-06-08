package ru.NikitaPopovskiy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.NikitaPopovskiy.entity.Player;
import ru.NikitaPopovskiy.enums.ExceptionMessage;
import ru.NikitaPopovskiy.exception.DataBaseUnavailableException;

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
            throw new DataBaseUnavailableException(ExceptionMessage.DB_NOT_UNAVAILABLE.getMessage());
        }
    }

    @Override
    public Optional<Player> getByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Player WHERE name = :name";
            return session.createQuery(hql, Player.class)
                    .setParameter("name", name)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataBaseUnavailableException(ExceptionMessage.DB_NOT_UNAVAILABLE.getMessage());
        }
    }
}
