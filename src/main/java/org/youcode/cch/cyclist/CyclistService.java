package org.youcode.cch.cyclist;

import org.youcode.cch.cyclist.DTOs.CyclistResponseDTO;
import org.youcode.cch.cyclist.interfaces.CyclistDaoI;
import org.youcode.cch.cyclist.interfaces.CyclistServiceI;
import org.youcode.cch.cyclist.mappers.CyclistEntityToCyclistResponseDTOMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CyclistService implements CyclistServiceI {

    private final CyclistDaoI cyclistDao;
    private final CyclistEntityToCyclistResponseDTOMapper cyclistEntityToCyclistResponseDTOMapper;

    public CyclistService(CyclistDaoI cyclistDao , CyclistEntityToCyclistResponseDTOMapper cyclistEntityToCyclistResponseDTOMapper){
        this.cyclistDao = cyclistDao ;
        this.cyclistEntityToCyclistResponseDTOMapper = cyclistEntityToCyclistResponseDTOMapper;
    }

    @Override
    public List<CyclistResponseDTO> getAllCyclists(){
        return cyclistDao.findAll().stream()
                .map(cyclistEntityToCyclistResponseDTOMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Cyclist getCyclistById(Long id){
        Optional<Cyclist> cyclist = cyclistDao.findById(id);
        return cyclist.orElse(null);
    }

    @Override
    public Cyclist save(Cyclist c){
        cyclistDao.save(c);
        return c;
    }

    @Override
    public Cyclist update(Cyclist c){
        cyclistDao.update(c);
        return c;
    }
    @Override
    public Cyclist deleteById(Long id){
        Cyclist cyclistToDelete = getCyclistById(id);
        cyclistDao.deleteById(id);
        return cyclistToDelete;
    }

    @Override
    public List<Cyclist> getOrderedCyclistListByName(){
        return cyclistDao.sortCyclistByName();
    }

    @Override
    public List<Cyclist> getOrderedCyclistListByNationality(){
        return cyclistDao.sortCyclistByNationality();
    }

    @Override
    public List<Cyclist> getOrderedCyclistListByTeam(){
        return cyclistDao.sortCyclistByTeam();
    }

    private CyclistResponseDTO convertToResponseDTO(Cyclist c){
        return cyclistEntityToCyclistResponseDTOMapper.entityToDto(c);
    }
}
