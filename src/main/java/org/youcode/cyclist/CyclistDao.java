package org.youcode.cyclist;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.youcode.cyclist.interfaces.CyclistDaoI;
import org.youcode.shared.GenericDao;

public class CyclistDao extends GenericDao<Cyclist> implements CyclistDaoI {

    public CyclistDao(SessionFactory sessionFactory){
        super(Cyclist.class,sessionFactory);
    }

}
