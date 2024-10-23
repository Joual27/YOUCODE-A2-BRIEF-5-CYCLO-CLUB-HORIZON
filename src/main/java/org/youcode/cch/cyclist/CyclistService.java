package org.youcode.cch.cyclist;

import org.youcode.cch.cyclist.DTOs.CreateAndUpdateCyclistDTO;
import org.youcode.cch.cyclist.DTOs.CyclistResponseDTO;
import org.youcode.cch.cyclist.interfaces.CyclistDaoI;
import org.youcode.cch.cyclist.interfaces.CyclistServiceI;
import org.youcode.cch.cyclist.mappers.CreateCyclistDTOToCyclistEntityMapper;
import org.youcode.cch.cyclist.mappers.CyclistEntityToCyclistResponseDTOMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CyclistService implements CyclistServiceI {

    private final CyclistDaoI cyclistDao;
    private final CyclistEntityToCyclistResponseDTOMapper cyclistEntityToCyclistResponseDTOMapper;
    private final CreateCyclistDTOToCyclistEntityMapper createCyclistDTOToCyclistEntityMapper;

    public CyclistService(CyclistDaoI cyclistDao , CyclistEntityToCyclistResponseDTOMapper cyclistEntityToCyclistResponseDTOMapper , CreateCyclistDTOToCyclistEntityMapper createCyclistDTOToCyclistEntityMapper){
        this.cyclistDao = cyclistDao ;
        this.cyclistEntityToCyclistResponseDTOMapper = cyclistEntityToCyclistResponseDTOMapper;
        this.createCyclistDTOToCyclistEntityMapper = createCyclistDTOToCyclistEntityMapper;
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
    public CyclistResponseDTO save(CreateAndUpdateCyclistDTO c){
        Cyclist cyclistToCreate = createCyclistDTOToCyclistEntityMapper.toEntity(c);
        Long generatedId = cyclistDao.save(cyclistToCreate);
        cyclistToCreate.setId(generatedId);
        return cyclistEntityToCyclistResponseDTOMapper.entityToDto(cyclistToCreate);
    }

    @Override
    public CyclistResponseDTO update(Long id , CreateAndUpdateCyclistDTO createAndUpdateCyclistDTO){
        Cyclist c = createCyclistDTOToCyclistEntityMapper.toEntity(createAndUpdateCyclistDTO);
        c.setId(id);
        cyclistDao.update(c);
        return cyclistEntityToCyclistResponseDTOMapper.entityToDto(c);
    }

    @Override
    public CyclistResponseDTO deleteById(Long id){
        Cyclist cyclistToDelete = getCyclistById(id);
        cyclistDao.deleteById(id);
        return cyclistEntityToCyclistResponseDTOMapper.entityToDto(cyclistToDelete);
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
