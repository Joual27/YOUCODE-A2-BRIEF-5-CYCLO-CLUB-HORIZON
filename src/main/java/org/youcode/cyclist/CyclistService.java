package org.youcode.cyclist;

import org.youcode.cyclist.interfaces.CyclistDaoI;
import org.youcode.cyclist.interfaces.CyclistServiceI;

import java.util.List;
import java.util.Optional;

public class CyclistService implements CyclistServiceI {

    private final CyclistDaoI cyclistDao;

    public CyclistService(CyclistDaoI cyclistDao){
        this.cyclistDao = cyclistDao ;
    }

    public List<Cyclist> getAllCyclists(){
        return cyclistDao.findAll();
    }
    public Cyclist getCyclistById(Long id){
        Optional<Cyclist> cyclist = cyclistDao.findById(id);
        return cyclist.orElse(null);
    }
    public Cyclist save(Cyclist c){
        cyclistDao.save(c);
        return c;
    }
    public Cyclist update(Cyclist c){
        cyclistDao.update(c);
        return c;
    }
    public Cyclist delete(Long id){
        cyclistDao.deleteById(id);
        return getCyclistById(id);
    }
}
