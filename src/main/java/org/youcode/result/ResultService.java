package org.youcode.result;

import org.youcode.result.interfaces.ResultDaoI;
import org.youcode.result.interfaces.ResultServiceI;

public class ResultService implements ResultServiceI {

    private final ResultDaoI resultDao;

    public ResultService(ResultDaoI resultDao){
        this.resultDao = resultDao;
    }
}
