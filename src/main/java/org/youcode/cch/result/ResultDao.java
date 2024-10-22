package org.youcode.cch.result;

import org.hibernate.SessionFactory;
import org.youcode.cch.result.interfaces.ResultDaoI;
import org.youcode.cch.shared.GenericDao;

public class ResultDao extends GenericDao<Result> implements ResultDaoI {
    public ResultDao(SessionFactory sessionFactory){
        super(Result.class , sessionFactory);
    }
}
