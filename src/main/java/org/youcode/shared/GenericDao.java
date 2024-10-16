package org.youcode.shared;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.youcode.shared.interfaces.GenericDaoI;
import org.youcode.utils.SessionHandler;

import java.util.List;
import java.util.Optional;


public class GenericDao<T> implements GenericDaoI<T> {
    private final Class<T> entityClass;

    public GenericDao(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    @Override
    public void save(T entity) {
        Transaction transaction = null;
        try {
            SessionHandler.openSession();
            Session session = SessionHandler.getCurrentSession();
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            SessionHandler.closeSession();
        }
    }

    @Override
    public void update(T entity) {
        Transaction transaction = null;
        try {
            SessionHandler.openSession();
            Session session = SessionHandler.getCurrentSession();
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            SessionHandler.closeSession();
        }
    }

    @Override
    public List<T> findAll() {
        try {
            SessionHandler.openSession();
            Session session = SessionHandler.getCurrentSession();
            return session.createQuery("From " + entityClass.getName() + " e", entityClass).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            SessionHandler.closeSession();
        }
    }

    @Override
    public Optional<T> findById(Long id) {
        try {
            SessionHandler.openSession();
            Session session = SessionHandler.getCurrentSession();
            return Optional.ofNullable(session.get(entityClass, id));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            SessionHandler.closeSession();
        }
    }

    @Override
    public void delete(T entity) {
        Transaction transaction = null;
        try {
            SessionHandler.openSession();
            Session session = SessionHandler.getCurrentSession();
            transaction = session.beginTransaction();
            session.remove(session.contains(entity) ? entity : session.merge(entity));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            SessionHandler.closeSession();
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            SessionHandler.openSession();
            Optional<T> entity = findById(id);
            entity.ifPresent(this::delete);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SessionHandler.closeSession();
        }
    }

}
