package org.youcode.shared;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.youcode.shared.interfaces.GenericDaoI;

import java.util.List;
import java.util.Optional;

public abstract class GenericDao<T> implements GenericDaoI<T> {
    private final Class<T> entityClass;
    private final SessionFactory sessionFactory;

    public GenericDao(Class<T> entityClass, SessionFactory sessionFactory) {
        this.entityClass = entityClass;
        this.sessionFactory = sessionFactory;
    }

    protected Session openSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void save(T entity) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = openSession()) {
            return session.createQuery("FROM " + entityClass.getName(), entityClass).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<T> findById(Long id) {
        try (Session session = openSession()) {
            return Optional.ofNullable(session.get(entityClass, id));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void delete(T entity) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.remove(session.contains(entity) ? entity : session.merge(entity));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        Optional<T> entity = findById(id);
        entity.ifPresent(this::delete);
    }
}
