package org.youcode.generalResult;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.youcode.generalResult.interfaces.GeneralResultDaoI;
import org.youcode.shared.GenericDao;


@Repository
public class GeneralResultDao extends GenericDao<GeneralResult> implements GeneralResultDaoI {
    public GeneralResultDao(SessionFactory sessionFactory){
        super(GeneralResult.class ,sessionFactory );
    }
}
