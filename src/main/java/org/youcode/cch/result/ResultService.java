package org.youcode.cch.result;

import org.youcode.cch.result.interfaces.ResultDaoI;
import org.youcode.cch.result.interfaces.ResultServiceI;

public class ResultService implements ResultServiceI {

    private final ResultDaoI resultDao;

    public ResultService(ResultDaoI resultDao){
        this.resultDao = resultDao;
    }
}
