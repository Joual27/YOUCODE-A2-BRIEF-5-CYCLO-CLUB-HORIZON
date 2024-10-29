package org.youcode.cch.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.cyclist.CyclistDao;
import org.youcode.cch.cyclist.DTOs.EmbeddedCyclistDTO;
import org.youcode.cch.exceptions.EntityNotFoundException;
import org.youcode.cch.result.DTOs.CreateResultDTO;
import org.youcode.cch.result.DTOs.ResultResponseDTO;
import org.youcode.cch.result.embeddables.ResultKey;
import org.youcode.cch.result.mappers.CreateResultDTOToResultEntityMapper;
import org.youcode.cch.result.mappers.ResultEntityToResultResponseDTOMapper;
import org.youcode.cch.stage.DTOs.EmbeddedStageDTO;
import org.youcode.cch.stage.Stage;
import org.youcode.cch.stage.StageDao;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ResultServiceTest {
    @Mock
    private ResultDao resultDao;
    @Mock
    private CreateResultDTOToResultEntityMapper createResultDTOToResultEntityMapper;
    @Mock
    private ResultEntityToResultResponseDTOMapper resultEntityToResultResponseDTOMapper;
    @Mock
    private StageDao stageDao;
    @Mock
    private CyclistDao cyclistDao;
    @InjectMocks
    private ResultService resultService;
    private final EmbeddedStageDTO embeddedStageDTO = new EmbeddedStageDTO(15, "test" , "test" , "test");
    private final EmbeddedCyclistDTO embeddedCyclistDTO = new EmbeddedCyclistDTO("test", "test" , "test");


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllResults(){
        List<Result> results = List.of(new Result() , new Result() , new Result());
        when(resultDao.findAll()).thenReturn(results);
        ResultResponseDTO resultResponseDTO = new ResultResponseDTO(new ResultKey(15L , 15L ), Duration.ofMinutes(15), 15 , embeddedStageDTO , embeddedCyclistDTO);
        when(resultEntityToResultResponseDTOMapper.entityToDto(any(Result.class))).thenReturn(resultResponseDTO);
        List<ResultResponseDTO> res = resultService.getAllStageResults();
        assertEquals(3 , res.size());
        verify(resultDao , times(1)).findAll();
    }

    @Test
    public void testResultCreation() {

        Stage s = new Stage();
        s.setId(1L);

        Cyclist c = new Cyclist();
        c.setId(2L);

        when(stageDao.findById(1L)).thenReturn(Optional.of(s));
        when(cyclistDao.findById(2L)).thenReturn(Optional.of(c));
        CreateResultDTO createResultDTO = new CreateResultDTO(1L , 2L , Duration.ofMinutes(5));
        Result resToCreate = new Result();
        when(createResultDTOToResultEntityMapper.toEntity(createResultDTO)).thenReturn(resToCreate);
        resToCreate.setRank(1);
        Result createdResult = new Result();
        when(resultDao.save(resToCreate)).thenReturn(createdResult);
        ResultResponseDTO resultResponseDTO = new ResultResponseDTO(new ResultKey(15L, 15L), Duration.ofMinutes(15), 15, embeddedStageDTO, embeddedCyclistDTO);
        when(resultEntityToResultResponseDTOMapper.entityToDto(createdResult)).thenReturn(resultResponseDTO);
        ResultResponseDTO res = resultService.save(createResultDTO);
        assertNotNull(res);
        verify(stageDao, times(1)).findById(1L);
        verify(cyclistDao, times(1)).findById(2L);
        verify(createResultDTOToResultEntityMapper, times(1)).toEntity(createResultDTO);
        verify(resultDao, times(1)).save(resToCreate);
    }

    @Test
    public void testResultCreation_cyclistDoesntExist(){
        Long cyclistId = 2L;
        Long stageId = 1L;
        Stage s = new Stage();
        when(cyclistDao.findById(cyclistId)).thenReturn(Optional.empty());
        when(stageDao.findById(stageId)).thenReturn(Optional.of(s));
        CreateResultDTO res = new CreateResultDTO(stageId , cyclistId , Duration.ofMinutes(5));
        assertThrows(EntityNotFoundException.class , () -> resultService.save(res));
    }

    @Test
    public void testGetCyclistStageResult(){
        Long stageId = 1L;
        Long cyclistId = 2L;
        ResultKey resultId = new ResultKey(stageId ,  cyclistId);
        Result r = new Result();
        when(resultDao.findById(resultId)).thenReturn(Optional.of(r));
        ResultResponseDTO resultResponseDTO = new ResultResponseDTO(new ResultKey(15L, 15L), Duration.ofMinutes(15), 15, embeddedStageDTO, embeddedCyclistDTO);
        when(resultEntityToResultResponseDTOMapper.entityToDto(r)).thenReturn(resultResponseDTO);
        ResultResponseDTO res = resultService.getCyclistStageResult(stageId , cyclistId);
        assertNotNull(res);
        verify(resultDao,times(1)).findById(resultId);
    }

    @Test
    public void testGetCyclistStageResult_resultDoesntExist(){
        ResultKey resultId = new ResultKey(100L ,  200L);
        when(resultDao.findById(resultId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class , () -> resultService.getCyclistStageResult(resultId.getStageId() ,resultId.getCyclistId()));
    }
    @Test
    public void testDeletingResult(){
        Long stageId = 1L;
        Long cyclistId = 2L;
        ResultKey resultId = new ResultKey(stageId ,  cyclistId);
        Result r = new Result();
        when(resultDao.findById(resultId)).thenReturn(Optional.of(r));
        ResultResponseDTO resultResponseDTO = new ResultResponseDTO(new ResultKey(15L, 15L), Duration.ofMinutes(15), 15, embeddedStageDTO, embeddedCyclistDTO);
        when(resultEntityToResultResponseDTOMapper.entityToDto(r)).thenReturn(resultResponseDTO);

        ResultResponseDTO res = resultService.delete(stageId , cyclistId);

        assertNotNull(res);
        verify(resultDao , times(1)).findById(resultId);
    }

    @Test
    public void testDeletingResult_resultDoesntExist(){
        Long stageId = 1L;
        Long cyclistId = 2L;
        ResultKey resultId = new ResultKey(stageId ,  cyclistId);
        when(resultDao.findById(resultId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class , () -> resultService.delete(resultId.getStageId() , resultId.getCyclistId()));
    }

}
