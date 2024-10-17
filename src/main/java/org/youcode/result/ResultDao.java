package org.youcode.result;

import org.hibernate.SessionFactory;
import org.youcode.result.interfaces.ResultDaoI;
import org.youcode.shared.GenericDao;

public class ResultDao extends GenericDao<Result> implements ResultDaoI {
    public ResultDao(SessionFactory sessionFactory){
        super(Result.class , sessionFactory);
    }
}
