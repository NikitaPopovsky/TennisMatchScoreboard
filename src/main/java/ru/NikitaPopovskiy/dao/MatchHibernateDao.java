package ru.NikitaPopovskiy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.NikitaPopovskiy.entity.MatchEntity;
import ru.NikitaPopovskiy.enums.ExceptionMessage;
import ru.NikitaPopovskiy.exception.DataBaseUnavailableException;

import java.util.List;

public class MatchHibernateDao implements MatchDao {
    private final SessionFactory sessionFactory;

    public MatchHibernateDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public MatchEntity save(MatchEntity match) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(match);

            session.getTransaction().commit();
            return match;
        } catch (Exception e) {
            throw new DataBaseUnavailableException(ExceptionMessage.DB_NOT_UNAVAILABLE.getMessage());
        }
    }

    @Override
    public List<MatchEntity> getByPlayersName(String name, int pageSize, int offset) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM MatchEntity m WHERE m.player1.name = '' OR m.player2.name = '' ORDER BY m.id DESC LIMIT :pageSize OFFSET :offset";
            return session.createQuery(hql, MatchEntity.class)
                    .setParameter("name", name)
                    .setParameter("pageSize", pageSize)
                    .setParameter("offset", offset)
                    .stream().toList();
        } catch (Exception e) {
            throw new DataBaseUnavailableException(ExceptionMessage.DB_NOT_UNAVAILABLE.getMessage());
        }
    }

    @Override
    public List<MatchEntity> getAll(int pageSize, int offset) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM MatchEntity m ORDER BY m.id DESC LIMIT :pageSize OFFSET :offset";
            return session.createQuery(hql, MatchEntity.class)
                    .setParameter("pageSize", pageSize)
                    .setParameter("offset", offset)
                    .stream().toList();
        } catch (Exception e) {
            throw new DataBaseUnavailableException(ExceptionMessage.DB_NOT_UNAVAILABLE.getMessage());
        }
    }
}
