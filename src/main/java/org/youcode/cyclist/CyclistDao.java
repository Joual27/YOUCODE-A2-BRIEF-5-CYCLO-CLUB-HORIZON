package org.youcode.cyclist;

import org.youcode.cyclist.interfaces.CyclistDaoI;
import org.youcode.shared.GenericDao;

public class CyclistDao extends GenericDao<Cyclist> implements CyclistDaoI {
    public CyclistDao(){
        super(Cyclist.class);
    }
}
