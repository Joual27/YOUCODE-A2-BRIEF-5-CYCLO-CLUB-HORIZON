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
    public CyclistResponseDTO getCyclistById(Long id){
        Optional<Cyclist> cyclist = cyclistDao.findById(id);
        if (cyclist.isPresent()){
            return cyclistEntityToCyclistResponseDTOMapper.entityToDto(cyclist.get());
        }
        return null;
    }

    @Override
    public CyclistResponseDTO save(CreateAndUpdateCyclistDTO c){
        Cyclist cyclistToCreate = convertFromCreateOrUpdateDTOToEntity(c);
        Long generatedId = cyclistDao.save(cyclistToCreate);
        cyclistToCreate.setId(generatedId);
        return convertToResponseDTO(cyclistToCreate);
    }

    @Override
    public CyclistResponseDTO update(Long id , CreateAndUpdateCyclistDTO createAndUpdateCyclistDTO){
        Cyclist c = convertFromCreateOrUpdateDTOToEntity(createAndUpdateCyclistDTO);
        c.setId(id);
        cyclistDao.update(c);
        return convertToResponseDTO(c);
    }

    @Override
    public CyclistResponseDTO deleteById(Long id){
        CyclistResponseDTO cyclistToDelete = getCyclistById(id);
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

    private Cyclist convertFromCreateOrUpdateDTOToEntity(CreateAndUpdateCyclistDTO c){
        return createCyclistDTOToCyclistEntityMapper.toEntity(c);
    }

    private Cyclist convertFromResponseDTOToEntity(CyclistResponseDTO c){
        return cyclistEntityToCyclistResponseDTOMapper.toEntity(c);
    }
}
