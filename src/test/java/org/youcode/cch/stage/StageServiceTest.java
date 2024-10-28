package org.youcode.cch.stage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.youcode.cch.competition.DTOs.EmbeddedCompetitionDTO;
import org.youcode.cch.exceptions.EntityNotFoundException;
import org.youcode.cch.stage.DTOs.CreateAndUpdateStageDTO;
import org.youcode.cch.stage.DTOs.StageResponseDTO;
import org.youcode.cch.stage.mappers.CreateAndUpdateStageDTOToEntityMapper;
import org.youcode.cch.stage.mappers.StageEntityToStageResponseDTOMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StageServiceTest {
    @Mock
    private StageDao stageDao;
    @Mock
    private CreateAndUpdateStageDTOToEntityMapper createAndUpdateStageDTOToEntityMapper;
    @Mock
    private StageEntityToStageResponseDTOMapper stageEntityToStageResponseDTOMapper;
    @InjectMocks
    private StageService stageService;


    @Test
    public void testGetAllStages(){
        List<Stage> stages = List.of(new Stage() , new Stage() , new Stage());
        when(stageDao.findAll()).thenReturn(stages);
        EmbeddedCompetitionDTO competition = new EmbeddedCompetitionDTO("test" , 2024 , LocalDate.of(2024,12,12) , LocalDate.of(2024,12,12), 50);
        StageResponseDTO stageResponseDTO = new StageResponseDTO(100L , 15, "test" , "test" , "test" , competition , false);
        when(stageEntityToStageResponseDTOMapper.entityToDto(any(Stage.class))).thenReturn(stageResponseDTO);

        List<StageResponseDTO> res = stageService.getAllStages();
        assertEquals(3 , res.size());
        verify(stageDao , times(1)).findAll();
    }

    @Test
    public void testStageCreation(){
        Stage stageToCreate = new Stage();
        CreateAndUpdateStageDTO s = new CreateAndUpdateStageDTO();
        when(createAndUpdateStageDTOToEntityMapper.toEntity(s)).thenReturn(stageToCreate);
        Stage createdStage = new Stage();
        createdStage.setIsCompleted(false);
        createdStage.setId(100L);
        when(stageDao.save(stageToCreate)).thenReturn(createdStage).thenReturn(createdStage);
        EmbeddedCompetitionDTO competition = new EmbeddedCompetitionDTO("test" , 2024 , LocalDate.of(2024,12,12) , LocalDate.of(2024,12,12), 50);
        StageResponseDTO createdStageResponse = new StageResponseDTO(100L , 15, "test" , "test" , "test" , competition , false);
        when(stageEntityToStageResponseDTOMapper.entityToDto(createdStage)).thenReturn(createdStageResponse);

        StageResponseDTO res = stageService.save(s);
        assertNotNull(res);
    }

    @Test
    public void testStageUpdate(){
       Stage stageToUpdate = new Stage();
       Long id = 100L;
       CreateAndUpdateStageDTO s = new CreateAndUpdateStageDTO();
       when(createAndUpdateStageDTOToEntityMapper.toEntity(s)).thenReturn(stageToUpdate);
       when(stageDao.findById(id)).thenReturn(Optional.of(stageToUpdate));
       EmbeddedCompetitionDTO competition = new EmbeddedCompetitionDTO("test" , 2024 , LocalDate.of(2024,12,12) , LocalDate.of(2024,12,12), 50);
       StageResponseDTO updatedStageResponse = new StageResponseDTO(100L , 15, "test" , "test" , "test" , competition , false);
       when(stageEntityToStageResponseDTOMapper.entityToDto(stageToUpdate)).thenReturn(updatedStageResponse);
       StageResponseDTO res = stageService.update(id,s);
       assertNotNull(res);
    }

    @Test
    public void testStageUpdate_stageDoesntExist(){
        CreateAndUpdateStageDTO s = new CreateAndUpdateStageDTO();
        Long id = 100L;
        when(stageDao.findById(100L)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class , () -> stageService.update(id , s));
    }

    @Test
    public void getStageById(){
        Long id = 100L;
        Stage s = new Stage();
        s.setId(id);
        when(stageDao.findById(id)).thenReturn(Optional.of(s));
        EmbeddedCompetitionDTO competition = new EmbeddedCompetitionDTO("test" , 2024 , LocalDate.of(2024,12,12) , LocalDate.of(2024,12,12), 50);
        StageResponseDTO stageResponse = new StageResponseDTO(100L , 15, "test" , "test" , "test" , competition , false);
        when(stageEntityToStageResponseDTOMapper.entityToDto(s)).thenReturn(stageResponse);

        StageResponseDTO res = stageService.getStageById(id);
        assertNotNull(res);

    }

    @Test
    public void getStageById_stageDoesntExist(){
       Long id = 100L;
       when(stageDao.findById(id)).thenReturn(Optional.empty());
       assertThrows(EntityNotFoundException.class , () -> stageService.getStageById(id));
    }

    @Test
    public void deleteById(){
        Long id = 100L;
        Stage s = new Stage();
        when(stageDao.findById(id)).thenReturn(Optional.of(s));
        EmbeddedCompetitionDTO competition = new EmbeddedCompetitionDTO("test" , 2024 , LocalDate.of(2024,12,12) , LocalDate.of(2024,12,12), 50);
        StageResponseDTO deletedStageResponse = new StageResponseDTO(100L , 15, "test" , "test" , "test" , competition , false);
        when(stageEntityToStageResponseDTOMapper.entityToDto(s)).thenReturn(deletedStageResponse);
        StageResponseDTO res = stageService.deleteById(id);
        assertNotNull(res);
    }

    @Test
    public void deleteById_stageDoesntExist(){
        Long id = 100L;
        when(stageDao.findById(id)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class , () -> stageService.deleteById(id));
    }
}
