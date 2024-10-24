package org.youcode.cch.stage;

import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.cyclist.DTOs.CreateAndUpdateCyclistDTO;
import org.youcode.cch.cyclist.DTOs.CyclistResponseDTO;
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

    public List<Stage> getAllStages(){
        return stageDao.findAll();
    }
    public Stage getStageById(Long id){
        Optional<Stage> s = stageDao.findById(id);
        return s.orElse(null);
    }
    public StageResponseDTO save(CreateAndUpdateStageDTO c){
        Stage stageToCreate = convertFromCreateOrUpdateDTOToEntity(c);
        Long id = stageDao.save(stageToCreate);
        stageToCreate.setId(id);
        return convertToResponseDTO(stageToCreate);
    }
    public Stage update(Stage c){
        stageDao.update(c);
        return c;
    }
    public Stage deleteById(Long id){
        Stage s = getStageById(id);
        if (s != null){
            stageDao.deleteById(id);
        }
        return s;
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
}
