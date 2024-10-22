package org.youcode.cch.cyclist;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.youcode.cch.cyclist.interfaces.CyclistDaoI;
import org.youcode.cch.shared.GenericDao;

import java.util.List;



@Repository
public class CyclistDao extends GenericDao<Cyclist> implements CyclistDaoI {

    public CyclistDao(SessionFactory sessionFactory){
        super(Cyclist.class,sessionFactory);
    }

    public List<Cyclist> sortCyclistByName(){
        try(Session session = openSession()){
            TypedQuery<Cyclist> query = session.createQuery("FROM Cyclist c ORDER BY firstName", Cyclist.class);
            return query.getResultList();
        }
    }

    public List<Cyclist> sortCyclistByNationality(){
        try(Session session = openSession()) {
            TypedQuery<Cyclist> query = session.createQuery("FROM Cyclist c ORDER BY nationality" , Cyclist.class);
            return query.getResultList();
        }
    }
    public List<Cyclist> sortCyclistByTeam(){
        try(Session session = openSession()) {
            TypedQuery<Cyclist> query = session.createQuery("SELECT c FROM Cyclist c JOIN c.team t ORDER BY t.name" , Cyclist.class);
            return query.getResultList();
        }
    }
}
