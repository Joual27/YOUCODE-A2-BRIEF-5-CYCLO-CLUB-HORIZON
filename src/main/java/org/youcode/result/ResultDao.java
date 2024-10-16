package org.youcode.result;

import org.youcode.result.interfaces.ResultDaoI;
import org.youcode.shared.GenericDao;

public class ResultDao extends GenericDao<Result> implements ResultDaoI {
    public ResultDao(){
        super(Result.class);
    }
}
