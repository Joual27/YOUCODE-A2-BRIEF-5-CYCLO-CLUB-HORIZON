package org.youcode.cch.stage;


import org.youcode.cch.exceptions.EntityNotFoundException;
import org.youcode.cch.stage.DTOs.CreateAndUpdateStageDTO;
import org.youcode.cch.stage.DTOs.StageResponseDTO;
import org.youcode.cch.stage.interfaces.StageDaoI;
import org.youcode.cch.stage.interfaces.StageServiceI;
import org.youcode.cch.stage.mappers.CreateAndUpdateStageDTOToEntityMapper;
import org.youcode.cch.stage.mappers.StageEntityToStageResponseDTOMapper;

import java.util.List;
import java.util.Optional;


public class StageService implements StageServiceI {
    private final StageDaoI stageDao;
    private final CreateAndUpdateStageDTOToEntityMapper createAndUpdateStageDTOToEntityMapper;
    private final StageEntityToStageResponseDTOMapper stageEntityToStageResponseDTOMapper;

    public StageService(StageDaoI stageDao , CreateAndUpdateStageDTOToEntityMapper createAndUpdateStageDTOToEntityMapper , StageEntityToStageResponseDTOMapper stageEntityToStageResponseDTOMapper){
        this.stageDao = stageDao;
        this.createAndUpdateStageDTOToEntityMapper = createAndUpdateStageDTOToEntityMapper;
        this.stageEntityToStageResponseDTOMapper = stageEntityToStageResponseDTOMapper;
    }

    @Override
    public List<StageResponseDTO> getAllStages(){
        List<Stage> stages = stageDao.findAll();
        return stages.stream()
                .map(this::convertToResponseDTO)
                .toList();
    }
    @Override
    public StageResponseDTO getStageById(Long id){
        Optional<Stage> s = stageDao.findById(id);
        if (s.isEmpty()){
            throw new EntityNotFoundException("No stage is found with the given ID");
        }
        return convertToResponseDTO(s.get());
    }
    @Override
    public StageResponseDTO save(CreateAndUpdateStageDTO c){
        Stage stageToCreate = convertFromCreateOrUpdateDTOToEntity(c);
        stageToCreate.setIsCompleted(false);
        Stage createdStage = stageDao.save(stageToCreate);
        stageToCreate.setId(createdStage.getId());
        return convertToResponseDTO(stageToCreate);
    }

    @Override
    public StageResponseDTO update(Long id ,CreateAndUpdateStageDTO c){
        Stage stageToUpdate = convertFromCreateOrUpdateDTOToEntity(c);
        if (stageDao.findById(id).isEmpty()){
            throw new EntityNotFoundException("No stage found with given ID");
        }
        else{
            stageToUpdate.setId(id);
            stageDao.update(stageToUpdate);
            return convertToResponseDTO(stageToUpdate);
        }
    }

    @Override
    public StageResponseDTO deleteById(Long id){
        StageResponseDTO stageToDelete = getStageById(id);
        stageDao.deleteById(id);
        return stageToDelete;
    }

    private StageResponseDTO convertToResponseDTO(Stage s){
        return stageEntityToStageResponseDTOMapper.entityToDto(s);
    }

    private Stage convertFromCreateOrUpdateDTOToEntity(CreateAndUpdateStageDTO stageDTO){
        return createAndUpdateStageDTOToEntityMapper.toEntity(stageDTO);
    }

    private Stage convertFromResponseDTOToEntity(StageResponseDTO stageResponseDTO){
        return stageEntityToStageResponseDTOMapper.toEntity(stageResponseDTO);
    }

    @Override
    public StageResponseDTO markStageAsCompleted(Long id){
        Stage s = stageDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No stage found with given Id !"));
        stageDao.setStageAsCompleted(s);
        s.setIsCompleted(true);
        return stageEntityToStageResponseDTOMapper.entityToDto(s);
    }


}
