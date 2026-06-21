package ru.NikitaPopovskiy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.NikitaPopovskiy.entity.PlayerEntity;
import ru.NikitaPopovskiy.enums.ExceptionMessage;
import ru.NikitaPopovskiy.exception.DataBaseUnavailableException;

import java.util.Optional;

public class PlayerHibernateDao implements PlayerDao{
    private final SessionFactory sessionFactory;

    public PlayerHibernateDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public PlayerEntity save(PlayerEntity player) {
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
    public Optional<PlayerEntity> getByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM PlayerEntity WHERE name = :name";
            return session.createQuery(hql, PlayerEntity.class)
                    .setParameter("name", name)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataBaseUnavailableException(ExceptionMessage.DB_NOT_UNAVAILABLE.getMessage());
        }
    }

    @Override
    public Optional<PlayerEntity> getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.find(PlayerEntity.class, id));
        } catch (Exception e) {
            throw new DataBaseUnavailableException(ExceptionMessage.DB_NOT_UNAVAILABLE.getMessage());
        }
    }
}
