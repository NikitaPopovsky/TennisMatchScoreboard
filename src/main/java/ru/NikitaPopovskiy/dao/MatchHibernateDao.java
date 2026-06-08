package ru.NikitaPopovskiy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.NikitaPopovskiy.entity.Match;
import ru.NikitaPopovskiy.entity.Player;
import ru.NikitaPopovskiy.enums.ExceptionMessage;
import ru.NikitaPopovskiy.exception.DataBaseUnavailableException;

import java.util.List;

public class MatchHibernateDao implements MatchDao {
    private final SessionFactory sessionFactory;

    public MatchHibernateDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Match save(Match match) {
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
    public List<Match> getByPlayersName(String name, int pageSize, int offset) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Match m WHERE m.player1.name = '' OR m.player2.name = '' ORDER BY m.id DESC LIMIT :pageSize OFFSET :offset";
            return session.createQuery(hql, Match.class)
                    .setParameter("name", name)
                    .setParameter("pageSize", pageSize)
                    .setParameter("offset", offset)
                    .stream().toList();
        } catch (Exception e) {
            throw new DataBaseUnavailableException(ExceptionMessage.DB_NOT_UNAVAILABLE.getMessage());
        }
    }

    @Override
    public List<Match> getAll(int pageSize, int offset) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Match m ORDER BY m.id DESC LIMIT :pageSize OFFSET :offset";
            return session.createQuery(hql, Match.class)
                    .setParameter("pageSize", pageSize)
                    .setParameter("offset", offset)
                    .stream().toList();
        } catch (Exception e) {
            throw new DataBaseUnavailableException(ExceptionMessage.DB_NOT_UNAVAILABLE.getMessage());
        }
    }
}
