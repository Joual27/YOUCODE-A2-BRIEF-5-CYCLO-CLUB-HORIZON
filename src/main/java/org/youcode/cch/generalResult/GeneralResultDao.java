package org.youcode.cch.generalResult;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.youcode.cch.generalResult.embeddables.GeneralResultKey;
import org.youcode.cch.generalResult.interfaces.GeneralResultDaoI;
import org.youcode.cch.shared.GenericDao;


@Repository
public class GeneralResultDao extends GenericDao<GeneralResult , GeneralResultKey> implements GeneralResultDaoI {
    public GeneralResultDao(SessionFactory sessionFactory){
        super(GeneralResult.class ,sessionFactory );
    }
}
