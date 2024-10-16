package org.youcode.generalResult;

import org.youcode.generalResult.interfaces.GeneralResultDaoI;
import org.youcode.shared.GenericDao;

public class GeneralResultDao extends GenericDao<GeneralResult> implements GeneralResultDaoI {
    public GeneralResultDao(){
        super(GeneralResult.class);
    }
}
